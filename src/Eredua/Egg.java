package src.Eredua;

public class Egg extends Tamagotchi{
    
    public Egg (int pBizitza, int pAsetasuna, boolean pGaixorik, boolean pKaka){
        super(pBizitza, pAsetasuna, pGaixorik, pKaka);
    }

    @Override
    protected void kontadoreakEguneratu(){
        if (this.kaka){
            this.osasunaGalduKaka();
        }
        else if (this.gaixorik){
            this.osasunaGalduGaixorik();
        }
    }

}
