package com.example.Travel_Website_1.service;

import com.example.Travel_Website_1.Dtos.BookingDTO;
import com.example.Travel_Website_1.model.Booking;
import com.example.Travel_Website_1.model.User;
import com.example.Travel_Website_1.repository.BookingRepository;

import java.util.List;
import java.util.Set;

public interface BookingInterface {



    public Booking updateBooking(Long bookingId, Booking booking);

    public void deleteBookingById(Long bookingId);


    List<Booking> showAllBookings();

    List<Booking> showBookingById(Long userId);


    Booking createReservation(BookingDTO reservation, Long userId, Long hotelId);


    Double getTotalPriceForUser(Long userId);

   Set<Booking> getgetBookingByHotelId(Long hotelId);


    List<Booking> getAllBooking();

    void save(Booking theBooking);



}
