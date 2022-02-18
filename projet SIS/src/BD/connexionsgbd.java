package BD;

// attention, il faut ajouter ojdbc6.jar dans les librairies du projet pour que cela fonctionne
// si on n'est pas sur le domaine uga, il faut se connecter en VPN UGA pour que cela fonctionne
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import nf.DMR;
import nf.Genre;
import nf.Personnel;
import nf.TypeExamen;

class Connexionsgbd {

    private static final String configurationFile
            = "BD.properties.txt";

    public static void main(String args[]) {
        try {   
            /*String jdbcDriver, dbUrl, username, password;
            DatabaseAccessProperties dap = new DatabaseAccessProperties(configurationFile);
            jdbcDriver = dap.getJdbcDriver();
            dbUrl = dap.getDatabaseUrl();
            username = dap.getUsername();
            password = dap.getPassword();
// Load the database driver 
            Class.forName(jdbcDriver);
// Get a connection to the database
            Connection conn = DriverManager.getConnection(dbUrl, username, password);*/
            Connection conn = requetesbd.connexionBD();
            System.out.println(requetesbd.connexion(conn, "1234567891", "'bow12'"));
            conn = requetesbd.connexionBD();
            System.out.println(requetesbd.connexion(conn, "1234567891", "'bow1'"));
            conn = requetesbd.connexionBD();
            Personnel p = requetesbd.utilisateur(conn, 1234567890);

            System.out.println(p + " type" + p.getClass());
            conn = requetesbd.connexionBD();
            p = requetesbd.utilisateur(conn, 1234567891);
            System.out.println(p + " type" + p.getClass());
            conn = requetesbd.connexionBD();
            p = requetesbd.utilisateur(conn, 1234567892);
            System.out.println(p + " type" + p.getClass());
            conn = requetesbd.connexionBD();
            p = requetesbd.utilisateur(conn, 1234567893);
            System.out.println(p + " type" + p.getClass());
            conn = requetesbd.connexionBD();
            p = requetesbd.utilisateur(conn, 1234567894);
            System.out.println(p + " type" + p.getClass());
            conn = requetesbd.connexionBD();
            int id = requetesbd.nouveauIdDMR(conn);
            System.out.println(id);
            int i = 2;
            String s = "";

            //DateFormatSymbols dfsEN = new DateFormatSymbols(Locale.ENGLISH);
            //java.util.Date myDate = new java.util.Date("10-OCT-2009");
            //java.sql.Date d = new java.sql.Date(myDate.getTime());
            String d = "06-06-2006"; 

            conn = requetesbd.connexionBD();

            DMR dmr0 = requetesbd.creationDMR(conn, "Doe", "John", d, "2", "masculin", s, s, s);
            System.out.println(dmr0);
            conn = requetesbd.connexionBD();
            DMR dmr1 = requetesbd.recupDMR(conn, "5");
            System.out.println(dmr1.toString());

            conn = requetesbd.connexionBD();
            if (requetesbd.dmrExisteBis(conn, "Doe", "John", d)) {
                conn = requetesbd.connexionBD();
                ArrayList<DMR> listedmr = requetesbd.recupDMRBis(conn, "Doe", "John", d);
                System.out.println(listedmr.toString()); 
            } 
            conn = requetesbd.connexionBD();

            requetesbd.creationExamen(conn, dmr1, 1234567890, TypeExamen.IRM, 1);
            
            conn = requetesbd.connexionBD();
            requetesbd.creationCR(conn, dmr1.getExamens().get(1), "18-02-2022", "test2");
            System.out.println(dmr1.getExamens());
 
            // requetesbd.employes(conn);
// Print information about connection warnings
            //SQLWarningsExceptions.printWarnings(conn);
            //conn.close();
        } catch (SQLException se) {
// Print information about SQL exceptions
            SQLWarningsExceptions.printExceptions(se);
            return;
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
            return;
        }
    }
}
