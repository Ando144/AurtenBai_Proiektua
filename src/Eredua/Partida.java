package src.Eredua;

import java.util.*;
import java.io.*;
import java.util.Observable;

public class Partida extends Observable{
    private int score;
    private String izena;
    private int candy;
    private int soup;
    private Tamagotchi tamagotchi;
    private Minijokoa minijokoa;
	public Partida(){
        this.score = 0;
        //this.izena = "";
        this.candy = 0;
        this.soup = 0;
        this.tamagotchi = new Egg(20, 20, false, false);
    }

    public void main(){
			bihotzakEguneratu(20);
        	sopakEguneratu(20);    
    }
    private void bihotzakEguneratu(int pBizitza) {
		System.out.println("hemen nago");
		int zenb = pBizitza;
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
    private void sopakEguneratu(int pAsetasuna) {
		int zenb = pAsetasuna;
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
    /*private void bihotzakBistaratu(int bihotzKop) {
		if(bihotzKop==0) {
           setChanged();
            notifyObservers("hildaDago");
		}
		if(bihotzKop==1) {
            setChanged();
           notifyObservers("bihotz1jarri");
		}
		if(bihotzKop==2) {
			setChanged();
            notifyObservers("2bihotzjarri");
		}
		if(bihotzKop==3) {
            setChanged();
            notifyObservers("3bihotzjarri");
		}
		if(bihotzKop==4) {
			setChanged();
            notifyObservers("4bihotzjarri");	
		}
		} */
   /*  private void sopakBistaratu(int sopaKop) {
		if(sopaKop==0) {
            setChanged();
            notifyObservers("hildaDago");
		}
		if(sopaKop==1) {
            setChanged();
            notifyObservers("sopa1jarri");
		}
		if(sopaKop==2) {
			setChanged();
            notifyObservers("2sopajarri");
		}
		if(sopaKop==3) {
            setChanged();
            notifyObservers("3sopajarri");
		}
		if(sopaKop==4) {
			setChanged();
            notifyObservers("4sopajarri");	
		}
	}*/

}
