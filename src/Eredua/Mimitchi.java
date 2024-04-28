package src.Eredua;

public class Mimitchi implements Egoera /*extends Tamagotchi*/{

    @Override
    public void sendatu(Tamagotchi tamagotchi) {}
    @Override
    public void kakaEgin(Tamagotchi tamagotchi) {}
    @Override
    public void gaixotu(Tamagotchi tamagotchi) {}

    @Override
    public void eboluzionatu(Tamagotchi tamagotchi) {
        if(tamagotchi.kaka || tamagotchi.gaixorik){
            tamagotchi.setEgoeraEbol(new Maskutchi());
        }else{
            tamagotchi.setEgoeraEbol(new Marutchi());
        }
    }

    @Override
    public void kontadoreakEguneratu(Tamagotchi tamagotchi){
        tamagotchi.bizitza -= 7;
        tamagotchi.asetasuna -= 7;
    }

    /*public Mimitchi(int pBizitza, int pAsetasuna, boolean pGaixorik, boolean pKaka, EgoeraGK pEgoeraGK){
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
    }*/
}
