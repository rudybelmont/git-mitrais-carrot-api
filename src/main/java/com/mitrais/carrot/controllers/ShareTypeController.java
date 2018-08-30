package com.mitrais.carrot.controllers;

import com.mitrais.carrot.config.Config;
import com.mitrais.carrot.models.ShareType;
import com.mitrais.carrot.repositories.ShareTypeRepository;
import java.util.Optional;
import javax.validation.Valid;
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
        return shareTypeRepository.save(sl);
    }

    @DeleteMapping("/share-types/{id}")
    @ResponseBody
    public String delete(@PathVariable Integer id) {
        Optional<ShareType> sl = shareTypeRepository.findById(id);
        shareTypeRepository.delete(sl.get());
        return "";
    }
}
