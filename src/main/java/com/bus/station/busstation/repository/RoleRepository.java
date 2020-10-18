package com.bus.station.busstation.repository;

import com.bus.station.busstation.model.utility.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

    Optional<Role> getByName(String name);
}
