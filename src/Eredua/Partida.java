package src.Eredua;

import java.util.*;

import src.Bista.panelNagusia;

import java.io.*;

public class Partida extends Observable{
    private int score;
    private String izena;
    private Tamagotchi tamagotchi;
	private boolean minijokoaMartxan;
	private Timer lausegundo;
	private TimerTask task;
	//private int piruletak;
	//private int koilarak;
	private JanariMultzoa janariMultzoa;
	private static Partida partida = null;

	public Partida(){
        this.score = 0;
		this.minijokoaMartxan = false;
        this.tamagotchi = new Tamagotchi(40, 40, false, false);
		//this.piruletak = 0;
		//this.koilarak = 0;
		this.janariMultzoa = new JanariMultzoa();
		this.lausegundo = new Timer();
		this.lausegundo.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
				if(!minijokoaMartxan && !amaituDa()){
					minijokoaJokatu();
					scoreEguneratu();
					eboluzioaSaiatu();
					kakaEdoGaixoSaiatu();
					tamagotchi.kontadoreakEguneratu();
					bihotzakEguneratu();
					sopakEguneratu();
					System.out.println("--------------------------BIZITZA:     "+Partida.getPartida().tamagotchi.bizitza);
					System.out.println("--------------------------ASETASUNA:   "+Partida.getPartida().tamagotchi.asetasuna);
					System.out.println("--------------------------KAKA:        "+Partida.getPartida().tamagotchi.kaka);
					System.out.println("--------------------------GAIXO:       "+Partida.getPartida().tamagotchi.gaixorik);
				}
            }		
        }, 4000, 4000);
    }
	public void setMinijokoaMartxan(boolean pMinijokoaMartxan){
		this.minijokoaMartxan = pMinijokoaMartxan;
	}

	public static Partida getPartida()
    {
        if(Partida.partida == null)
        {
            Partida.partida = new Partida();
        }
        return Partida.partida;
    }

	public void reset(){
		this.tamagotchi = null;
		this.lausegundo.cancel();
		this.lausegundo = null;
		Partida.partida = null;
	}

    public void PartidaHasiera(){
		new panelNagusia(this, this.tamagotchi);
	} 

	public void setIzena(String izena){
		if(izena.length() > 0){
			this.izena = izena;
		}else{
        	this.izena = "¡zen #ar¡K";
		}
	}
	public void gordePartida(){
		PartidaErregistro.getPartidaErregistro().eguneratu(this.score, this.izena);
	}
	private boolean getGaixorik(){
		return tamagotchi.gaixorik;
	}
	private boolean getKaka(){
		return tamagotchi.kaka;
	}
	public Tamagotchi getTamagotchi(){
		return tamagotchi;
	}
	public void minijokoaAmaituDa(){
		minijokoaMartxan = false;
	}
	public void tamaBirusKendu(){
		//tamagotchi.setGaixorik(false);
		tamagotchi.sendatu();
	}
	public void tamaKakaGarbitu(){
		//tamagotchi.setKaka(false);
		tamagotchi.sendatu();
	}
	private void hasieratuPanelNagusia(){
		setChanged();
		notifyObservers(1);
	}
	public void tamaJan(){
		/*int punt=0;
		int biz = this.piruletak;
		int ase = this.koilarak;
		this.piruletak = 0; this.koilarak = 0; 
		System.out.println(biz);
		System.out.println(ase);
		if(biz!=0){
			Puntuacion= Puntuacion+(biz * 3)-1;
			this.tamagotchi.bizitza = this.tamagotchi.bizitza +(10 * biz);
			System.out.println(this.tamagotchi.bizitza+" bizitzan sartu nahiz");
			bihotzakEguneratu();
			scoreEguneratu();
		}
		if (ase!=0) {
			Puntuacion= Puntuacion+(ase * 3)-1;
			score = score + punt;
			this.tamagotchi.asetasuna = this.tamagotchi.asetasuna +(10 * ase);               COMPOSITE GABE
			sopakEguneratu();
			scoreEguneratu();
		}
		if(biz!=0 && ase!=0){
			Puntuacion=Puntuacion+((ase + biz)*(ase *3 + biz *3))-1;
			scoreEguneratu();
		}*/
		this.janariMultzoa.jan();                                                      //    COMPOSITE-EKIN
	}

    private void bihotzakEguneratu() {
		if(this.tamagotchi.bizitza > 41){
			score= score - 6;
			scoreEguneratu();
			this.tamagotchi.bizitza = 35;
		}
		
		if (this.tamagotchi.bizitza>=31) {
			setChanged();
            notifyObservers(2);
		}
		if (this.tamagotchi.bizitza>=21 && this.tamagotchi.bizitza<=30) {
			setChanged();
            notifyObservers(3);
		}
		if (this.tamagotchi.bizitza>=11 && this.tamagotchi.bizitza<=20) {
			setChanged();
            notifyObservers(4);
		}
		if (this.tamagotchi.bizitza>=1 && this.tamagotchi.bizitza<=10) {
			setChanged();
            notifyObservers(5);
		}
        if (this.tamagotchi.bizitza<=0){
			lausegundo.cancel();
			setChanged();
            notifyObservers(7);
			AzkenJokoa.getAzkenJokoa().partidaBatJokatu();
		}
	}
    private void sopakEguneratu() {
		if (this.tamagotchi.asetasuna>41){
			score= score - 6;
			scoreEguneratu();
			this.tamagotchi.asetasuna = 35;
		}
		if (this.tamagotchi.asetasuna>=31) {
			setChanged();
            notifyObservers(8);
		}
		if (this.tamagotchi.asetasuna>=21 && this.tamagotchi.asetasuna<=30) {
			setChanged();
            notifyObservers(9);
		}
		if (this.tamagotchi.asetasuna>=11 && this.tamagotchi.asetasuna<=20) {
			setChanged();
            notifyObservers(10);
		}
		if (this.tamagotchi.asetasuna>=1 && this.tamagotchi.asetasuna<=10) {
			setChanged();
            notifyObservers(11);
		}
		if(this.tamagotchi.asetasuna<=0){
			lausegundo.cancel();
			setChanged();
            notifyObservers(6);
		}
	}
	private void kakaEdoGaixoSaiatu(){
		tamagotchi.kakaEdoGaixoSaiatu();
	}
	private boolean minijokoaJokatu(){
		Random probabilitatea = new Random();
		int zenbakia = probabilitatea.nextInt(101);
		
		if(1<=zenbakia && zenbakia<=12){
			setChanged();
			notifyObservers(14);
			minijokoaMartxan = true;
			return true;
		}
		else{
			return false;
		}
	}
	private void eboluzioaSaiatu(){
		tamagotchi.eboluzionatuTama();
	}
	public int getScore(){
		return score;
	}
	//private int Puntuacion;
	private int diferencia;
	private void scoreEguneratu(){
		//+1 cada vez que pasan 4 segundos
		score=score +1;
		if (this.tamagotchi.gaixorik==true){
			score =score - 5;
		}
		if (this.tamagotchi.kaka==true){
			score =score - 5;
		}
		/*if (this.tamagotchi.zeinEboluzioDa().equals("Marutchi")){
			score =score + 20;
		}
		if(this.tamagotchi.bizitza>40){
			score = score -5;
		}
		if(this.tamagotchi.asetasuna>40){
			score = score -5;
		}*/
		/*Minijokoa minijokoa=Minijokoa.getMinijokoa();
		if(minijokoa.irabaziDu()==true){
			Puntuacion =Puntuacion + 20;
		}
		if(minijokoa.irabaziDu()==false){
			Puntuacion =Puntuacion - 20;
		}*/

		//si se da una piruleta o sopa +5 
		/*if(score<0){
			score=0;
		}*/
		//score = Puntuacion;
		setChanged();
		notifyObservers(19);
	}
	
	public boolean amaituDa( ){
		int b = this.tamagotchi.bizitza;
		int a = this.tamagotchi.asetasuna;
		boolean amaitu =false;
		if (b<=0){
			amaitu=true;
			//lausegundo.cancel();
			//setChanged();
			//notifyObservers(7);
		}
		if (a<=0){
			amaitu=true;
			//lausegundo.cancel();
			//setChanged();
			//notifyObservers(6);
		}
		return amaitu;
	}
	public void sumarPuntuacion(int pScore){
		this.score = this.score + pScore;
		setChanged();
		notifyObservers(19);
	}
	public void gehituPiruleta(){
		//this.piruletak++;
		this.janariMultzoa.addJanaria(new Piruleta());
	}
	public void gehituKoilara(){
		//this.koilarak++;
		this.janariMultzoa.addJanaria(new Koilara());
	}
	public void gehituBizitza(int pBizitza){
		this.tamagotchi.bizitza = this.tamagotchi.bizitza + pBizitza;
		bihotzakEguneratu();
	}
	public void gehituAsetasuna(int pAsetasuna){
		this.tamagotchi.asetasuna = this.tamagotchi.asetasuna + pAsetasuna;
		sopakEguneratu();
	}
	public void tamagotchiErrebibitu(){
		this.tamagotchi.errebibitu();
		setChanged();
		notifyObservers(22);
		setChanged();
		notifyObservers(2);
		setChanged();
		notifyObservers(8);
		lausegundo = new Timer();
		lausegundo.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
				if(!minijokoaMartxan && !amaituDa()){
					minijokoaJokatu();
					scoreEguneratu();
					eboluzioaSaiatu();
					kakaEdoGaixoSaiatu();
					tamagotchi.kontadoreakEguneratu();
					bihotzakEguneratu();
					sopakEguneratu();
					System.out.println("--------------------------BIZITZA:     "+Partida.getPartida().tamagotchi.bizitza);
					System.out.println("--------------------------ASETASUNA:   "+Partida.getPartida().tamagotchi.asetasuna);
					System.out.println("--------------------------KAKA:        "+Partida.getPartida().tamagotchi.kaka);
					System.out.println("--------------------------GAIXO:       "+Partida.getPartida().tamagotchi.gaixorik);
				}
            }		
        }, 4000, 4000);
	}
	public void partidaBukatu(){
		gordePartida();
		reset();
		setChanged();
		notifyObservers(23);
	}
}
