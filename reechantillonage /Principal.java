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

import java.util.List;

public class Principal {
    public static void main(String[] args) {

        int degre = 0;
        double distanceH = 0.0;

        double xzero = 0.0;

        Calcul unCalcul;
        unCalcul = new Calcul(degre, distanceH, xzero);
        unCalcul.lireFichier();
        List<Double> list = unCalcul.getListOfy();



        switch (unCalcul.getDegre()) {
            case 1:



                for (int i = 0; i < list.size() -1; i++) {


                    double deltaI = Lineaire.evaluerDeltaI(list.get(i + 1), list.get(i));
                    double a = Lineaire.evaluerA(deltaI, unCalcul.getDistanceH());


                    double xi = Calcul.calculerXI(unCalcul.getXzero(), unCalcul.getDistanceH(), i);

                    double xi1 = Calcul.calculerXI1(xi, unCalcul.getDistanceH());

                    double xi2 = Calcul.calculerXI2(xi, unCalcul.getDistanceH());

                    double xi3 = Calcul.calculerXI3(xi, unCalcul.getDistanceH());

                    double b = Lineaire.evaluerB(list.get(i), a, xi);

                    double yi1 = a * xi1 + b;
                    double yi2 = a * xi2 + b;
                    double yi3 = a * xi3 + b;

                    System.out.println("y :" + list.get(i) + " " + yi1 + " " + yi2 + " " + yi3);

                }

                break;

            case 2:

                for (int i = 0; i < list.size() -1; i++) {


                    double deltaI = Lineaire.evaluerDeltaI(list.get(i + 1), list.get(i));
                    //calcul de deltaI+1
                    double deltaIplus1 = Lineaire.evaluerDeltaI(list.get(i + 2), list.get(i + 1));
                    //calcul de deltaI two dots

                    double deltaI2dots = Lineaire.evaluerDeltaI(deltaIplus1, deltaI);
                    //calcul de a
                    double a = Quadratique.evaluerA(deltaI2dots, unCalcul.getDistanceH());

                    //calcul de xi

                    double xi = Calcul.calculerXI(unCalcul.getXzero(), unCalcul.getDistanceH(), i);

                    double xi1 = Calcul.calculerXI1(xi, unCalcul.getDistanceH());

                    double xi2 = Calcul.calculerXI2(xi, unCalcul.getDistanceH());

                    double xi3 = Calcul.calculerXI3(xi, unCalcul.getDistanceH());

                    double xiplus1 = xi + unCalcul.getDistanceH();

                    double b = (deltaI / unCalcul.getDistanceH()) - a * (xi + xiplus1);

                    double c = list.get(i) - b * xi - a * Math.sqrt(xi);


                    double yi1 = a * Math.sqrt(xi1) + b * xi1 + c;
                    double yi2 = a * Math.sqrt(xi2) + b * xi2 + c;
                    double yi3 = a * Math.sqrt(xi3) + b * xi3 + c;

                    System.out.println("y :" + list.get(i) + " " + yi1 + " " + yi2 + " " + yi3);

                }

                break;

            case 3:

                for (int i = 0; i < list.size() -1; i++) {


                    double deltaI = Lineaire.evaluerDeltaI(list.get(i + 1), list.get(i));

                    //calcul de deltaI+1
                    double deltaIplus1 = Lineaire.evaluerDeltaI(list.get(i + 2), list.get(i + 1));

                    //calcul de deltaI + 2
                    double deltaIplus2 = Lineaire.evaluerDeltaI(list.get(i + 3), list.get(i + 2));

                    //calcul de deltaI two dots

                    double deltaI2dots = Lineaire.evaluerDeltaI(deltaIplus1, deltaI);

                    //Calcul de deltaI2dotsplus1
                    double deltaI2dotsplus1 = Lineaire.evaluerDeltaI(deltaIplus2, deltaIplus1);


                    //Calcul de deltaI3dots
                    double deltaI3dots = Lineaire.evaluerDeltaI(deltaI2dotsplus1, deltaI2dots);

                    //calcul de a
                    double a = Cubique.evaluerA(deltaI3dots, unCalcul.getDistanceH());

                    double xi = Calcul.calculerXI(unCalcul.getXzero(), unCalcul.getDistanceH(), i);

                    double xi1 = Calcul.calculerXI1(xi, unCalcul.getDistanceH());

                    double xi2 = Calcul.calculerXI2(xi, unCalcul.getDistanceH());

                    double xi3 = Calcul.calculerXI3(xi, unCalcul.getDistanceH());

                    //calcul de xiplus1

                    double xiplus1 = xi + unCalcul.getDistanceH();

                    //calcul de xiplus2

                    double xiplus2 = xiplus1 + unCalcul.getDistanceH();

                    double b = Quadratique.evaluerA(deltaI2dots, unCalcul.getDistanceH()) - a * (xi + xiplus1 + xiplus2);

                    double c = Lineaire.evaluerA(deltaI, unCalcul.getDistanceH()) - b *(xi + xiplus1)  - a *(Math.sqrt(xi) + (xi * xiplus1) + Math.sqrt(xiplus1));

                    //calcul de d
                    double d = list.get(i) - (c * xi) - (b * Math.sqrt(xi)) - a * (Math.pow(xi, 3));


                    double yi1 = a * Math.pow(xi1, 3) + b * Math.sqrt(xi1) + c * xi1 + d;

                    double yi2 = a * Math.pow(xi2, 3) + b * Math.sqrt(xi2) + c * xi2 + d;

                    double yi3 = a * Math.pow(xi3, 3) + b * Math.sqrt(xi3) + c * xi3 + d;

                    System.out.println("y :" + list.get(i) + " " + yi1 + " " + yi2 + " " + yi3);

                    break;


                }

            default:

                System.out.println("le  degré de l'équation devrait etre en 1 et 3 inclusivement ");

        }
    }
}