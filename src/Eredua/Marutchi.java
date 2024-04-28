package src.Eredua;

public class Marutchi extends Tamagotchi{

    public Marutchi(int pBizitza, int pAsetasuna, boolean pGaixorik, boolean pKaka, EgoeraGK pEgoeraGK){
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
        this.bizitza -= 1;
        this.asetasuna -= 1;

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
