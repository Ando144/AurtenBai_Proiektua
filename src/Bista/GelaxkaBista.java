package src.Bista;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import org.w3c.dom.events.MouseEvent;

import src.Eredua.Minijokoa;

public class GelaxkaBista extends JLabel implements Observer{
    int lerroa;
    int zutabea;

    public GelaxkaBista(int pLerroa, int pZutabea){
        this.lerroa = pLerroa;
        this.zutabea = pZutabea;
        this.setOpaque(true);
        this.setBackground(koloreaAtera());
        this.addMouseListener(new CustomMouseListener());
        this.setEnabled(true);
    }
    public int getLerroa(){
        return this.lerroa;
    }
    public int getZutabea(){
        return this.zutabea;
    }
    
    public void LaukiaAktualizatu(){
        this.setBackground(koloreaAtera());
    }   
    private Color koloreaAtera()
    {
        if (Minijokoa.getMinijokoa().getGelaxka(lerroa,zutabea).getIndarra()==1)
        {
            return Color.LIGHT_GRAY;
        }
        else if (Minijokoa.getMinijokoa().getGelaxka(lerroa,zutabea).getIndarra() == 2)
        {
            return Color.GRAY;
        }
        else if (Minijokoa.getMinijokoa().getGelaxka(lerroa,zutabea).getIndarra() == 3)
        {
            return Color.DARK_GRAY;
        }
        else
        {
            return Color.BLACK;
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        switch((String)arg){
            case "laukiAktualizatu":
                LaukiaAktualizatu();
                break;
        }

    }

    
    private class CustomMouseListener implements MouseListener{

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            Minijokoa.getMinijokoa().getGelaxka(lerroa, zutabea).laukiaAktualizatu();
        }

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {}

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {}

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {}

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {}
    }
    
}
