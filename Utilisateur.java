/*
 * Classe objet correspondant à l'utilisateur
 */
package controleur;

/**
 *
 * @author Bastide_Fiorenza_Jacquesy TD05
 */
abstract class Utilisateur {
    /// ATTIRBUTS
    protected int m_iduser;
    protected String m_email;
    protected String m_mdp;
    protected String m_nom;
    protected String m_prenom;
    protected int m_droit;
    
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
    
    abstract void ajouterUtilisateur();         //Méthode abstraite qui permettra d'ajouter un ou plusieurs utilisateurs en fonction de leurs types
    abstract void supprimerUtilisateur();           //Méthode abstraite qui permettra de supprimer un ou plusieurs utilisateurs en  fonction de leurs types
    
    
    
}