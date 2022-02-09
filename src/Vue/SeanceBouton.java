/*
 * Classe affichage bouton seance pour ouvrir une fenetre d'information
 */
package Vue;

import Controleur.*;
import Modele.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Bastide_Fiorenza_Jacquesy TD05
 */
public class SeanceBouton extends JPanel{
    /// ATTRIBUTS

    /**
     *
     */
    protected JButton Bouton;

    /**
     *
     */
    protected Seance seance;

    /**
     *
     */
    protected ArrayList<Groupe> listgrp = new ArrayList<>(100);

    /**
     *
     */
    protected Enseignant prof;

    /**
     *
     */
    protected Salle salle;

    /**
     *
     */
    protected Cours cours;

    /**
     *
     */
    protected TypeCours typecours;

    /**
     *
     */
    protected Utilisateur profdetail;
    private SeanceSQL con = new SeanceSQL();
    private UserSQL taupe = new UserSQL();
    private int iduser;
    private Tabedt wal;
    
    /// CONSTRUCTEURS
    /**Bouton séane pour accéder aux infos*/
    SeanceBouton(int idseance, int iduser, Tabedt wa){
        this.iduser = iduser;
        wal = wa;
        seance = con.retrieveSeanceFromID(idseance);
        salle = con.retrieveSeanceSalleFromIDseance(idseance);
        listgrp = con.retrieveSeanceGrpFromIDseance(idseance);
        prof = con.retrieveSeanceEnseignantFromIDseance(idseance);
        cours = con.retrieveCoursFromIDcours(seance.getCours());
        typecours = con.retrieveTypeCoursFromIDcours(seance.getTypeCours());
        profdetail = taupe.retrieveUserFromID(prof.getID());
        //Affichage via HTML des infos Séance
        Bouton = new JButton("<html>" + cours.getNom() + "<br>M. " + profdetail.getNom() +"<br>salle: " + salle.getNom() +"</html>");
        Bouton.setSize(250, 50);
        //Choisir une couleur par matière
        if(cours.getNom().equals("Physique"))
            Bouton.setBackground(Color.GREEN);
        else if(cours.getNom().equals("Maths"))
            Bouton.setBackground(Color.YELLOW);
        else if(cours.getNom().equals("Info"))
            Bouton.setBackground(Color.MAGENTA);
        else if(cours.getNom().equals("Electronique"))
            Bouton.setBackground(Color.ORANGE);
        else if(cours.getNom().equals("Gestion de projet"))
            Bouton.setBackground(Color.PINK);
        else Bouton.setBackground(Color.BLUE);
        Bouton.addActionListener(new Details()); //Ouverture d'une fenetre avec les infos de la séance
        add(Bouton);
        //this.setSize(100, 75);
        validate();
    }
    
    /// METHODES
    /**Ouverture de la fenetre de détail de la séance*/
    private class Details implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // Ouverture de la séance
            SeanceFenetre flute = new SeanceFenetre(seance, iduser, wal);
        }
    }
}
