package com.mitrais.carrot.controllers;

import com.mitrais.carrot.config.Config;
import com.mitrais.carrot.models.Rewards;
import com.mitrais.carrot.repositories.RewardsRepository;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Rewards crud controller
 *
 * @author rudy@mitrais.com
 */
@CrossOrigin
@RestController
@RequestMapping(Config.BASE_URI_API)
public class RewardsController {

    @Autowired
    public RewardsRepository rewardsRepository;

    @GetMapping("/rewards")
    @ResponseBody
    public Iterable<Rewards> all() {
        return rewardsRepository.findAll();
    }

    @PostMapping("/rewards")
    @ResponseBody
    public Rewards save(@Valid @RequestBody Rewards body) {
        return rewardsRepository.save(body);
    }

    @GetMapping("/rewards/{id}")
    @ResponseBody
    public Optional<Rewards> detail(@PathVariable Integer id) {
        return rewardsRepository.findById(id);
    }

    @PutMapping("/rewards/{id}")
    @ResponseBody
    public Rewards update(@PathVariable Integer id, @Valid @RequestBody Rewards body) {
        Optional<Rewards> model = rewardsRepository.findById(id);
        Rewards sl = model.get();
        BeanUtils.copyProperties(body, sl);
        sl.setId(id);
        return rewardsRepository.save(sl);
    }
    
    @PutMapping("/delete/users/{id}")
    public Rewards deleteUser(@PathVariable Integer id) {
        Optional<Rewards> model = rewardsRepository.findById(id);
        
        if(model.isPresent()) {
        	Rewards r = model.get();
        	r.setIsDeteled(1);
            return rewardsRepository.save(r);
       }
        else {
        	return model.get();
        }
    }
    
    @DeleteMapping("/rewards/{id}")
    @ResponseBody
    public boolean delete(@PathVariable Integer id) {
        Optional<Rewards> model = rewardsRepository.findById(id);

        if(model.isPresent() ) {
        	Rewards r = model.get();
            if(r.getIsDeteled() == 1) {
            	rewardsRepository.delete(r);
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
