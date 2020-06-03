/*
 * Classe objet correspondant à la matière du cours
 */
package Controleur;

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
    public Cours(){
        
    }
    
    public Cours(int id, String nom){
        m_idCours   = id;
        m_nom       = nom;
    }
    
    /// METHODES
    /**affichage*/
    public void afficher()
    {
        System.out.println("Cours Data");
        System.out.println(m_idCours);
        System.out.println(m_nom);
    }
    
    /** Fonction de récupération l'ID */
    public int getID(){
        return m_idCours;
    }
    
    public void setID(int id)
    {
        m_idCours = id;
    }
    
    /** Fonction de récupération ou pour set la matière */
    public String getNom(){
        return m_nom;
    }
    public void setNom(String nom){
        m_nom     = nom;
    }
}