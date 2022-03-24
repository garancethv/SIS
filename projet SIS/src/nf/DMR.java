package nf;

import java.util.ArrayList;
import java.util.Date;

/**
 * Créer une instance de DMR
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

    /**
     * Constructeur de la classe DMR
     * @param nomPatient
     * @param prenomPatient
     * @param dateNaissance
     * @param genre
     * @param id
     */
    public DMR(String nomPatient, String prenomPatient, Date dateNaissance, Genre genre, int id) {
        this.nomPatient = nomPatient;
        this.prenomPatient = prenomPatient;
        this.dateNaissance = dateNaissance; //il existe plusieurs constructeurs dans la classe Date de Java. Pour une date de naissance, on rentre Date("année", "mois", "jour")
        this.genre = genre;
        this.id = id;
        examens = new ArrayList<Examen>();
    }

    /**
     * Constructeur de la classe DMR
     * @param nomPatient
     * @param prenomPatient
     * @param dateNaissance
     * @param tel
     * @param genre
     * @param id
     * @param adresse
     * @param codePostal
     * @param ville
     */
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
    
    /**
     * renvoie une date selon le format jj/mm/aaaa
     * @param date
     * @return
     */
    public static String format_date(Date date) {
        String année="1800";
        if (Integer.valueOf(date.getYear())-100 > 9) {
            année="20"+String.valueOf(date.getYear()-100);
        }
        else if (Integer.valueOf(date.getYear())>100) {
            année="200"+String.valueOf(date.getYear()-100);
        }
        else {
            année="19"+String.valueOf(date.getYear());
        }
        return String.valueOf(date.getDate())+"/"+String.valueOf(date.getMonth()+1)+"/"+année;
    }

    /**
     * Renvoue le nom du patient
     * @return
     */
    public String getNomPatient() {
        return nomPatient;
    }

    /**
     * renvoie le prénom du patient
     * @return
     */
    public String getPrenomPatient() {
        return prenomPatient;
    }

    /**
     *renvoie la date de naissance du patient
     * @return
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }

    /**
     *renvoie le genre du patient
     * @return
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * renvoie l'identifiant DMR du patient
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * renvoie le numéro de téléphone du patient
     * @return
     */
    public int getTel() {
        return tel;
    }

    /**
     * renvoie l'adresse du patient
     * @return
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * renvoie le code postal du patient
     * @return
     */
    public String getCodePostal() {
        return codePostal;
    }

    /**
     * renvoie la ville du patient
     * @return
     */
    public String getVille() {
        return ville;
    }

    /**
     * renvoie la liste d'examens du patient
     * @return
     */
    public ArrayList<Examen> getExamens() {
        return examens;
    }

    /**
     * ajoute un examen à la liste d'examens en le créant
     * @param date
     * @param idPhRespo
     * @param typeExamen
     * @param numPACS
     * @param texteCR
     */
    public void ajouterExamen( Date date, int idPhRespo, TypeExamen typeExamen, int numPACS, String texteCR){//ajoute un nouvel examen dans le DMR courant
        Examen examen = new Examen(id,date, idPhRespo,typeExamen,numPACS, texteCR);   
        examens.add(examen);
    }
    
    /**
     * ajoute un examen passé en paramètre à la liste d'examens 
     * @param examen
     */
    public void ajouterExamen(Examen examen) {
        examens.add(examen);
    }
    
    /**
     * remplace la liste d'examens existante par une nouvelle
     * @param examens
     */
    public void setExamens(ArrayList<Examen> examens) {
        this.examens=examens;
    }

    /**
     * tri des examens par Date
     */
    public void trierExamensParDate(){
        int nb_examens = this.examens.size();
        if (nb_examens > 0){
            ArrayList<Examen> examens_tri = new ArrayList<>();
            for (int i = 0; i < nb_examens; i++){
                int j = 0;
                Examen exam_courant = examens.get(i);
                while (exam_courant.getDate().after(examens_tri.get(j).getDate()) && j < i){//car i = examens_tri.size()
                    j++;
                }
                examens_tri.add(j + 1, exam_courant);
            }
        }
    }
  
    @Override
    public String toString() {
        return prenomPatient+" "+ nomPatient +" ("+DMR.format_date(dateNaissance)+")";
    }
    
}
