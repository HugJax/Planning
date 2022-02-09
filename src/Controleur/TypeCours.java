/*
 * Classe objet correspondant au type de cours enseigné
 */
package Controleur;

/**
 *
 * @author Bastide_Fiorenza_Jacquesy TD05
 */
public class TypeCours 
{
    /// ATTRIBUTS
    private int m_idCours;
    private String m_nom;
    
    /// CONSTRUCTEURS
    public TypeCours(){
        
    }
    
    public TypeCours(int id, String nom){
        m_idCours   = id;
        m_nom       = nom;
    }
    
    /// METHODES
    /**Affichage*/
    public void afficher()
    {
         System.out.println("TypeCours Data");
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
    
    /** Fonction de récupération ou pour set le type de cours */
    public void setNom(String nom){
        m_nom       = nom;
    }
    public String getNom(){
        return m_nom;
    }
    
}