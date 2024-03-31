package src.Eredua;

import java.util.Observable;

public abstract class Tamagotchi extends Observable{
    protected int bizitza;
    protected int asetasuna;
    protected boolean gaixorik;
    protected boolean kaka;

    protected Tamagotchi(int pBizitza, int pAsetasuna, boolean pGaixorik, boolean pKaka) {
        this.bizitza = pBizitza;
        this.asetasuna = pAsetasuna;
        this.gaixorik = pGaixorik;
        this.kaka = pKaka;
    }
    
    public String zeinEboluzioDa(){
        if (this instanceof Egg){
            return "Egg";
        }else if (this instanceof Kuchipatchi){
            return "Kuchipatchi";
        }else if (this instanceof Mimitchi){
            return "Mimitchi";
        }else if (this instanceof Maskutchi){    
            return "Maskutchi";
        }else{    
            return "Marutchi";
        }
    }

    public abstract void kontadoreakEguneratu();

    protected void osasunaGalduKaka(){
        bizitza -= 5;
        asetasuna += 10;
    }

    protected void osasunaGalduGaixorik(){
        bizitza -= 7;
        asetasuna += 5;
    }



}
