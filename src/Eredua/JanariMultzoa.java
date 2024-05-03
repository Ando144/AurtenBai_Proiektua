package src.Eredua;

import java.util.*;

public class JanariMultzoa implements Janaria{

    private List<Janaria> janariKol = new ArrayList<Janaria>();

    @Override
    public void jan() {
        janariKol.stream().forEach(Janaria::jan);

        int p = janariKol.size() * (3 * janariKol.size());
        Partida.getPartida().sumarPuntuacion(p);
        this.janariKol.clear();
    }

    public void addJanaria(Janaria pJanaria){
        janariKol.add(pJanaria);
    }
    
}
