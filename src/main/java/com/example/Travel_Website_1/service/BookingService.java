package com.example.Travel_Website_1.service;


import com.example.Travel_Website_1.Dtos.BookingDTO;
import com.example.Travel_Website_1.model.Booking;
import com.example.Travel_Website_1.model.Enum.Discount;
import com.example.Travel_Website_1.model.Enum.MealPlan;
import com.example.Travel_Website_1.model.Hotel;
import com.example.Travel_Website_1.model.User;
import com.example.Travel_Website_1.repository.BookingRepository;
import com.example.Travel_Website_1.repository.HotelRepository;
import com.example.Travel_Website_1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookingService  implements BookingInterface {



//    @Autowired
//    private BookingRepository bookingRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private HotelRepository hotelRepository;
//
////    @Override
////    public Booking addBooking(BookingDTO booking) {
////
////        Booking booking1= new Booking();
////        //setez bookerooms
////        // trebuie sa ma folosesc de DTO la toate
////        booking1.setBookingId(booking.getUserId());
////        return bookingRepository.save(booking1);
////    }


    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final HotelRepository hotelRepository;

    public BookingService(BookingRepository bookingRepository, UserRepository userRepository, HotelRepository hotelRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Booking updateBooking(Long bookingId, Booking booking) {
        Booking bookingDb =bookingRepository.findById(bookingId).get();

        if(Objects.nonNull(booking.getBookedRooms()))
        {

            bookingDb.setBookedRooms(booking.getBookedRooms());
        }

        if(Objects.nonNull(booking.getNumberOfPersons()))
        {

            bookingDb.setNumberOfPersons(booking.getNumberOfPersons());
        }





        return  bookingRepository.save(bookingDb);
    }


    @Override
    public void deleteBookingById(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    @Override
    public List<Booking> showAllBookings() {
       return (List<Booking>) bookingRepository.findAll();
    }

    @Override
    public List<Booking> showBookingById(Long userId) {
        List<Booking> reservationList= (List<Booking>) bookingRepository.findAll();
        List<Booking> userList= new ArrayList<>();
        for (Booking element:reservationList)
        {
            if(element.getUser().getUserId().equals(userId))
            {
                userList.add(element);
            }
        }
        return userList;

    }

    @Override
    public Booking createReservation(BookingDTO reservation, Long userId, Long hotelId) {
        Booking reservation1= new Booking();
        Optional<User>  user= userRepository.findById(userId);

//        if(user.isPresent())
//        {
//            reservation1.setUser(user.get());
//
//        }
//        else {
//            throw  new RuntimeException();
//        }

        reservation1.setUser(user.get());
        Optional<Hotel> hotel= hotelRepository.findById(hotelId);

        if(hotel.isPresent()) {
            reservation1.setHotel(hotel.get());

        }
        else
        {
            throw  new RuntimeException();
        }
        reservation1.setBookedRooms(reservation.getBookedRooms());
        reservation1.setNumberOfPersons(reservation.getNumberOfPersons());
        reservation1.setPrice(reservation.getPrice());
        reservation1.setMealPlan(reservation.getMealPlan());
        reservation1.setStartDate(reservation.getStartDate());
        reservation1.setEndDate(reservation.getEndDate());
        reservation1.setBookingCreateDate(reservation.getBookingCreateDate());
        reservation1.setFacilitiesAdditionalPrice(reservation.getFacilitiesAdditionalPrice());
        return bookingRepository.save(reservation1);
    }

    @Override
    public Double getTotalPriceForUser(Long userId) {
        Set<Booking> bookings= new HashSet<>(showBookingById(userId));
        Double totalprice=0.0;
        for (Booking currentBooking:bookings)
        {
            totalprice+=currentBooking.getPrice();
        }
        return totalprice;
    }

    @Override
    public Set<Booking> getgetBookingByHotelId(Long hotelId) {
        Set<Booking> bookings= new HashSet<>();
        bookingRepository.findByHotelHotelId(hotelId).iterator().forEachRemaining(bookings::add);
        return  bookings;
    }

    @Override
    public List<Booking> getAllBooking() {
        return (List<Booking>) bookingRepository.findAll();
    }

    @Override
    public void save(Booking theBooking) {
        bookingRepository.save(theBooking);
    }


    public static double calculatePriceWithDiscount(double pricePerNight, Discount discount)
     {
         double finalPrice=pricePerNight;
         if(discount==Discount.LEVEL1)
         {
             finalPrice=finalPrice *0.9;
         }
         else if(discount==Discount.LEVEL2)
         {
             finalPrice=finalPrice *0.85;
         }
         else if(discount==Discount.LEVEL3)
         {
             finalPrice=finalPrice *0.8;
         }
         return finalPrice;
     }

}




