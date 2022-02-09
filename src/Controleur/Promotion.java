/*
 * Classe objet correspondant à une promotion
 */
package Controleur;

/**
 *
 * @author Bastide_Fiorenza_Jacquesy TD05
 */
public class Promotion {
    /// ATTRIBUTS
    private int m_idpromo;
    private String m_promo;
    
    /// CONSTRUCTEURS
    public Promotion(){
        
    }
    
    public Promotion(int id, String promo){
        m_idpromo   = id;
        m_promo     = promo;
    }
    
    /// METHODES
    /** Fonction de récupération l'ID */
    public void setID(int id){
        m_idpromo = id;
    }
    public int getID(){
        return m_idpromo;
    }
    
    /** Fonction de récupération ou pour set la promo */
    public String getPromo(){
        return m_promo;
    }
    public void setPromo(String promo){
        m_promo     = promo;
    }
}
