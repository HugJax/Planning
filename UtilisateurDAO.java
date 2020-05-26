/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Database.Utilisateur;
import java.sql.SQLException;
import java.util.ArrayList;
import Connexion.Connexion;
/**
 *
 * @author thoma
 */
public class UtilisateurDAO extends DAO<Utilisateur>{
    
    public UtilisateurDAO(Connexion conn){
        super(conn);
    }
    
    /**
  * Méthode de création
  * @param obj
  * @return boolean 
  */
    @Override
  public boolean create(Utilisateur obj)
  {
      return false;
  }

  /**
  * Méthode pour effacer
  * @param obj
  * @return boolean 
  */
    @Override
  public boolean delete(Utilisateur obj)
  {
      return false;
  }

  /**
  * Méthode de mise à jour
  * @param obj
  * @return boolean
  */
    @Override
  public boolean update(Utilisateur obj)
  {
      return false;
  }

  /**
  * Méthode de recherche des informations
  * @param id
  * @return T
  */
    @Override
  public Utilisateur find(int id)
  {
      ArrayList<String> testList = new ArrayList<>();
      Utilisateur test = new Utilisateur();
      
      try
      {
      //testList = maconnexion.remplirChampsTable("utilisateur");
      String requeteSelectionnee = "select * from " + "utilisateur" + ";";
      testList = maconnexion.remplirChampsRequete(requeteSelectionnee);
      test.Set_Utilisateur(testList);
      test.afficher_data();
      }
      catch(SQLException e)
      {
          System.out.println("Connexion echouee : probleme SQLUtilisateurDAO");
      }
      
      
      return test;
  }
    
}
/**
 *
 * @author thoma
 */

