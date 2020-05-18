/*
 * Classe objet du groupe de classe
 */
package controleur;

/**
 *
 * @author Bastide_Fiorenza_Jacquesy TD05
 */
public class Groupe 
{
    /// ATTRIBUTS
    private int m_idGroupe;
    private String m_nom;
    
    /// CONSTRUCTEURS
    Groupe(){
        
    }
    
    Groupe(int id, String nom){
        m_idGroupe  = id;
        m_nom       = nom;
    }
    
    /// METHODES
    /** Fonction de récupération l'ID */
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
    
}
