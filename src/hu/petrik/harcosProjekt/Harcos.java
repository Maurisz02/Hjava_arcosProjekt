package hu.petrik.harcosProjekt;

public class Harcos {
    private String nev;
    private int szint;
    private int tapasztalat;
    private int eletero;
    private int alapEletero;
    private int alapSebzes;

    Harcos(String nev, int statuszSablon){
        this.nev = nev;
        this.szint = 1;
        this.tapasztalat=0;

        if (statuszSablon==1){
            this.alapEletero = 15;
            this.alapSebzes = 3;
        }else if(statuszSablon==2){
            this.alapEletero = 12;
            this.alapSebzes = 4;
        }else if(statuszSablon==3){
            this.alapEletero = 8;
            this.alapSebzes = 5;
        }else{
            System.out.println("Hiba");
        }

        this.eletero = getMaxEletero();

    }

    public String getNev(){
        return this.nev;
    }

    public void setNev(String nev){
        this.nev = nev;
    }

    public int getSzint(){
        return this.szint;
    }

    public void setSzint(int szint){
        this.szint=szint;
    }

    public int getTapasztalat(){
        return this.tapasztalat;
    }

    public void setTapasztalat(int tapasztalat){
        this.tapasztalat = tapasztalat;
    }

    public int getAlapEletero(){
        return this.alapEletero;
    }

    public int getAlapSebzes(){
        return this.alapSebzes;
    }

    public int getEletero(){
        return  this.eletero;
    }

    public void setEletero(int eletero){
        this.eletero = eletero;
    }

    public int getSebzes(){
        int sebzes = this.alapSebzes*this.szint;
        return sebzes;
    }

    public int getSzintLepeshez(){
        int szintLepes = 10 + this.szint * 5;
        return szintLepes;
    }

    public int getMaxEletero(){
    int maxElet = this.alapEletero + this.szint * 3;
    return  maxElet;
    }

    public void megkuzd(Harcos h){
        if(h.nev == this.nev && h.szint == this.szint){
            System.out.println("Saját magaddal nem tudsz harcolni!");
        }else if(h.eletero==0 || this.eletero==0){
            System.out.println("Nem tudsz harcolni, ha valamelyikőtök életereje 0");
        }else{
            int tamadoS = this.getSebzes();
            int tamadoE = this.getEletero();
            int vedoS = h.getSebzes();
            int vedoE = h.getEletero();
            vedoE = vedoE-tamadoS;
            h.setEletero(vedoE);
            //vagy getEletero t vizsgálunk
            if (vedoE > 0){
                tamadoE = tamadoE-vedoS;
                this.setEletero(tamadoE);
                h.setTapasztalat(5);
                if (tamadoE > 0){
                    this.setTapasztalat(5);
                }else{
                    h.setTapasztalat(10);
                }
            }else{
                this.setTapasztalat(10);
            }

        }

    }

    public void gyogyul(){

    }

    @Override
    public String toString() {
        return String.format("%s - LVL: %d - EXP: %d/%d - HP: %d/%d - DMG: %d",this.nev,getSzint(),getTapasztalat(),getSzintLepeshez(),getEletero(),getMaxEletero(),getSebzes());
    }
}
