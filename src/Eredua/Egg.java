package src.Eredua;

public class Egg /*implements EgoeraGK*/ extends Tamagotchi{

    /*@Override
    public void sendatu(Tamagotchi tamagotchi) {}
    @Override
    public void kakaEgin(Tamagotchi tamagotchi) {}
    @Override
    public void gaixotu(Tamagotchi tamagotchi) {}

    @Override
    public void eboluzionatu(Tamagotchi tamagotchi) {
        tamagotchi.setEgoeraGK(new Kuchipatchi());
    }*/
    
    public Egg (int pBizitza, int pAsetasuna, boolean pGaixorik, boolean pKaka){
        super(pBizitza, pAsetasuna, pGaixorik, pKaka);
    }

    @Override
    public void kontadoreakEguneratu(){
        if (this.kaka){
            this.osasunaGalduKaka();
        }
        else if (this.gaixorik){
            this.osasunaGalduGaixorik();
        }

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
