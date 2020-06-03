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
    /// ATTRIBUTS
   private JTabbedPane panelOnglet;
   private JPanel[] onglet = new JPanel[53];
   private JLabel[] edtsemaines = new JLabel[53];
   
   /// CONSTRUCTEURS
   public Tabedt(Wall wa, int iduser){
      //Création d'un tableau d'onglet
      panelOnglet = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
      //Création des onglets et remplissage des onglets
      for(int i=1;i<=52;i++){
          onglet[i] = new JPanel();
          onglet[i].add(new GrilleEdt(iduser, i));
      }
      
      // ajout des onglets au tableau d'onglet
      for(int i=1;i<=52;i++){
          String a = ""+i;
          panelOnglet.addTab(a, null, onglet[i]);
      }
      this.setSize(1100, 550);
      // ajout du tableau d'onglet sur la page JPanel
      this.add(panelOnglet);
      this.setVisible(true);
   }
}
