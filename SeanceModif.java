/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.*;
import Modele.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class SeanceModif extends JFrame{
    protected Cours cours;
    private SeanceSQL con = new SeanceSQL();
    protected Seance seanceux;
    private JTextField matiere;
    private JComboBox typec;
    
    public SeanceModif(Seance seance, SeanceFenetre wa)
    {
        this.seanceux = seance;
        
        matiere = new JTextField();
        cours = con.retrieveCoursFromIDcours(seance.getCours());
        matiere.setText(cours.getNom());
        add(matiere);
        String typecours[] = {"Cours Magistral","TP","TD", "Cours interractif", "Avancement projet", "Soutien", "EXAMEN"};        
        typec = new JComboBox(typecours);
        add(typec);
        
        JButton modif = new JButton("Modifier séance");
        modif.setBackground(Color.BLUE);
        modif.addActionListener(new Update());
        add(modif);
        
        JButton suppr = new JButton("Supprimer séance");
        suppr.setBackground(Color.RED);
        suppr.addActionListener(new Supprimer());
        add(suppr);
        
        setSize(300, 400);
        
        setLayout(new GridLayout(4,1)); 
        
        setVisible(true);
    }
    
    private class Update implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //créer matiere
            int i = (int) (1 + Math.random()*(3000) + 1);
            Cours bressom = new Cours(i, matiere.getText());
            con.addCours(bressom);
            //modifier seanceux
            int tutu=0;
            String rep = (String) typec.getItemAt(typec.getSelectedIndex());
            switch(rep)
            {
                case "Cours Magistral": tutu=1;
                break;
                case "Cours interractif": tutu=2;
                break;
                case "TD": tutu=3;
                break;
                case "TP": tutu=4;
                break;
                case "Avancement projet": tutu=5;
                break;
                case "Soutien": tutu=6;
                break;
                case "EXAMEN": tutu=7;
                break;
            }
            Seance temp = new Seance(seanceux.getID(), i, tutu);
            //update la bdd
            con.updateSeance(temp);
        }
    }
    
    private class Supprimer implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //supprimer à partir de l'id
            con.deleteSeance(seanceux);
        }
    }
    
}
