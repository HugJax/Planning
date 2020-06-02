/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Controleur.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SeanceSQL {
    
    public SeanceSQL(){
        
    }
    
    public Seance retrieveSeanceFromID(int id) {
        Seance temp = new Seance();
        String query = "SELECT * FROM seance WHERE IDseance = " + id;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/planning", "root", "");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                temp.setID(rs.getInt(1));
                temp.setSemaine(rs.getInt(2));
                temp.setDate(rs.getInt(3));
                temp.setHeureDebut(rs.getInt(4));
                temp.setHeureFin(rs.getInt(5));
                temp.setEtat(rs.getInt(6));
                temp.setCours(rs.getInt(7));
                temp.setTypeCours(rs.getInt(8));
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return temp;
    }
    
    public ArrayList<Groupe> retrieveSeanceGrpFromIDseance(int id) {
        ArrayList<Groupe> list = new ArrayList<>(100);
        Groupe temp = new Groupe();
        String query = "SELECT groupe.IDgroupe, groupe.Groupe, groupe.IDpromo FROM groupe, seancegroupe WHERE groupe.IDgroupe = seancegroupe.IDgroupe AND IDseancegroupe = " + id;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/planning", "root", "");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                temp.setID(rs.getInt(1));
                temp.setGroupe(rs.getString(2));
                temp.setIDpromo(rs.getInt(3));
                list.add(temp);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return list;
    }
    
    public Enseignant retrieveSeanceEnseignantFromIDseance(int id) {
        Enseignant temp = new Enseignant();
        String query = "SELECT enseignant.IDenseignant, enseignant.IDcours FROM seanceenseignant, enseignant WHERE seanceenseignant.IDenseignant = enseignant.IDenseignant AND seanceenseignant.IDseance = " + id;
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
    
    public Salle retrieveSeanceSalleFromIDseance(int id) {
        Salle temp = new Salle();
        String query = "SELECT salle.IDsalle, salle.Nom, salle.IDsite FROM seancesalle, salle WHERE salle.IDsalle = seancesalle.IDsalle AND seancesalle.IDseance = " + id;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/planning", "root", "");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                //à remplir
                temp.setID(rs.getInt(1));
                temp.setNom(rs.getString(2));
                temp.setSite(rs.getInt(3));
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return temp;
    }
    
    public Cours retrieveCoursFromIDcours(int id) {
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
    
    public TypeCours retrieveTypeCoursFromIDcours(int id) {
        TypeCours temp = new TypeCours();
        String query = "SELECT * FROM typecours WHERE IDtypecours = " + id;
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
    
    public Site retrieveSiteFromIDsite(int id) {
        Site temp = new Site();
        String query = "SELECT * FROM site WHERE IDsite = " + id;
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
    
    public int ajouterSeance(int semaine,int date,int heuredebut,int heurefin,int etat,int idcours,int idtypecours) throws SQLException
    {
            String query = "INSERT INTO seance (Semaine, Date, HeureDebut, HeureFin, Etat, IDcours, IDtypecours) VALUES ("+ semaine +","+ date + ","+ heuredebut +","+ heurefin + ","+ etat + ","+ idcours +","+ idtypecours +");";
            int idnewseance =0;
                
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/planning", "root", "");
                Statement stm = con.createStatement();
                stm.executeUpdate(query);
            
                query  = "SELECT IDseance FROM seance WHERE Semaine='" + semaine + "' AND Date='" + date + "' AND HeureDebut='" + heuredebut +"' AND HeureFin='" + heurefin + "' AND Etat='" + etat + "' AND IDcours='" + idcours + "' AND IDtypecours='" + idtypecours + "';";
                ResultSet rs = stm.executeQuery(query);
                 while (rs.next()) {
                     idnewseance = rs.getInt(1);
            }
                
        return idnewseance;
    }
    
    public void ajouterSeanceEnseignant(int idseance,int idenseignant) throws SQLException
    {
              String query = "INSERT INTO seanceenseignant (IDseance, IDenseignant) VALUES ("+ idseance +","+ idenseignant + ");";
                
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/planning", "root", "");
                Statement stm = con.createStatement();
                stm.executeUpdate(query);
    }
    
    public void ajouterSeanceGroupe(int idseance,int idgroupe) throws SQLException
    {
              String query = "INSERT INTO seancegroupe (IDseance, IDgroupe) VALUES ("+ idseance +","+ idgroupe + ");";
                
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/planning", "root", "");
                Statement stm = con.createStatement();
                stm.executeUpdate(query);
    }
    
    public void ajouterSeanceSalle(int idseance,int idsalle) throws SQLException
    {
              String query = "INSERT INTO seancesalle (IDseance, IDsalle) VALUES ("+ idseance +","+ idsalle + ");";
                
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/planning", "root", "");
                Statement stm = con.createStatement();
                stm.executeUpdate(query);
    }
}
