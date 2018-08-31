package com.mitrais.carrot.controllers;

import com.mitrais.carrot.config.Config;
import com.mitrais.carrot.models.User;
import com.mitrais.carrot.repositories.UserRepository;
import com.mitrais.carrot.services.UserService;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public Iterable<User> all() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User save(@RequestBody User body) {
        body.setCreatedTime(new Date());
        return userRepository.save(body);
    }

    @GetMapping("/users/{id}")
    public Optional<User> show(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    @PutMapping("/users/{id}")
    public User update(@PathVariable Integer id, @RequestBody User body) {
        Optional<User> user = userRepository.findById(id);
        
        if(user.isPresent()) {
        	User u = user.get();
        	
        	 BeanUtils.copyProperties(body, u);
             u.setId(id);
            return userRepository.save(body);
       }
        else {
        	return body;
        }
    }
    
    @PutMapping("/delete/users/{id}")
    public User deleteUser(@PathVariable Integer id) {
        Optional<User> model = userRepository.findById(id);
        
        if(model.isPresent()) {
        	User u = model.get();
        	u.setIsDeteled(1);
            return userRepository.save(u);
       }
        else {
        	return model.get();
        }
    }

    @DeleteMapping("/users/{id}")
    public boolean delete(@PathVariable Integer id) {
        Optional<User> model = userRepository.findById(id);
        
        if(model.isPresent() ) {
            User u = model.get();
            if(u.getIsDeteled() == 1) {
                userRepository.delete(u);
       	 	return true; 
            }
        	else {
                return false;
            }
        }
        else {
        	return false;	
        }
    }
}
