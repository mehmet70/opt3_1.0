package com.company;

public interface Observer {
    static void Notify(Gebruiker gebruiker){
        System.out.println(gebruiker.naam + ", alle gegevens zijn opgeslagen");
    }
}
