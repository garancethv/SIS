package BD;

// attention, il faut ajouter ojdbc6.jar dans les librairies du projet pour que cela fonctionne
// si on n'est pas sur le domaine uga, il faut se connecter en VPN UGA pour que cela fonctionne
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import nf.DMR;
import nf.Personnel;

class Connexionsgbd {

    private static final String configurationFile
            = "BD.properties.txt";

    public static void main(String args[]) {
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
            System.out.println(requetesbd.connexion(conn, 1234567891, "'bow12'"));
            System.out.println(requetesbd.connexion(conn, 1234567891, "'bow1'"));
            Personnel p = requetesbd.utilisateur(conn, 1234567890);
            System.out.println(p + " type" + p.getClass());
            p = requetesbd.utilisateur(conn, 1234567891);
            System.out.println(p + " type" + p.getClass());
            p = requetesbd.utilisateur(conn, 1234567892);
            System.out.println(p + " type" + p.getClass());
            p = requetesbd.utilisateur(conn, 1234567893);
            System.out.println(p + " type" + p.getClass());
            p = requetesbd.utilisateur(conn, 1234567894);
            System.out.println(p + " type" + p.getClass());
            int id=requetesbd.nouveauIdDMR(conn);
            System.out.println(id);
            int i = 0 ;
            String s="";
            java.sql.Date d= new java.sql.Date(06,11,1978);
            
            int de=requetesbd.creationDMR(conn, "Doe", "John", id, d, i, "autre", s, s, s);
            
            // requetesbd.employes(conn);
// Print information about connection warnings
            SQLWarningsExceptions.printWarnings(conn);
            conn.close();
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
