package com.company;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws Exception {
        Gebruiker gebruiker = new Gebruiker("Hans", "Anders");
        Gerecht.loadGerechten();
        Menu.startMenu(gebruiker);
    }


}
