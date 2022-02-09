/* 
 * To change this license header, choose License Headers in Project Properties. 
 * To change this template file, choose Tools | Templates 
 * and open the template in the editor. 
 */ 
package Vue; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import javax.swing.JButton; 
import javax.swing.JPanel; 
import java.awt.Color; 
import javax.swing.JScrollPane; 
import javax.swing.JTable; 
 
/** 
 * 
 * @author thoma 
 */ 
public class valideSeance extends JPanel{ 
     
    private JTable jt; 
    private TablSeanceValide modele; 
     
    /**Validation d'une séance*/
    public valideSeance () 
    { 
        modele = new TablSeanceValide(); 
        jt = new JTable(modele); 
        jt.setSize(900, 400);
        JScrollPane sp = new JScrollPane(jt); 
        jt.setBackground(Color.gray); 
        
        //jt.setOpaque(true); 
         
        JPanel Area = new JPanel(); 
        JButton Bouton = new JButton("Valider cette séance"); 
        Bouton.addActionListener(new MAJ()); 
        Area.add(Bouton); 
         
        add(sp); 
        add(Area); 
        
        setVisible(true); 
        validate(); 
        //jt.setBounds(300,400,2000,3000); 
        /*JScrollPane sp = new JScrollPane(jt); 
        add(sp); 
        setVisible(true); 
        validate();*/ 
    } 
 
    /**Mise à jour ed la séance validée*/
      private class MAJ implements ActionListener { 
 
        @Override 
        public void actionPerformed(ActionEvent e) 
        { 
            int[] selection = jt.getSelectedRows(); 
            for(int i = selection.length -1; i >= 0 ; i--) 
            { 
                //System.out.println(selection[i]); 
                modele.setValide(selection[i]); 
                 
                 
            } 
        } 
      } 
     
    
} 