package BD;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chloé
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * The BenchmarkProperties class describes the properties of the benchmark to
 * run.
 */
public class DatabaseAccessProperties {

    private Properties prop = new Properties();
    private String jdbcDriver;
    private String dbUrl;
    private String username, password;

    /**
     * Récupération des inofrmations de connexion à la base de données en trouvant le dossier de connexion
     * @param propertiesFile
     */
    public DatabaseAccessProperties(String propertiesFile) {
        try {
            prop = new Properties();
            prop.load(new FileInputStream(propertiesFile));
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException: "
                    + e.getMessage());
            e.printStackTrace();
            return;
        } catch (IOException e) {
            System.err.println("IOException: "
                    + e.getMessage());
            e.printStackTrace();
            return;
        }
        jdbcDriver = prop.getProperty("jdbc.driver");
        dbUrl = prop.getProperty("database.url");
        username = prop.getProperty("database.username");
        password = prop.getProperty("database.password");
    }

    /**
     * Renvoie le Driver
     * @return string
     */
    public String getJdbcDriver() {
        return jdbcDriver;
    }

    /**
     * Renvoie la DAtabaseUrl
     * @return String
     */
    public String getDatabaseUrl() {
        return dbUrl;
    }

    /**
     * Renvoie le nom d'utilisateur
     * @return String
     */
    public String getUsername() {
        return username;
    }

    /**
     * Renvoie le mot de passe Password
     * @return String
     */
    public String getPassword() {
        return password;
    }
}
