/*
 * Classe objet du groupe de classe
 */
package Controleur;

/**
 *
 * @author Bastide_Fiorenza_Jacquesy TD05
 */
public class Groupe 
{
    /// ATTRIBUTS
    private int m_idGroupe;
    private String m_nom;
    private int m_idpromo;
    
    /// CONSTRUCTEURS
    public Groupe(){
        
    }
    
    public Groupe(int id, String nom){
        m_idGroupe  = id;
        m_nom       = nom;
    }
    
    public Groupe(int id, String nom, int idpromo){
        m_idGroupe  = id;
        m_nom       = nom;
        m_idpromo   = idpromo;
    }
    
    /// METHODES
    /** Fonction de récupération l'ID */
    public void setID(int id){
        m_idGroupe = id;
    }
    public int getID(){
        return m_idGroupe;
    }
    
    /** Fonction de récupération ou pour set le groupe */
    public String getGroupe(){
        return m_nom;
    }
    public void setGroupe(String nom){
        m_nom     = nom;
    }
    
    public void setIDpromo(int id){
        m_idpromo = id;
    }
    public int getIDpromo(){
        return m_idpromo;
    }
    
}
