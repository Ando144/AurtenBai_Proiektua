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
   private static int[][] laukiak = new int [12][12]; 
   private static int tamagochiLerroa;
   private static int tamagochiZutabea;
   private static int tartaLerroa;
   private static int tartaZutabea;
   private static int xAnterior;
    private static int yAnterior;
    private Timer timer;

    private static Minijokoa NireMinijokoa = null;
    public static Minijokoa getMinijokoa()
    {
        if(NireMinijokoa == null)
        {
            NireMinijokoa = new Minijokoa();
            NireMinijokoa.timer = new Timer();

        }
        return NireMinijokoa;
    }
    public static void main(String[] args) 
    {
        Minijokoa minijokoa = new Minijokoa();
        miniJokoaBista bista = new miniJokoaBista(minijokoa);
        minijokoa.hasieratuLaukiak();
        minijokoa.TamagochietaTartaHasieratu();
        minijokoa.AktBuklea();
        

    }
    private void hasieratuLaukiak()
    {
        for (int i = 0; i < 12; i++)
        {
            for (int j = 0; j < 12; j++)
            {
                laukiak[i][j] = (int) (Math.random() * 3) + 1;//mirar esto pq el random no debe ser 0 tmb
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
    public int[][] getLaukiak()
    {
        return laukiak;
    }
    public boolean tartaVisible()
    {
        if(laukiak[tartaZutabea][tartaLerroa] == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static boolean tamagochiVisible()
    {
        if(laukiak[tamagochiLerroa][tamagochiZutabea] == 0)
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
                if (tamagochiLerroa > 0 && tamagochiLerroa <= 12 && laukiak[tamagochiLerroa - 1][tamagochiZutabea] == 0)
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
                if (tamagochiLerroa <= 10 & tamagochiLerroa >= 0 && laukiak[tamagochiLerroa + 1][tamagochiZutabea] == 0)
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
                if (tamagochiZutabea >= 1 && tamagochiZutabea <= 12 && laukiak[tamagochiLerroa][tamagochiZutabea - 1] == 0)
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
                if (tamagochiZutabea <= 10 && tamagochiZutabea >= 0 && laukiak[tamagochiLerroa][tamagochiZutabea + 1] == 0)
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
            System.out.println("ha entrado en el norabide 1");
            if (mugimenduaEginDaiteke(1))
            {

                tamagochiLerroa--;
                System.out.println("posicion actualizada");
                if(irabaziDu())
                {
                    setChanged();
                    notifyObservers("irabaziDu");
                }
                else
                {
                    setChanged();
                    System.out.println("ha entrado en el norabide 1");
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

        while (!irabaziDu()) {
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
        setChanged();
        notifyObservers("irabaziDu");
        NireMinijokoa.timer.cancel();

    }
    public void laukiaAktualizatu(int lerroa, int zutabea)
    {
        //PROBLEMA: cuando llega al notifyObservers no salta a el update de minijokoaBista y no se porque
        //si te fijas cuando ejecutas el codigo funciona bien pero no se actualiza la vista
        // esto puedes saberlo por los prints qie he puesto pq si pasas dos veces el raton por encima de 
        //una casilla esta perdera fuerzas, pero lo q pasa que no se actualiza la vista.
        //EN RESUMEN, mirar pq no salta del notifyObservers al update de minijokoaBista
        if (laukiak[lerroa][zutabea] == 1)
        {
            laukiak[lerroa][zutabea] = 0;
            setChanged();
            notifyObservers("laukiAktualizatu");//cambiar el color del panel
            //convertirlo en invisible
        }
        else if (laukiak[lerroa][zutabea] == 2)
        {
            laukiak[lerroa][zutabea] = 1;
            setChanged();
            notifyObservers("laukiAktualizatu");//cambiar el color del panel

        }
        else if (laukiak[lerroa][zutabea] == 3)
        {
            laukiak[lerroa][zutabea] = 2;
            setChanged();
            notifyObservers("laukiAktualizatu");//cambiar el color del panel

        }
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