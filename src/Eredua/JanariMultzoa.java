package src.Eredua;

import java.util.*;

public class JanariMultzoa implements Janaria{

    private List<Janaria> janariKol = new ArrayList<Janaria>();

    @Override
    public void jan() {
        int kont=0;
        for(Janaria elem: janariKol){
            elem.jan();
            kont++;
        }
        int n = kont*(3*kont);
        Partida.getPartida().sumarPuntuacion(n);
        this.janariKol.clear();
    }

    public void addJanaria(Janaria pJanaria){
        janariKol.add(pJanaria);
    }
    
}
