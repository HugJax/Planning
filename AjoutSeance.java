/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;


public class AjoutSeance extends JPanel{
    protected JTextField course;
    private Enseignant prof;
    private Utilisateur useractif;
    private UserSQL con = new UserSQL();
    private AutreSQL conbis = new AutreSQL();
    private Cours cours;
    
    public AjoutSeance(int iduser){
        useractif = con.retrieveUserFromID(iduser);
        prof = con.retrieveEnseignantFromID(iduser);
        cours = conbis.retrieveCours(prof.getIDcours());
        //nom de la matière
        course = new JTextField(30);
        course.setText(cours.getNom());
        //type de cours
        String typecours[] = {"Cours Magistral","TP","TD", "Cours interractif", "Avancement projet", "Soutien", "EXAMEN"};        
        JComboBox typec = new JComboBox(typecours);
        //promo
        String promo[] = {"Premier Cycle","Second Cycle","Dernier Cycle"};        
        JComboBox cycle = new JComboBox(promo);
        //groupe
        JCheckBox checkBox1 = new JCheckBox("TD01", false);
        JCheckBox checkBox2 = new JCheckBox("TD02", false);
        JCheckBox checkBox3 = new JCheckBox("TD03", false);
        //horaires
        
        //ajouter
        JButton bouton = new JButton("Valider cette séance");
        
        add(course);
        add(typec);
        add(cycle);
        add(checkBox1);
        add(checkBox2);
        add(checkBox3);
        add(bouton);
        setVisible(true);
        validate();
    }
    
}
