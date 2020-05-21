/*
 * Classe objet correspondant au batiment utilisé pour faire cours
 */
package controleur;

/**
 *
 * @author Bastide_Fiorenza_Jacquesy TD05
 */
public class Site 
{
    /// ATTRIBUTS
    private int m_idSite;
    private String m_nom;
    
    /// CONSTRUCTEURS
    Site(){
        
    }
    
    Site(int id, String nom){
        m_idSite   = id;
        m_nom     = nom;
    }
    
    /// METHODES
    /** Fonction de récupération l'ID */
    public int getID(){
        return m_idSite;
    }
    
    /** Fonction de récupération ou pour set le lieu */
    public String getNom(){
        return m_nom;
    }
    public void setNom(String nom){
        m_nom     = nom;
    }
    
}