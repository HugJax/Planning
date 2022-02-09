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
    private String m_cours; 
    private String m_typescours; 
    private String m_salle; 
    private String m_site; 
    private String m_promotion; 
    private String m_groupe; 
    private String m_enseignant; 
    
    /// CONSTRUCTEURS

    /**
     *
     */
    public Seance(){
        
    }
    
    /**
     *
     * @param id
     * @param idcours
     * @param idtype
     */
    public Seance(int id, int idcours, int idtype){
        m_idSeance      = id;
        m_idtypeCours     = idtype;
        m_idcours         = idcours;
    }
    
    /**
     *
     * @param id
     * @param semaine
     * @param date
     * @param hdeb
     * @param hfin
     */
    public Seance(int id, int semaine, int date, int hdeb, int hfin){
        m_idSeance      = id;
        m_semaine       = semaine;
        m_date          = date;
        m_heureDebut    = hdeb;
        m_heureFin      = hfin;
    }
    
    /**
     *
     * @param id
     * @param semaine
     * @param date
     * @param hrsdeb
     * @param hrsfin
     * @param etat
     * @param typecours
     * @param cours
     */
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
    
    
    /** Fonction de récupération l'ID
     * @return  */
    public int getID(){
        return m_idSeance;
    }

    /**
     *
     * @param id
     */
    public void setID(int id){
         m_idSeance = id;
    }
    
    /** Fonction de récupération ou pour set la semaine
     * @return  */
    public int getSemaine(){
        return m_semaine;
    }

    /**
     *
     * @param semaine
     */
    public void setSemaine(int semaine){
        m_semaine       = semaine;
    }
    
    /** Fonction de récupération ou pour set la date
     * @return  */
    public int getDate(){
        return m_date;
    }

    /**
     *
     * @param date
     */
    public void setDate(int date){
        m_date          = date;
    }
    
    /** Fonction de récupération ou pour set l'heure de début
     * @return  */
    public int getHeureDebut(){
        return m_heureDebut;
    }

    /**
     *
     * @param hrs
     */
    public void setHeureDebut(int hrs){
        m_heureDebut    = hrs;
    }
    
    /** Fonction de récupération ou pour set l'heure de fin
     * @return  */
    public int getHeureFin(){
        return m_heureFin;
    }

    /**
     *
     * @param hrs
     */
    public void setHeureFin(int hrs){
        m_heureFin      = hrs;
    }
    
    /** Fonction de récupération ou pour set l'état du cours
     * @return  */
    public int getEtat(){
        return m_etat;
    }

    /**
     *
     * @param etat
     */
    public void setEtat(int etat){
        m_etat          = etat;
    }
    
    /** Fonction de récupération ou pour set le type de cours
     * @return  */
    public int getTypeCours(){
        return m_idtypeCours;
    }

    /**
     *
     * @param type
     */
    public void setTypeCours(int type){
        m_idtypeCours     = type;
    }
    
    /** Fonction de récupération ou pour set la matière
     * @return  */
    public int getCours(){
        return m_idcours;
    }

    /**
     *
     * @param type
     */
    public void setCours(int type){
        m_idcours         = type;
    }
    
    /**
     *
     * @return
     */
    public String getCoursNom(){ 
        return m_cours; 
    } 

    /**
     *
     * @param type
     */
    public void setCoursNom(String type){ 
        m_cours         = type; 
    } 

    /**
     *
     * @return
     */
    public String gettypeCoursNom(){ 
        return m_typescours; 
    } 
     
    /**
     *
     * @param type
     */
    public void settypeCoursNom(String type){ 
        m_typescours         = type; 
    } 
     
     /** Fonction de récupération ou pour set la salle 
     * @return  */ 
     public String getsalle(){ 
        return m_salle; 
    } 
     
    /**
     *
     * @param type
     */
    public void setsalle(String type){ 
        m_salle         = type; 
    } 
     
     /** Fonction de récupération ou pour set le site 
     * @return  */ 
     public String getsite(){ 
        return m_site; 
    } 
     
    /**
     *
     * @param type
     */
    public void setsite(String type){ 
        m_site       = type; 
    } 
     
     /** Fonction de récupération ou pour set la promotion 
     * @return  */ 
     public String getpromotion(){ 
        return m_promotion; 
    } 
     
    /**
     *
     * @param type
     */
    public void setpromotion(String type){ 
        m_promotion         = type; 
    } 
     
     /** Fonction de récupération ou pour set le groupe 
     * @return  */ 
     public String getgroupe(){ 
        return m_groupe; 
    } 
     
    /**
     *
     * @param type
     */
    public void setgroupe(String type){ 
        m_groupe        = type; 
    } 
     
     /** Fonction de récupération ou pour set le groupe 
     * @return  */ 
     public String getenseignant(){ 
        return m_enseignant; 
    } 
     
    /**
     *
     * @param type
     */
    public void setenseignant(String type){ 
        m_enseignant        = type; 
    } 
    
    
    
}