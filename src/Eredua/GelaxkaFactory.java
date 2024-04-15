package src.Eredua;

public class GelaxkaFactory {
    private static GelaxkaFactory nGF =null;
    private GelaxkaFactory(){}
    public static GelaxkaFactory getGF(){
        if(nGF==null){
            nGF= new GelaxkaFactory();
        }
        return nGF;
    }
    public Gelaxka createGelaxka(int pMota){
        Gelaxka nGe=null;
        switch (pMota) {
            case 1: nGe= new Gelaxka1(); break;
            case 2: nGe= new Gelaxka2(); break;
            case 3: nGe= new Gelaxka3(); break;
        }
        return nGe;
    }

}
