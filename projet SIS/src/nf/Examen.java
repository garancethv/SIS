

package nf;

import java.util.Date;

/**
 *
 * @author Mathilde
 */
public class Examen {
    private int idDMR;
    private Date date; //il existe plusieurs constructeurs dans la classe Date de Java. Pour une date d'examen, on rentre Date("année", "mois", "jour", "heure", "minute")
    private int idPhRespo;
    private TypeExamen typeExamen;
    private int numPACS; //numPACS est null quand les images sont format papier, c'est pourquoi j'ai du mettre un type String et pas int!!!!!!!
    private String texteCR; //texteCR est null quand le CR est format papier

    public Examen(int idDMR, Date date, int idPhRespo, TypeExamen type) {
        this.idDMR = idDMR;
        this.date = date;
        this.idPhRespo = idPhRespo;
        this.typeExamen=type;
    }
   
    public Examen(int idDMR, Date date, int idPhRespo, TypeExamen typeExamen, int numPACS, String texteCR) {
        this.idDMR = idDMR;
        this.date = date;
        this.idPhRespo = idPhRespo;
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

    public int getIdPhRespo() {
        return idPhRespo;
    }

    public TypeExamen getTypeExamen() {
        return typeExamen;
    }

    public int getNumPACS() {
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

    public void setNumPACS(int numPACS) {
        if (this.numPACS == 0){
            this.numPACS = numPACS;
        }
    }

    public Object getPhRespo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
