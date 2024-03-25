package src.Eredua;

public class Maskutchi extends Tamagotchi{

    public Maskutchi(int pBizitza, int pAsetasuna, boolean pGaixorik, boolean pKaka){
        super(pBizitza, pAsetasuna, pGaixorik, pKaka);
    }

    @Override
    protected void kontadoreakEguneratu(){  
        if (this.kaka){
            this.osasunaGalduKaka();
        }
        if (this.gaixorik){
            this.osasunaGalduGaixorik();
        }
        this.bizitza -= 3;
        this.asetasuna -= 14;
		setChanged();
		notifyObservers();
    }
}
