

/**
 * Université du Québec à Montréal (UQAM)
 * INF1120 - Groupe 11 - Hiver 2019
 *
 * Classe ApplicationPrincipale : cette classe, (à travers les classes Employe, Calculette, et Entreprise)
 * permet de lire un fichier d'employés ou de saisir les données des employés afin de calculer leurs bonus
 * et augmentation de salaire dans le contexte d'une entreprise.
 * VOUS DEVEZ COMPLÉTER CETTE CLASSE.
 *
 * @author SAFIR / MOKHTAR & SAFM14118605
 * @version 25-03-2019
 *
 */


public class Lineaire extends Calcul {

    public Lineaire(int degre, double distanceH, double xzero) {
        super(degre, distanceH, xzero);
    }

    public  static double evaluerDeltaI(double  y1, double y0){  // tab[i] tab[i+1]

        double deltaI = y1-y0;
        return deltaI;

    }

    public  static double evaluerA( double deltaI, double distanceH){
       double  a = deltaI / distanceH;
       return a;
    }


    public static double evaluerB(double yi, double a, double x){
        double b = yi - a*x;
        return b;
    }


}
