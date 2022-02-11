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
    private int tel;
    private String adresse;
    private String codePostal;
    private String ville;

    private ArrayList<Examen> examens;

    public DMR(String nomPatient, String prenomPatient, Date dateNaissance, Genre genre, int id) {
        this.nomPatient = nomPatient;
        this.prenomPatient = prenomPatient;
        this.dateNaissance = dateNaissance; //il existe plusieurs constructeurs dans la classe Date de Java. Pour une date de naissance, on rentre Date("année", "mois", "jour")
        this.genre = genre;
        this.id = id;
        examens = new ArrayList<Examen>();
    }

    public DMR(String nomPatient, String prenomPatient, Date dateNaissance, int tel, Genre genre, int id, String adresse, String codePostal, String ville) {
        this.nomPatient = nomPatient;
        this.prenomPatient = prenomPatient;
        this.dateNaissance = dateNaissance; //il existe plusieurs constructeurs dans la classe Date de Java. Pour une date de naissance, on rentre Date("année", "mois", "jour")
        this.genre = genre;
        this.id = id;
        this.adresse = adresse;
        this.tel = tel;
        this.codePostal = codePostal;
        this.ville = ville;
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

    public void ajouterExamen(Examen examen) {
        examens.add(examen);
    }
}
