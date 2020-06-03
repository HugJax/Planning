/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;


public class BoutonModif extends JPanel{
    private JButton Bouton;
    private Seance seanceux;
    private SeanceFenetre wa;
    
    public BoutonModif(Seance seance, SeanceFenetre wal){
        seanceux = seance;
        wa = wal;
        Bouton = new JButton("<html>Modifier</html>");
        Bouton.addActionListener(new Babla());
        add(Bouton);
        validate();
    }
    
    private class Babla implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            SeanceModif truc = new SeanceModif(seanceux, wa);
        }
    }
    
}
