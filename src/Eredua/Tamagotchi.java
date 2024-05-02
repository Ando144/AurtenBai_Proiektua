package src.Eredua;

import java.util.Observable;
import java.util.Random;

public class Tamagotchi extends Observable{
    protected int bizitza;
    protected int asetasuna;
    protected boolean gaixorik;
    protected boolean kaka;
    private Egoera egoeraGK;
    private Egoera egoeraEbol;
    private int kontTimerZikloak;

    public Tamagotchi(int pBizitza, int pAsetasuna, boolean pGaixorik, boolean pKaka) {
        this.bizitza = pBizitza;
        this.asetasuna = pAsetasuna;
        this.gaixorik = pGaixorik;
        this.kaka = pKaka;
        this.egoeraGK = new Osasuntsu();
        this.egoeraEbol = new Egg();
        this.kontTimerZikloak = 0;
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
    public void errebibitu(){
        this.egoeraGK.sendatu(this);
        this.bizitza = 40;
        this.asetasuna = 40;
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
        kontTimerZikloak++;
        if(kontTimerZikloak == 3){
            this.egoeraEbol.eboluzionatu(this);                                          //              STATE-EKIN
            tamagotchiEguneratu();
            kontTimerZikloak = 0;
        }
    }
	private void tamagotchiEguneratu( ){
		String izena =this.zeinEboluzioDa();
		//System.out.println(izena);
		if (izena == "Marutchi") {
			setChanged();
			notifyObservers(15);
		}
		if (izena == "Kuchipatchi") {
			setChanged();
			notifyObservers(17);
		}
		if (izena == "Maskutchi") {
			setChanged();
			notifyObservers(18);
		}
		if (izena == "Mimitchi") {
			setChanged();
			notifyObservers(16);
		}

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
		//setChanged();
		//notifyObservers();
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
	public void kakaEdoGaixoSaiatu(){
        if(this.kaka==false && this.gaixorik==false){
            Random probabilitatea = new Random();
            System.out.println("KAIXO");
            int zenbakia = probabilitatea.nextInt(101);
            System.out.println("kaka zenb "+zenbakia);
            if(1<=zenbakia && zenbakia<=20 && this.kaka==false){
                //this.tamagotchi.setKaka(true);
                this.kakaEgin();
                kakaBistaratu(true);
            }
            else{
                probabilitatea = new Random();
                zenbakia = probabilitatea.nextInt(101);
                System.out.println("gaixo zenb "+zenbakia);
                if(1<=zenbakia && zenbakia<=30){
                    //this.tamagotchi.gaixorik = true;
                    this.gaixotu();
                    gaixoBistaratu(true);
                }
            }
        }
	}
	private void kakaBistaratu(boolean kaka){
		String izena=this.zeinEboluzioDa();
		if(kaka==true){
			setChanged();
			notifyObservers(12);
			if (izena == "Marutchi") {
				setChanged();
				notifyObservers(20);
			}
		}
	}
	private void gaixoBistaratu(boolean gaixo){
		String izena=this.zeinEboluzioDa();
		if(gaixo==true){
			setChanged();
			notifyObservers(13);
			if (izena == "Marutchi") {
				setChanged();
				notifyObservers(21);
			}
		}
	}
}
