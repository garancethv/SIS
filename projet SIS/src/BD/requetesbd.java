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
     * Ouvre une connexion à la BD
     *
     * @return la connexion Connection
     * @throws SQLException en cas d'erreur d'acc�s � la base de donn�es
     * @throws java.lang.ClassNotFoundException
     */
    public static Connection connexionBD() throws SQLException, ClassNotFoundException {
        
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



    
    /**
     *Ferme la connexion
     * @param conn
     * @throws SQLException
     */

    public static void deconnexionBD(Connection conn) throws SQLException {
        /*déconnexion de la BD*/
        conn.close();
    }

    /**
     * Vérifie si l'identifiant et le mot de passe entrés sont valides pour ouvrir une session
     * @param conn
     * @param idPerso identifiant du personnel
     * @param mdp mot de passe du personnel
     * @return boolean
     * @throws SQLException
     */

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

    /**
     * Vérifie que le personnel existe dans la base de données
     * @param conn
     * @param idPerso
     * @return boolean
     * @throws SQLException
     */
    public static boolean PhExiste(Connection conn, String idPerso) throws SQLException {
  
        try {

// Get a statement from the connection
            Statement stmt = conn.createStatement();
// Execute the query
            ResultSet rs = stmt.executeQuery("select nom from Personnel where idPerso ='" + idPerso + "'");
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



    /**
     * Renvoie le personnel qui est censé être connecté
     * @param conn
     * @param idPerso
     * @return Personnel
     * @throws SQLException
     */
    
      public static DMR triExamenSelonDateAsc(Connection conn, DMR dmr) throws SQLException {
        /*renvoie l'examen recherché
        NE PAS UTILISER EN DEHORS DE REQUETESBD (car ne ferme pas la connexion à la BD*/
        try {
// Get a statement from the connection
            Statement stmt = conn.createStatement();
// Execute the query
            ResultSet rs = stmt.executeQuery("select dateExamen, texteCR, idPH, idPACS, lower(typeExamen) typeExamen, archivagePapier from Examen where idDMR = '" + dmr.getId() + "' ORDER BY dateExamen");
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
                liste.add(new Examen(dmr.getId(), (Date) rs.getTimestamp("dateExamen"), rs.getInt("idPH"), typeExam, rs.getInt("idPACS"), rs.getString("texteCR")));

            }
            dmr.setExamens(liste);
// Close the result set, statement and the connection 
            rs.close();
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
    
    public static DMR triExamenSelonDateDesc(Connection conn, DMR dmr) throws SQLException {
        /*renvoie l'examen recherché
        NE PAS UTILISER EN DEHORS DE REQUETESBD (car ne ferme pas la connexion à la BD*/
        try {
// Get a statement from the connection
            Statement stmt = conn.createStatement();
// Execute the query
            ResultSet rs = stmt.executeQuery("select dateExamen, texteCR, idPH, idPACS, lower(typeExamen) typeExamen, archivagePapier from Examen where idDMR = '" + dmr.getId() + "' ORDER BY dateExamen desc");
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
                liste.add(new Examen(dmr.getId(), (Date) rs.getTimestamp("dateExamen"), rs.getInt("idPH"), typeExam, rs.getInt("idPACS"), rs.getString("texteCR")));

            }
            dmr.setExamens(liste);
// Close the result set, statement and the connection 
            rs.close();
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
    

    public static DMR triExamenSelonPH(Connection conn, DMR dmr) throws SQLException {
        /*renvoie l'examen recherché
        NE PAS UTILISER EN DEHORS DE REQUETESBD (car ne ferme pas la connexion à la BD*/
        try {
// Get a statement from the connection
            Statement stmt = conn.createStatement();
            
// Execute the query
            ResultSet rs = stmt.executeQuery("select dateExamen, texteCR, idPH, idPACS, lower(typeExamen) typeExamen, archivagePapier from Examen JOIN Personnel ON (idPH=idPerso) where idDMR = '" + dmr.getId() + "' ORDER BY nom");
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
                liste.add(new Examen(dmr.getId(), (Date) rs.getTimestamp("dateExamen"), rs.getInt("idPH"), typeExam, rs.getInt("idPACS"), rs.getString("texteCR")));

            }
            dmr.setExamens(liste);
// Close the result set, statement and the connection 
            rs.close();
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
    
    public static DMR triExamenSelonTypeExam(Connection conn, DMR dmr, String typeExamen) throws SQLException {
        /*renvoie l'examen recherché
        NE PAS UTILISER EN DEHORS DE REQUETESBD (car ne ferme pas la connexion à la BD*/
        try {
// Get a statement from the connection
            Statement stmt = conn.createStatement();
            
// Execute the query
            ResultSet rs = stmt.executeQuery("select dateExamen, texteCR, idPH, idPACS, lower(typeExamen) typeExamen, archivagePapier from Examen where idDMR = '" + dmr.getId() + "' AND lower(typeExamen) = '" + typeExamen.toLowerCase() + "' ORDER BY dateExamen desc");
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
                liste.add(new Examen(dmr.getId(), (Date) rs.getTimestamp("dateExamen"), rs.getInt("idPH"), typeExam, rs.getInt("idPACS"), rs.getString("texteCR")));

            }
            dmr.setExamens(liste);
// Close the result set, statement and the connection 
            rs.close();
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

    public static Personnel utilisateur(Connection conn, int idPerso) throws SQLException {
       
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

 
    /**
     * Renvoie le DMR recherché par son identifiant
     * @param conn
     * @param idDMR
     * @return DMR
     * @throws SQLException
     */

    public static DMR recupDMR(Connection conn, String idDMR) throws SQLException {
       
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

            recupExamen(conn, dmr);

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

    
    /**
     * Charge les examens d'un DMR
     * NE PAS UTILISER EN DEHORS DE REQUETESBD (car ne ferme pas la connexion à la BD)
     * @param conn
     * @param dmr
     * @return
     * @throws SQLException
     */
    private static DMR recupExamen(Connection conn, DMR dmr) throws SQLException {
        

        try {
// Get a statement from the connection
            Statement stmt = conn.createStatement();
// Execute the query

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
                liste.add(new Examen(dmr.getId(), (Date) rs.getTimestamp("dateExamen"), rs.getInt("idPH"), typeExam, rs.getInt("idPACS"), rs.getString("texteCR")));

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

    public static DMR triExamenSelonDate(Connection conn, DMR dmr) throws SQLException {
        /*renvoie l'examen recherché
        NE PAS UTILISER EN DEHORS DE REQUETESBD (car ne ferme pas la connexion à la BD*/
        try {
// Get a statement from the connection
            Statement stmt = conn.createStatement();
// Execute the query
            ResultSet rs = stmt.executeQuery("select dateExamen, texteCR, idPH, idPACS, lower(typeExamen) typeExamen, archivagePapier from Examen where idDMR = '" + dmr.getId() + "' ORDER BY dateExamen");
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
                liste.add(new Examen(dmr.getId(), (Date) rs.getTimestamp("dateExamen"), rs.getInt("idPH"), typeExam, rs.getInt("idPACS"), rs.getString("texteCR")));

            }
            dmr.setExamens(liste);
// Close the result set, statement and the connection 
            rs.close();
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

    
    /**
     * Création d'un examen et chargement des examens du DMR
     * @param conn
     * @param dmr
     * @param idPH
     * @param typeExam
     * @param archivagePapier
     * @param texteCR
     * @return DMR
     * @throws SQLException
     */

    public static DMR creationExamen(Connection conn, DMR dmr, int idPH, TypeExamen typeExam, int archivagePapier, String texteCR) throws SQLException {
        try {
// Get a statement from the connection
            Statement stmt = conn.createStatement();
// Execute the query
            System.out.println("a");
            int rowCount = stmt.executeUpdate("INSERT INTO Examen(idDMR, dateExamen, idPH, typeExamen, archivagePapier, texteCR) VALUES ('"
                    + dmr.getId()
                    + "', sysdate ,'"
                    + idPH + "',lower('"
                    + typeExam.toString() + "'),'"
                    + archivagePapier + "', '" + texteCR + "')");

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

    /**
     * Création d'un compte-rendu dans la base de données
     * @param conn
     * @param examen
     * @param date
     * @param texteCR
     * @throws SQLException
     */
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



    
//    /**
//     * 
//     * @param conn
//     * @param examen
//     * @throws SQLException
//     */
//    public static void numerisationImage(Connection conn, Examen examen) throws SQLException {
//        /*renvoie le DMR recherché
//        NE PAS UTILISER EN DEHORS DE REQUETESBD (car ne ferme pas la connexion à la BD*/
//        try {
//// Get a statement from the connection
//            Statement stmt = conn.createStatement();
//// Execute the query
//            int rowCount = stmt.executeUpdate("INSERT INTO Examen SET texteCR ='"
//                    + "' where idDMR ='" + examen.getIdDMR() + "' and idExamen ='" + examen.getDate().toString() + "'");
//
//// Close the result set, statement and the connection 
//            stmt.close();
//            SQLWarningsExceptions.printWarnings(conn);
//            
//        } finally {
//            //close connection
//            if (conn != null) {
//                conn.close();
//            }
//        }
//    }

    /**
     * Récupération de tous les DMR ayant le même nom, prénom et la même date de naissance
     * @param conn
     * @param nom
     * @param prenom
     * @param dateNaissance
     * @return liste de DMR
     * @throws SQLException
     */

    public static ArrayList<DMR> recupDMRBis(Connection conn, String nom, String prenom, String dateNaissance) throws SQLException {

        ArrayList<DMR> listeDMR = new ArrayList<>();
        try {
// Get a statement from the connection
            Statement stmt = conn.createStatement();
// Execute the query
            ResultSet rs = stmt.executeQuery("select TRIM(nom) nom, TRIM(prenom) prenom, idDMR, dateNaissance, tel, TRIM(genre) genre, TRIM(adresse) adresse,TRIM(codePostal) codePostal,TRIM(ville) ville from DMR where nom='" + nom + "' and prenom='" + prenom + "'and dateNaissance='" + dateNaissance + "'");

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
                recupExamen(conn, dmr);
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

    
    /**
     * Récupération de tous les DMR ayant le même nom et prénom lors de la recherche par nom et prénom
     * @param conn
     * @param nom
     * @param prenom
     * @return liste de DMR
     * @throws SQLException
     */

    public static ArrayList<DMR> recupDMRBis(Connection conn, String nom, String prenom) throws SQLException {

        /*renvoie le DMR recherché*/
        ArrayList<DMR> listeDMR = new ArrayList<>();
        try {
// Get a statement from the connection
            Statement stmt = conn.createStatement();
// Execute the query
            ResultSet rs = stmt.executeQuery("select TRIM(nom) nom, TRIM(prenom) prenom, idDMR, dateNaissance, tel, TRIM(genre) genre, TRIM(adresse) adresse,TRIM(codePostal) codePostal,TRIM(ville) ville from DMR where nom='" + nom + "' and prenom='" + prenom + "'");

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
                recupExamen(conn, dmr);
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


    /**
     * Récupération de tous les DMR ayant le même nom lors de la recherche par nom
     * @param conn
     * @param nom
     * @return liste de DMR
     * @throws SQLException
     */

    public static ArrayList<DMR> recupDMRTer(Connection conn, String nom) throws SQLException {

        ArrayList<DMR> listeDMR = new ArrayList<>();
        try {
// Get a statement from the connection
            Statement stmt = conn.createStatement();
// Execute the query
            ResultSet rs = stmt.executeQuery("select TRIM(nom) nom, TRIM(prenom) prenom, idDMR, dateNaissance, tel, TRIM(genre) genre, TRIM(adresse) adresse,TRIM(codePostal) codePostal,TRIM(ville) ville from DMR where nom='" + nom + "'");

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
                recupExamen(conn, dmr);
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

    
    /**
     * Vérifie si le DMR existe
     * @param conn
     * @param idDMR
     * @return boolean
     * @throws SQLException
     */

    public static boolean dmrExiste(Connection conn, int idDMR) throws SQLException {
       
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

    
    /**
     * Vérifie que le DMR ayant ce nom, prenom et cette date de naissance existe
     * @param conn
     * @param nom
     * @param prenom
     * @param dateNaissance
     * @return boolean
     * @throws SQLException
     */

    public static boolean dmrExisteBis(Connection conn, String nom, String prenom, String dateNaissance) throws SQLException {
       
        try {
// Get a statement from the connection
            Statement stmt = conn.createStatement();
// Execute the query
            ResultSet rs = stmt.executeQuery("select idDMR from DMR where nom='" + nom + "'and prenom='" + prenom + "' and dateNaissance ='" + dateNaissance + "'");
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

    
    /**
     * Renvoie un nouvel idDMR
     * NE PAS UTILISER EN DEHORS DE REQUETESBD (car ne ferme pas la connexion à la BD)
     * @param conn
     * @return nouveau  idDMR = max(idDMR)+1
     * @throws SQLException
     */
    private static int nouveauIdDMR(Connection conn) throws SQLException {
        

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

    
    /**
     * création dans la base de données d’un nouveau DMR
     * @param conn
     * @param nom
     * @param prenom
     * @param dateNaissance
     * @param tel
     * @param genre
     * @param adresse
     * @param codePostal
     * @param ville
     * @return DMR
     * @throws SQLException
     */

    public static DMR creationDMR(Connection conn, String nom, String prenom, String dateNaissance, String tel, String genre, String adresse, String codePostal, String ville) throws SQLException {
    
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
