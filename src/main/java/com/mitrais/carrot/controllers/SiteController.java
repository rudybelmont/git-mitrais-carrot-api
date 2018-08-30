package com.mitrais.carrot.controllers;

import com.mitrais.carrot.config.Config;
import com.mitrais.carrot.models.User;
import com.mitrais.carrot.services.UserService;
import com.mitrais.carrot.validation.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rudy@mitrais.com
 */
@CrossOrigin
@RestController
@RequestMapping(Config.BASE_URI_API)
public class SiteController {

    String msg = "";

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody User body) {

        User user = userService.findUserByEmail(body.getEmail());
        if (user != null) {
            if (user.getPassword().equals(body.getPassword())) {
                return "ok";
            } else {
                throw new ResourceNotFoundException("user", "password is wrong", body.getEmail());
            }
        }
        throw new ResourceNotFoundException("user", "email", body.getEmail());
    }

    @PostMapping("/register")
    public String register(@RequestBody User body, BindingResult bindingResult) {

        User userExists = userService.findUserByEmail(body.getEmail());
        if (userExists != null) {
            throw new ResourceNotFoundException("user", "There is already a user registered with the email provided", body.getEmail());
        }
        if (bindingResult.hasErrors()) {
            throw new ResourceNotFoundException("user", bindingResult.toString(), body.getEmail());
        } else {
            userService.saveUser(body, "staff");
            return "ok";
        }
    }
}
