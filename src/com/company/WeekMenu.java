package com.company;

import java.util.*;

public class WeekMenu {
    static String[] dagen = new String[]{"Maandag", "Dinsdag", "Woensdag", "Donderdag", "Vrijdag", "Zaterdag", "Zondag"};
    static int dag = 0;

    public static void sorteerDagen() {
        List<Gerecht> gerechten = Gerecht.getAllGerechten();
        Collections.sort(gerechten, Comparator.comparing(Gerecht::getLaatstGegeten));

        for(Gerecht gerecht : gerechten)
        {
            if (dag == 6){
                dag = 0;
            }
            System.out.println(dagen[dag] + ": " + gerecht.getNaam());
            dag ++;
        }
    }
}
