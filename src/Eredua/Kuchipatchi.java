package src.Eredua;

public class Kuchipatchi extends Tamagotchi{

    public Kuchipatchi(int pBizitza, int pAsetasuna, boolean pGaixorik, boolean pKaka){
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
        this.bizitza -= 2;
        this.asetasuna -= 5;
		setChanged();
		notifyObservers();
    }
    /*public void bihotzakEguneratu(int multi1){
        int bizitza1=getBizitzaTama();
        this.bizitza = bizitza1 +(10 * multi1);
        System.out.println("tama claseko bizitza"+this.bizitza);
    }
    public void katiluakEguneratu(int multi2){
       
        this.asetasuna = this.asetasuna +(10 * multi2);
    }
    public int getBizitzaTama(){
        return this.bizitza;
    }
    public int getAseTama(){
        return this.asetasuna;

    }*/
    
}
