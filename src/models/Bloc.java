package models;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class Bloc {
    //MR Attribut doit être static
    public final int NBRE_DEMI_JOURS_SEMAINE = 10;
    //MR Les deux attributs ci-dessous peuvent être final
    private String nom;
    private ModuleInfo[] modules;

    public Bloc(String nom) {
        this.nom = nom;
        modules = new ModuleInfo[NBRE_DEMI_JOURS_SEMAINE];
        ModuleInfo matu = new ModuleInfo("matu");
        modules[0] = matu;
        modules[1] = matu;
        modules[2] = matu;
        modules[3] = matu;
    }

    public String getNom() {
        return nom;
    }

    //MR Ta méthode est juste, mais si il n'y a pas assez de place, il planifie tout de même les premiers modules
    public boolean planifierModule(ModuleInfo module) {
        boolean planificationReussi = false;
        int count = 0;
        for (int i = 0; i < modules.length; i++) {
            if (modules[i] == null) {
                modules[i] = module;
                count++;
                if (count == 3) {
                    planificationReussi = true;
                    break;
                }
                

            }
        }
        return planificationReussi;
    }

    public void afficherHoraire() {
        System.out.println(nom);
        System.out.println("--------------");
        System.out.println(DayOfWeek.values()[0].getDisplayName(TextStyle.FULL, Locale.FRANCE));
        System.out.println(" matin : " + modules[0]);
        System.out.println(" après-midi : " + modules[1]);
        System.out.println(DayOfWeek.values()[1].getDisplayName(TextStyle.FULL, Locale.FRANCE));
        System.out.println(" matin : " + modules[2]);
        System.out.println(" après-midi : " + modules[3]);
        System.out.println(DayOfWeek.values()[2].getDisplayName(TextStyle.FULL, Locale.FRANCE));
        System.out.println(" matin : " + modules[4]);
        System.out.println(" après-midi : " + modules[5]);
        System.out.println(DayOfWeek.values()[3].getDisplayName(TextStyle.FULL, Locale.FRANCE));
        System.out.println(" matin : " + modules[6]);
        System.out.println(" après-midi : " + modules[7]);
        System.out.println(DayOfWeek.values()[4].getDisplayName(TextStyle.FULL, Locale.FRANCE));
        System.out.println(" matin : " + modules[8]);
        System.out.println(" après-midi : " + modules[9]);

    }

    //MR C'est l'inverse, il faut vérifier si au moins un module est null et ça fait false
    public boolean estTotalementPlanifie() {
        boolean estPlanifie = false;
        for (int i = 0; i < modules.length; i++) {
            if (modules[i] != null) {
                estPlanifie = true;
                break;
            }
        }
        return estPlanifie;
    }

    public boolean contientModule(ModuleInfo module) {
        boolean contient = false;
        for (int i = 0; i < modules.length; i++) {
            if (modules[i] == module) {
                contient = true;
                break;
            }
        }
        return contient;
    }

    @Override
    public String toString() {
        return nom;
    }
}
