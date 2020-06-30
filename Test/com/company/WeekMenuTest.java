package com.company;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class WeekMenuTest {

    @Test
    public void sorteerDagen() throws ParseException {
        // Ik maak eerst een array aan
        ArrayList<Gerecht> allGerechten = new ArrayList<Gerecht>();
        //dit zorgt ervoor dat het in de juiste format wordt opgeslagen
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date yourDate = sdf.parse("2022-07-26");
        java.util.Date yourDate1 = sdf.parse("2020-07-26");
        java.util.Date yourDate3 = sdf.parse("2023-07-26");

        // 3 Gerechten met verschillende datums worden opgeslagen
        Gerecht gerecht2 = new Gerecht("Pasta", "pasta", 400, 12, yourDate, true);
        Gerecht gerecht3 = new Gerecht("Friet", "aardappel", 700, 12, yourDate1, true);
        Gerecht gerecht4 = new Gerecht("Pap", "pap", 700, 12, yourDate3, true);
        //Gerechten worden aan de array toegevoegd
        allGerechten.add(gerecht2);
        allGerechten.add(gerecht4);
        allGerechten.add(gerecht3);
        //Dit sorteerd de array op laatst gegeten datum-
        Collections.sort(allGerechten, Comparator.comparing(Gerecht::getLaatstGegeten));


        //Teller houdt bij hoevaak er door de foreach loop is geloopt, vervolgends wordt er gekeken of er op de juiste manier is gesorteerd. Friet, Pasta, Pap
        int teller = 0;
        for(Gerecht gerecht : allGerechten)
        {
            if (teller == 0 ){
                assertEquals(gerecht.getNaam(), "Friet");
            }
            if (teller == 1){
                assertEquals(gerecht.getNaam(), "Pasta");
            }
            if (teller == 2){
                assertEquals(gerecht.getNaam(), "Pap");
            }
            teller++;
        }
    }
}