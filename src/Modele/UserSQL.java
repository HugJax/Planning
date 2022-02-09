/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Controleur.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hecat
 */
public class UserSQL {
    
    /**
     *
     */
    public UserSQL(){
    }
    
    /**Retrouver un utilisateur via identificatio
     * @param mail
     * @param mdp
     * @return temp*/
    public Utilisateur retrieveUser(String mail, String mdp) {
        Utilisateur temp = new Utilisateur();
        String query = "SELECT * FROM Utilisateur WHERE Email = '" + mail + "' AND MotDePasse = '" + mdp + "'";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/planning", "root", "");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                temp.setID(rs.getInt(1));
                temp.setMail(rs.getString(2));
                temp.setMdP(rs.getString(3));
                temp.setNom(rs.getString(4));
                temp.setPrenom(rs.getString(6));
                temp.setDroit(rs.getInt(6));
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return temp;
    }
    
    /**Retrouver un utlisateur via ID
     * @param id
     * @return temp*/
    public Utilisateur retrieveUserFromID(int id) {
        Utilisateur temp = new Utilisateur();
        String query = "SELECT * FROM Utilisateur WHERE IDuser = " + id;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/planning", "root", "");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                temp.setID(rs.getInt(1));
                temp.setMail(rs.getString(2));
                temp.setMdP(rs.getString(3));
                temp.setNom(rs.getString(4));
                temp.setPrenom(rs.getString(5));
                temp.setDroit(rs.getInt(6));
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return temp;
    }
    
    /**Vérifier existance d'unn utilisateur
     * @param mail
     * @param mdp
     * @return i*/
    public int existUser(String mail, String mdp) {
        int i=0;
        String query = "SELECT count(*) FROM Utilisateur WHERE Email = '" + mail + "' AND MotDePasse = '" + mdp + "'";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/planning", "root", "");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                i = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return i;
    }
    
    
    
    
    /**Retrouver étudiant via ID
     * @param id
     * @return temp*/
    public Etudiant retrieveEtudiantFromID(int id) {
        Etudiant temp = new Etudiant();
        String query = "SELECT * FROM etudiant WHERE IDetudiant = " + id;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/planning", "root", "");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                temp.setID(rs.getInt(1));
                temp.setNumero(rs.getInt(2));
                temp.setGroupe(rs.getInt(3));
                temp.setPromo(rs.getInt(4));
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return temp;
    }
    
    /**Retrouver un enseignant via ID
     * @param id
     * @return temp*/
    public Enseignant retrieveEnseignantFromID(int id) {
        Enseignant temp = new Enseignant();
        String query = "SELECT * FROM enseignant WHERE IDenseignant = " + id;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/planning", "root", "");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                temp.setID(rs.getInt(1));
                temp.setIDcours(rs.getInt(2));
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return temp;
    }
    
}
