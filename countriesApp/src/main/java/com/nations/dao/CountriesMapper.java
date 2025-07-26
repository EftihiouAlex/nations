package com.nations.dao;

import com.nations.model.Countries;
import com.nations.dto.CountriesStatsDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface CountriesMapper {

     List<Countries> fetchCountries();

     List<CountriesStatsDTO> findCountryStats();

     List<CountriesStatsDTO> getFilteredStats(@Param("yearFrom") int yearFrom, @Param("yearTo") int yearTo);
}
