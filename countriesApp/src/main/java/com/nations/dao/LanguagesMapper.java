package com.nations.dao;

import com.nations.dto.LanguagesDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LanguagesMapper {

    List<LanguagesDTO> findSpokenLanguages(@Param("id") long id);
}
