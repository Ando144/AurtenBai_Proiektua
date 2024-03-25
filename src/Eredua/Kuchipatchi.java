package src.Eredua;

public class Kuchipatchi extends Tamagotchi{

    public Kuchipatchi(int pBizitza, int pAsetasuna, boolean pGaixorik, boolean pKaka){
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
        this.bizitza -= 2;
        this.asetasuna -= 5;
		setChanged();
		notifyObservers();
    }
}
