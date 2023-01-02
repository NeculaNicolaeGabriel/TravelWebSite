package com.example.Travel_Website_1.contoller;




import com.example.Travel_Website_1.model.Hotel;
import com.example.Travel_Website_1.service.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Slf4j
@Controller
public class HotelController {


    @Autowired
    private HotelService hotelInterface;


    @PostMapping("/hotel")
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hotelInterface.addhotel(hotel);
    }


    @GetMapping("/hotel")
    public List<Hotel> fetchBookingList() {
        return hotelInterface.fetchBookingList();
    }

    @GetMapping("/hotel/{hotelId}")
    public Hotel fetchHotelById(@PathVariable("hotelId") Long hotelId) {
        return hotelInterface.fetchHotelById(hotelId);
    }


    @GetMapping("/hotels")
    public String listHotels(Model theModel) {
        theModel.addAttribute("hotels", hotelInterface.getAllHotels());
        return "list-hotels";

    }


    @GetMapping("/showFormForAddHotel")
    public String showFormForAdd(Model theModel) {
        Hotel hotel = new Hotel();
        theModel.addAttribute("hotels", hotel);
        return "hotels-form";
    }

    @PostMapping("/saveHotel")
    public String saveHotel(@ModelAttribute("hotel") Hotel hotel) {
        hotelInterface.save(hotel);
        return "redirect:/hotels";
    }

    @PutMapping("/hotels/{hotelId}")
    public Hotel updateHotel(@PathVariable("hotelId") Long hotelId, @RequestBody Hotel hotel) {
        return hotelInterface.updateHotel(hotelId, hotel);
    }

    @PostMapping("/showFormForUpdateHotel")
    public String showFormForUpdateHotel(@RequestParam("hotelId")
                                         long hotelId, Model theModel) {
        // get the employee from the service
        Hotel theHotels = hotelInterface.findById(hotelId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("hotels", theHotels);

        // send over to our form
        return "hotels-form";
    }

    @PostMapping("/deleteHotel")
    public String deleteHotel(@RequestParam("hotelId") long hotelId) {

        // delete the hotel
        hotelInterface.deleteById(hotelId);

        // redirect to /hotels
        return "redirect:/hotels";

    }



    @GetMapping("/hotels/{id}/show")
    public String showById(@PathVariable String hotelId, Model model) {
        model.addAttribute("hotels", hotelInterface.findById(Long.valueOf(hotelId)));
        return "hotels/show";
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(itschool.springframework.exceptions.NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception) {

        log.error("Handling not found exception");
        log.error(exception.getMessage());

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("404error");
        modelAndView.addObject("exception", exception);

        return modelAndView;
    }


}