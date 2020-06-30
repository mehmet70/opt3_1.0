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
        System.out.println("5. Bekijk dag gerechten");
        Integer output = scanner.nextInt();

        if (output.equals(1)){
            Gerecht.gerechtToevoegen(scanner, gebruiker);
            System.out.println("1. terug naar menu");
            output = scanner.nextInt();
            if (output == 1 ){
                startMenu(gebruiker);
            }
        }
        if (output.equals(2)){
            Gerecht.deleteGerecht(gebruiker);
            System.out.println("1. terug naar menu");
            output = scanner.nextInt();
            if (output == 1 ){
                startMenu(gebruiker);
            }
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
            Gerecht.showAllGerechten();
            System.out.println("1. terug naar menu");
            output = scanner.nextInt();
            if (output == 1 ){
                startMenu(gebruiker);
            }
        }
        if (output.equals(5)){
            System.out.println("Kies een dag:");
            System.out.println("0. Maandag");
            System.out.println("1. Dinsdag");
            System.out.println("2. Woensdag");
            System.out.println("3. Donderdag");
            System.out.println("4. Vrijdag");
            System.out.println("5. Zaterdag");
            System.out.println("6. Zondag");
            output = scanner.nextInt();
            DagGerecht.getGerechtPerDay(output);
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
