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
	private static Partida partida = null;

	public Partida(){
        this.score = 0;
		this.minijokoaMartxan = false;
        this.tamagotchi = new Egg(40, 40, false, false, new Osasuntsu());
		this.lausegundo = new Timer();
		this.lausegundo.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
				if(!minijokoaMartxan && !amaituDa()){
					Partida.getPartida().minijokoaJokatu();
					scoreEguneratu();
					if(Partida.getPartida().getGaixorik()==false && Partida.getPartida().getKaka()==false) {
						Partida.getPartida().kakaEgin();
					}
					Partida.getPartida().eboluzionatuTamagotchi();
					Partida.getPartida().tamagotchi.kontadoreakEguneratu();
					bihotzakEguneratu();
					sopakEguneratu();
					System.out.println("--------------------------BIZITZA:    "+Partida.getPartida().tamagotchi.bizitza);
					System.out.println("--------------------------ASETASUNA:  "+Partida.getPartida().tamagotchi.asetasuna);
					System.out.println("--------------------------KAKA:    "+Partida.getPartida().tamagotchi.kaka);
					System.out.println("--------------------------GAIXO:  "+Partida.getPartida().tamagotchi.gaixorik);
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
			System.out.println("partida berria egin da");
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

	public static void main(String[] args) {
		Partida.getPartida().PartidaHasiera();
	}

    public void PartidaHasiera(){
		new panelNagusia(this);
		//frame.setVisible(true);
		//this.hasieratuPanelNagusia();
		//this.partidaBuklea();
	} 

	/*public void partidaBuklea(){
		while(!amaituDa()){		
			this.bihotzakEguneratu();
			this.sopakEguneratu();
		}
		lausegundo.cancel();
	}*/
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
	public int tamaJan(int biz, int ase){
		int punt=0;
		System.out.println(biz);
		System.out.println(ase);
		//this.tamagotchi.bizitza = this.tamagotchi.bizitza + biz;
		if(biz!=0){
			punt=biz * 3;
			score = score + punt;
			//this.tamagotchi.bihotzakEguneratu(biz);
			this.tamagotchi.bizitza = this.tamagotchi.bizitza +(10 * biz);
			System.out.println(this.tamagotchi.bizitza+" bizitzan sartu nahiz");
			bihotzakEguneratu();
			//scoreEguneratu();
		}
		if (ase!=0) {
			punt= ase * 3;
			score = score + punt;
			this.tamagotchi.asetasuna = this.tamagotchi.asetasuna +(10 * ase);
			sopakEguneratu();
			//scoreEguneratu();
		}
		if(biz!=0 && ase!=0){
			punt=(ase + biz)*(ase *3 + biz *3);
			score= score + punt;
			//scoreEguneratu();
		}
		return punt;
	}

    private void bihotzakEguneratu() {
		if(this.tamagotchi.bizitza > 41){
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
			setChanged();
            notifyObservers(7);
		}
	}
    private void sopakEguneratu() {
		if (this.tamagotchi.asetasuna>41){
			diferencia = this.tamagotchi.asetasuna-40;
			
			this.tamagotchi.asetasuna = this.tamagotchi.asetasuna - diferencia - 5 ;

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
			setChanged();
            notifyObservers(6);
		}
	}
	private void kakaEgin(){ //mira si se hace kk
		Random probabilitatea = new Random();
		System.out.println("KAIXO");
		int zenbakia = probabilitatea.nextInt(101);
		System.out.println("kaka zenb "+zenbakia);
		if(1<=zenbakia && zenbakia<=20 && this.tamagotchi.kaka==false){
			//this.tamagotchi.setKaka(true);
			//REVISAR-------------------------------------!!!
			this.tamagotchi.kakaEgin();
			kakaBistaratu(true);
		}
		else{
			System.out.println("kaka ez du egin");
			this.tamagotchi.setKaka(false);
			gaixorikEgon();
		}
	}
	private void gaixorikEgon(){
		Random probabilitatea = new Random();
		int zenbakia = probabilitatea.nextInt(101);
		System.out.println("gaixo zenb "+zenbakia);
		if(1<=zenbakia && zenbakia<=30){
			//this.tamagotchi.gaixorik = true;
			this.tamagotchi.gaixotu();
			gaixoBistaratu(true);
		}
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
	private void kakaBistaratu(boolean kaka){
		if(kaka==true){
			setChanged();
			notifyObservers(12);
		}
	}
	private  void gaixoBistaratu(boolean gaixo){
		if(gaixo==true){
			setChanged();
			notifyObservers(13);
		}
	}
	private void tamagotchiEguneratu( ){
		String izena =this.tamagotchi.zeinEboluzioDa();
		System.out.println(izena);
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
	private void eboluzionatuTamagotchi(){
		if(tamagotchi instanceof Egg || tamagotchi instanceof Kuchipatchi || tamagotchi instanceof Mimitchi){
			tamagotchi = tamagotchi.eboluzionatuTama();
			tamagotchiEguneratu();
		}
	}
	public int getScore(){
		return score;
	}
	private int Puntuacion;
	private int diferencia;
	private void scoreEguneratu(){
		//+1 cada vez que pasan 4 segundos
		Puntuacion=Puntuacion +1;
		if (this.tamagotchi.gaixorik==true){
			Puntuacion =Puntuacion - 5;
		}
		if (this.tamagotchi.kaka==true){
			Puntuacion =Puntuacion - 5;
		}
		if (this.tamagotchi.zeinEboluzioDa().equals("Marutchi")){
			Puntuacion =Puntuacion + 20;
		}
		if(this.tamagotchi.bizitza>40){
			Puntuacion = Puntuacion -5;
		}
		if(this.tamagotchi.asetasuna>40){
			Puntuacion = Puntuacion -5;
		}
		/*Minijokoa minijokoa=Minijokoa.getMinijokoa();
		if(minijokoa.irabaziDu()==true){
			Puntuacion =Puntuacion + 20;
		}
		if(minijokoa.irabaziDu()==false){
			Puntuacion =Puntuacion - 20;
		}*/

		//si se da una piruleta o sopa +5 
		if(Puntuacion<0){
			Puntuacion=0;
		}
		score = Puntuacion;
		setChanged();
		notifyObservers(19);
	}
	public boolean amaituDa( ){
		//int zenb = tamagotchi.getBizitza();
		//int zenb1= tamagotchi.getAsetasuna();
		//int zenb=tamagotchi.getBizitza();
		int b = this.tamagotchi.bizitza;
		int a = this.tamagotchi.asetasuna;
		boolean amaitu =false;
		if (b<=0){
			amaitu=true;
			notifyObservers(7);
			setChanged();
		}
		if (a<=0){
			amaitu=true;
			notifyObservers(6);
			setChanged();
		}
		return amaitu;
	}
	public void sumarPuntuacion(int puntuacion){
		Puntuacion = Puntuacion + puntuacion;
	}
}
