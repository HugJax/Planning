/*
 * Classe objet de la séance de cours
 */
package controleur;

/**
 *
 * @author Bastide_Fiorenza_Jacquesy TD05
 */
public class Seance 
{
    /// ATTRIBUTS
    private int m_idSeance;
    private int m_semaine;
    private int m_date;
    private int m_heureDebut;
    private int m_heureFin;
    private int m_etat;
    private TypeCours m_typeCours;
    private Cours m_cours;
    
    /// CONSTRUCTEURS
    Seance(){
        
    }
    
    Seance(int id, int semaine, int date, int hrsdeb, int hrsfin, int etat, TypeCours typecours, Cours cours){
        m_idSeance      = id;
        m_semaine       = semaine;
        m_date          = date;
        m_heureDebut    = hrsdeb;
        m_heureFin      = hrsfin;
        m_etat          = etat;
        m_typeCours     = typecours;
        m_cours         = cours;
    }
    
    /// METHODES
    /** Fonction de récupération l'ID */
    public int getID(){
        return m_idSeance;
    }
    
    /** Fonction de récupération ou pour set la semaine */
    public int getSemaine(){
        return m_semaine;
    }
    public void setSemaine(int semaine){
        m_semaine       = semaine;
    }
    
    /** Fonction de récupération ou pour set la date */
    public int getDate(){
        return m_date;
    }
    public void setDate(int date){
        m_date          = date;
    }
    
    /** Fonction de récupération ou pour set l'heure de début */
    public int getHeureDebut(){
        return m_heureDebut;
    }
    public void setHeureDebut(int hrs){
        m_heureDebut    = hrs;
    }
    
    /** Fonction de récupération ou pour set l'heure de fin */
    public int getHeureFin(){
        return m_heureFin;
    }
    public void setHeureFin(int hrs){
        m_heureFin      = hrs;
    }
    
    /** Fonction de récupération ou pour set l'état du cours */
    public int getEtat(){
        return m_etat;
    }
    public void setEtat(int etat){
        m_etat          = etat;
    }
    
    /** Fonction de récupération ou pour set le type de cours */
    public TypeCours getTypeCours(){
        return m_typeCours;
    }
    public void setTypeCours(TypeCours type){
        m_typeCours     = type;
    }
    
    /** Fonction de récupération ou pour set la matière */
    public Cours getCours(){
        return m_cours;
    }
    public void setCours(Cours type){
        m_cours         = type;
    }
    
}
