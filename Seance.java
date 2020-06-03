/*
 * Classe objet de la séance de cours
 */
package Controleur;

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
    private int m_idtypeCours;
    private int m_idcours;
    
    /// CONSTRUCTEURS
    public Seance(){
        
    }
    
    public Seance(int id, int idcours, int idtype){
        m_idSeance      = id;
        m_idtypeCours     = idtype;
        m_idcours         = idcours;
    }
    
    public Seance(int id, int semaine, int date, int hdeb, int hfin){
        m_idSeance      = id;
        m_semaine       = semaine;
        m_date          = date;
        m_heureDebut    = hdeb;
        m_heureFin      = hfin;
    }
    
    public Seance(int id, int semaine, int date, int hrsdeb, int hrsfin, int etat, int typecours, int cours){
        m_idSeance      = id;
        m_semaine       = semaine;
        m_date          = date;
        m_heureDebut    = hrsdeb;
        m_heureFin      = hrsfin;
        m_etat          = etat;
        m_idtypeCours     = typecours;
        m_idcours         = cours;
    }
    
    /// METHODES
    
    /**
     * Fonction afficher 
     */
    public void afficher()
    {
        System.out.println("Seance Data");
        System.out.println(m_idSeance);
        System.out.println(m_semaine);
        System.out.println(m_date);
        System.out.println(m_heureDebut);
        System.out.println(m_heureFin);
        System.out.println(m_etat);
    }
    
    
    /** Fonction de récupération l'ID */
    public int getID(){
        return m_idSeance;
    }
    public void setID(int id){
         m_idSeance = id;
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
    public int getTypeCours(){
        return m_idtypeCours;
    }
    public void setTypeCours(int type){
        m_idtypeCours     = type;
    }
    
    /** Fonction de récupération ou pour set la matière */
    public int getCours(){
        return m_idcours;
    }
    public void setCours(int type){
        m_idcours         = type;
    }
    
    
    
}