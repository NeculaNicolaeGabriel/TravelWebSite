package com.example.Travel_Website_1.repository;


import com.example.Travel_Website_1.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {


    //   Optional<Hotel> findById(Long id);

    Optional<Role> findById(Long Id);
}
