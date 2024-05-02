package src.Eredua;

public class Harria implements Aukera{

    @Override
    public void jokatu(AzkenJokoa partida, Aukera aukOrdenagailu) {
        if(aukOrdenagailu instanceof Artazia){
            partida.jokRondaIrabazi();
        }else if(aukOrdenagailu instanceof Orria){
            partida.jokRondaGaldu();
        }else{
            partida.rondaBerdinketa();
        }
    }
    
}
