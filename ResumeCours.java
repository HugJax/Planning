/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class ResumeCours extends JPanel{
    /// ATTRIBUTS
    private int physique, maths, info, elec, projet;
    private AutreSQL con = new AutreSQL();
    
    /// CONSTRUCTEUR
    public ResumeCours(int iduser){
        String column[] = {"Matière","Enseignant","Nombre de cours"};
        
        physique = con.retrieveHeuresCours("Physique");
        maths = con.retrieveHeuresCours("Maths");
        info = con.retrieveHeuresCours("Info");
        elec = con.retrieveHeuresCours("Electronique");
        projet = con.retrieveHeuresCours("Gestion de projet");
        
        String data[][] = {{"Physique","Albert Boum",""+physique}, 
                            {"Mathématiques","Julien LesProfs",""+maths}, 
                            {"Informatique","Eliot Alderson",""+info}, 
                            {"Electronique","Thor Odinson",""+elec}, 
                            {"Gestion de projet","Tony Stark",""+projet}};
        JTable jt=new JTable(data,column); 
        jt.setBounds(450,400,1000,100); 
        JScrollPane sp=new JScrollPane(jt); 
        add(sp);
    }
    
}
