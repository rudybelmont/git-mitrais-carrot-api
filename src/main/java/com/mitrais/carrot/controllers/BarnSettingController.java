package com.mitrais.carrot.controllers;

import com.mitrais.carrot.config.Config;
import com.mitrais.carrot.models.BarnSetting;
import com.mitrais.carrot.repositories.BarnSettingRepository;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * BarnSetting crud controller
 *
 * @author rudy@mitrais.com
 */
@CrossOrigin
@RestController
@RequestMapping(Config.BASE_URI_API)
public class BarnSettingController {

    @Autowired
    public BarnSettingRepository barnSettingRepository;

    @GetMapping("/barns-settings")
    @ResponseBody
    public Iterable<BarnSetting> all() {
        return barnSettingRepository.findAll();
    }

    @PostMapping("/barns-settings")
    @ResponseBody
    public BarnSetting save(@Valid @RequestBody BarnSetting body) {
        return barnSettingRepository.save(body);
    }

    @GetMapping("/barns-settings/{id}")
    @ResponseBody
    public Optional<BarnSetting> detail(@PathVariable Integer id) {
        return barnSettingRepository.findById(id);
    }

    @PutMapping("/barns-settings/{id}")
    @ResponseBody
    public BarnSetting update(@PathVariable Integer id, @Valid @RequestBody BarnSetting body) {
        Optional<BarnSetting> model = barnSettingRepository.findById(id);
        BarnSetting sl = model.get();
        return barnSettingRepository.save(sl);
    }

    @DeleteMapping("/barns-settings/{id}")
    @ResponseBody
    public String delete(@PathVariable Integer id) {
        Optional<BarnSetting> sl = barnSettingRepository.findById(id);
        barnSettingRepository.delete(sl.get());
        return "";
    }
}
