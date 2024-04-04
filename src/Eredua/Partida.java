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
	public Partida(){
        this.score = 0;
        //this.izena = "";
        this.candy = 0;
        this.soup = 0;
        this.tamagotchi = new Kuchipatchi(15, 15, false, false);
    }

	public void resetPartida(){
		nirePartida = null;
	}

	public static Partida getPartida()
    {
        if(nirePartida == null)
        {
            nirePartida = new Partida();
        }
        return nirePartida;
    }
    public static void main(String [] args){
			Partida nirePartida =new Partida();
			panelNagusia frame = new panelNagusia(nirePartida);

			nirePartida.hasieratuPartida();
			try{
				Thread.sleep(2000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			//nirePartida.tamagotchiEguneratu();
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
			System.out.println("itxaron 10 seg");
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
			
    }
	private void hasieratuPartida(){
		System.out.println("hemen nago");
		setChanged();
		notifyObservers("hasieratu");
	}
    private void bihotzakEguneratu() {
		System.out.println("hemen nagooooooooooo");
		int zenb = this.tamagotchi.bizitza;
		//int kont=0;
		if (zenb>=31 && zenb<=40) {
			setChanged();
            notifyObservers("4bihotzjarri");
		}
		if (zenb>=21 && zenb<=30) {
			setChanged();
            notifyObservers("3bihotzjarri");
		}
		if (zenb>=11 && zenb<=20) {
			setChanged();
            notifyObservers("2bihotzjarri");
		}
		if (zenb>=1 && zenb<=10) {
			setChanged();
            notifyObservers("bihotz1jarri");
		}
        else{
			setChanged();
            notifyObservers("hildaDago");
		}
	}
    private void sopakEguneratu( ) {
		int zenb = this.tamagotchi.asetasuna;
		//int kont=0;
		if (zenb>=31 && zenb<=40) {
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
		else{
			setChanged();
            notifyObservers("hildaDago");
		}
	}
	public boolean kakaEgin(){ //mira si se hace kk
		boolean kaka = false;
		Random probabilitatea = new Random();
		System.out.println("KAIXO");
		int zenbakia = probabilitatea.nextInt(101);
		System.out.println("kaka zenb "+zenbakia);
		if(1<=zenbakia && zenbakia<=20){
			kaka = true;
			kakaBistaratu(kaka); //aqui si se hace kk salta
		}
		else{
			System.out.println("kaka ez du egin");
			gaixotuAhalDa(kaka); //aqui salta a otro metodo para ver si se puede enfermar (no puede hacer kaka y enfermar a la misma vez)
		}
		
		return kaka;
	}
	public void gaixotuAhalDa(boolean kaka){
		System.out.println(kaka);
		if (kaka==false) {
			System.out.println("kaka ez du eginnnnnnnnnnn");
			gaixorikEgon();
		}
	}
	public boolean gaixorikEgon(){
		boolean gaixo = false;
		Random probabilitatea = new Random();
		int zenbakia = probabilitatea.nextInt(101);
		System.out.println("gaixo zenb "+zenbakia);
		if(1<=zenbakia && zenbakia<=30){
			gaixo = true;
			gaixoBistaratu(gaixo);
		}
		return gaixo;
	}
	public boolean minijokoaJokaatu(){
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
	public void kakaBistaratu(boolean kaka){
		if(kaka==true){
			setChanged();
			notifyObservers("kaka");
		}
	}
	public  void gaixoBistaratu(boolean gaixo){
		if(gaixo==true){
			setChanged();
			notifyObservers("gaixo");
		}
	}
	public void tamagotchiEguneratu(){
		String izena =this.tamagotchi.zeinEboluzioDa();
		if (izena == "Marutchi") {
			setChanged();
			notifyObservers("Marutchi");
		}
		if (izena == "Kuchipatchi") {
			setChanged();
			notifyObservers("Kuchipatchi");
		}
		if (izena == "Maskutchi") {
			setChanged();
			notifyObservers("Maskutchi");
		}
		if (izena == "Mimitchi") {
			setChanged();
			notifyObservers("Mimitchi");
		}

	}
	private void eboluzionatuTamagotchi(){//esto hay que ponerlo bien solamente era una prueba ra ver si funcionaban las co
			String 	TamaIzena;
			if((this.tamagotchi.bizitza<20)||(this.tamagotchi.asetasuna<20)){
				this.tamagotchi = new Mimitchi(40, 40, false, false);
				tamagotchiEguneratu();
			}
			else  {
				System.out.println(this.tamagotchi.bizitza);
				this.tamagotchi = new Maskutchi(19, 19, false, false);
				tamagotchiEguneratu();
			}
	}
	public int getScore(){
		return nirePartida.score;
	}
	private void scoreEguneratu(){
		int puntuazioa=nirePartida.score;
		//+1 cada vez que pasan 4 segundos
		if (this.gaixorikEgon()==true){
			puntuazioa=puntuazioa-5;
		}
		if (this.kakaEgin()==true){
			puntuazioa=puntuazioa-5;
		}
		if (this.tamagotchi.zeinEboluzioDa()=="Marutchi"){
			puntuazioa=puntuazioa+20;
		}
		//si se da una piruleta o sopa +5 
		setChanged();
		notifyObservers("Puntuazioa");
	}

}
