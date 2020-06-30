package com.company;

public class Gebruiker {
    private String naam;
    private String achternaam;

    public Gebruiker(String naam, String achternaam) {
        this.naam = naam;
        this.achternaam = achternaam;
    }

    public String getNaam() {
        return naam;
    }

    public String getAchternaam() {
        return achternaam;
    }
}
