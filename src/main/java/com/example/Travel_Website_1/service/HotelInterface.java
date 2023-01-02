package com.example.Travel_Website_1.service;


import com.example.Travel_Website_1.model.Hotel;

import java.util.List;

public interface HotelInterface {


  public   Hotel addhotel(Hotel hotel);

   public List<Hotel> fetchBookingList();

    Hotel fetchHotelById(Long hotelId);

    void deleteHotel(Hotel hotel);

 void delete(Hotel hotel);

 Hotel updateHotel(Long hotelId, Hotel hotel);


    List<Hotel> getAllHotels();



    void save(Hotel hotel);



    Hotel findById(Long theId);


    void deleteById(long hotelId);
}
