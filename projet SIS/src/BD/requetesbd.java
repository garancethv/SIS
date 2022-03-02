package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import nf.DMR;
import nf.Examen;
import nf.Genre;
import nf.Interne;
import nf.Manip;
import nf.PH;
import nf.Personnel;
import nf.Secretaire;
import nf.TypeExamen;

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
    
    private static final String configurationFile
            = "BD.properties.txt";

    /**
     * Afficher toutes les informations sur tous les spectacles.
     *
     * @param conn connexion � la base de donn�es
     * @throws SQLException en cas d'erreur d'acc�s � la base de donn�es
     */
    public static Connection connexionBD() throws SQLException, ClassNotFoundException {
        /* connexion à la BD*/
        try {
            String jdbcDriver, dbUrl, username, password;
            DatabaseAccessProperties dap = new DatabaseAccessProperties(configurationFile);
            jdbcDriver = dap.getJdbcDriver();
            dbUrl = dap.getDatabaseUrl();
            username = dap.getUsername();
            password = dap.getPassword();
// Load the database driver
            Class.forName(jdbcDriver);
// Get a connection to the database
            Connection conn = DriverManager.getConnection(dbUrl, username, password);
            // Print information about connection warnings
            SQLWarningsExceptions.printWarnings(conn);
            return conn;
        } finally {
            
        }
    }
    
    public static void deconnexionBD(Connection conn) throws SQLException {
        /*déconnexion de la BD*/
        conn.close();
    }
    
    public static boolean connexion(Connection conn, String idPerso, String mdp) throws SQLException {
        /*vérifie que le personnel existe dans la base de données*/
        try {

// Get a statement from the connection
            Statement stmt = conn.createStatement();
// Execute the query
            ResultSet rs = stmt.executeQuery("select nom from Personnel where idPerso ='" + idPerso + "' and mdp ='" + mdp + "'");
            boolean a = rs.next();

// Close the result set, statement and the connection 
            rs.close();
            stmt.close();
            SQLWarningsExceptions.printWarnings(conn);
            return a;
        } finally {
            //close connection
            if (conn != null) {
                conn.close();
            }
        }
    }

    public static boolean PhExiste(Connection conn, String idPerso) throws SQLException {
        /*vérifie que le personnel existe dans la base de données*/
        try {

// Get a statement from the connection
            Statement stmt = conn.createStatement();
// Execute the query
            ResultSet rs = stmt.executeQuery("select nom from Personnel where idPerso ='" + idPerso +"'");
            boolean a = rs.next();

// Close the result set, statement and the connection 
            rs.close();
            stmt.close();
            SQLWarningsExceptions.printWarnings(conn);
            return a;
        } finally {
            //close connection
            if (conn != null) {
                conn.close();
            }
        }
    }


    public static Personnel utilisateur(Connection conn, int idPerso) throws SQLException {
        /*renvoie le personnel qui est censé être connecté*/
        try {
// Get a statement from the connection
            Statement stmt = conn.createStatement();
// Execute the query
            ResultSet rs = stmt.executeQuery("select TRIM(nom) nom, TRIM(prenom) prenom, idPerso, TRIM(mdp) mdp, TRIM(statut) statut, isChef from Personnel where idPerso =" + idPerso);
            rs.next();
            Personnel p;
            String s = rs.getString("statut");
            
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
            SQLWarningsExceptions.printWarnings(conn);
            return p;
        } finally {
            //close connection
            if (conn != null) {
                conn.close();
            }
        }
    }
    
    public static DMR recupDMR(Connection conn, String idDMR) throws SQLException {
        /*renvoie le DMR recherché*/
        try {
// Get a statement from the connection
            Statement stmt = conn.createStatement();
// Execute the query
            ResultSet rs = stmt.executeQuery("select TRIM(nom) nom, TRIM(prenom) prenom, idDMR, dateNaissance, tel, TRIM(genre) genre, TRIM(adresse) adresse,TRIM(codePostal) codePostal,TRIM(ville) ville from DMR where idDMR =" + idDMR);
            rs.next();
            DMR dmr;
            String g = rs.getString("genre");
            Genre genre;
            if (g.equals("masculin")) {
                genre = Genre.H;
            } else if (g.equals("feminin")) {
                genre = Genre.F;
            } else {
                genre = Genre.Autre;
            }
            
            dmr = new DMR(rs.getString("nom"), rs.getString("prenom"), ((Date) rs.getDate("dateNaissance")), rs.getInt("tel"), genre, rs.getInt("idDMR"), rs.getString("adresse"), rs.getString("codePostal"), rs.getString("ville"));

// Close the result set, statement and the connection 
            rs.close();
            ResultSet rs1 = stmt.executeQuery("select TRIM(nom) nom, TRIM(prenom) prenom, idDMR, dateNaissance, tel, TRIM(genre) genre, TRIM(adresse) adresse,TRIM(codePostal) codePostal,TRIM(ville) ville from DMR where idDMR =" + idDMR);
            rs1.next();
            recupExamen(conn, dmr);
            rs1.close();
            stmt.close();
            SQLWarningsExceptions.printWarnings(conn);
            
            return dmr;
        } finally {
            //close connection
            if (conn != null) {
                conn.close();
            }
        }
    }
    
    public static DMR recupExamen(Connection conn, DMR dmr) throws SQLException {
        /*renvoie le DMR recherché
        NE PAS UTILISER EN DEHORS DE REQUETESBD (car ne ferme pas la connexion à la BD*/
        try {
// Get a statement from the connection
            Statement stmt = conn.createStatement();
// Execute the query
            System.out.println("b");
            ResultSet rs = stmt.executeQuery("select dateExamen, texteCR, idPH, idPACS, lower(typeExamen) typeExamen, archivagePapier from Examen where idDMR =" + dmr.getId());
            ArrayList<Examen> liste = new ArrayList<>();
            while (rs.next()) {
                String s = rs.getString("typeExamen");
                TypeExamen typeExam;
                if (s.equals("irm")) {
                    typeExam = TypeExamen.IRM;
                } else if (s.equals("scanner")) {
                    typeExam = TypeExamen.SCANNER;
                } else {
                    typeExam = TypeExamen.RADIOGRAPHIE;
                }
                liste.add(new Examen(dmr.getId(), (Date) rs.getDate("dateExamen"), rs.getInt("idPH"), typeExam, rs.getInt("idPACS"), rs.getString("texteCR")));
                
            }
            dmr.setExamens(liste);

// Close the result set, statement and the connection 
            rs.close();
            stmt.close();
            SQLWarningsExceptions.printWarnings(conn);
            
            return dmr;
        } finally {
            
        }
    }
    
    public static DMR creationExamen(Connection conn, DMR dmr, int idPH, TypeExamen typeExam, int archivagePapier) throws SQLException {
        /*renvoie le DMR recherché
        NE PAS UTILISER EN DEHORS DE REQUETESBD (car ne ferme pas la connexion à la BD*/
        try {
// Get a statement from the connection
            Statement stmt = conn.createStatement();
// Execute the query
            System.out.println("a");
            int rowCount = stmt.executeUpdate("INSERT INTO Examen(idDMR, dateExamen, idPH, typeExamen, archivagePapier) VALUES ('"
                    + dmr.getId()
                    + "', sysdate ,'"
                    + idPH + "',lower('"
                    + typeExam.toString() + "'),'"
                    + archivagePapier + "')");
            
            recupExamen(conn, dmr);

// Close the result set, statement and the connection 
            stmt.close();
            SQLWarningsExceptions.printWarnings(conn);
            
            return dmr;
        } finally {
            //close connection
            if (conn != null) {
                conn.close();
            }
        }
    }

    public static void creationCR(Connection conn, Examen examen, String date, String texteCR) throws SQLException {
     
        try {
// Get a statement from the connection
            Statement stmt = conn.createStatement();
            System.out.println("1");
// Execute the query


            int rowCount = stmt.executeUpdate("UPDATE Examen SET texteCR ='"
                    + texteCR + "' where idDMR ='" + examen.getIdDMR() + "' and dateExamen ='" + date + "'");


            examen.setTexteCR(texteCR);
            System.out.println("3");
// Close the result set, statement and the connection 
            stmt.close();
            System.out.println("4");
            SQLWarningsExceptions.printWarnings(conn);
            
        } finally {
            //close connection
            if (conn != null) {
                conn.close();
            }
        }
    }
    
    public static void numerisationImage(Connection conn, Examen examen) throws SQLException {
        /*renvoie le DMR recherché
        NE PAS UTILISER EN DEHORS DE REQUETESBD (car ne ferme pas la connexion à la BD*/
        try {
// Get a statement from the connection
            Statement stmt = conn.createStatement();
// Execute the query
            int rowCount = stmt.executeUpdate("INSERT INTO Examen SET texteCR ='"
                    + "' where idDMR ='" + examen.getIdDMR() + "' and idExamen ='" + examen.getDate().toString() + "'");

// Close the result set, statement and the connection 
            stmt.close();
            SQLWarningsExceptions.printWarnings(conn);
            
        } finally {
            //close connection
            if (conn != null) {
                conn.close();
            }
        }
    }


    public static ArrayList<DMR> recupDMRBis(Connection conn, String nom, String prenom, String dateNaissance) throws SQLException {

        /*renvoie le DMR recherché*/
        ArrayList<DMR> listeDMR = new ArrayList<>();
        try {
// Get a statement from the connection
            Statement stmt = conn.createStatement();
// Execute the query
            ResultSet rs = stmt.executeQuery("select TRIM(nom) nom, TRIM(prenom) prenom, idDMR, dateNaissance, tel, TRIM(genre) genre, TRIM(adresse) adresse,TRIM(codePostal) codePostal,TRIM(ville) ville from DMR where lower(nom)='" + nom.toLowerCase() + "' and lower(prenom)='" + prenom.toLowerCase() + "'and dateNaissance='" + dateNaissance + "'");

            while (rs.next()) {
                DMR dmr;
                String g = rs.getString("genre");
                Genre genre;
                if (g.equals("masculin")) {
                    genre = Genre.H;
                } else if (g.equals("feminin")) {
                    genre = Genre.F;
                } else {
                    genre = Genre.Autre;
                }


                dmr = new DMR(rs.getString("nom"), rs.getString("prenom"), ((Date) rs.getDate("dateNaissance")), rs.getInt("tel"), genre, rs.getInt("idDMR"), rs.getString("adresse"), rs.getString("codePostal"), rs.getString("ville"));
                listeDMR.add(dmr);
            }
// Close the result set, statement and the connection 
            rs.close();
            stmt.close();
            SQLWarningsExceptions.printWarnings(conn);
            return listeDMR;
        } finally {
            //close connection
            if (conn != null) {
                conn.close();
            }
        }
    }
    
    public static boolean dmrExiste(Connection conn, int idDMR) throws SQLException {
        /*renvoie un nouveau  idDMR = max(idDMR)+1*/
        try {
// Get a statement from the connection
            Statement stmt = conn.createStatement();
// Execute the query
            ResultSet rs = stmt.executeQuery("select idDMR from DMR where idDMR=" + idDMR);
            boolean a = rs.next();

// Close the result set, statement and the connection 
            rs.close();
            stmt.close();
            SQLWarningsExceptions.printWarnings(conn);
            return a;
        } finally {
            //close connection
            if (conn != null) {
                conn.close();
            }
        }
    }
    
    public static boolean dmrExisteBis(Connection conn, String nom, String prenom, String dateNaissance) throws SQLException {
        /*renvoie un nouveau  idDMR = max(idDMR)+1*/
        try {
// Get a statement from the connection
            Statement stmt = conn.createStatement();
// Execute the query
            ResultSet rs = stmt.executeQuery("select idDMR from DMR where lower(nom)='" + nom.toLowerCase() + "'and lower(prenom)='" + prenom.toLowerCase() + "' and dateNaissance ='" + dateNaissance + "'");
            boolean a = rs.next();

// Close the result set, statement and the connection 
            rs.close();
            stmt.close();
            SQLWarningsExceptions.printWarnings(conn);
            return a;
        } finally {
            //close connection
            if (conn != null) {
                conn.close();
            }
        }
    }
    
    public static int nouveauIdDMR(Connection conn) throws SQLException {
        /*renvoie un nouveau  idDMR = max(idDMR)+1
        NE PAS UTILISER EN DEHORS DE REQUETESBD (car ne ferme pas la connexion à la BD*/
        try {
// Get a statement from the connection
            Statement stmt = conn.createStatement();
// Execute the query
            ResultSet rs = stmt.executeQuery("select max(idDMR) id from DMR ");
            boolean a = rs.next();
            int idDMR = rs.getInt("id") + 1;

// Close the result set, statement and the connection 
            rs.close();
            stmt.close();
            SQLWarningsExceptions.printWarnings(conn);
            return idDMR;
        } finally {
            
        }
    }
    
    public static DMR creationDMR(Connection conn, String nom, String prenom, String dateNaissance, String tel, String genre, String adresse, String codePostal, String ville) throws SQLException {
        /*création dans la base de données d’un nouveau DMR => renvoie idDMR*/
        try {
// Get a statement from the connection
            Statement stmt = conn.createStatement();

// Execute the query
            int idDMR = nouveauIdDMR(conn);
            
            int rowCount = stmt.executeUpdate("INSERT INTO DMR(nom,prenom,idDMR,dateNaissance,tel,genre,Adresse,CodePostal,Ville) VALUES ('"
                    + nom + "','"
                    + prenom
                    + "','" + idDMR + "','"
                    + dateNaissance + "','"
                    + tel + "','"
                    + genre
                    + "','" + adresse + "','"
                    + codePostal + "','"
                    + ville + "')");

// Close the statement and the connection
            DMR dmr = recupDMR(conn, String.valueOf(idDMR));
            stmt.close();
            SQLWarningsExceptions.printWarnings(conn);
            return dmr;
        } finally {
            //close connection
            if (conn != null) {
                conn.close();
            }
        }
    }
}
