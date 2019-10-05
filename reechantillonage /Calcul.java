/**
 * Université du Québec à Montréal (UQAM)
 * INF1120  - Automne 2019
 *
 * Classe Calcul : cette classe contient 4 champs qui vont etre heriter par d'autres classes.
 * cette classe, (à travers les classes Employe, Calculette, et Entreprise)
 * permet de lire un fichier d'employés ou de saisir les données des employés afin de calculer leurs bonus
 * et augmentation de salaire dans le contexte d'une entreprise.
 * VOUS DEVEZ COMPLÉTER CETTE CLASSE.
 *
 * @author SAFIR / MOKHTAR & SAFM14118605
 * @version 25-03-2019
 *
 */


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Calcul {
    protected  int degre;
    protected double distanceH;
    protected double xzero;
    public ArrayList<Double> listOfy;

    public Calcul (int degre, double distanceH, double xzero ){
        this.degre =degre;
        this.distanceH  =distanceH ;
        this.xzero =xzero;
        this.listOfy= new ArrayList<Double>();
    }

    public int getDegre() {
        return degre;
    }

    public double getDistanceH() {
        return distanceH;
    }

    public double getXzero() {
        return xzero;
    }

    public ArrayList<Double> getListOfy() {
        return listOfy;
    }

    public void setDegre(int degre) {
        this.degre = degre;
    }

    public void setDistanceH(double distanceH) {
        this.distanceH = distanceH;
    }

    public void setXzero(double xzero) {
        this.xzero = xzero;
    }

    public void setListOfy(ArrayList<Double> listOfy) {
        this.listOfy = listOfy;
    }

    public static double calculerXI (double x0, double h , int i ){
        double xi = x0 + i*h;
        return xi;
    }

    public static double calculerXI1 (double xi, double h){
        double xi1 = xi + 0.25*h;
        return xi1;
    }
    public static double calculerXI2 (double xi, double h){
        double xi2 = xi + 0.5*h;
        return xi2;
    }
    public static double calculerXI3 (double xi, double h){
        double xi3 = xi + 0.75*h;
        return xi3;
    }



    public void lireFichier(){

        String nom = "resources/valeur.txt";


        try {

            FileReader fr = new FileReader(nom);
            BufferedReader fichier = new BufferedReader(fr);
            Scanner sc = new Scanner(fichier);
            sc.useLocale(Locale.CANADA);

            if (sc.hasNextInt()) {
                setDegre(sc.nextInt());
            }
            if (sc.hasNextDouble()) {
                setDistanceH(sc.nextDouble());
            }

            if (sc.hasNextDouble()){
                setXzero(sc.nextDouble());
            }


            while (sc.hasNextDouble()){
                listOfy.add(sc.nextDouble());

            }

            fichier.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("erreur entree/sortie");
        }

    }



    @Override
    public String toString() {
        return "Calcul{" +
                "degre=" + degre +
                ", distanceH=" + distanceH +
                ", xzero=" + xzero +
                ", listOfy=" + listOfy +
                '}';
    }




}
















