package com.nations.controllers;

import com.nations.dto.CountriesDTO;
import com.nations.dto.CountriesHighestGDP;
import com.nations.dto.CountriesStatsDTO;
import com.nations.service.CountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/")
public class CountriesController {

    @Autowired
    private CountriesService countryService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all-nations")
    public List<CountriesDTO> getAllCountries(){
        return countryService.getFetchedCountries();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all-nations-stats")
    public List<CountriesStatsDTO> getCountriesAllStats(){
        return countryService.getCountriesAllStats();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all-nations-highest-gdp")
    public List<CountriesHighestGDP> getAllCountriesGDP(){
        return countryService.getAllCountriesHighestGDP();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all-nations-filtered-stats")
    public List<CountriesStatsDTO> getFilteredCountryStats(@RequestParam int yearFrom, @RequestParam int yearTo){
        return countryService.getFilteredStats(yearFrom, yearTo);
    }
}
