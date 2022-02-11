

package nf;

import java.util.Date;

/**
 *
 * @author Mathilde
 */
public class Examen {
    private int idDMR;
    private Date date; //il existe plusieurs constructeurs dans la classe Date de Java. Pour une date d'examen, on rentre Date("année", "mois", "jour", "heure", "minute")
    private PH phRespo;
    private TypeExamen typeExamen;
    private String numPACS; //numPACS est null quand les images sont format papier, c'est pourquoi j'ai du mettre un type String et pas int!!!!!!!
    private String texteCR; //texteCR est null quand le CR est format papier

    public Examen(int idDMR, Date date, PH phRespo, TypeExamen type) {
        this.idDMR = idDMR;
        this.date = date;
        this.phRespo = phRespo;
        this.typeExamen=type;
    }
   
    public Examen(int idDMR, Date date, PH phRespo, TypeExamen typeExamen, String numPACS, String texteCR) {
        this.idDMR = idDMR;
        this.date = date;
        this.phRespo = phRespo;
        this.typeExamen = typeExamen;
        this.numPACS = numPACS;
        this.texteCR = texteCR;
    }
    
    public int getIdDMR() {
        return idDMR;
    }

    public Date getDate() {
        return date;
    }

    public PH getPhRespo() {
        return phRespo;
    }

    public TypeExamen getTypeExamen() {
        return typeExamen;
    }

    public String getNumPACS() {
        return numPACS;
    }

    public String getTexteCR() {
        return texteCR;
    }

    //on ne peut set texteCR et numPACS que si ils n'ont jamais été entrés
    public void setTexteCR(String texteCR) {
        if (this.texteCR == null){
            this.texteCR = texteCR;
        }
    }

    public void setNumPACS(String numPACS) {
        if (this.numPACS == null){
            this.numPACS = numPACS;
        }
    }
}
