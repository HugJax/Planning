/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Connexion.Connexion;
/**
 *
 * @author thoma
 * @param <T>
 */
public abstract class DAO<T> {
  Connexion maconnexion = null;
  
   
  public DAO(Connexion conn){
    this.maconnexion  = conn;
  }
   
  /**
  * Méthode de création
  * @param obj
  * @return boolean 
  */
  public abstract boolean create(T obj);

  /**
  * Méthode pour effacer
  * @param obj
  * @return boolean 
  */
  public abstract boolean delete(T obj);

  /**
  * Méthode de mise à jour
  * @param obj
  * @return boolean
  */
  public abstract boolean update(T obj);

  /**
  * Méthode de recherche des informations
     * @param d
  * @return T
  */
  public abstract T find(int d);
}
