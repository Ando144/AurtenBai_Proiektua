package src.Eredua;

import java.util.Observable;

public class Tamagotchi extends Observable{
    protected int bizitza;
    protected int asetasuna;
    protected boolean gaixorik;
    protected boolean kaka;
    private Egoera egoeraGK;
    private Egoera egoeraEbol;

    public Tamagotchi(int pBizitza, int pAsetasuna, boolean pGaixorik, boolean pKaka) {
        this.bizitza = pBizitza;
        this.asetasuna = pAsetasuna;
        this.gaixorik = pGaixorik;
        this.kaka = pKaka;
        this.egoeraGK = new Osasuntsu();
        this.egoeraEbol = new Egg();
    }
    
    public String zeinEboluzioDa(){
        if (this.egoeraEbol instanceof Egg){
            return "Egg";
        }else if (this.egoeraEbol instanceof Kuchipatchi){
            return "Kuchipatchi";
        }else if (this.egoeraEbol instanceof Mimitchi){
            return "Mimitchi";
        }else if (this.egoeraEbol instanceof Maskutchi){    
            return "Maskutchi";
        }else{    
            return "Marutchi";
        }
    }

    public void setKaka(boolean pKaka){
        this.kaka = pKaka;
    }
    public boolean getKaka(){
        return this.kaka;
    }
    public void setGaixorik(boolean pGaixorik){
        this.gaixorik = pGaixorik;
    }
    public boolean getGaixorik(){
        return this.gaixorik;
    }
    public void setEgoeraGK(Egoera pEgoera){
        this.egoeraGK = pEgoera;
    }
    public void setEgoeraEbol(Egoera pEgoera){
        this.egoeraEbol = pEgoera;
    }
    public void gaixotu(){
        this.egoeraGK.gaixotu(this);
    }
    public void kakaEgin(){
        this.egoeraGK.kakaEgin(this);
    }
    public void sendatu(){
        this.egoeraGK.sendatu(this);
    }
    public void eboluzionatuTama(){
        /*Tamagotchi nireTama;
        if(this instanceof Egg){
            nireTama = new Kuchipatchi(bizitza, asetasuna, gaixorik, kaka, egoeraGK);
        }else if(this instanceof Kuchipatchi){
            nireTama = new Mimitchi(bizitza, asetasuna, gaixorik, kaka, egoeraGK);
        }else{
            if((gaixorik==false) && (kaka==false)){                                                STATE GABE
                nireTama = new Marutchi(bizitza, asetasuna, gaixorik, kaka, egoeraGK);
            }else{
                nireTama = new Maskutchi(bizitza, asetasuna, gaixorik, kaka, egoeraGK);
            }
        }*/
        this.egoeraEbol.eboluzionatu(this);                                          //              STATE-EKIN
    }
    public void kontadoreakEguneratu(){
        if (this.kaka){
            this.osasunaGalduKaka();
        }
        else if (this.gaixorik){
            this.osasunaGalduGaixorik();
        }
        this.egoeraEbol.kontadoreakEguneratu(this);
        if(this.bizitza <= 0){
            this.bizitza = 0;
        }
        if(this.asetasuna <= 0){
            this.asetasuna = 0;
        }
		setChanged();
		notifyObservers();
    }
    private void osasunaGalduKaka(){
        bizitza = bizitza - 5;
        asetasuna = asetasuna + 10;
    }
    private void osasunaGalduGaixorik(){
        bizitza = bizitza - 7;
        asetasuna = asetasuna - 5;
    }

    /*public void zeinEgoeraGK(){
        if(this.egoeraGK instanceof Osasuntsu){
            System.out.println("Osasuntsu");
        }else if(this.egoeraGK instanceof Kaka){
            System.out.println("Kaka");
        }else if(this.egoeraGK instanceof Gaixorik){
            System.out.println("Gaixorik");
        }
    }*/
}
