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
    private Tamagotchi getTamagotchi(){
        return this;
    }
    public Tamagotchi eboluzionatuTama(boolean kaka, boolean gaixorik){
        Tamagotchi nireTama= new Kuchipatchi(bizitza, asetasuna, gaixorik, kaka);
        return nireTama;
     }
    public Tamagotchi eboluzionatuTama2(boolean kaka, boolean gaixorik){
       Tamagotchi nireTama= new Mimitchi(bizitza, asetasuna, gaixorik, kaka);
       return nireTama;
    }
   public Tamagotchi azkenEbol(boolean kaka, boolean gaixo){
        Tamagotchi nireTama = this.getTamagotchi();
        if((gaixo==false) && (kaka==false)){
            nireTama = new Marutchi(bizitza, asetasuna, gaixorik, kaka);
        }
        else{
            nireTama = new Maskutchi(bizitza, asetasuna, gaixorik, kaka);
        }
        return nireTama;
   }

}
