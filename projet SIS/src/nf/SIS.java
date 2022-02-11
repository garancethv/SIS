package nf;

import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Garance
 */
public class SIS {

    public static void main(String[] args) {
        /*String nomPatient1 = "Laurant";
        String prenomPatient1 = "Mathilde";
        Date dateNaissance1 = new Date(2001, 10, 14);
        Genre genre1 = Genre.F;
        int id1 = 123;
        DMR dmr1 = new DMR(nomPatient1, prenomPatient1, dateNaissance1, genre1, id1);*/
        
        /*Genre g = Genre.F;
        System.out.println(g.getGenre());*/
        
        //String nom = null;
        //System.out.println(nom);
        
        Date d1 = new Date(01, 01, 1001);
        Date d2 = new Date(01, 01, 1002);
        Date d3 = new Date(01, 01, 1003);
        Date d4 = new Date(01, 01, 1004);
        Date d5 = new Date(01, 01, 1005);
        ArrayList<Date> dates = new ArrayList<>();
        dates.add(d1);
        dates.add(d2);
        dates.add(d3);
        dates.add(d4);
        dates.add(d5);
        
        
        /*int nb_examens = dates.size();
        if (nb_examens > 0){
            ArrayList<Date> dates_tri = new ArrayList<>();
            for (int i = 0; i < nb_examens; i++){
                int j = 0;
                Date exam_courant = dates.get(i);
                while (exam_courant.after(dates_tri.get(j)) && j < i){//car i = examens_tri.size()
                    j++;
                }
                dates_tri.add(j + 1, exam_courant);
            }
        }
        System.out.println(dates_tri.get(3).toString());*/

}

}
