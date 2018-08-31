package com.mitrais.carrot.controllers;

import com.mitrais.carrot.config.Config;
import com.mitrais.carrot.models.Role;
import com.mitrais.carrot.repositories.RoleRepository;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Role crud controller
 *
 * @author rudy@mitrais.com
 */
@CrossOrigin
@RestController
@RequestMapping(Config.BASE_URI_API)
public class RoleController {

    @Autowired
    public RoleRepository roleRepository;

    @GetMapping("/roles")
    @ResponseBody
    public Iterable<Role> all() {
        return roleRepository.findAll();
    }

    @PostMapping("/roles")
    @ResponseBody
    public Role save(@Valid @RequestBody Role body) {
        return roleRepository.save(body);
    }

    @GetMapping("/roles/{id}")
    @ResponseBody
    public Optional<Role> detail(@PathVariable Integer id) {
        return roleRepository.findById(id);
    }

    @PutMapping("/roles/{id}")
    @ResponseBody
    public Role update(@PathVariable Integer id, @Valid @RequestBody Role body) {
        Optional<Role> model = roleRepository.findById(id);
        Role role = model.get();
        role.setRoleName(body.getRoleName());
        role.setIsDeteled(body.getIsDeteled());
        return roleRepository.save(role);
    }
    
    @PutMapping("/delete/roles/{id}")
    public Role deleteRole(@PathVariable Integer id) {
        Optional<Role> model = roleRepository.findById(id);
        
        if(model.isPresent()) {
        	Role r = model.get();
        	r.setIsDeteled(1);
            return roleRepository.save(r);
        }
        else {
        	return model.get();
        }
        
    }

    @DeleteMapping("/roles/{id}")
    @ResponseBody
    public boolean delete(@PathVariable Integer id) {
        Optional<Role> model = roleRepository.findById(id);
        
        if(model.isPresent() ) {
        	Role r = model.get();
            if(r.getIsDeteled() == 1) {
            	roleRepository.delete(r);
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
