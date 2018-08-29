package com.mitrais.carrot.controllers;

import com.mitrais.carrot.config.Config;
import com.mitrais.carrot.models.BazaarItem;
import com.mitrais.carrot.repositories.BazaarItemRepository;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * BazaarItem crud controller
 *
 * @author Febri_MW251@mitrais.com
 */
@CrossOrigin
@RestController
@RequestMapping(Config.BASE_URI_API)
public class BazaarItemController {

    @Autowired
    public BazaarItemRepository bazaarItemsRepository;

    @GetMapping("/bazaars-items")
    @ResponseBody
    public Iterable<BazaarItem> all() {
        return bazaarItemsRepository.findAll();
    }

    @PostMapping("/bazaars-items")
    @ResponseBody
    public BazaarItem save(@Valid @RequestBody BazaarItem body) {
        return bazaarItemsRepository.save(body);
    }

    @GetMapping("/bazaars-items/{id}")
    @ResponseBody
    public Optional<BazaarItem> detail(@PathVariable Integer id) {
        return bazaarItemsRepository.findById(id);
    }

    @PutMapping("/bazaars-items/{id}")
    @ResponseBody
    public BazaarItem update(@PathVariable Integer id, @Valid @RequestBody BazaarItem body) {
        Optional<BazaarItem> model = bazaarItemsRepository.findById(id);
        BazaarItem sl = model.get();
        return bazaarItemsRepository.save(sl);
    }

    @DeleteMapping("/bazaars-items/{id}")
    @ResponseBody
    public String delete(@PathVariable Integer id) {
        Optional<BazaarItem> sl = bazaarItemsRepository.findById(id);
        bazaarItemsRepository.delete(sl.get());
        return "";
    }
}
