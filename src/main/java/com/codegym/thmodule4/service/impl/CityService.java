package com.codegym.thmodule4.service.impl;

import com.codegym.thmodule4.model.City;
import com.codegym.thmodule4.repository.CityRepository;
import com.codegym.thmodule4.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CityService implements ICityService {
    @Autowired
    private CityRepository cityRepository;
    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findById(Long id) {
        Optional<City> cityOptional = cityRepository.findById(id);
        return cityOptional.get();
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);

    }

    @Override
    public void remove(Long id) {
        cityRepository.deleteById(id);

    }
}
