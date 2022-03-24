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

    public int getTel() {
        return tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public String getVille() {
        return ville;
    }

    public ArrayList<Examen> getExamens() {
        return examens;
    }

    public void ajouterExamen( Date date, int idPhRespo, TypeExamen typeExamen, int numPACS, String texteCR){//ajoute un nouvel examen dans le DMR courant
        Examen examen = new Examen(id,date, idPhRespo,typeExamen,numPACS, texteCR);   
        examens.add(examen);
    }
    
    public void ajouterExamen(Examen examen) {
        examens.add(examen);
    }
    
    public void setExamens(ArrayList<Examen> examens) {
        this.examens=examens;
    }

    
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
        return id+" - "+prenomPatient+" "+ nomPatient +" ("+DMR.format_date(dateNaissance)+")";
    }
    
}
