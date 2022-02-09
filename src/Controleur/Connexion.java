/*
 * Classe de connexion pour acceder au planning
 */
package Controleur;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Vue.*;
import Modele.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Bastide_Fiorenza_Jacquesy TD05
 */
public class Connexion extends JPanel{
    /// ATTRIBUTS

    /**
     *
     */
    protected JTextField user;

    /**
     *
     */
    protected JPasswordField pass;

    /**
     *
     */
    protected JLabel use;

    /**
     *
     */
    protected JLabel pas;

    /**
     *
     */
    protected JButton login;
    private int[] idpers;
    private Page pa;
    private Utilisateur useractif = new Utilisateur();
    private UserSQL con = new UserSQL();
    
    /// CONSTRUCTEURS
    Connexion(Page a){
        pa=a;
        setLayout(null);
        use = new JLabel("Adresse e-mail");
        use.setBounds(850, 270, 300, 30);
        pas = new JLabel("mot de passe");
        pas.setBounds(850, 320, 300, 30);
        user = new JTextField(30);
        user.setBounds(850, 295, 300, 25);
        //user.setText("admin");// à supprimer à la fin
        pass = new JPasswordField(15);
        pass.setBounds(850, 345, 300, 25);
        //pass.setText("admin");// à supprimer à la fin
        login = new JButton("Login");
        login.setBounds(1050, 400, 100, 30);
        add(use);
        add(user);
        add(pas);
        add(pass);
        login.addActionListener(new Login());
        add(login);
        validate();
    }
    
    /// METHODES
    /** Création d'un arrière plan */
    public void paintComponent(Graphics g)
    {
        try {
            int i = (int) (1 + Math.random()*(4) + 1);
            String filename = "images\\co" + i + ".png";
            Image img = ImageIO.read(new File(filename));
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erreur image de fond: " +e.getMessage());
        }
    }
    
    /** Vérification identification */
    private class Login implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                    int exi = con.existUser(user.getText(), String.valueOf(pass.getPassword()));
                    if(exi == 1){
                        setVisible(false);
                        pa.setVisible(false);
                        useractif = con.retrieveUser(user.getText(), String.valueOf(pass.getPassword()));
                        Wall wall= new Wall(useractif.getID());
                    }
                }
            }
    }
