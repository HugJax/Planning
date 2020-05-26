/*
 * Classe mur sur laquelle sont envoyés toutes les informations à afficher
 */
package Vue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import Controleur.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

/**
 *
 * @author Bastide_Fiorenza_Jacquesy TD05
 */
public class Wall extends JFrame{
   private JTabbedPane panelOnglet;
   private JPanel[] onglet = new JPanel[5];
   
   public Wall(){
      panelOnglet = new JTabbedPane();
      panelOnglet.setPreferredSize(new Dimension(20, 20));
      onglet[1] = new JPanel();
      onglet[1].add(new Tabedt(this));
      onglet[0] = new JPanel();
      onglet[0].add(new JLabel("onglet partie 1"));
      onglet[2] = new JPanel();
      onglet[2].add(new JLabel("onglet partie 3"));
      onglet[3] = new JPanel();
      onglet[3].add(new JLabel("onglet partie 4"));
      onglet[4] = new JPanel();
      onglet[4].add(new JLabel("onglet partie 5"));
      for(int i=0;i<5;i++){
          String a = "Partie "+(i+1);
          panelOnglet.addTab(a, null, onglet[i]);
      }
      this.setTitle("Planning");
      this.getContentPane().add(panelOnglet);
      this.setSize(1200,650);
      this.setVisible(true);
   }
    
}
