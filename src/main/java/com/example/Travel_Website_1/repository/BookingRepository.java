package com.example.Travel_Website_1.repository;

import com.example.Travel_Website_1.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface BookingRepository extends CrudRepository<Booking,Long> {
    Set<Booking> findByUserUserId(Long userId);
    Set<Booking> findByHotelHotelId(Long hotelId);

}
