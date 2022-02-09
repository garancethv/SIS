package BD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import nf.DMR;
import nf.Interne;
import nf.Manip;
import nf.PH;
import nf.Personnel;
import nf.Secretaire;

/*
* To change this license header, choose License Headers in
Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
/**
 *
 * @author catherineberrut
 */
public class requetesbd {

    /**
     * Afficher toutes les informations sur tous les spectacles.
     *
     * @param conn connexion � la base de donn�es
     * @throws SQLException en cas d'erreur d'acc�s � la base de donn�es
     */
    public static boolean connexion(Connection conn, int idPerso, String mdp) throws SQLException {
        /*vérifie que le personnel existe dans la base de données*/
// Get a statement from the connection
        Statement stmt = conn.createStatement();
// Execute the query
        ResultSet rs = stmt.executeQuery("select nom from Personnel where idPerso =" + idPerso + " and mdp =" + mdp);
        boolean a = rs.next();

// Close the result set, statement and the connection 
        rs.close();
        stmt.close();
        return a;
    }

    public static Personnel utilisateur(Connection conn, int idPerso) throws SQLException {
        /*renvoie le personnel qui est censé être connecté*/
// Get a statement from the connection
        Statement stmt = conn.createStatement();
// Execute the query
        ResultSet rs = stmt.executeQuery("select TRIM(nom) nom, TRIM(prenom) prenom, idPerso, TRIM(mdp) mdp, TRIM(statut) statut, isChef from Personnel where idPerso =" + idPerso);
        rs.next();
        Personnel p;
        String s=rs.getString("statut");

        if (s.equals("secretaire")) {
            p = new Secretaire(rs.getString("nom"), rs.getString("prenom"), rs.getInt("idPerso"), rs.getString("mdp"));
        } else if (s.equals("ph")) {
            p = new PH(rs.getString("nom"), rs.getString("prenom"), rs.getInt("idPerso"), rs.getString("mdp"), rs.getInt("isChef"));
        } else if (s.equals("manipulateur")) {
            p = new Manip(rs.getString("nom"), rs.getString("prenom"), rs.getInt("idPerso"), rs.getString("mdp"));
        } else {
            p = new Interne(rs.getString("nom"), rs.getString("prenom"), rs.getInt("idPerso"), rs.getString("mdp"));
        }

// Close the result set, statement and the connection 
        rs.close();
        stmt.close();
        return p;
    }
    
    public static DMR recupDMR(Connection conn, int idDMR) throws SQLException {
        /*renvoie le DMR recherché*/
// Get a statement from the connection
        Statement stmt = conn.createStatement();
// Execute the query
        /*ResultSet rs = stmt.executeQuery("select TRIM(nom) nom, TRIM(prenom) prenom, idDMR, TRIM(mdp) mdp, TRIM(statut) statut, isChef from Personnel where idPerso =" + idPerso);
        rs.next();
        Personnel p;
        String s=rs.getString("statut");

        if (s.equals("secretaire")) {
            p = new Secretaire(rs.getString("nom"), rs.getString("prenom"), rs.getInt("idPerso"), rs.getString("mdp"));
        } else if (s.equals("ph")) {
            p = new PH(rs.getString("nom"), rs.getString("prenom"), rs.getInt("idPerso"), rs.getString("mdp"), rs.getInt("isChef"));
        } else if (s.equals("manipulateur")) {
            p = new Manip(rs.getString("nom"), rs.getString("prenom"), rs.getInt("idPerso"), rs.getString("mdp"));
        } else {
            p = new Interne(rs.getString("nom"), rs.getString("prenom"), rs.getInt("idPerso"), rs.getString("mdp"));
        }

// Close the result set, statement and the connection 
        rs.close();
        stmt.close();
        return p;*/
        DMR d=null;
        return d;
    }

    public static int nouveauIdDMR(Connection conn) throws SQLException {
        /*renvoie un nouveau  idDMR = max(idDMR)+1*/
// Get a statement from the connection
        Statement stmt = conn.createStatement();
// Execute the query
        ResultSet rs = stmt.executeQuery("select max(idDMR) id from DMR ");
        boolean a = rs.next();
        int idDMR = rs.getInt("id") + 1;

// Close the result set, statement and the connection 
        rs.close();
        stmt.close();
        return idDMR;
    }

    public static int creationDMR(Connection conn, String nom, String prenom, int idDMR, java.sql.Date dateNaissance, int tel, String genre, String adresse, String codePostal, String ville) throws SQLException {
        /*création dans la base de données d’un nouveau DMR => renvoie 1 si la création a bien été réalisée*/
// Get a statement from the connection
        Statement stmt = conn.createStatement();
// Execute the query
        int rowCount = stmt.executeUpdate("INSERT INTO DMR(nom, prenom, idDMR,dateNaissance,tel,genre,Adresse,CodePostal,Ville) VALUES (nom,prenom,idDMR,dateNaissance,tel,genre,adresse,codePostal,ville)");

// Close the statement and the connection
        stmt.close();
        return rowCount;
    }
}
