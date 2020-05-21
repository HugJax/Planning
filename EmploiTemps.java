/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.util.ArrayList;

/**
 *
 * @author Rémi Fiorenza
 */
public class EmploiTemps {
    
    //ATTRIBUTS
    
    private ArrayList<SeanceEmploi> m_seances;              //Séances à afficher dans l'emploi du temps 
    
    //METHODES
    
    void afficherSeances()
    {
        for(int i = 0; i < m_seances.size(); ++i)
        {
            System.out.print(i);
        }
    }
    
}
