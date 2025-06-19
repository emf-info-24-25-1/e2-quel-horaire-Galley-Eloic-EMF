package app;

import models.*;
import services.*;

public class App {

    public static final String[] NOMS_MODULES = { "G300", "187", "162", "123", "293", "117", "164", "216", "106", "231",
            "122", "431" };

    public static void main(String[] args) {

        Horaire horaire = new Horaire();

        ModuleInfo[] modules1ere = new ModuleInfo[NOMS_MODULES.length];

        for (int i = 0; i < modules1ere.length; i++) {
            modules1ere[i] = new ModuleInfo(NOMS_MODULES[i]);
        }

        Professeur[] profs = new Professeur[5];
        profs[0] = new Professeur("Wick", "John");
        profs[1] = new Professeur("Croft", "Lara");
        profs[2] = new Professeur("Richard", "Jean-marc");
        profs[3] = new Professeur("Marley", "Bob");
        profs[4] = new Professeur("Skywalker", "Anakin");

        do {
            ServiceFormationMaitres.attribuerModules(profs, modules1ere);
            // MR Attention tu appelles deux fois la méthose tousModulesCouverts
            // Il faut récupérer le boolean et l'utiliser ensuite dans le while.
            ServiceFormationMaitres.tousModulesCouverts(profs, modules1ere);
        } while (!ServiceFormationMaitres.tousModulesCouverts(profs, modules1ere));

        System.out.println("l'ecole a engagé les professeurs suivants : ");
        for (int i = 0; i < profs.length; i++) {
            System.out.print("- " + profs[i] + " peut enseigner les modules : ");
            //MR A quoi sert cette boucle et pourquoi tu nomme professeur ?
            for (ModuleInfo professeur : modules1ere) {
                System.out.print(modules1ere[i].getNom());
            }
            System.out.println();
        }

        System.out.println("\nIl est temps de préparer l'horaire.\n");

        boolean succes = horaire.planifier(modules1ere, profs);

        if (succes) {
            System.out.println("Modules planifiés avec succès !");
            horaire.afficherHoraire();

        }else{
            System.out.println("Problème de planification !");
        }

    }

}
