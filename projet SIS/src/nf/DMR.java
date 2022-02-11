

package nf;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Mathilde
 */
public class DMR {
    private String nomPatient;
    private String prenomPatient;
    private Date dateNaissance;
    private Genre genre;
    private int id;
    private ArrayList<Examen> examens;

    public DMR(String nomPatient, String prenomPatient, Date dateNaissance, Genre genre, int idDMR) {
        this.nomPatient = nomPatient;
        this.prenomPatient = prenomPatient;
        this.dateNaissance = dateNaissance; //il existe plusieurs constructeurs dans la classe Date de Java. Pour une date de naissance, on rentre Date("année", "mois", "jour")
        this.genre = genre;
        this.id = id;
        examens = new ArrayList<Examen>();
    }   

    public String getNomPatient() {
        return nomPatient;
    }

    public String getPrenomPatient() {
        return prenomPatient;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Examen> getExamens() {
        return examens;
    }
    
    public void ajouterExamen(Date date, PH phResp){//ajoute un nouvel examen dans le DMR courant
        Examen examen = new Examen(this.getId(), date, phResp);   
        examens.add(examen);
    }
}
