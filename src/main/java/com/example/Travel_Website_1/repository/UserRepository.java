package com.example.Travel_Website_1.repository;

import com.example.Travel_Website_1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface   UserRepository extends CrudRepository<User,Long> {


}

