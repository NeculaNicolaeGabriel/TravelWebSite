package com.example.Travel_Website_1.h2database;

import com.example.Travel_Website_1.model.Booking;
import com.example.Travel_Website_1.model.Enum.Gender;
import com.example.Travel_Website_1.model.Enum.MealPlan;
import com.example.Travel_Website_1.model.Enum.Type;
import com.example.Travel_Website_1.model.Hotel;
import com.example.Travel_Website_1.model.Role;
import com.example.Travel_Website_1.model.User;
import com.example.Travel_Website_1.repository.BookingRepository;
import com.example.Travel_Website_1.repository.HotelRepository;
import com.example.Travel_Website_1.repository.RoleRepository;
import com.example.Travel_Website_1.repository.UserRepository;
import com.example.Travel_Website_1.service.HotelService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class InitialUser  implements ApplicationListener<ContextRefreshedEvent> {

//     Role roleAdmin= new Role();
// declar cele 4 roluri
    // role repository in constructor

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final HotelRepository hotelRepository;

    private final BookingRepository bookingRepository;

    Role admin= new Role();
    Role travelAgent = new Role();
    Role client = new Role();
    Role hotelEmployee = new Role();


    public InitialUser(UserRepository userRepository, RoleRepository roleRepository, HotelRepository hotelRepository,BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.hotelRepository = hotelRepository;
        this.bookingRepository=bookingRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        roleRepository.saveAll(addRols());
        userRepository.saveAll(addUser());
        hotelRepository.saveAll(addHotels());
        bookingRepository.saveAll(addBooking());


    }


    public List<Role> addRols()
    {
        List<Role> roles= new ArrayList<>();
        admin.setType(Type.ADMIN);
        travelAgent.setType(Type.TOURIST_AGENT);
        client.setType(Type.CUSTOMER);
        hotelEmployee.setType(Type.HOTEL_EMPLOYEE);

        roles.add(admin);
        roles.add(travelAgent);
        roles.add(client);
        roles.add(hotelEmployee);
        return roles;

    }


    public List<User> addUser()
    {
        List<User> userList= new ArrayList<>();

        User newUserAdmin= new User();
        newUserAdmin.setRole(admin);
        newUserAdmin.setUsername("neculagabriel15");
        newUserAdmin.setPassword(generatePassword());
        newUserAdmin.setCnp("1980929271697");
        newUserAdmin.setPhoneNumber("0743301377");
        newUserAdmin.setEmail("admin1@yahoo.com");
        newUserAdmin.setGender(Gender.MALE);

        User newUserAdmin2 = new User();

        newUserAdmin2.setRole(admin);
        newUserAdmin2.setUsername("nicolae1999");
        newUserAdmin2.setPassword(generatePassword());
        newUserAdmin2.setCnp("1980955656651");
        newUserAdmin2.setPhoneNumber("07655665466");
        newUserAdmin2.setEmail("admin2@yahoo.com");
        newUserAdmin2.setGender(Gender.MALE);


        userList.add(newUserAdmin);
        userList.add(newUserAdmin2);
        return userList;
    }

    public List<Hotel> addHotels()
    {
        List<Hotel> hotels = new ArrayList<>();

        Hotel continental= new Hotel();

        continental.setHotelName("Continental");
        continental.setCity("Bucuresti");
        continental.setImage(null);
        continental.setNumberOfRooms(200);
        continental.setMealPlan(MealPlan.ALL_INCLUSIVE);
        continental.setPricePerNight(170.50);
        continental.setGym(true);
        continental.setSpa(true);
        continental.setTransferAiroport(true);

        Hotel anaHotels = new Hotel();

        anaHotels.setHotelName("AnaHotels");
        anaHotels.setCity("Poiana Brasov");
        anaHotels.setImage(null);
        anaHotels.setNumberOfRooms(315);
        anaHotels.setMealPlan(MealPlan.ALL_INCLUSIVE);
        anaHotels.setPricePerNight(290.50);
        anaHotels.setGym(true);
        anaHotels.setSpa(false);
        anaHotels.setTransferAiroport(true);


        hotels.add(continental);
        hotels.add(anaHotels);
        return hotels;


    }

    public List<Booking> addBooking()
    {





        List<Booking> bookings= new ArrayList<>();
        Booking booking1= new Booking();

        booking1.setBookedRooms(200);
        booking1.setNumberOfPersons(12);
        booking1.setPrice(20.9);
        booking1.setMealPlan(MealPlan.ALL_INCLUSIVE);
        booking1.setStartDate(null);
        booking1.setEndDate(null);
        booking1.setBookingCreateDate(null);
        booking1.setFacilitiesAdditionalPrice(2.37);
        bookings.add(booking1);
        return bookings;
    }


    public static String generatePassword() {
        String passwordString;
        String upperLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerLetters = "abcdefghijklmnopqrstuvxyz";
        String digits = "0123456789";
        String specialChar = "!@#$%^&*?+";
        String allChars = upperLetters + lowerLetters + digits + specialChar;

        Random random = new Random();
        int length = random.nextInt(6) + 6;
        char[] password = new char[length];

        password[0] = lowerLetters.charAt(random.nextInt(lowerLetters.length()));
        password[1] = upperLetters.charAt(random.nextInt(upperLetters.length()));
        password[2] = specialChar.charAt(random.nextInt(specialChar.length()));
        password[3] = digits.charAt(random.nextInt(digits.length()));

        for (int i = 4; i < length; i++) {
            password[i] = allChars.charAt(random.nextInt(allChars.length()));
        }


        passwordString = String.valueOf(password);
        return passwordString;
    }


}
