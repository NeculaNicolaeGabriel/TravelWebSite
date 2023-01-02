package com.example.Travel_Website_1.repository;

import com.example.Travel_Website_1.model.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepository extends CrudRepository<Hotel,Long> {



}
