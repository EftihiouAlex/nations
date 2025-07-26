package com.nations.service;

import com.nations.dao.CountriesMapper;
import com.nations.dto.CountriesDTO;
import com.nations.dto.CountriesHighestGDP;
import com.nations.model.Countries;
import com.nations.dto.CountriesStatsDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CountriesService {

    @Autowired
    private CountriesMapper countriesMapper;

    public List<CountriesHighestGDP> getAllCountriesHighestGDP(){
        List<CountriesHighestGDP> highestGDPCountries = new ArrayList<>();
        List<CountriesStatsDTO> countryStats = countriesMapper.findCountryStats();

        HashMap<Long, CountriesStatsDTO> gdpMap = new HashMap();
        for (CountriesStatsDTO countryStat : countryStats) {
            long countryId = countryStat.getCountryId();
            if (!gdpMap.containsKey(countryId)) {
                gdpMap.put(countryId, countryStat);
            } else {
                CountriesStatsDTO existing = gdpMap.get(countryId);

                double currentRatio = countryStat.getGdp().doubleValue() / countryStat.getPopulation();
                double existingRatio = existing.getGdp().doubleValue() / existing.getPopulation();

                if (currentRatio > existingRatio) {
                    gdpMap.put(countryId, countryStat);
                }
            }

        }

        List<Countries> countries = countriesMapper.fetchCountries();
        for (Countries country : countries) {
            long countryId = country.getCountryId();
            BigDecimal gdp = null;
            long population = 0;
            int year = 0;
            if (gdpMap.containsKey(countryId)){
                gdp = BigDecimal.valueOf(gdpMap.get(countryId).getGdp());
                population = gdpMap.get(countryId).getPopulation();
                year = gdpMap.get(countryId).getYear();
            }

            CountriesHighestGDP highestGDPCountry = new CountriesHighestGDP(
                    countryId,
                    country.getName(),
                    country.getCountryCode3(),
                    year,
                    population,
                    gdp);
            highestGDPCountries.add(highestGDPCountry);
        }

        return highestGDPCountries;
    }



    public List<CountriesDTO> getFetchedCountries(){
        List<Countries> originalCountriesList = countriesMapper.fetchCountries();
        List<CountriesDTO> fetchedCountriesList = new ArrayList<>();


        for(Countries country : originalCountriesList){
            fetchedCountriesList.add(new CountriesDTO(country.getCountryId(), country.getName(), country.getArea(), country.getCountryCode2()));
        }

        return fetchedCountriesList;
    }

    public List<CountriesStatsDTO> getCountriesAllStats(){
        return countriesMapper.findCountryStats();
    }

    public List<CountriesStatsDTO> getFilteredStats(@Param("yearFrom") int yearFrom, @Param("yearTo") int yearTo){
        return countriesMapper.getFilteredStats(yearFrom, yearTo);
    }
}
