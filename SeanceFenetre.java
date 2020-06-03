/*
 * Classe fenetre des informations d'une séance
 */
package Vue;

import javax.swing.JLabel;
import java.awt.Color;
import Controleur.*;
import Modele.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Bastide_Fiorenza_Jacquesy TD05
 */
public class SeanceFenetre extends JFrame{
    /// ATTRIBUTS
    private JLabel info;
    protected Seance seanceux;
    protected ArrayList<Groupe> listgrp = new ArrayList<>(100);
    protected Enseignant prof;
    protected Salle salle;
    protected Site site;
    protected Cours cours;
    protected TypeCours typecours;
    protected Utilisateur profdetail;
    private SeanceSQL con = new SeanceSQL();
    private UserSQL taupe = new UserSQL();
    
    /// CONSTRUCTEURS
    SeanceFenetre(Seance seance, int iduser){
        this.seanceux = seance;
        salle = con.retrieveSeanceSalleFromIDseance(seance.getID());
        listgrp = con.retrieveSeanceGrpFromIDseance(seance.getID());
        prof = con.retrieveSeanceEnseignantFromIDseance(seance.getID());
        cours = con.retrieveCoursFromIDcours(seance.getCours());
        typecours = con.retrieveTypeCoursFromIDcours(seance.getTypeCours());
        profdetail = taupe.retrieveUserFromID(prof.getID());
        site = con.retrieveSiteFromIDsite(salle.getSite());
        setBackground(new Color(1,177,229));
        setSize(350,450);
        // Affichage via HTML des infos Séance
        String str = "<html><ul><li>Matiere : "+cours.getNom()+"</li><br><li>Enseignant : "+profdetail.getNom()+" "+profdetail.getPrenom()+"</li><br><li>"+typecours.getNom()+"</li><br><li>";
        for(Groupe grp: listgrp){
            str = str + grp.getGroupe() + "  ";
        }
        str = str + "</li><br><li>Localisation : " + salle.getNom() + " - " + site.getNom();
        str = str +"</li><br><li>Heure Début : "+seance.getHeureDebut()+"h - Heure fin : "+seance.getHeureFin()+"h</li></ul></html>";
        info = new JLabel(str);
        add(info);
        
        if(profdetail.getDroit()==3)
        {
            add(new BoutonModif(seanceux, this));
        }
        
        //setSize(220, 300);
        setLayout(new GridLayout(2,1)); 
        setVisible(true);
        validate();
    }
    
}
