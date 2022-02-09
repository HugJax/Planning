/* 
 * To change this license header, choose License Headers in Project Properties. 
 * To change this template file, choose Tools | Templates 
 * and open the template in the editor. 
 */ 
package Vue; 
 
import Controleur.Enseignant; 
import Controleur.Groupe; 
import Controleur.Salle; 
import Controleur.Seance; 
import Controleur.Utilisateur; 
import Modele.AutreSQL; 
import Modele.UserSQL; 
import java.util.ArrayList; 
import javax.swing.table.AbstractTableModel; 
import Modele.SeanceSQL; 
 
/** 
 * 
 * @author thoma 
 */ 
public class TablSeanceValide extends AbstractTableModel{ 
    private final SeanceSQL con = new SeanceSQL(); 
    private final UserSQL conbis = null; 
    private ArrayList<Seance> m_seance; 
    /*private SeanceEnseignant[] m_enseignat; 
    private String[] Cours; 
    private String[] TypesCours; 
    private String[] Salle; 
    private String[] Groupe; 
    private String[] Promotion; 
    private String[] Site;*/ 
    private Object[][] donnees; 
    private String[] entetes;  
     
    /**Affichage de la table de validation admin*/
    public TablSeanceValide() 
    { 
        super(); 
        //useractif = conbis.retrieveUserFromID(iduser); 
        entetes = new String[]{"Enseignant","Matiere","Type de cours","semaine","Date","Horaires","Salle","Site","Promotion","Groupe"}; 
        //donnees= new Object[][]{{"Thomas","Physique","EXAM","23","Lundi","8-9h","205","Eiffel 2","Cycle secondaire","TD03"}}; 
        m_seance = con.retrieveSeanceValide(); 
        
    } 
     
     /**Compteur de ligne*/
    @Override 
     public int getRowCount() 
    { 
        return m_seance.size(); 
       //return Cours.length; 
    } 
     
     
     /**Compteur de colonne*/
    @Override 
    public int getColumnCount() 
    { 
        return entetes.length; 
    } 
     
    /** 
     * 
     * @param columnIndex 
     * @return 
     */ 
    @Override 
    public String getColumnName(int columnIndex) 
    { 
        return entetes[columnIndex]; 
    } 
     
    /** 
     * 
     * @param rowIndex 
     * @param ColumnIndex 
     * @return 
     */ 
    /**Récupération des données
     * @param ColumnIndex*/
    @Override 
    public Object getValueAt(int rowIndex,int ColumnIndex) 
    { 
        switch(ColumnIndex) 
        { 
            case 0: 
                return m_seance.get(rowIndex).getenseignant(); 
            case 1: 
                return m_seance.get(rowIndex).getCoursNom(); 
            case 2: 
                return m_seance.get(rowIndex).gettypeCoursNom(); 
            case 3: 
                return m_seance.get(rowIndex).getSemaine(); 
            case 4: 
                    int jours = m_seance.get(rowIndex).getDate(); 
            switch (jours) { 
                case 1: 
                    return "Lundi"; 
                case 2: 
                    return "mardi"; 
                case 3: 
                    return "mercredi"; 
                case 4: 
                    return "jeudi"; 
                case 5: 
                    return "vendredi"; 
                case 6: 
                    return "vendredi"; 
                default: 
                    return "date incorrect"; 
            } 
 
            case 5: 
                String heure = m_seance.get(rowIndex).getHeureDebut()+ "-" + m_seance.get(rowIndex).getHeureFin() + "h"; 
                return heure; 
            case 6: 
                return m_seance.get(rowIndex).getsalle(); 
            case 7: 
                return m_seance.get(rowIndex).getsite(); 
            case 8: 
                return m_seance.get(rowIndex).getpromotion(); 
            case 9: 
                return m_seance.get(rowIndex).getgroupe(); 
            default: 
                return "donnee introuvable"; 
        } 
        //return donnees[rowIndex][ColumnIndex]; 
    } 
     
    /**Valider une séance
     * @param rowIndex*/
    public void setValide(int rowIndex) 
    { 
        con.ValideSeance(m_seance.get(rowIndex).getID()); 
        m_seance.remove(rowIndex); 
        fireTableRowsDeleted(rowIndex,rowIndex); 
    } 
} 