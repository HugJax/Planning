/*
 * Classe objet de la salle utilisée
 */
package Controleur;

/**
 *
 * @author Bastide_Fiorenza_Jacquesy TD05
 */
public class Salle 
{
    /// ATTRIBUTS
    private int m_idSalle;
    private String m_nom;
    private int m_capacite;
    private int m_idsite;
    
    /// CONSTRUCTEURS
    public Salle(){
        
    }
    public Salle(int id, String nom, int capacite, int site){
        m_idSalle   = id;
        m_nom       = nom;
        m_capacite  = capacite;
        m_idsite      = site;
    }
    
    /// METHODES
    /** Fonction de récupération l'ID */
    public void setID(int id){
        m_idSalle = id;
    }
    public int getID(){
        return m_idSalle;
    }
    
    /** Fonction de récupération ou pour set la salle */
    public String getNom(){
        return m_nom;
    }
    public void setNom(String nom){
        m_nom       = nom;
    }
    
    /** Fonction de récupération ou pour set la capacité */
    public int getCapacite(){
        return m_capacite;
    }
    public void setCapacite(int capacite){
        m_capacite  = capacite;
    }
    
    /** Fonction de récupération ou pour set le site */
    public int getSite(){
        return m_idsite;
    }
    public void setSite(int site){
        m_idsite       = site;
    }
    
}
