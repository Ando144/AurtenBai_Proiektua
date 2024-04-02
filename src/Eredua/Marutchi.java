package src.Eredua;

public class Marutchi extends Tamagotchi{

    public Marutchi(int pBizitza, int pAsetasuna, boolean pGaixorik, boolean pKaka){
        super(pBizitza, pAsetasuna, pGaixorik, pKaka);
    }

    @Override
    public void kontadoreakEguneratu(){  
        if (this.kaka){
            this.osasunaGalduKaka();
        }
        if (this.gaixorik){
            this.osasunaGalduGaixorik();
        }
        this.bizitza -= 1;
        this.asetasuna -= 1;
		setChanged();
		notifyObservers();
    }
}
