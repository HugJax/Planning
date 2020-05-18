/*
 * Classe objet correspondant à l'utilisateur
 */
package controleur;

/**
 *
 * @author Bastide_Fiorenza_Jacquesy TD05
 */
public class Utilisateur {
    /// ATTIRBUTS
    private int m_iduser;
    private String m_email;
    private String m_mdp;
    private String m_nom;
    private String m_prenom;
    private int m_droit;
    
    /// CONSTRUCTEURS
    Utilisateur(){
        
    }
    
    Utilisateur(int id, String mail, String mdp, String lastname, String firstname, int autho){
        m_iduser    = id;
        m_email     = mail;
        m_mdp       = mdp;
        m_nom       = lastname;
        m_prenom    = firstname;
        m_droit     = autho;
    }
    
    /// METHODES
    /** Fonction de récupération d'ID */
    public int getID(){
        return m_iduser;
    }
    
    /** Fonction de récupération ou pour set le mail */
    public void setMail(String mail){
        m_email     = mail;
    }
    public String getMail(){
        return m_email;
    }
    
    /** Fonction de récupération ou pour set le mot de passe */
    public void setMdP(String code){
        m_mdp       = code;
    }
    public String getMdP(){
        return m_mdp;
    }
    
    /** Fonction de récupération ou pour set le nom */
    public void setNom(String nom){
        m_nom       = nom;
    }
    public String getNom(){
        return m_nom;
    }
    
    /** Fonction de récupération ou pour set le prenom */
    public void setPrenom(String prenom){
        m_prenom    = prenom;
    }
    public String getPrenom(){
        return m_prenom;
    }
    
    /** Fonction de récupération ou pour set le droit */
    public void setDroit(int droit){
        m_droit     = droit;
    }
    public int getDroit(){
        return m_droit;
    }
    
}
