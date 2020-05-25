/*
 * Classe fenetre des informations d'une séance
 */
package Vue;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import Controleur.*;
import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *
 * @author Bastide_Fiorenza_Jacquesy TD05
 */
public class SeanceFenetre extends JFrame{
    //private int IDseance;
    //private Seance cours;
    private JLabel info;
    
    SeanceFenetre(){
        this.setBackground(new Color(1,177,229));
        this.setSize(300,200);
        
        info = new JLabel("<html><ul><li>Matiere : Physique</li><br><li>prof : Moi</li><br><li>Cours magistral</li><br><li>Heure Début : 8h<br>Heure fin : 10h</li></ul></html>");
        
        this.add(info);
        
        this.setVisible(true);
        this.validate();
    }
}
