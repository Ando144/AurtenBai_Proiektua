package src.Eredua;

public class Jokoa {
    private static Jokoa nJokoa;
    private Partida currentPartida;

    private Jokoa(){}

    public static Jokoa getJokoa(){
        if (nJokoa == null){
            nJokoa = new Jokoa();
        }
        return nJokoa;
    }

    public void partidaBatJokatu(){
        currentPartida = new Partida();
    }
}
