/*
 * Classe affichage bouton seance pour ouvrir une fenetre d'information
 */
package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.red;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Bastide_Fiorenza_Jacquesy TD05
 */
public class SeanceBouton extends JPanel{
    protected JButton Bouton;
    
    SeanceBouton(){
        //Bouton.setPreferredSize(new Dimension(120, 60));
        //this.setBackground(Color.GREEN);
        Bouton = new JButton("<html>Matiere<br>prof<br>Cours magistral</html>");
        Bouton.setBackground(Color.GREEN);
        Bouton.addActionListener(new Details());
        add(Bouton);
        validate();
    }
    
    private class Details implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
           SeanceFenetre flute = new SeanceFenetre();
        }
    }
}
