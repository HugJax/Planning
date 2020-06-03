/*
 * Classe de la page
 */
package Controleur;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author Bastide_Fiorenza_Jacquesy TD05
 */
public class Page extends JPanel{
    public Page()
    {
        this.setLayout(new BorderLayout());
        JPanel buffer= new Connexion(this);
        add(buffer,BorderLayout.CENTER);
        this.validate();
    }
    
}
