/*
 * Classe fenetre
 */
package Vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Controleur.*;

/**
 *
 * @author Bastide_Fiorenza_Jacquesy TD05
 */
public class Fenetre extends JFrame
{
    private Page page;
    public Fenetre() throws IOException
    {
        setVisible(true);
        setTitle("Planning");
        setSize(1200, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        page = new Page();
        add(page);
        this.validate();
    }
        
}
