package com.nations.controllers;

import com.nations.dto.LanguagesDTO;
import com.nations.service.LanguagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/")
@RestController
public class LanguagesController {

    @Autowired
    private LanguagesService languagesService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}/languages")
    public List<LanguagesDTO> getAllSpokenCountryLanguages(@PathVariable long id){
         return languagesService.getAllCountryLanguages(id);
    }
}
