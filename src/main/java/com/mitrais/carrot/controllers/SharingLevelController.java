package com.mitrais.carrot.controllers;

import com.mitrais.carrot.config.Config;
import com.mitrais.carrot.models.SharingLevel;
import com.mitrais.carrot.models.User;
import com.mitrais.carrot.repositories.SharingLevelRepository;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rudy@mitrais.com
 */
@CrossOrigin
@RestController
@RequestMapping(Config.BASE_URI_API)
public class SharingLevelController {

    @Autowired
    public SharingLevelRepository sharingLevelRepository;
    
    @GetMapping("/sharinglevels")
    public Iterable<SharingLevel> all() {
        return sharingLevelRepository.findAll();
    }

    @PostMapping("/sharinglevels")
    public SharingLevel save(@RequestBody SharingLevel body) {
        return sharingLevelRepository.save(body);
    }

    @GetMapping("/sharinglevels/{id}")
    public Optional<SharingLevel> show(@PathVariable Integer id) {
        return sharingLevelRepository.findById(id);
    }

    @PutMapping("/sharinglevels/{id}")
    @ResponseBody
    public SharingLevel update(@PathVariable Integer id,@Valid @RequestBody SharingLevel body) {
        Optional<SharingLevel> model = sharingLevelRepository.findById(id);
        SharingLevel sl = model.get();        
        if (body.getGrade() != null) {
            sl.setGrade(body.getGrade());
        }
        if (body.getSharingLevel() != null) {
            sl.setSharingLevel(body.getSharingLevel());
        }
        return sharingLevelRepository.save(sl);
    }
    
    @PutMapping("/delete/sharingLevels/{id}")
    public SharingLevel deleteSharingLevel(@PathVariable Integer id) {
        Optional<SharingLevel> model = sharingLevelRepository.findById(id);
        
        if(model.isPresent()) {
        	SharingLevel sL = model.get();
        	sL.setIsDeteled(1);
            return sharingLevelRepository.save(sL);
       }
        else {
        	return model.get();
        }
    }

    @DeleteMapping("/sharinglevels/{id}")
    public boolean delete(@PathVariable Integer id) {
        Optional<SharingLevel> model = sharingLevelRepository.findById(id);

        if(model.isPresent()) {
        	SharingLevel sl = model.get();
        	 if (sl.getIsDeteled() == 1) {
        		 sharingLevelRepository.delete(sl);
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
