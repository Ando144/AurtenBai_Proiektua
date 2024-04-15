package src.Eredua;

public class Mimitchi extends Tamagotchi{

    public Mimitchi(/*int pBizitza, int pAsetasuna,*/boolean pGaixorik, boolean pKaka){
        super(/*int pBizitza, int pAsetasuna,*/ pGaixorik, pKaka);
    }

   /* @Override
    public void kontadoreakEguneratu(){
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
    public void bihotzakEguneratu(int multi1){
        this.bizitza = this.bizitza +(10 * multi1);
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
