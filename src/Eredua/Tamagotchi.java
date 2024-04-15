package src.Eredua;

import java.util.Observable;

public abstract class Tamagotchi extends Observable{
    //protected int bizitza;
    //protected int asetasuna;
    protected boolean gaixorik;
    protected boolean kaka;

    protected Tamagotchi(/*int pBizitza, int pAsetasuna,*/ boolean pGaixorik, boolean pKaka) {
        //this.bizitza = pBizitza;
        //this.asetasuna = pAsetasuna;
        this.gaixorik = pGaixorik;
        this.kaka = pKaka;
    }
    
    public String zeinEboluzioDa(){
        if (this instanceof Egg){
            return "Egg";
        }else if (this instanceof Kuchipatchi){
            return "Kuchipatchi";
        }else if (this instanceof Mimitchi){
            return "Mimitchi";
        }else if (this instanceof Maskutchi){    
            return "Maskutchi";
        }else{    
            return "Marutchi";
        }
    }

   // public boolean bizirikDago(){
     //   return (bizitza > 0 && asetasuna > 0);
    //}
    public void setKaka(boolean pKaka){
        this.kaka = pKaka;
    }
    public boolean getKaka(){
        return this.kaka;
    }
    public boolean getGaixorik(){
        return this.gaixorik;
    }
    public void setGaixorik(boolean pGaixorik){
        this.gaixorik = pGaixorik;
    }
   /* public void jokoaEgin(){
        if (bizirikDago()){
            if (kaka){
                osasunaGalduKaka();
            }
            if (gaixorik){
                osasunaGalduGaixorik();
            }
        }
        kontadoreakEguneratu();
    }*/
    
    //public abstract void kontadoreakEguneratu(); 
   // public abstract void bihotzakEguneratu(int multiplikatzaile1);
    //public abstract void katiluakEguneratu(int multiplikatzaile2 );
  //  public abstract int getBizitzaTama();
    //public abstract int getAseTama();
   /* protected void osasunaGalduKaka(){
        bizitza = bizitza - 5;
        asetasuna = asetasuna + 10;
    }*/

  /*  protected void osasunaGalduGaixorik(){
        bizitza = bizitza - 7;
        asetasuna = asetasuna - 5;
    }*/
    public Tamagotchi getTamagotchi(){
        return this;
    }
    public Tamagotchi eboluzionatuTama(){
        Tamagotchi nireTama;
        if(this instanceof Egg){
            nireTama = new Kuchipatchi(gaixorik, kaka);
        }else if(this instanceof Kuchipatchi){
            nireTama = new Mimitchi(gaixorik, kaka);
        }else{
            if((gaixorik==false) && (kaka==false)){
                nireTama = new Marutchi(gaixorik, kaka);
            }else{
                nireTama = new Maskutchi(gaixorik, kaka);
            }
        }
        return nireTama;
    }
    /* public Tamagotchi eboluzionatuTama2(boolean kaka, boolean gaixorik){
       Tamagotchi nireTama= new Mimitchi(/*bizitza, asetasuna, gaixorik, kaka);
       return nireTama;
    }
    public void katiluakEguneratu2(int multi2){     
        this.asetasuna = this.asetasuna +(10*multi2);
    } */
    /*public int getBizitza(){
        return this.bizitza;
    }*/
   /* public int getAsetasuna(){
        return this.asetasuna;
    }*/
    /*public void bihotzakEguneratu(int multi1){
        this.bizitza=this.bizitza +(10*multi1);
    }*/
   /* public void katiluakEguneratu(int multi2){
        this.asetasuna=this.asetasuna +(10*multi2);
    }
   public Tamagotchi azkenEbol(boolean kaka, boolean gaixo){
        Tamagotchi nireTama = this.getTamagotchi();
        if((gaixo==false) && (kaka==false)){
            nireTama = new Marutchi(/*bizitza, asetasuna, gaixorik, kaka);
        }
        else{
            nireTama = new Maskutchi(/*bizitza, asetasuna, gaixorik, kaka);
        }
        return nireTama;
   }*/

}
