package com.example.Travel_Website_1.service;


import com.example.Travel_Website_1.model.Hotel;
import com.example.Travel_Website_1.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService implements HotelInterface {



    @Autowired

    public HotelRepository hotelRepository;



    @Override
    public Hotel addhotel(Hotel hotel) {

        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> fetchBookingList() {
        return (List<Hotel>) hotelRepository.findAll();
    }

    @Override
    public Hotel fetchHotelById(Long hotelId) {
        return hotelRepository.findById(hotelId).get();
    }

    @Override
    public void deleteHotel(Hotel hotel) {

    }


    @Override
    public void delete(Hotel hotel) {

    }


    @Override
    public List<Hotel> getAllHotels() {

        return (List<Hotel>) hotelRepository.findAll();
    }

    @Override
    public void save(Hotel hotel){
        hotelRepository.save(hotel);
    }



    @Override
    public Hotel updateHotel(Long hotelId, Hotel hotel) {
        Hotel hotelDb=hotelRepository.findById(hotelId).get();
        return hotelRepository.save(hotelDb);
    }

    @Override
    public Hotel findById(Long theHotelId) {
        Optional<Hotel> result = hotelRepository.findById(theHotelId);

        Hotel theHotel = null;

        if (result.isPresent()) {
            theHotel= result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theHotelId);
        }

        return theHotel;
    }
    @Override
    public void deleteById(long hotelId) {
        hotelRepository.deleteById(hotelId);
    }


}
