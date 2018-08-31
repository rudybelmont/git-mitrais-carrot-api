package com.mitrais.carrot.controllers;

import com.mitrais.carrot.config.Config;
import com.mitrais.carrot.models.ShareType;
import com.mitrais.carrot.repositories.ShareTypeRepository;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ShareType crud controller
 *
 * @author rudy@mitrais.com
 */
@CrossOrigin
@RestController
@RequestMapping(Config.BASE_URI_API)
public class ShareTypeController {

    @Autowired
    public ShareTypeRepository shareTypeRepository;

    @GetMapping("/share-types")
    @ResponseBody
    public Iterable<ShareType> all() {
        return shareTypeRepository.findAll();
    }

    @PostMapping("/share-types")
    @ResponseBody
    public ShareType save(@Valid @RequestBody ShareType body) {
        return shareTypeRepository.save(body);
    }

    @GetMapping("/share-types/{id}")
    @ResponseBody
    public Optional<ShareType> detail(@PathVariable Integer id) {
        return shareTypeRepository.findById(id);
    }

    @PutMapping("/share-types/{id}")
    @ResponseBody
    public ShareType update(@PathVariable Integer id, @Valid @RequestBody ShareType body) {
        Optional<ShareType> model = shareTypeRepository.findById(id);
        ShareType sl = model.get();
        BeanUtils.copyProperties(body, sl);
        sl.setId(id);
        return shareTypeRepository.save(sl);
    }

    @PutMapping("/delete/share-types/{id}")
    public ShareType deleteShareType(@PathVariable Integer id) {
        Optional<ShareType> model = shareTypeRepository.findById(id);
        
        if(model.isPresent()) {
        	ShareType st = model.get();
        	st.setIsDeteled(1);
            return shareTypeRepository.save(st);
       }
        else {
        	return model.get();
        }
    }
    
    @DeleteMapping("/share-types/{id}")
    @ResponseBody
    public boolean delete(@PathVariable Integer id) {
        Optional<ShareType> model = shareTypeRepository.findById(id);        

        if(model.isPresent() ) {
        	ShareType st = model.get();
            if(st.getIsDeteled() == 1) {
            	shareTypeRepository.delete(st);
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
