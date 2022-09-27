package hu.petrik.harcosProjekt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Harcosok {

    private List<Harcos> harcosok;

    public Harcosok(Harcos[] harcosTomb){
        this.harcosok =  new ArrayList<>();
        this.harcosok.addAll(Arrays.asList(harcosTomb));
    }

    public Harcosok (String fajlNev) throws IOException{
        this.harcosok =  new ArrayList<>();
        FileReader fr = new FileReader(fajlNev);
        BufferedReader br = new BufferedReader(fr);
        String sor = br.readLine();
        while(sor != null && !sor.equals("")){
            String[] adatok = sor.split(";");
            Harcos harcos = new Harcos(adatok[0],Integer.parseInt(adatok[1]));
            this.harcosok.add(harcos);
            sor = br.readLine();
        }
        br.close();
        fr.close();
    }

    public List<Harcos> getHarcosok(){
        return harcosok;
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        for(Harcos h: this.harcosok){
            sb.append(h.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
