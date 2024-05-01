package src.Eredua;
import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import src.Bista.miniJokoaBista;
import java.util.Timer;
import java.util.TimerTask;


public class Minijokoa extends Observable{
   // Tanto aqui como en vista los ejes estan al reves, primero es lerroa(y) y luego zutabea(x)
   //durante el desarrollo de la aplicacion algunos se han liado con los ejes y han puesto al reves
   //pero por el bien del funcionamiento de la aplicacion se ha decidido dejarlo asi.
    private static Gelaxka[][] laukiak = new Gelaxka [12][12]; 
    private static int tamagochiLerroa;
    private static int tamagochiZutabea;
    private static int tartaLerroa;
    private static int tartaZutabea;
    private static boolean flag = false;
    private static int xAnterior;
    private static int yAnterior;
    private Timer timer;
    private static Minijokoa NireMinijokoa = null;

    private Minijokoa(){}

    public static Minijokoa getMinijokoa(){
        if(NireMinijokoa == null){
            NireMinijokoa = new Minijokoa();
        }
        return NireMinijokoa;
    }

    public void reset(){
        NireMinijokoa = null;
    }

    public void hasieratuMinijokoa(){
        new miniJokoaBista(this);
        hasieratuLaukiak();
        TamagochietaTartaHasieratu();
        AktBuklea();
    }
    private void hasieratuLaukiak()
    {
        for (int i = 0; i < 12; i++)
        {
            for (int j = 0; j < 12; j++)
            {
                laukiak[i][j] = GelaxkaFactory.getGF().createGelaxka((int)(Math.random() * 3) + 1);
            }
        }
        setChanged();
        notifyObservers("hasieratu");
    }
    public int getLerroa(){
        return tamagochiLerroa;
    }
    public int getZutabea(){
        return tamagochiZutabea;
    }
    public static int getAnteriorLerroa(){
        return yAnterior;
    }
    public static int getAnteriorZutabea(){
        return xAnterior;
    }
    public static int getTartaLerroa()
    {
        return tartaLerroa;
    }
    public static int getTartaZutabea()
    {
        return tartaZutabea;
    }   
    public Gelaxka[][] getLaukiak()
    {
        return laukiak;
    }
    public Gelaxka getGelaxka(int i, int j)
    {
        return laukiak[i][j];
    }
    public boolean tartaVisible()
    {
        if(laukiak[tartaZutabea][tartaLerroa].getIndarra() == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static boolean tamagochiVisible(){
        if(laukiak[tamagochiLerroa][tamagochiZutabea].getIndarra()== 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    private static boolean mugimenduaEginDaiteke(int norabidea)
    /*comprueba si el movimiento esta dentro de la matriz 
    y si la casilla a la que se quiere desplazar esta con laukiak de valor 0*/
    {
        if(tamagochiVisible()){
            if (norabidea == 1)
            {
                if (tamagochiLerroa > 0 && tamagochiLerroa <= 12 && laukiak[tamagochiLerroa - 1][tamagochiZutabea].getIndarra() == 0)
                {

                    return true;
                }
                else
                {

                    return false;
                }
            }
            else if (norabidea == 2)
            {
                if (tamagochiLerroa <= 10 & tamagochiLerroa >= 0 && laukiak[tamagochiLerroa + 1][tamagochiZutabea].getIndarra() == 0)
                {

                    return true;
                }
                else
                {
                    return false;
                }
            }
            else if (norabidea == 3)
            {
                if (tamagochiZutabea >= 1 && tamagochiZutabea <= 12 && laukiak[tamagochiLerroa][tamagochiZutabea - 1].getIndarra() == 0)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else if (norabidea == 4)
            {
                if (tamagochiZutabea <= 10 && tamagochiZutabea >= 0 && laukiak[tamagochiLerroa][tamagochiZutabea + 1].getIndarra() == 0)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    public void TamagochiMugitu(int norabidea)
    //mueve el tamagochi en la matriz siempre y cuando sea movimiento valido
    {
        
        if (norabidea == 1)
        {
            if (mugimenduaEginDaiteke(1))
            {

                tamagochiLerroa--;
                if(irabaziDu())
                {
                    setChanged();
                    notifyObservers("irabaziDu");
                }
                else
                {
                    setChanged();
                    notifyObservers("tamagochiMugitu");
                }
            }
        }
        else if (norabidea == 2)
        {
            if (mugimenduaEginDaiteke(2))
            {

                tamagochiLerroa++;
                if(irabaziDu())
                {
                    setChanged();
                    notifyObservers("irabaziDu");
                }
                else
                {
                    setChanged();
                    notifyObservers("tamagochiMugitu");
                }
            }
        }
        else if (norabidea == 3)
        {
            if (mugimenduaEginDaiteke(3))
            {   

                tamagochiZutabea--;
                if(irabaziDu())
                {
                    setChanged();
                    notifyObservers("irabaziDu");
                }
                else
                {
                    setChanged();
                    notifyObservers("tamagochiMugitu");
                }

            }
        }
        else if (norabidea == 4)
        {
            if (mugimenduaEginDaiteke(4))
            {   

                tamagochiZutabea++;
                if(irabaziDu())
                {
                    setChanged();
                    notifyObservers("irabaziDu");
                }
                else
                {
                    setChanged();
                    notifyObservers("tamagochiMugitu");
                }
            }
        }
    }      
    private  void TamagochietaTartaHasieratu()
    {
        tamagochiLerroa = (int) (Math.random() * 11)+1;
        tamagochiZutabea = (int) (Math.random() * 11)+1;
        tartaLerroa = (int) (Math.random() * 11)+1;
        tartaZutabea = (int) (Math.random() * 11)+1;

        //Cuenta atras para terminar el juego
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                setChanged();
                notifyObservers("galduDu");
            }
            //30 segundos
        },  30000);

        if(osoGertu(tartaLerroa, tartaZutabea))
        {
            while(osoGertu(tartaLerroa, tartaZutabea))
            {
                tartaLerroa = (int) (Math.random() * 12);
                tartaZutabea = (int) (Math.random() * 12);
            }
        }
        setChanged();
        notifyObservers("tamagochietaTartaHasieratu");
    }
    private void AktBuklea()
    {
        flag = false;
       while (!irabaziDu() && !flag)
        {
            setChanged();
            notifyObservers("laukiAktualizatu");
            setChanged();
            notifyObservers("tamagochiMugitu");
            try {
                Thread.sleep(150); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        if(irabaziDu())
        {
            timer.cancel();
            setChanged();
            notifyObservers("irabaziDu");
        }
        else
        {
            timer.cancel();
            setChanged();
            notifyObservers("galduDu");
        }
       

    }

    public static void setFlag(boolean x)
    {
        flag = x;
    }
    public static boolean irabaziDu()
    {
        //aqui estan al reves por el bien del programa
        if (tamagochiLerroa == tartaZutabea && tamagochiZutabea == tartaLerroa)
        {
            return true;

        }
        else
        {
            return false;
        }
    }
    public static boolean galduDu() {
       
        long startTime = System.currentTimeMillis();
        long elapsedTime = 0;
        while (elapsedTime < 30000) {
            elapsedTime = System.currentTimeMillis() - startTime;
        }
        return true;
        
    }
    public void apagarTimer()
    {
        timer.cancel();
    }
    public void apagarMinijokoa()
    {
        setChanged();
        notifyObservers("itzali");
    }
    public static boolean osoGertu(int lerroa, int zutabea)
    {
        if (lerroa == tamagochiLerroa && zutabea == tamagochiZutabea)
        {
            return true;
        }
        else if (lerroa == tamagochiLerroa - 1 && zutabea == tamagochiZutabea)
        {
            return true;
        }
        else if (lerroa == tamagochiLerroa + 1 && zutabea == tamagochiZutabea)
        {
            return true;
        }
        else if (lerroa == tamagochiLerroa && zutabea == tamagochiZutabea - 1)
        {
            return true;
        }
        else if (lerroa == tamagochiLerroa && zutabea == tamagochiZutabea + 1)
        {
            return true;
        }
        else if (lerroa == tamagochiLerroa - 1 && zutabea == tamagochiZutabea - 1)
        {
            return true;
        }
        else if (lerroa == tamagochiLerroa - 1 && zutabea == tamagochiZutabea + 1)
        {
            return true;
        }
        else if (lerroa == tamagochiLerroa + 1 && zutabea == tamagochiZutabea - 1)
        {
            return true;
        }
        else if (lerroa == tamagochiLerroa + 1 && zutabea == tamagochiZutabea + 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
}