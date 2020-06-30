package com.company;

import java.time.temporal.WeekFields;
import java.util.*;

public class WeekMenu {
    static String[] dagen = new String[]{"Maandag", "Dinsdag", "Woensdag", "Donderdag", "Vrijdag", "Zaterdag", "Zondag"};
    static int dag = 0;
    public static ArrayList<Gerecht> allGerechten = new ArrayList<Gerecht>();

    public static void sorteerDagen() {

        // Ik wou als eerst 7 variabelen met de namen maandag, dinsdag etc. maken, Vervolgens een foreach loop maken en met 7 if statements de variabele vullen. CODESMELL
        Collections.sort(allGerechten, Comparator.comparing(Gerecht::getLaatstGegeten));

        for(Gerecht gerecht : allGerechten)
        {
            if (dag == 7){
                dag = 0;
            }
            System.out.println(dagen[dag] + ": " + gerecht.getNaam() + " |laatst gegeten op: " + gerecht.getLaatstGegeten());
            dag ++;
        }
        dag = 0;
    }
    public static void addGerecht(Gerecht gerecht){
        allGerechten.add(gerecht);
    }

    public static ArrayList<Gerecht> getAllGerechten() {
        return allGerechten;
    }
}
