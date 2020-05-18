/*
 * Classe objet de la salle utilisée
 */
package controleur;

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
    private Site m_site;
    
    /// CONSTRUCTEURS
    Salle(){
        
    }
    Salle(int id, String nom, int capacite, Site site){
        m_idSalle   = id;
        m_nom       = nom;
        m_capacite  = capacite;
        m_site      = site;
    }
    
    /// METHODES
    /** Fonction de récupération l'ID */
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
    public Site getSite(){
        return m_site;
    }
    public void setSite(Site site){
        m_site       = site;
    }
    
}
