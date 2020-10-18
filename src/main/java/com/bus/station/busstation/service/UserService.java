package com.bus.station.busstation.service;

import com.bus.station.busstation.exception.DataNotFoundException;
import com.bus.station.busstation.exception.UserException;
import com.bus.station.busstation.model.User;
import com.bus.station.busstation.repository.UserRepository;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final RoleService roleService;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    public UserService(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    private User save(User user) {

        user.setRegistrationDate(new Date());
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRoles(Sets.newHashSet(roleService.getByName("USER")));
        return userRepository.save(user);
    }

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("User with id: " + id + " not found"));
    }

    public void deleteById(int id) {

        userRepository.deleteById(id);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new DataNotFoundException("User with username: " + username + " not found"));
    }

    public User changePassword(String username, String oldPassword, String newPassword) {
        User currentUser = findByUsername(username);
        if (oldPassword.equals(newPassword)) {
            throw new UserException("Old password and new password is equals");
        }

        if (encoder.matches(oldPassword, currentUser.getPassword())) {
            currentUser.setPassword(encoder.encode(newPassword));
            return update(currentUser);
        } else {
            throw new UserException("Old password is not correct");
        }

    }

    public User changeEmail(String username, String newEmail) {
        User currentUser = findByUsername(username);

        if (newEmail.equals(currentUser.getEmail())) {
            throw new UserException("Old email and new email is equal");
        }

        currentUser.setEmail(newEmail);

        return update(currentUser);
    }

    public User  blockAccount(int userId) {
        User user = getById(userId);

        if (user.isLocked()) {
            throw new UserException("User already blocked");
        }

        user.setLocked(true);
        return save(user);
    }

    public User saveWithCheck(User user) {
        if (!user.getPassword().equals(user.getRepeatedPassword())) {
            throw new UserException("Password and repeated password is not equals");
        }

        return save(user);
    }
}
