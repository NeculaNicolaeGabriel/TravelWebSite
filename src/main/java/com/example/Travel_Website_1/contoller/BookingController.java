package com.example.Travel_Website_1.contoller;


import com.example.Travel_Website_1.Dtos.BookingDTO;
import com.example.Travel_Website_1.model.Booking;
import com.example.Travel_Website_1.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
public class BookingController {


    @Autowired
    private BookingService service;



    @PostMapping("/create/{userId}/{hotelId}")
    public Booking createReservation(@RequestBody BookingDTO reservation, @PathVariable Long userId,
                                         @PathVariable Long hotelId){
        return service.createReservation(reservation,userId,hotelId);
    }


    @PutMapping("/booking/{bookingId}")

    public Booking updateBooking(@PathVariable("bookingId") Long bookingId, @RequestBody Booking booking) {
        return service.updateBooking(bookingId, booking);
    }


    @DeleteMapping("/booking/{bookingId}")

            public String deleteBookingById(@PathVariable("bookingId") Long bookingId)
    {

          service.deleteBookingById(bookingId);

          return "Booking delete Successfully";
    }

     @GetMapping("/showBooking")

    public List<Booking> showAllBookings()
     {
         return service.showAllBookings();
     }

     @GetMapping("/allReservationById/{userId}")
    public List<Booking> showBookingById(@PathVariable Long userId)
     {
         return service.showBookingById(userId);
     }


     @GetMapping("/booking/price/{userId}")

    public Double getTotalPriceForUser(@PathVariable("userId") Long userId)
     {
         return service.getTotalPriceForUser(userId);
     }

     @GetMapping("/booking/getAllBookings/{hotelId}")

    public ResponseEntity<Set<Booking>> getBookingByHotelId
             (@PathVariable("hotelId")Long hotelId)
     {
         return ResponseEntity.ok
                 (service.getgetBookingByHotelId(hotelId));
     }


     @GetMapping("/listBooking")

    public String listBooking(Model theModel)
     {
          theModel.addAttribute("booking",service.getAllBooking());
          return "list-booking";

     }

     @GetMapping("/showBookingFormForAdd")
    public String showBookingFormForAdd(Model theModel)
     {
         Booking theBooking = new Booking();

         theModel.addAttribute("booking",theBooking);

         return "booking-form";
     }

     @PostMapping("/saveBooking")

    public String saveBooking(@ModelAttribute("booking") Booking theBooking)
     {

         service.save(theBooking);
         return "redirect:/listBooking";
     }

}
