package src.Eredua;

import java.util.Observable;

import src.Bista.AzkenJokoaBista;


public class AzkenJokoa extends Observable{
    private static AzkenJokoa nireAzkenJokoa = null;
    private Aukera aukeraJokalaria;
    private Aukera aukeraOrdenagailua;
    private int puntJokalaria;
    private int puntOrdenagailua;
    //private boolean jokIrabazi;


    private AzkenJokoa(){
        aukeraJokalaria = null;
        aukeraOrdenagailua = null;
        puntJokalaria = 0;
        puntOrdenagailua = 0;
        //jokIrabazi = false;
    }

    public static AzkenJokoa getAzkenJokoa(){
        if (nireAzkenJokoa == null){
            nireAzkenJokoa = new AzkenJokoa();
        }
        return nireAzkenJokoa;
    }
    public void reset(){
        aukeraJokalaria = null;
        aukeraOrdenagailua = null;
        puntJokalaria = 0;
        puntOrdenagailua = 0;
        //jokIrabazi = false;
        nireAzkenJokoa = null;
    }
	public static void main(String[] args) {
        AzkenJokoa.getAzkenJokoa().partidaBatJokatu();
	}
    public void partidaBatJokatu(){
        new AzkenJokoaBista(this);
    }
    public int getPuntJokalaria(){
        return puntJokalaria;
    }
    public int getPuntOrdenagailua(){
        return puntOrdenagailua;
    }
    public void rondaBatJokatu(){
        if(aukeraJokalaria != null){
            aukeraJokalaria.jokatu(this, randomAukera());
            aukeraJokalaria = null;
            aukeraOrdenagailua = null;
        }
    }
    public void jokRondaIrabazi(){
        puntJokalaria++;
        setChanged();
        if(puntJokalaria >= 2){
            //jokIrabazi = true;
            notifyObservers("jIrabazi");
        }else{
            notifyObservers("rIrabazi");
        }
    }
    public void jokRondaGaldu(){
        puntOrdenagailua++;
        setChanged();
        if(puntOrdenagailua >= 2){
            notifyObservers("jGaldu");
        }else{
            notifyObservers("rGaldu");
        }
    }
    public void rondaBerdinketa(){
        setChanged();
        notifyObservers("rBerdinketa");
    }
    public void jokalariaAukeraEgin(Aukera pAukera){
        aukeraJokalaria = pAukera;
    }
    private Aukera randomAukera(){
        Aukera[] aukerak = {new Harria(), new Orria(), new Artazia()};
        int randomIndex = (int) (Math.random() * aukerak.length);
        this.aukeraOrdenagailua = aukerak[randomIndex];
        setChanged();
        notifyObservers(aukeraOrdenagailua.getClass().getSimpleName());
        return aukeraOrdenagailua;
    }

}
