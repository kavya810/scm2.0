package com.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.Entity.User;
import com.scm.Forms.UserForm;
import com.scm.helper.Message;
import com.scm.helper.messageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class Pagecontroller {

    
    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String home(Model model) {

        System.out.println("home page handler");
        model.addAttribute("name", "kavya chouksey");
        return "home";
    }

    @RequestMapping("/about")
    public String about() {
        System.out.println("about page handler");
        return "about";
    }

    @RequestMapping("/services")
    public String services() {
        System.out.println("about page handler");
        return "services";
    }

    @GetMapping("/contact")
    public String contact() {
        return new String("contact");
    }

    @GetMapping("/Login")
    public String Login() {
        return new String("Login");
    }

    @GetMapping("/register")
    public String register(Model model) {

        UserForm userForn = new UserForm();

        model.addAttribute("userForm", userForn);
        return new String("register");
    }

    // processing register
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@Valid  @ModelAttribute UserForm userForn , BindingResult rBindingResult , HttpSession session) {

        // connectivity database
        //valid  form data 
        if(rBindingResult.hasErrors()){
            return "register";
        }

        //          User user = User.builder().name(userForn.getName()).email(userForn.getEmail())
        //         .password(userForn.getPassword()).about(userForn.getAbout()).phoneNumber(userForn.getPhoneNumber())
        //         .profileLink("").build();

        User user = new User();
        user.setName(userForn.getName());
        user.setEmail(userForn.getEmail());
        user.setPassword(userForn.getPassword());
        user.setAbout(userForn.getAbout());
        user.setPhoneNumber(userForn.getPhoneNumber());
        user.setEnabled(true);
        user.setProfileLink("");

        User saveUser  = userService.saveUser(user);

        System.out.println("user has saved");


        //add the message

         Message message = Message.builder().content("Registration Successful").type(messageType.green).build();

        session.setAttribute("message", message);

        //redirect the login page 
        return "redirect:/register";
    }

}
