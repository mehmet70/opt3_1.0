package com.company;

import java.util.*;

public class WeekMenu {
    static String[] dagen = new String[]{"Maandag", "Dinsdag", "Woensdag", "Donderdag", "Vrijdag", "Zaterdag", "Zondag"};
    static int dag = 0;
    public static List<Gerecht> gesorteerdeGerecht = Gerecht.getAllGerechten();

    public static void sorteerDagen() {
        Collections.sort(gesorteerdeGerecht, Comparator.comparing(Gerecht::getLaatstGegeten));

        for(Gerecht gerecht : gesorteerdeGerecht)
        {
            if (dag == 6){
                dag = 0;
            }
            System.out.println(dagen[dag] + ": " + gerecht.getNaam());
            dag ++;
        }
        dag = 0;
    }

}
