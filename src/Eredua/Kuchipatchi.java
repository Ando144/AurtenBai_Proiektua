package src.Eredua;

public class Kuchipatchi implements Egoera /*extends Tamagotchi*/{

    @Override
    public void sendatu(Tamagotchi tamagotchi) {}
    @Override
    public void kakaEgin(Tamagotchi tamagotchi) {}
    @Override
    public void gaixotu(Tamagotchi tamagotchi) {}

    @Override
    public void eboluzionatu(Tamagotchi tamagotchi) {
        tamagotchi.setEgoeraEbol(new Mimitchi());
    }

    @Override
    public void kontadoreakEguneratu(Tamagotchi tamagotchi){
        tamagotchi.bizitza -= 2;
        tamagotchi.asetasuna -= 5;
    }

    /*public Kuchipatchi(int pBizitza, int pAsetasuna, boolean pGaixorik, boolean pKaka, EgoeraGK pEgoeraGK){
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
        this.bizitza -= 2;
        this.asetasuna -= 5;

        if(this.bizitza <= 0){
            this.bizitza = 0;
        }
        if(this.asetasuna <= 0){
            this.asetasuna = 0;
        }
		setChanged();
		notifyObservers();
    }*/
}
