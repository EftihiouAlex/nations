package com.nations.service;

import com.nations.dao.LanguagesMapper;
import com.nations.dto.LanguagesDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguagesService {

    @Autowired
    private LanguagesMapper languagesMapper;

    public List<LanguagesDTO> getAllCountryLanguages(@Param("id") long id){
        return languagesMapper.findSpokenLanguages(id);
    }
}
