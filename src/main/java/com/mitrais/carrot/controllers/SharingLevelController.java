package com.mitrais.carrot.controllers;

import com.mitrais.carrot.config.Config;
import com.mitrais.carrot.models.SharingLevel;
import com.mitrais.carrot.repositories.SharingLevelRepository;
import java.util.Optional;
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
 * @author Febri_MW251@mitrais.com
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
    public SharingLevel update(@PathVariable Integer id, @RequestBody SharingLevel body) {
        Optional<SharingLevel> shareLevel = sharingLevelRepository.findById(id);
        SharingLevel sl = shareLevel.get();        
        if (body.getGrade() != null) {
            sl.setGrade(body.getGrade());
        }
        if (body.getSharingLevel() != null) {
            sl.setSharingLevel(body.getSharingLevel());
        }
        return sharingLevelRepository.save(sl);
    }

    @DeleteMapping("/sharinglevels/{id}")
    public String delete(@PathVariable Integer id) {
        Optional<SharingLevel> sl = sharingLevelRepository.findById(id);
        sharingLevelRepository.delete(sl.get());
        return "";
    }
}
