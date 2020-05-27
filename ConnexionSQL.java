/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnexionSQL;
import java.sql.*;
//import java.util.ArrayList;
import controleur.*;

/**
 *
 * @author thoma
 */
public class ConnexionSQL {
    /**
     * Attributs prives : connexion JDBC, statement, ordre requete et resultat
     * requete
     */
    private final Connection conn;
    private final Statement stmt;
    private ResultSet rset;
    private ResultSetMetaData rsetMeta;
    
    /**
     * Constructeur avec 3 paramètres : nom, login et password de la BDD locale
     *
     * @param nameDatabase
     * @param loginDatabase
     * @param passwordDatabase
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public ConnexionSQL(String nameDatabase, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException{
        // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.jdbc.Driver");

        // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
        String urlDatabase = "jdbc:mysql://localhost:3306/" + nameDatabase;
       // String urlDatabase = "jdbc:mysql://localhost:3308/jps?characterEncoding=latin1";

        //création d'une connexion JDBC à la base 
        conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);

        // création d'un ordre SQL (statement)
        stmt = conn.createStatement();
    }
    
    
    /**
     * Methode qui retourne un utilisateur apres une connexion
     * @param requeteSelectionnee
     * @param user
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    
    public void remplirUtilisateurConn(String requeteSelectionnee,Utilisateur user)throws SQLException, ClassNotFoundException
    {
         // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requeteSelectionnee);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();
        
        System.out.println(nbColonne);
        
        if(nbColonne == 6)
        {
        
        rset.next();
        
        int id =  rset.getInt(1);
        String Email = rset.getString(2);
        String MotDePasse = rset.getString(3);
        String Nom = rset.getString(4);
        String Prenom = rset.getString(5);
        int droit = rset.getInt(6);
        
         /*System.out.println(id);
          System.out.println(Email);
           System.out.println(MotDePasse);
            System.out.println(Nom);
             System.out.println(Prenom);
              System.out.println(droit);*/
        
        user.setID(id);
        user.setMail(Email);
        user.setMdP(MotDePasse);
        user.setNom(Nom);
        user.setPrenom(Prenom);
        user.setDroit(droit);
        
        }
        else
        {
            System.out.println("probleme ClassSQLConnexion");
        }
    }
    
    /**
     * Methode qui retourne un utilisateur apres une connexion
     * @param requeteSelectionnee
     * @param user
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
public void remplireSeance(String requeteSelectionnee,Seance user)throws SQLException, ClassNotFoundException
{
     // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requeteSelectionnee);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();
        
        //System.out.println(nbColonne);
        
        if(nbColonne == 8)
        {
        
        rset.next();
        
        int id =  rset.getInt(1);
        int Semaine = rset.getInt(2);
        int Date = rset.getInt(3);
        int Heure_Debut = rset.getInt(4);
        int Heure_Fin= rset.getInt(5);
        int Etat = rset.getInt(6);
        int IDcours = rset.getInt(7);
        int IDtypeCours = rset.getInt(8);
        
         /*System.out.println(id);
          System.out.println(Semaine);
           System.out.println(Date);
            System.out.println(Heure_Debut);
             System.out.println(Heure_Fin);
              System.out.println(Etat);*/
        
        user.setID(id);
        user.setSemaine(Semaine);
        user.setDate(Date);
        user.setHeureDebut(Heure_Debut);
        user.setHeureFin(Heure_Fin);
        user.setEtat(Etat);
        
        //System.out.println(IDtypeCours);
        requeteSelectionnee ="SELECT * FROM typecours WHERE IDtypecours='" + IDtypeCours + "';";
        
        TypeCours tmp1 = new TypeCours();
            // récupération de l'ordre de la requete
            rset = stmt.executeQuery(requeteSelectionnee);

            // récupération du résultat de l'ordre
            rsetMeta = rset.getMetaData();

            // calcul du nombre de colonnes du resultat
            nbColonne = rsetMeta.getColumnCount();
        
            //System.out.println(nbColonne);
        
            if(nbColonne == 2)
            {
                rset.next();
        
               int idTypeCours =  rset.getInt(1);
               String Nom = rset.getString(2);
               
               //System.out.println(idTypeCours);
               //System.out.println(Nom);
               
               tmp1.setID(idTypeCours);
               tmp1.setNom(Nom);
               
                user.setTypeCours(tmp1);
            }
             else
            {
                System.out.println("probleme ClassSQLConnexion TypeCours");
            }
        
         //System.out.println(IDcours);
         requeteSelectionnee ="SELECT * FROM cours WHERE IDcours='" + IDcours + "';";
         
         Cours tmp2 = new Cours();
            // récupération de l'ordre de la requete
            rset = stmt.executeQuery(requeteSelectionnee);

            // récupération du résultat de l'ordre
            rsetMeta = rset.getMetaData();

            // calcul du nombre de colonnes du resultat
            nbColonne = rsetMeta.getColumnCount();
        
            //System.out.println(nbColonne);
        
            if(nbColonne == 2)
            {
                rset.next();
        
               int idCours =  rset.getInt(1);
               String NomCours = rset.getString(2);
               
               //System.out.println(idCours);
               //System.out.println(NomCours);
               
               tmp2.setID(idCours);
               tmp2.setNom(NomCours);
               
                user.setCours(tmp2);
            }
             else
            {
                System.out.println("probleme ClassSQLConnexion Cours");
            }
         
        }
        else
        {
            System.out.println("probleme ClassSQLConnexion Seance");
        }
}

}


