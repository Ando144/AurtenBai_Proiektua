package src.Eredua;
import java.util.Observable;
import java.util.Observer;

public abstract class Gelaxka extends Observable{
        private int indarra;
        protected Gelaxka(int pIndarra){
            this.indarra=pIndarra;
        }
        public void ikutu(){
            this.indarra-=1;
        }
        public int getIndarra(){
            return this.indarra;
        }
        public void setIndarra(int pZenbaki){
            this.indarra=pZenbaki;
        }
}
