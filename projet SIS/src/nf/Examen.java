package nf;

import java.util.Date;

/**
 * Créer une instance d'Examen
 * @author Mathilde
 */
public class Examen {

    private int idDMR;
    private Date date; //il existe plusieurs constructeurs dans la classe Date de Java. Pour une date d'examen, on rentre Date("année", "mois", "jour", "heure", "minute")
    private int idPhRespo;
    private TypeExamen typeExamen;
    private int numPACS; //numPACS est null quand les images sont format papier, c'est pourquoi j'ai du mettre un type String et pas int!!!!!!!
    private String texteCR; //texteCR est null quand le CR est format papier

    /**
     * Constructeur de la classe Examen
     *
     * @param idDMR
     * @param date
     * @param idPhRespo
     * @param type
     */
    public Examen(int idDMR, Date date, int idPhRespo, TypeExamen type) {
        this.idDMR = idDMR;
        this.date = date;
        this.idPhRespo = idPhRespo;
        this.typeExamen = type;
    }

    /**
     * Contructeur de la classe Examen
     *
     * @param idDMR
     * @param date
     * @param idPhRespo
     * @param typeExamen
     * @param numPACS
     * @param texteCR
     */
    public Examen(int idDMR, Date date, int idPhRespo, TypeExamen typeExamen, int numPACS, String texteCR) {
        this.idDMR = idDMR;
        this.date = date;
        this.idPhRespo = idPhRespo;
        this.typeExamen = typeExamen;
        this.numPACS = numPACS;
        this.texteCR = texteCR;
    }

    /**
     * renvoie l'identifiant du DMR dans lequel est l'examen
     *
     * @return
     */
    public int getIdDMR() {
        return idDMR;
    }

    /**
     * Renvoie la date d'examens
     *
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     * Renvoie l'identifiant du PH responsable de la réalisation de l'examen
     *
     * @return
     */
    public int getIdPhRespo() {
        return idPhRespo;
    }

    /**
     * Renvoie le type de l'examen
     *
     * @return
     */
    public TypeExamen getTypeExamen() {
        return typeExamen;
    }

    /**
     * Renvoie le texte du compte-rendu de l'examen
     *
     * @return
     */
    public String getTexteCR() {
        return texteCR;
    }

    //on ne peut set texteCR et numPACS que si ils n'ont jamais été entrés
    /**
     * Ajoute un texte de compte-rendu
     *
     * @param texteCR
     */
    public void setTexteCR(String texteCR) {
        if (this.texteCR == null) {
            this.texteCR = texteCR;
        }
    }

    @Override
    public String toString() {
        return "Examen{" + "idDMR=" + idDMR + ", date=" + date + ", idPhRespo=" + idPhRespo + ", typeExamen=" + typeExamen + ", numPACS=" + numPACS + ", texteCR=" + texteCR + '}';
    }

}
