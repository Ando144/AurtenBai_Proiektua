package src.Eredua;

import java.util.*;

import src.Bista.panelNagusia;

import java.io.*;

public class Partida extends Observable{
    private int score;
    private String izena;
    private int candy;
    private int soup;
    private Tamagotchi tamagotchi;
	private int bizitza;
    private static Partida nirePartida;
	private int Puntuazioa;

	public Partida(){
        this.score = 0;
        //this.izena = "";
        this.candy = 0;
        this.soup = 0;
        this.tamagotchi = new Egg(40, 40, false, false);
    }

	public void resetPartida(){
		nirePartida = null;
	}

	public static Partida getPartida()
    {
        if(nirePartida == null)
        {
			System.out.println("partida berria egin da");
            nirePartida = new Partida();
        }
        return nirePartida;
    }
    public static void main(String [] args){
		Partida.getPartida().partidaBatJokatu();
	}
    public void partidaBatJokatu(){
			boolean bukatuta = false;

			Partida nirePartida =new Partida();
			panelNagusia frame = new panelNagusia(nirePartida);
			nirePartida.hasieratuPartida();
			//frame.setVisible(true);
			try{
				Thread.sleep(4000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			nirePartida.eboluzionatuTamagotchi();
			nirePartida.tamagotchiEguneratu();
			Thread lausegundo = new Thread(()->{
					while(!bukatuta){
						System.out.println("lau seg    "+this.tamagotchi.kaka+ "   /////////////////////");
						nirePartida.bihotzakEguneratu();
						nirePartida.sopakEguneratu(); 
						nirePartida.scoreEguneratu();
						nirePartida.minijokoaJokatu();
						//nirePartida.tamagotchiEguneratu();
						try{
							Thread.sleep(5000);
						}
						catch (InterruptedException e) {
							e.printStackTrace();
						}
	
					}
				});
			lausegundo.start();
			Thread hilo20segundo= new Thread(()->{
				while (nirePartida.getGaixorik()==false && nirePartida.getKaka()==false) {
					nirePartida.kakaEgin();
					try {
						Thread.sleep(20000); // Espera 20 segundo
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			hilo20segundo.start();

			try {
				Thread.sleep(20000); // Espera 20 segundo
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			
			System.out.println("40 falta");
			nirePartida.eboluzionatuTamagotchi2();
			try{
				Thread.sleep(10000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("azkenboluzioa");

			nirePartida.azkeneboluzioa();
			//nirePartida.tamagotchiEguneratu();
			/* 
			Thread lausegundo = new Thread(()->{
				while(true){
					nirePartida.bihotzakEguneratu();
					nirePartida.sopakEguneratu(); 
					nirePartida.scoreEguneratu();
					nirePartida.tamagotchiEguneratu();
					try{
						Thread.sleep(4000);
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			});
			lausegundo.start();
			Thread hilo20segundo= new Thread(()->{
				while (nirePartida.kakaEgin()==false && nirePartida.gaixorikEgon()==false) {
					nirePartida.kakaEgin();
					try {
						Thread.sleep(10000); // Espera 20 segundo
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			try {
				Thread.sleep(10000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			hilo20segundo.start();
			Thread hilo15segundo =new Thread(()->{
				while (true) {
					nirePartida.eboluzionatuTamagotchi();
					try{
						Thread.sleep(15000);
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			hilo15segundo.start();
			try{
				Thread.sleep(40000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			nirePartida.azkeneboluzioa();*/
    }
	private boolean getGaixorik(){
		return this.tamagotchi.gaixorik;
	}
	private boolean getKaka(){
		return this.tamagotchi.kaka;
	}
	public void tamaSendatu(){
		this.tamagotchi.gaixorik=false;
	}
	public void tamaKakaGarbitu(){
		this.tamagotchi.kaka=false;
	}
	public void tamaJan(int biz, int ase){

		System.out.println(biz);
		System.out.println(ase);
		//this.tamagotchi.bizitza = this.tamagotchi.bizitza + biz;
		this.tamagotchi.bihotzakEguneratu(biz);
		bihotzakEguneratu();
		this.tamagotchi.katiluakEguneratu(ase);
		sopakEguneratu();
		//this.tamagotchi.asetasuna = this.tamagotchi.asetasuna + ase;
	
		System.out.println("tama bizitza"+this.tamagotchi.getBizitzaTama());
		System.out.println("tamagotchi asetasuna"+this.tamagotchi.getAseTama());
	}
	private void hasieratuPartida(){
		setChanged();
		notifyObservers("hasieratu");
	}
    private void bihotzakEguneratu() {
		this.tamagotchi.kontadoreakEguneratu();
		int zenb1 = this.tamagotchi.getBizitzaTama();
		System.out.println("bihotz--------------"+zenb1);
		//int kont=0;
		if (zenb1>=31) {
			setChanged();
            notifyObservers("4bihotzjarri");
		}
		if (zenb1>=21 && zenb1<=30) {
			setChanged();
            notifyObservers("3bihotzjarri");
		}
		if (zenb1>=11 && zenb1<=20) {
			setChanged();
            notifyObservers("2bihotzjarri");
		}
		if (zenb1>=1 && zenb1<=10) {
			setChanged();
            notifyObservers("bihotz1jarri");
		}
        if (zenb1<=0){
			setChanged();
            notifyObservers("hildaDagoBihotz");
		}
	}
    private void sopakEguneratu() {
		this.tamagotchi.kontadoreakEguneratu();
		System.out.println("-------------------/"+ this.tamagotchi.asetasuna);
		int zenb = this.tamagotchi.getAseTama();
		System.out.println("asetasun"+zenb);
		//int kont=0;
		if (zenb>=31) {
			setChanged();
            notifyObservers("4sopajarri");
		}
		if (zenb>=21 && zenb<=30) {
			setChanged();
            notifyObservers("3sopajarri");
		}
		if (zenb>=11 && zenb<=20) {
			setChanged();
            notifyObservers("2sopajarri");
		}
		if (zenb>=1 && zenb<=10) {
			setChanged();
            notifyObservers("sopa1jarri");
		}
		if(zenb<=0){
			setChanged();
            notifyObservers("hildaDagoKat");
		}
	}
	private void kakaEgin(){ //mira si se hace kk
		Random probabilitatea = new Random();
		System.out.println("KAIXO");
		int zenbakia = probabilitatea.nextInt(101);
		System.out.println("kaka zenb "+zenbakia);
		if(1<=zenbakia && zenbakia<=20 && this.tamagotchi.kaka==false){
			this.tamagotchi.setKaka(true);
			kakaBistaratu(true);
		}
		else{
			System.out.println("kaka ez du egin");
			this.tamagotchi.setKaka(false);
			gaixotuAhalDa(this.tamagotchi.kaka); //aqui salta a otro metodo para ver si se puede enfermar (no puede hacer kaka y enfermar a la misma vez)
		}
	}
	private void gaixotuAhalDa(boolean kaka){
		if (kaka==false) {
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			this.tamagotchi.kaka=false;
			gaixorikEgon();
		}
	}
	private void gaixorikEgon(){
		Random probabilitatea = new Random();
		int zenbakia = probabilitatea.nextInt(101);
		System.out.println("gaixo zenb "+zenbakia);
		if(1<=zenbakia && zenbakia<=30){
			this.tamagotchi.gaixorik = true;
			gaixoBistaratu(this.tamagotchi.gaixorik );
		}
	}
	private boolean minijokoaJokatu(){
		Random probabilitatea = new Random();
		int zenbakia = probabilitatea.nextInt(101);
		if(1<=zenbakia && zenbakia<=12){
			setChanged();
			notifyObservers("MiniJokua");
			return true;
		}
		else{
			return false;
		}
	}
	private void kakaBistaratu(boolean kaka){
		if(kaka==true){
			setChanged();
			notifyObservers("kaka");
		}
	}
	private  void gaixoBistaratu(boolean gaixo){
		if(gaixo==true){
			setChanged();
			notifyObservers("gaixo");
		}
	}
	private void tamagotchiEguneratu( ){
		String izena =this.tamagotchi.zeinEboluzioDa();
		System.out.println(izena);
		if (izena == "Marutchi") {
			setChanged();
			notifyObservers("marutchi");
		}
		if (izena == "Kuchipatchi") {
			setChanged();
			notifyObservers("kuchipatchi");
		}
		if (izena == "Maskutchi") {
			setChanged();
			notifyObservers("maskutchi");
		}
		if (izena == "Mimitchi") {
			System.out.println("hemen nago mimi");
			setChanged();
			notifyObservers("mimitchi");
		}

	}
	private void eboluzionatuTamagotchi(){
		this.tamagotchi = this.tamagotchi.eboluzionatuTama(this.tamagotchi.kaka, this.tamagotchi.gaixorik);
		tamagotchiEguneratu();
	}
	private void eboluzionatuTamagotchi2(){//esto hay que ponerlo bien solamente era una prueba ra ver si funcionaban las co
				//this.tamagotchi = new Mimitchi(40, 40, false, false);
				//tamagotchiEguneratu();
				System.out.println("mimimi");
				this.tamagotchi = this.tamagotchi.eboluzionatuTama2(this.tamagotchi.kaka, this.tamagotchi.gaixorik);
				tamagotchiEguneratu();
	}
	public int getScore(){
		//Puntuazioa = this.score;
		System.out.println("El score del this.score es: "+this.score);
		return scoreEguneratu();
	}
	private int Puntuacion;
	private int scoreEguneratu(){
		//+1 cada vez que pasan 4 segundos
		Puntuacion=Puntuacion +1;
		if (this.tamagotchi.gaixorik==true){
			Puntuacion =Puntuacion - 5;
		}
		if (this.tamagotchi.kaka==true){
			Puntuacion =Puntuacion - 5;
		}
		if (this.tamagotchi.zeinEboluzioDa()=="Marutchi"){
			Puntuacion =Puntuacion + 20;
		}
		/*Minijokoa minijokoa=Minijokoa.getMinijokoa();
		if(minijokoa.irabaziDu()==true){
			Puntuacion =Puntuacion + 20;
		}
		if(minijokoa.irabaziDu()==false){
			Puntuacion =Puntuacion - 20;
		}*/
		System.out.println("Puntuacion "+ Puntuacion);

		//si se da una piruleta o sopa +5 
		setChanged();
		notifyObservers("Puntuazioa");
		return Puntuacion;
	}
	public void sumarPuntuacion(int puntuacion){
		Puntuacion = Puntuacion + puntuacion;
	}

	private void azkeneboluzioa(){
		this.tamagotchi=this.tamagotchi.azkenEbol(this.tamagotchi.kaka, this.tamagotchi.gaixorik);
		tamagotchiEguneratu();
	}
}
