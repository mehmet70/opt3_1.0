package com.company;

import java.awt.*;
import java.util.*;

public class DagGerecht extends WeekMenu {


    public static void getGerechtPerDay(int inputDay){
        dag = 0;
        Collections.sort(allGerechten, Comparator.comparing(Gerecht::getLaatstGegeten));

        for(Gerecht gerecht : allGerechten)
        {
            if (inputDay == dag ){
                System.out.println(dagen[inputDay] + ": " + gerecht.getNaam());
                System.out.println("Gerecht voor " + dagen[inputDay] +" |Naam: " + gerecht.getNaam() + " |Soort: " + gerecht.getSoort() + " |Calorieën: " + gerecht.getCalorieën() + " |Bereidingstijd: " + gerecht.getBereidingstijd() + " |Vegetarisch: " + gerecht.getVegetarisch() + " |Laatst Gegeten: " + gerecht.getLaatstGegeten());
            }
            dag ++;
        }

    }
}
