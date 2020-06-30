package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Gerecht {
    private String naam;
    private String soort;
    private Integer calorieën;
    private Integer bereidingstijd;
    private Date laatstGegeten;
    private Boolean vegetarisch;
    private String gezondHeidsLabel;
    private static ArrayList<Gerecht> allGerechten = new ArrayList<Gerecht>();

    public Gerecht(String naam, String soort, Integer calorieën, Integer bereidingstijd, Date laatstGegeten, Boolean vegetarisch) {
        this.naam = naam;
        this.soort = soort;
        this.calorieën = calorieën;
        this.bereidingstijd = bereidingstijd;
        this.laatstGegeten = laatstGegeten;
        this.vegetarisch = vegetarisch;

        if (calorieën <= 250) {
            this.gezondHeidsLabel= "Erg Gezond";
        }
        if (calorieën > 250 && calorieën <= 450) {
            this.gezondHeidsLabel= "Gezond";
        }
        if (calorieën > 450 && calorieën <= 600) {
            this.gezondHeidsLabel= "Ongezond";
        }
        if (calorieën >600) {
            this.gezondHeidsLabel= "Erg Ongezond";
        }

    }

    public String getNaam() {
        return naam;
    }

    public String getSoort() {
        return soort;
    }

    public Integer getCalorieën() {
        return calorieën;
    }

    public Integer getBereidingstijd() {
        return bereidingstijd;
    }

    public Date getLaatstGegeten() {
        return laatstGegeten;
    }

    public Boolean getVegetarisch() {
        return vegetarisch;
    }

    public String getGezondHeidsLabel() {
        return gezondHeidsLabel;
    }

    public static void loadGerechten() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date yourDate = sdf.parse("2020-07-26");
        java.util.Date yourDate1 = sdf.parse("2022-07-26");
        java.util.Date yourDate2 = sdf.parse("2015-07-26");
        java.util.Date yourDate3 = sdf.parse("2021-07-26");

        Gerecht gerecht2 = new Gerecht("Pasta", "pasta", 400, 12, yourDate, true);
        Gerecht gerecht3 = new Gerecht("Friet", "aardappel", 700, 12, yourDate1, true);
        Gerecht gerecht4 = new Gerecht("Pannenkoek", "deeg", 900, 12, yourDate2, true);
        Gerecht gerecht5 = new Gerecht("Salade", "groente", 20, 12, yourDate3, true);
        Gerecht gerecht6 = new Gerecht("Bami", "Mixed", 20, 12, yourDate3, true);
        Gerecht gerecht7 = new Gerecht("Stampot", "groente", 20, 12, yourDate3, true);
        Gerecht gerecht8 = new Gerecht("Erwten Soep", "Soep", 20, 12, yourDate3, true);

        allGerechten.add(gerecht2);
        allGerechten.add(gerecht3);
        allGerechten.add(gerecht4);
        allGerechten.add(gerecht5);
        allGerechten.add(gerecht6);
        allGerechten.add(gerecht7);
        allGerechten.add(gerecht8);
    }

    public static void gerechtToevoegen(Scanner scanner, Gebruiker gebruiker ) throws ParseException {

        System.out.println("Wat is de naam van het gerecht?");
        scanner.nextLine();
        String naam = scanner.nextLine();

        System.out.println("Wat voor soort gerecht is het?");
        String soort = scanner.nextLine();

        System.out.println("Hoeveel calorieën bevat het gerecht?");
        Integer calorieën = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Wat is de bereidingstijd van het gerecht in minuten?");
        Integer bereidingstijd = scanner.nextInt();

        System.out.println("Is het gerecht vegetarisch? Beantwoord met true of false");
        Boolean vegetarisch = scanner.nextBoolean();
        scanner.nextLine();

        System.out.println("Wanneer is het gerecht voor het laatst gegeten? (Dag/Maand/Jaar)");
        String laatstGegeten = scanner.nextLine();
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(laatstGegeten);

        Gerecht gerecht = new Gerecht(naam, soort, calorieën, bereidingstijd, date, vegetarisch);
        Observer.Notify(gebruiker);
        System.out.println("gerecht succesvol toegevoegd:");
        System.out.println("Gerecht gegevens:");
        System.out.println("|Naam: " + gerecht.getNaam() + " |Soort: " + gerecht.getSoort() + " |Calorieën: " + gerecht.getCalorieën() + " |Bereidingstijd: " + gerecht.getBereidingstijd() + " |Vegetarisch: " + gerecht.getVegetarisch() + " |Laatst Gegeten: " + gerecht.getLaatstGegeten());
        System.out.println(gerecht.getGezondHeidsLabel());
        allGerechten.add(gerecht);

    }

    public static ArrayList<Gerecht> getAllGerechten() {
        return allGerechten;
    }

    public static void deleteGerecht( Gebruiker gebruiker) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("kies het gerecht dat u wilt verwijderen");
        int teller = 0;
        for (Gerecht gerecht: allGerechten) {
            teller++;
            System.out.println(teller +". " + gerecht.getNaam());
        }
        teller = 0;
        Integer input = scanner.nextInt();
        for (Gerecht gerecht: allGerechten) {
            teller ++;
            if (input.equals(teller)){
                System.out.println("Weet u zeker dat u " + gerecht.getNaam() + " wilt verwijderen?");
                System.out.println("1. Ja");
                System.out.println("2. Nee");
                input = scanner.nextInt();
                if (input.equals(1)){
                    System.out.println(gerecht.getNaam());
                   allGerechten.remove(gerecht);
                    Menu.startMenu(gebruiker);
                }
                if (input.equals(2)){

                }
            }
        }
    }
    public static void showAllGerechten(){
        for (Gerecht gerecht: allGerechten) {
            System.out.println("Naam: " + gerecht.getNaam() + " | soort: " + gerecht.soort + " | calorieën :" + gerecht.calorieën + " | Gezondheid :" + gerecht.gezondHeidsLabel + " | Bereidingstijd: " + gerecht.bereidingstijd + " | Vegetarisch: " + gerecht.vegetarisch + " | Laatst Gegeten: " + gerecht.laatstGegeten );
        }
    }

    public static void Notify(){
        System.out.println("Gegevens zijn opgeslagen!");
    }

}