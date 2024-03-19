package src.Eredua;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Minijokoa {
   
   private static int[][] laukiak = new int [12][12]; 
   private static boolean[][] tarta = new boolean [12][12];
   private static boolean[][] tamagochi = new boolean [12][12];
   private static int tamagochiLerroa;
   private static int tamagochiZutabea;
   private static int tartaLerroa;
   private static int tartaZutabea;

    public static void main(String[] args) 
    {
        
    }
    public static void hasieratuLaukiak()
    {
        for (int i = 0; i < 12; i++)
        {
            for (int j = 0; j < 12; j++)
            {
                laukiak[i][j] = (int) (Math.random() * 3) + 1;
            }
        }
    }
    public static void TamagochietaTartaHasieratu()
    {
        tamagochiLerroa = (int) (Math.random() * 12);
        tamagochiZutabea = (int) (Math.random() * 12);
        tamagochi[tamagochiLerroa][tamagochiZutabea] = true;
        tartaLerroa = (int) (Math.random() * 12);
        tartaZutabea = (int) (Math.random() * 12);
        if(osoGertu(tartaLerroa, tartaZutabea))
        {
            while(osoGertu(tartaLerroa, tartaZutabea))
            {
                tartaLerroa = (int) (Math.random() * 12);
                tartaZutabea = (int) (Math.random() * 12);
            }
        }
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
