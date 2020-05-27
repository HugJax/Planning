/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.SQLException;
import java.util.ArrayList;
import ConnexionSQL.ConnexionSQL;
import controleur.*;
/**
 *
 * @author thoma
 */
public class UtilisateurDAO extends DAO<Utilisateur>{
    
    public UtilisateurDAO(ConnexionSQL conn){
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
  * @param user
  * @param mdp
  * @param User
  */
  public void findConnexion(String user,String mdp,Utilisateur User)
  {
      
     try
     {
      try
      {
      //testList = maconnexion.remplirChampsTable("utilisateur");
            String requeteSelectionnee = "SELECT * FROM utilisateur WHERE Email='" + user + "' AND MotDePasse='" + mdp +"';";
            //String requeteSelectionnee = "select * from utilisateur";
            maconnexion.remplirUtilisateurConn(requeteSelectionnee,User);
 
     
      }
      catch(SQLException e)
      {
          System.out.println("Connexion echouee : probleme SQLUtilisateurDAO");
      }
      
     }
     catch(ClassNotFoundException e)
     {
         System.out.println("Connexion echouee : probleme ClassNotfoundtilisateurDAO");
     }
  }

/**
  * Méthode de recherche des informations
  * @param ID
  * @param User
  */
  public void findUserId(String ID,Utilisateur User)
  {
      
     try
     {
      try
      {
      //testList = maconnexion.remplirChampsTable("utilisateur");
            String requeteSelectionnee = "SELECT * FROM utilisateur WHERE IDuser='" + ID + "';";
            //String requeteSelectionnee = "select * from utilisateur";
            maconnexion.remplirUtilisateurConn(requeteSelectionnee,User);
 
     
      }
      catch(SQLException e)
      {
          System.out.println("Connexion echouee : probleme SQLUtilisateurDAO");
      }
      
     }
     catch(ClassNotFoundException e)
     {
         System.out.println("Connexion echouee : probleme ClassNotfoundtilisateurDAO");
     }
  }
    
}
/**
 *
 * @author thoma
 */

