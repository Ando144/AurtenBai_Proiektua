package src.Eredua;

public class Mimitchi extends Tamagotchi{

    public Mimitchi(int pBizitza, int pAsetasuna, boolean pGaixorik, boolean pKaka, EgoeraGK pEgoeraGK){
        super(pBizitza, pAsetasuna, pGaixorik, pKaka, pEgoeraGK);
    }

    @Override
    public void kontadoreakEguneratu(){
        if (this.kaka){
            this.osasunaGalduKaka();
        }
        if (this.gaixorik){
            this.osasunaGalduGaixorik();
        }
        this.bizitza -= 7;
        this.asetasuna -= 7;

        if(this.bizitza <= 0){
            this.bizitza = 0;
        }
        if(this.asetasuna <= 0){
            this.asetasuna = 0;
        }
		setChanged();
		notifyObservers();
    }
}
