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
public class AutreSQL {
    
    /**
     *
     */
    public AutreSQL(){
        
    }
    
    /**Retrouver un groupe via ID
     * @param id
     * @return temp*/
    public Groupe retrieveGroupe(int id) {
        Groupe temp = new Groupe();
        String query = "SELECT * FROM groupe WHERE IDgroupe = " + id;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/planning", "root", "");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                temp.setID(rs.getInt(1));
                temp.setGroupe(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return temp;
    }
    
    /**Retrouver une promo via ID
     * @param id
     * @return */
    public Promotion retrievePromo(int id) {
        Promotion temp = new Promotion();
        String query = "SELECT * FROM promotion WHERE IDpromo = " + id;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/planning", "root", "");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                temp.setID(rs.getInt(1));
                temp.setPromo(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return temp;
    }
    
    /**Retrouver un cours via ID
     * @param id
     * @return temp*/
    public Cours retrieveCours(int id) {
        Cours temp = new Cours();
        String query = "SELECT * FROM cours WHERE IDcours = " + id;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/planning", "root", "");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                temp.setID(rs.getInt(1));
                temp.setNom(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return temp;
    }
    
    /**Retrouver un horaire de cours via ID
     * @param matiere
     * @return q */
    public int retrieveHeuresCours(String matiere) {
        int q=0;
        String query = "SELECT count(*) FROM seance, cours WHERE seance.Etat = 2 AND seance.IDcours = cours.IDcours AND cours.Nom = '" + matiere + "'";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/planning", "root", "");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                q = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return q;
    }
    
}
