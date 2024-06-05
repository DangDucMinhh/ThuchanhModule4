package com.codegym.thmodule4.controller;

import com.codegym.thmodule4.model.Country;
import com.codegym.thmodule4.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    private ICountryService countryService;
    @GetMapping("")
    public ResponseEntity<List<Country>> getAllCountry(){
        List<Country> countryList = countryService.findAll();
        return new ResponseEntity<>(countryList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(Long id) {
        Country country = countryService.findById(id);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<String> addCountry(@RequestBody Country country) {
        countryService.save(country);
        String message = "add thanh cong";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> editCountry(@PathVariable Long id, @RequestBody Country country) {
        country.setId(id);
        countryService.save(country);
        String message = "Updated thanh cong";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCountry(@PathVariable Long id){
        countryService.remove(id);
        String message = "Deleted thanh cong";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}