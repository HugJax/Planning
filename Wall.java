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
      for(int i=1;i<=52;i++){
          onglet[i] = new JPanel();
          edtsemaines[i] = new JLabel("onglet correspondant à la semaine " + i);
          onglet[i].add(new SeanceBouton(),BorderLayout.CENTER);
      }
      for(int i=1;i<=52;i++){
          onglet[i].add(edtsemaines[i]);
      }
      for(int i=1;i<=52;i++){
          String a = ""+i;
          panelOnglet.addTab(a, null, onglet[i]);
      }
      this.setTitle("Planning");
      this.getContentPane().add(panelOnglet);
      this.setSize(1200,650);
      this.setVisible(true);
   }
    
}
