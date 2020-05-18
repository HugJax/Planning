/*
 * Classe objet correspondant à la matière du cours
 */
package controleur;

/**
 *
 * @author Bastide_Fiorenza_Jacquesy TD05
 */
public class Cours 
{
    /// ATTRIBUTS
    private int m_idCours;
    private String m_nom;
    
    /// CONSTRUCTEURS
    Cours(){
        
    }
    
    Cours(int id, String nom){
        m_idCours   = id;
        m_nom       = nom;
    }
    
    /// METHODES
    /** Fonction de récupération l'ID */
    public int getID(){
        return m_idCours;
    }
    
    /** Fonction de récupération ou pour set la matière */
    public String getNom(){
        return m_nom;
    }
    public void setNom(String nom){
        m_nom     = nom;
    }
}
