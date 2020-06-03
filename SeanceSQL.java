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
                list.add(new Groupe(rs.getInt(1), rs.getString(2), rs.getInt(3)));
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
    
    public ArrayList<Seance> retrieveSeanceFromSemaine(int id, int semaine) {
        ArrayList<Seance> list = new ArrayList<>(100);
        Seance temp = new Seance();
        String query = "SELECT seance.IDseance, seance.Semaine, seance.Date, seance.HeureDebut, seance.HeureFin FROM seance, seancegroupe, etudiant, enseignant, seanceenseignant WHERE (etudiant.IDgroupe = seancegroupe.IDgroupe AND seance.IDseance = seancegroupe.IDseance AND etudiant.IDetudiant = " + id + " AND seance.Semaine = " + semaine + ") OR (enseignant.IDenseignant = seanceenseignant.IDenseignant AND seance.IDseance = seanceenseignant.IDseance AND enseignant.IDenseignant = " + id + " AND seance.Semaine = " + semaine + ")";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/planning", "root", "");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                temp.setID(rs.getInt(1));
                temp.setSemaine(rs.getInt(2));
                temp.setDate(rs.getInt(3));
                temp.setHeureDebut(rs.getInt(4));
                temp.setHeureFin(rs.getInt(5));
                list.add(new Seance(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return list;
    }
    
    public void deleteSeance(Seance change) {
        String sql = "DELETE FROM seance WHERE IDseance = " + change.getID();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/planning", "root", "");
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        sql = "DELETE FROM seancegroupe WHERE IDseance = " + change.getID();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/planning", "root", "");
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        sql = "DELETE FROM seanceenseignant WHERE IDseance = " + change.getID();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/planning", "root", "");
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        sql = "DELETE FROM seancesalle WHERE IDseance = " + change.getID();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/planning", "root", "");
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
    
    public void updateSeance(Seance change) {
        String sql = "UPDATE seance SET IDcours = " + change.getCours() + ", IDtypecours = " + change.getTypeCours() + " WHERE IDseance = " + change.getID();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/planning", "root", "");
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
    
    public void addCours(Cours nouvp) {
        String sql = "INSERT INTO cours(IDcours, Nom) VALUES(?, ?)";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/planning", "root", "");
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, nouvp.getID());
            pst.setString(2, nouvp.getNom());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
    
}
