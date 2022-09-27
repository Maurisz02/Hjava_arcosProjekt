package hu.petrik.harcosProjekt;

import java.io.IOException;
import java.util.Scanner;

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

        Scanner sc = new Scanner(System.in);
        System.out.println("Add meg a harcosod nevét: ");
        String nev = sc.nextLine();
        System.out.println("Add meg a harcosod státusz sablonát(1-3):");
        int statusz = sc.nextInt();

        Harcos h4 = new Harcos(nev,statusz);
        titanLista.getHarcosok().add(h4);

        //System.out.println(titanLista);

        System.out.println("A karaktered: "+ h4);
        char valasz = 'w';
        while(valasz != 'c')
        for(int i = 0; i < titanLista.getHarcosok().size();i++){
            System.out.println(i+1+". "+titanLista.getHarcosok().get(i));
        }
        System.out.println("Mit Szeretnél csinálni?\n a, Megküzdeni egy harcossal\n b, Gyógyulni\n c, Kilépni");
        valasz = sc.nextLine().charAt(0);
        if (valasz == 'a'){
            
        }


    }
}
