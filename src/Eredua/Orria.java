package src.Eredua;

public class Orria implements Aukera{

    @Override
    public void jokatu(AzkenJokoa partida, Aukera aukOrdenagailu) {
        if(aukOrdenagailu instanceof Harria){
            partida.jokRondaIrabazi();
        }else if(aukOrdenagailu instanceof Artazia){
            partida.jokRondaGaldu();
        }else{
            partida.rondaBerdinketa();
        }
    }
    
}
