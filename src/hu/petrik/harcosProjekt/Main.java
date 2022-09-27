package hu.petrik.harcosProjekt;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Harcos h1 = new Harcos("Maurisz", 2);
        Harcos h2 = new Harcos("Kopcsak",1);
        Harcos h3 = new Harcos("Valentyo", 3);

        Harcosok titanLista = new Harcosok(new Harcos[]{h1,h2,h3});

        Harcosok titanLista1 = null;

        try{
            titanLista1 = new Harcosok("harcosok.csv");
            titanLista.getHarcosok().addAll(titanLista1.getHarcosok());
        }catch (IOException e){
            System.err.println("Ismeretlen hiba történt a fájl beolvasás folyamán");
        }

        System.out.println(titanLista);


    }
}
