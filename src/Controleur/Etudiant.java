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
public class Etudiant extends Utilisateur
{
    /// ATTRIBUTS
    private int m_numero;
    private int m_idgroupe;
    private int m_idpromo;
    
    /// CONSTRUCTEUR
    public Etudiant(){
        
    }
    
    /// METHODES
    public int getNumero(){
        return m_numero;
    }
    public void setNumero(int Id){
        m_numero = Id;
    }
    public int getGroupe(){
        return m_idgroupe;
    }
    public void setGroupe(int Id){
        m_idgroupe = Id;
    }
    public int getPromo(){
        return m_idpromo;
    }
    public void setPromo(int Id){
        m_idpromo = Id;
    }
    
}
