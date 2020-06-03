/*
 * Classe mur sur laquelle sont envoyés toutes les informations à afficher
 */
package Vue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import Controleur.*;
import Modele.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Bastide_Fiorenza_Jacquesy TD05
 */
public class Wall extends JFrame{
    /// ATTRIBUTS
   private JTabbedPane panelOnglet;
   private JPanel[] onglet = new JPanel[5];
   private UserSQL con = new UserSQL();
   private Utilisateur useractif;
   private Wall wa;
   protected JComboBox babla;
   
   /// CONSTRUCTEURS
   public Wall(int iduser){
      useractif = con.retrieveUserFromID(iduser);
      wa = this;
      //Création d'un tableau d'onglet
      panelOnglet = new JTabbedPane();
      panelOnglet.setPreferredSize(new Dimension(20, 20));
      //Remplissage des onglets
      int i=0;
      if(useractif.getDroit()==4)
      {
        onglet[i] = new JPanel();
        onglet[i].add(new ResumeCours(iduser));
        panelOnglet.addTab("Résumé des cours", null, onglet[i]);
        i++;
      }
      if(useractif.getDroit()==3 || useractif.getDroit()==4)
      {
        onglet[i] = new JPanel();
        onglet[i].add(new Tabedt(this, iduser)); // ajout de l'emploi du temps
        panelOnglet.addTab("Emploi du temps", null, onglet[i]);
        i++;
      }
      if(useractif.getDroit()==3)
      {
        onglet[i] = new JPanel();
        onglet[i].add(new AjoutSeance(iduser));
        panelOnglet.addTab("Planifier une séance", null, onglet[i]);
        i++;
      }
      if(useractif.getDroit()==1)
      {
        onglet[i] = new JPanel();
        onglet[i].add(new JLabel("Tableau qui affiche les séances à valider ou non"));
        panelOnglet.addTab("Valider une séance", null, onglet[i]);
        i++;
      }
      if(useractif.getDroit()==2)
      {
        onglet[i] = new JPanel();
        onglet[i].add(new JLabel("Nom de l'étudiant"));
        onglet[i].add(new JTextField(30));
        String but[]={"Premier Cycle - TD01","Premier Cycle - TD02","Premier Cycle - TD03","Second Cycle - TD01","Second Cycle - TD02","Second Cycle - TD03","Dernier Cycle - TD01","Dernier Cycle - TD02","Dernier Cycle - TD03"};  
        babla = new JComboBox(but);
        onglet[i].add(babla);
        JButton rech = new JButton("Rechercher");
        onglet[i].add(rech);
        rech.addActionListener(new Recherche());
        panelOnglet.addTab("Accéder aux emploi du temps", null, onglet[i]);
        i++;
      }
      onglet[i] = new JPanel();
      onglet[i].add(new AfficheProfil(iduser));
      panelOnglet.addTab("Profil utilisateur", null, onglet[i]);
      
      this.setTitle("Planning");
      this.getContentPane().add(panelOnglet);
      this.setSize(1200,650);
      this.setVisible(true);
   }
   
   
   private class Recherche implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                    onglet[0].removeAll();
                    String rep = (String) babla.getItemAt(babla.getSelectedIndex());
                    int idseance = 0;
                    Tabedt tab;
                    switch(rep)
                    {
                        case "Premier Cycle - TD01": idseance=10;
                                                    break;
                        case "Premier Cycle - TD02": idseance=13;
                                                    break;
                        case "Premier Cycle - TD03": idseance=18;
                                                    break;
                        case "Second Cycle - TD01": idseance=23;
                                                    break;
                        case "Second Cycle - TD02": idseance=26;
                                                    break;
                        case "Second Cycle - TD03": idseance=30;
                                                    break;
                        case "Dernier Cycle - TD01": idseance=33;
                                                    break;
                        case "Dernier Cycle - TD02": idseance=37;
                                                    break;
                        case "Dernier Cycle - TD03": idseance=41;
                                                    break;
                    }
                    
                    onglet[0].add(new JLabel("Nom de l'étudiant"));
                    onglet[0].add(new JTextField(30));
                    String but[]={"Premier Cycle - TD01","Premier Cycle - TD02","Premier Cycle - TD03","Second Cycle - TD01","Second Cycle - TD02","Second Cycle - TD03","Dernier Cycle - TD01","Dernier Cycle - TD02","Dernier Cycle - TD03"};  
                    babla = new JComboBox(but);
                    onglet[0].add(babla);
                    JButton rech = new JButton("Rechercher");
                    onglet[0].add(rech);
                    rech.addActionListener(new Recherche());
                    
                    tab = new Tabedt(wa, idseance);
                    onglet[0].add(tab);
                }
            }
    }
    
