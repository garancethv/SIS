package BD;

// attention, il faut ajouter ojdbc6.jar dans les librairies du projet pour que cela fonctionne
// si on n'est pas sur le domaine uga, il faut se connecter en VPN UGA pour que cela fonctionne
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormatSymbols;
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

            DMR dmr= requetesbd.creationDMR(conn, "Doe", "John", d, i, "masculin", s, s, s);
            System.out.println(dmr);
            conn = requetesbd.connexionBD();
            if (requetesbd.dmrExiste(conn, 1)) {
                conn = requetesbd.connexionBD();
                dmr = requetesbd.recupDMR(conn, 1);

                System.out.println(dmr.toString());
            }
            conn = requetesbd.connexionBD();
            if (requetesbd.dmrExisteBis(conn, "Doe" ,"John",d)) {
                conn = requetesbd.connexionBD();
                dmr = requetesbd.recupDMRBis(conn, "Doe","John",d);
                System.out.println(dmr.toString());
            }
            conn = requetesbd.connexionBD();
            dmr = requetesbd.creationExamen(conn, dmr, id, TypeExamen.IRM, 1);
            System.out.println(dmr);
            


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
