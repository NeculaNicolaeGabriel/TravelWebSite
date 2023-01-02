package com.example.Travel_Website_1.contoller;


import com.example.Travel_Website_1.model.User;

import com.example.Travel_Website_1.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller

public class UserController {

    @Autowired
    private UserService service;


    @PostMapping("/users")
    public User addUser(@RequestBody User user) {

        return service.addUser(user);

    }


//    @GetMapping("/users")
//    public List<User> getAllUsers( )
//    {
//
//        return service.getAllUsers();
//    }


    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        // add to the spring model
        theModel.addAttribute("users", service.getAllUsers());

        return "list-users";
    }



    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {

        User user= new User();
        theModel.addAttribute("users",user);
        return "users-form";
    }



    @PostMapping("/showFormForUpdate")

    public String showFormForUpdate(@RequestParam("userId") Long userId,
                                    Model theModel) {

        // get the employee from the service
        User theUsers = service.findById(userId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("users", theUsers);

        // send over to our form
        return "users-form";
    }



    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("users") User user)
    {
        service.save(user);
        return "redirect:/list";
    }




    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable("userId") Long userId, @RequestBody User user)
    {
        return service.updateUser(userId,user);
    }



    @PostMapping("/delete")
    public String deleteUser(@RequestParam("userId") long userId) {

        // delete the employee
        service.deleteById(userId);

        // redirect to /employees/list
        return "redirect:/list";

    }

}