package src.Eredua;
import java.util.Observable;
import java.util.Observer;

public abstract class Gelaxka extends Observable{
        private int indarra;
        protected Gelaxka(int pIndarra){
            this.indarra=pIndarra;
        }
        public void laukiaAktualizatu(){
            if(this.indarra>0){
                this.indarra-=1;
                Partida.getPartida().sumarPuntuacion(1);
                setChanged();
                notifyObservers("laukiAktualizatu");//cambiar el color del panel
                //convertirlo en invisible
            }
        }
        public void ikutu(){
        }
        public int getIndarra(){
            return this.indarra;
        }
        public void setIndarra(int pZenbaki){
            this.indarra=pZenbaki;
        }
}
