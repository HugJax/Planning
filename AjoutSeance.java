/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Modele.*;
import Controleur.*;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import Modele.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AjoutSeance extends JPanel{
    protected JTextField course;
    private final Enseignant prof;
    private final Utilisateur useractif;
    private final UserSQL con = new UserSQL();
    private final AutreSQL conbis = new AutreSQL();
    private final Cours cours;
    private SeanceEnseignant m_seanceE;
    private SeanceGroupe m_seanceG;
    private SeanceSalle m_seanceS;
    private Salle m_salle;
    private final JTextField semaine;
    private final JTextField Date;
    private final JComboBox typec;
    private final JComboBox cycle;
    private final JComboBox array;
    private final JComboBox hdebut;
    private final JComboBox hfin;
    private final JComboBox S;
    
    public AjoutSeance(int iduser){
        useractif = con.retrieveUserFromID(iduser);
        prof = con.retrieveEnseignantFromID(iduser);
        cours = conbis.retrieveCours(prof.getIDcours());
        //nom de la matière
        course = new JTextField(10);
        course.setText(cours.getNom());
        //type de cours
        String typecours[] = {"Cours Magistral","Cours interractif","TP","TD", "Avancement projet", "Soutien", "EXAMEN"};        
        typec = new JComboBox(typecours);
        //promo
        String promo[] = {"Premier Cycle","Second Cycle","Dernier Cycle"};        
        cycle = new JComboBox(promo);
        //groupe
        String groupe[] = {"TD01","TDO2","TD03"};        
        array = new JComboBox(groupe);
        //horaires
        JLabel Nhd = new JLabel("Heure Debut");
        String horairesdebut[] = {"8h","9h","10h","11h","12h","13h","14h","15h","16h","17h","18h","19h","20h"};        
        hdebut = new JComboBox(horairesdebut);
       
        
        JLabel Nhf = new JLabel("Heure Fin");
        String horairesfin[] = {"8h","9h","10h","11h","12h","13h","14h","15h","16h","17h","18h","19h","20h"};        
        hfin = new JComboBox(horairesfin);
       
        //PSemaine
        JLabel Ns = new JLabel("Semaine");
        semaine = new JTextField(10);
        //Date
        JLabel Nd = new JLabel("Date");
        Date = new JTextField(10);
        //Salle
        JLabel Nns = new JLabel("Salle");
        String Salle[] = {"101","102","103","201","202","203","301","302","303"};
        S = new JComboBox(Salle);
        
        //ajouter
        JButton bouton = new JButton("Valider cette séance");
        bouton.addActionListener(new MAJ());
        
        add(course);
        add(typec);
        add(cycle);
        add(array);
        add(Nhd);
        add(hdebut);
        add(Nhf);
        add(hfin);
        add(Ns);
        add(semaine);
        add(Nd);
        add(Date);
        add(Nns);
        add(S);
        add(bouton);
        setVisible(true);
        validate();
    }

    private class MAJ implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e)
        {
          try
          {
            int Semaine = Integer.parseInt(semaine.getText());
            int date = Integer.parseInt(Date.getText());
            /*System.out.println(Semaine);
            System.out.println(date);*/
          
          
          int hd = hdebut.getSelectedIndex() + 8;
          int hf = hfin.getSelectedIndex() + 8;
          int salle = S.getSelectedIndex() + 1;
          /*System.out.println(hd);
          System.out.println(hf);
          System.out.println(s);*/
          
          int typecours;
          typecours = typec.getSelectedIndex() + 1;
          //System.out.println(typecours);
          
          int idgroupes;
          idgroupes = array.getSelectedIndex() + 1 + 3*cycle.getSelectedIndex();
          
          //System.out.println(idgroupes);
            
            /*SeanceEnseignant m_SE = new SeanceEnseignant();
            SeanceGroupe m_SG = new SeanceGroupe();
            SeanceSalle m_SS = new SeanceSalle();*/
            SeanceSQL maj = new SeanceSQL();
              try {
                  int idseance= maj.ajouterSeance(Semaine, date, hd, hf, 0, prof.getIDcours(), typecours);
                  System.out.println(idseance);
                  maj.ajouterSeanceEnseignant(idseance, prof.getID());
                  maj.ajouterSeanceGroupe(idseance, idgroupes);
                  maj.ajouterSeanceSalle(idseance, salle);
              } catch (SQLException ex) {
                  Logger.getLogger(AjoutSeance.class.getName()).log(Level.SEVERE, null, ex);
              }
            }
          catch(NumberFormatException i)
          {
              System.out.println("mauvais format");
          }
                 
        }
    }
}
