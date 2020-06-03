/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import Controleur.*;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.util.ArrayList;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

/**
 *
 * @author Rémi Fiorenza
 */
public class Grille extends JPanel {
    
    
    protected GridLayout g;

    public void Grille(Tabedt te) {

      g = new GridLayout(12, 6);
      setLayout(g);
      
      
      int h = 8;            //Première partie de créneau horaire
      int harrivee = 8;             //Deuxième partie du créneau horaire
      
      String jour;
      ///Utiliser jlabel pour le nom des jours
      for(int i = 0 ; i < 12 ; i++)         
      {
          harrivee++;
          add(new Button(h + i + "h - " + harrivee + "h"));         //affichage du bouton et du créneau horaire          
          
          for(int j = 1 ; j < 6 ; j++)         
          {
            add(new Button(h + i + "h - " + harrivee + "h"));           //affichage du bouton et du créneau horaire 
          }
      }
      
      te.add(g);
      te.setvisible(true);
      validate();
    }


    
}







   
            
