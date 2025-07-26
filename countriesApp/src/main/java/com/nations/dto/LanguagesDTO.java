package com.nations.dto;

public class LanguagesDTO {
    private long languageId;
    private long official;
    private String language;
    private String countryName;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(long languageId) {
        this.languageId = languageId;
    }

    public long getOfficial() {
        return official;
    }

    public void setOfficial(long official) {
        this.official = official;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
