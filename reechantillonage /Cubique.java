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

public class Cubique extends Calcul {
    public Cubique(int degre, double distanceH, double xzero) {
        super(degre, distanceH, xzero);
    }

    public  static double evaluerA( double deltaI, double distanceH){
        double  a = deltaI / 6 * Math.pow(distanceH, 3);
        return a;
    }
}
