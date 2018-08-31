package com.mitrais.carrot.controllers;

import com.mitrais.carrot.config.Config;
import com.mitrais.carrot.models.Barn;
import com.mitrais.carrot.repositories.BarnRepository;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Barn crud controller
 *
 * @author rudy@mitrais.com
 */
@CrossOrigin
@RestController
@RequestMapping(Config.BASE_URI_API)
public class BarnController {

    @Autowired
    public BarnRepository barnRepository;

    @GetMapping("/barns")
    @ResponseBody
    public Iterable<Barn> all() {
        return barnRepository.findAll();
    }

    @PostMapping("/barns")
    @ResponseBody
    public Barn save(@Valid @RequestBody Barn body) {
        return barnRepository.save(body);
    }

    @GetMapping("/barns/{id}")
    @ResponseBody
    public Optional<Barn> detail(@PathVariable Integer id) {
        return barnRepository.findById(id);
    }

    @PutMapping("/barns/{id}")
    @ResponseBody
    public Barn update(@PathVariable Integer id, @Valid @RequestBody Barn body) {
        Optional<Barn> model = barnRepository.findById(id);
        Barn barn = model.get();
        BeanUtils.copyProperties(body, barn);
        barn.setId(id);
        return barnRepository.save(barn);
    }
    
    @PutMapping("/delete/barns/{id}")
    public Barn deleteUser(@PathVariable Integer id) {
        Optional<Barn> model = barnRepository.findById(id);
        
        if(model.isPresent()) {
        	Barn b = model.get();
        	b.setIsDeteled(1);
            return barnRepository.save(b);
       }
        else {
        	return model.get();
        }
    }

    @DeleteMapping("/barns/{id}")
    @ResponseBody
    public boolean delete(@PathVariable Integer id) {
        Optional<Barn> model = barnRepository.findById(id);

        if(model.isPresent() ) {
        	Barn b = model.get();
            if(b.getIsDeteled() == 1) {
            	barnRepository.delete(b);
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
