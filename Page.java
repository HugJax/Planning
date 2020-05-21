/*
 * Classe de la page
 */
package Controleur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
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
