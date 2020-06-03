/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

/**
 *
 * @author Rémi Fiorenza
 */
public class Enseignant extends Utilisateur
{
    /// ATTRIBUTS
    private int m_idcours;
    
    /// CONSTRUCTEUR
    public Enseignant(){
        
    }
    
    /// METHODES
    public void setIDcours(int id){
        m_idcours = id;
    }
    public int getIDcours(){
        return m_idcours;
    }
    
}
