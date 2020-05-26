/*
 * Classe d'affichage du tableau contenant l'emploi du temps
 */
package Vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Bastide_Fiorenza_Jacquesy TD05
 */
public class Tabedt extends JPanel{
   private JTabbedPane panelOnglet;
   private JPanel[] onglet = new JPanel[53];
   private JLabel[] edtsemaines = new JLabel[53];
   
   public Tabedt(Wall wa){
      panelOnglet = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
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
      //wa.getContentPane().add(panelOnglet);
      this.setSize(1100, 550);
      this.add(panelOnglet);
      this.setVisible(true);
   }
}
