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
        String info = "<html><ul><li>Nom :" + useractif.getNom() + "</li><li>Prénom :" + useractif.getPrenom();
        if(useractif.getDroit()==4)
        {
            etu = con.retrieveEtudiantFromID(iduser);
            grp = conbis.retrieveGroupe(etu.getGroupe());
            prom = conbis.retrievePromo(etu.getPromo());
            info = info + "</li><li>Promo :" + prom.getPromo() + "</li><li>Groupe :" + grp.getGroupe();
        }
        if(useractif.getDroit()==3)
        {
            prof = con.retrieveEnseignantFromID(iduser);
            cours = conbis.retrieveCours(prof.getIDcours());
            info = info + "</li><li>Matière :" + cours.getNom();
        }
            
        info = info + "</li></ul></html>";
        profil = new JLabel(info);
        bouton = new JButton("Déconnexion");
        bouton.setBackground(Color.RED);
        bouton.addActionListener(new Deco());
        this.add(profil);
        this.add(bouton);
        this.setVisible(true);
        this.validate();
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
