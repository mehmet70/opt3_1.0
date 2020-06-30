package com.company;

import java.text.ParseException;
import java.util.Scanner;

public final class Menu {

    private static Menu INSTANCE;

    private Menu() {
    }

    public static void startMenu(Gebruiker gebruiker) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("goedendag, " + gebruiker.getNaam() + " " + gebruiker.getAchternaam());
        System.out.println("Wat wilt u uitvoeren?");
        System.out.println("Voer een nummer in");
        System.out.println("1. Gerecht toevoegen");
        System.out.println("2. Gerecht Verwijderen");
        System.out.println("3. Week Gerechten Bekijken");
        System.out.println("4. Bekijk alle gerechten");
        Integer output = scanner.nextInt();

        if (output.equals(1)){
            Gerecht.gerechtToevoegen(scanner, gebruiker);
        }
        if (output.equals(2)){
            Gerecht.deleteGerecht(gebruiker);
        }
        if (output.equals(3)){
            WeekMenu.sorteerDagen();
            System.out.println("1. terug naar menu");
            output = scanner.nextInt();
            if (output == 1 ){
                startMenu(gebruiker);
            }
        }
        if (output.equals(4)){
            Gerecht.showAllGerechten(gebruiker);
            System.out.println("1. terug naar menu");
            output = scanner.nextInt();
            if (output == 1 ){
                startMenu(gebruiker);
            }
        }
    }

    public static Menu getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Menu();
        }
        return INSTANCE;
    }
}
