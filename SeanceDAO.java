/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import ConnexionSQL.ConnexionSQL;
import controleur.Seance;
import controleur.Utilisateur;
import java.sql.SQLException;

/**
 *
 * @author thoma
 */
public class SeanceDAO extends DAO<Seance>{
    public SeanceDAO(ConnexionSQL conn){
        super(conn);
    }
    
    /**
  * Méthode de création
  * @param obj
  * @return boolean 
  */
    @Override
  public boolean create(Seance obj)
  {
      return false;
  }

  /**
  * Méthode pour effacer
  * @param obj
  * @return boolean 
  */
    @Override
  public boolean delete(Seance obj)
  {
      return false;
  }

  /**
  * Méthode de mise à jour
  * @param obj
  * @return boolean
  */
    @Override
  public boolean update(Seance obj)
  {
      return false;
  }

  /**
  * Méthode de recherche des informations
  * @param idSeance
  * @param User
  */
  public void findConnexion(String idSeance,Seance User)
  {
      
     try
     {
      try
      {
      //testList = maconnexion.remplirChampsTable("utilisateur");
            String requeteSelectionnee = "SELECT * FROM seance WHERE IDseance='" + idSeance + "';";
            //String requeteSelectionnee = "select * from utilisateur";
            maconnexion.remplireSeance(requeteSelectionnee,User);
 
     
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
