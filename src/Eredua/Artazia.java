package src.Eredua;

public class Artazia implements Aukera{

    @Override
    public void jokatu(AzkenJokoa partida, Aukera aukOrdenagailu) {
        if(aukOrdenagailu instanceof Orria){
            partida.jokRondaIrabazi();
        }else if(aukOrdenagailu instanceof Harria){
            partida.jokRondaGaldu();
        }else{
            partida.rondaBerdinketa();
        }
    }
    
}
