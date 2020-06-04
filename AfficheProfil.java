/*
 * Afficher les infos de l'utilisateur
 */
package Vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Modele.*;
import Controleur.*;
import java.awt.GridLayout;
import java.awt.Label;
import javax.swing.JTable;

/**
 *
 * @author Bastide_Fiorenza_Jacquesy TD05
 */
public class AfficheProfil extends JPanel{
    /// ATTRIBUTS
    private JLabel profil;
    private JButton bouton;
    private Utilisateur useractif;
    private UserSQL con = new UserSQL();
    private AutreSQL conbis = new AutreSQL();
    private Etudiant etu;
    private Enseignant prof;
    private Cours cours;
    private Groupe grp;
    private Promotion prom;
    
    /// CONSTRUCTEURS
    public AfficheProfil(int iduser){
        
        
        useractif = con.retrieveUserFromID(iduser);
        String info = ""; //= "<html><ul><li>Nom :" + useractif.getNom() + "</li><li>Prénom :" + useractif.getPrenom();
        String infoVa = null;
        if(useractif.getDroit()==4)
        {
            etu = con.retrieveEtudiantFromID(iduser);
            grp = conbis.retrieveGroupe(etu.getGroupe());
            prom = conbis.retrievePromo(etu.getPromo());
            info = info + "</li><li>Promo :" + prom.getPromo() + "</li><li>Groupe :" + grp.getGroupe();
            infoVa = "Promo et Groupe :";
        }
        if(useractif.getDroit()==3)
        {
            prof = con.retrieveEnseignantFromID(iduser);
            cours = conbis.retrieveCours(prof.getIDcours());
            info = cours.getNom();
            //info = info + "</li><li>Matière :" + cours.getNom();
            infoVa = "Matière :";
        }
            
        //info = info + "</li></ul></html>";
        

        
        
        add(new JLabel("<html><h2> Nom :</h2></html>", null, JLabel.CENTER));
        add(new JLabel("<html><h2> Prenom :</h2></html>", null, JLabel.CENTER));
        add(new JLabel("<html><h2>" + infoVa + "</h2></html>", null, JLabel.CENTER));
        
        String temp="<html>"  + useractif.getNom() + "</html>";
        JLabel j1 = new JLabel(temp, null, JLabel.CENTER);
        
        String temp1="<html>"  + useractif.getPrenom()+ "</html>";
        JLabel j2 = new JLabel(temp1, null, JLabel.CENTER);
        
        JLabel j3 = new JLabel(info, null, JLabel.CENTER);
        
        JLabel j4 = new JLabel("", null, JLabel.CENTER);
        
        
       
        
      //  profil = new JLabel(info);
        bouton = new JButton("Déconnexion");
        bouton.setBackground(Color.RED);
        bouton.addActionListener(new Deco());
        add(j1);
        add(j2);
        add(j3);
        add(j4);
      //  this.add(profil);
        this.add(bouton);
        this.setVisible(true);
        this.validate();
        
        setLayout(new GridLayout(3,2));
    }
    
    /// METHODES
    private class Deco implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
}