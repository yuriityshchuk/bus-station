package com.bus.station.busstation.repository;

import com.bus.station.busstation.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM user WHERE user.username=?")
    Optional<User> findByUsername(String username);
}
