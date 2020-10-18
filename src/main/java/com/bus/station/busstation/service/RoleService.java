package com.bus.station.busstation.service;

import com.bus.station.busstation.exception.DataNotFoundException;
import com.bus.station.busstation.model.utility.Role;
import com.bus.station.busstation.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getByName(String name) {
        return roleRepository.getByName(name)
                .orElseThrow(() -> new DataNotFoundException("Role with name: " + name + " not found"));
    }
}
