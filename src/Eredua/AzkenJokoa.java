package src.Eredua;

import java.util.Observable;

import src.Bista.AzkenJokoaBista;


public class AzkenJokoa extends Observable{
    private static AzkenJokoa nireAzkenJokoa = null;
    private int emitzaJokalaria;
    private int emaitzaOrdenagailua;
    public static AzkenJokoa getAzkenJokoa(){
        if (nireAzkenJokoa == null){
            nireAzkenJokoa = new AzkenJokoa();
        }
        return nireAzkenJokoa;
    }


    

	public static void main(String[] args) {
        AzkenJokoa part = new AzkenJokoa();
		AzkenJokoaBista instance = new AzkenJokoaBista(part);
	}


    public void partidaBatJokatu()
    {
        setChanged();
        notifyObservers("Partida bat jokatu");

    }
    public void jokoaHasieratu(){
     
    }
    public void setEmaitza(int pIndex, int pBalioa){

    }

    private void rondaJokatu(String pAukera){
        String randomAukera = randomAukera();
        if (pAukera.equals(randomAukera)) 
        {
            setChanged();
            notifyObservers("Enpate");
        } 
        else if ((pAukera.equals("piedra") && randomAukera.equals("tijera")) ||
               (pAukera.equals("papel") && randomAukera.equals("piedra")) ||
               (pAukera.equals("tijera") && randomAukera.equals("papel"))) 
        {
            setChanged();
            notifyObservers("Win");
            emitzaJokalaria++;
        } else {
            setChanged();
            notifyObservers("Lose");
            //return false;
        }
    }
    private String randomAukera(){
        String[] opciones = {"piedra", "papel", "tijera"};
        int randomIndex = (int) (Math.random() * opciones.length);
        setChanged();
        notifyObservers(opciones[randomIndex]);
        return opciones[randomIndex];
    }
    /*  Eredua                         bista
     *  empiezalapartida-------------<
     */
}
