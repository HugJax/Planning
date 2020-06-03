/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.*;
import Modele.SeanceSQL;
import java.awt.Button;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GrilleEdt extends JPanel{
    private SeanceSQL con = new SeanceSQL();

    public GrilleEdt(int iduser, int semaine) {
          
        add(new JLabel("<html><h2>&emsp; Lundi &emsp;</h2></html>", null, JLabel.CENTER));
        add(new JLabel("<html><h2>&emsp; Mardi &emsp;</h2></html>", null, JLabel.CENTER));
        add(new JLabel("<html><h2>&emsp; Mercredi &emsp</h2></html>", null, JLabel.CENTER));
        add(new JLabel("<html><h2>&emsp; Jeudi &emsp</h2></html>", null, JLabel.CENTER));
        add(new JLabel("<html><h2>&emsp; Vendredi &emsp</h2></html>", null, JLabel.CENTER));  
        add(new JLabel("<html><h2>&emsp; Samedi &emsp</h2></html>", null, JLabel.CENTER));
    
    if(semaine<=20 || semaine>=25){
        int jour=1, horaire=0;
        for(int i=1;i<=36;i++){
            String temp="<html><br>&nbsp;&nbsp;" + (horaire+8) + " - " + (horaire+9) + "&nbsp&nbsp</br></html>";
            JLabel boule = new JLabel(temp, null, JLabel.CENTER);
            add(boule);
            if(jour!=6) {jour++;}
            else {jour=1;horaire++;}
        }
    }
    else
    {
        ArrayList<Seance> list = new ArrayList<>(100);
        list = con.retrieveSeanceFromSemaine(iduser, semaine);
        int jour=0, horaire=0;
        int idseance=0;
        for(int i=0;i<36;i++){
            for(Seance temp: list)
            {
                if(temp.getDate()==jour && temp.getHeureDebut()==(horaire+8))
                {
                    idseance = temp.getID();
                }
                if(idseance == 0)
                {
                    if(temp.getDate()==jour && temp.getHeureDebut()==(horaire+7) && temp.getHeureFin()==(horaire+9))
                    {
                        idseance = temp.getID();
                    }
                }
            }
            
                        
            if(idseance != 0)
            {
                add(new SeanceBouton(idseance, iduser));
            }else 
            {
                String temp="<html><br>&nbsp;&nbsp;" + (horaire+8) + " - " + (horaire+9) + "&nbsp&nbsp</br></html>";
                JLabel boule = new JLabel(temp, null, JLabel.CENTER);
                add(boule);
            }
            
            if(jour==5) {horaire++;}
            
            if(jour!=5) 
                {jour++;}
            else 
                {jour=0;}
            
            idseance = 0;
        }
    }
      
    setLayout(new GridLayout(7,6));  
    //setting grid layout of 3 rows and 3 columns  
  
    this.setSize(1100,600);
    //setVisible(true);  
    }
    
}
