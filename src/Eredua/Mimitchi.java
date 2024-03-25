package src.Eredua;

public class Mimitchi extends Tamagotchi{

    public Mimitchi(int pBizitza, int pAsetasuna, boolean pGaixorik, boolean pKaka){
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
        this.bizitza -= 7;
        this.asetasuna -= 7;
		setChanged();
		notifyObservers();
    }
}
