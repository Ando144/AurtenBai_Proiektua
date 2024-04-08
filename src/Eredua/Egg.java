package src.Eredua;

public class Egg extends Tamagotchi{
    
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
		setChanged();
		notifyObservers();
    }
    public void bihotzakEguneratu(int multi1){
        this.bizitza = this.bizitza +(10 * multi1);
    }
    public void katiluakEguneratu(int multi2){
        this.asetasuna = this.asetasuna +(10 * multi2);
    }

}
