package services;

import models.*;

public class ServiceFormationMaitres {
    public static void attribuerModules(Professeur[] professeurs, ModuleInfo[] modules) {
        for (int i = 0; i < modules.length; i++) {
            //MR Il n'est pas nécessaire de parcourir les modules, l'objectif est de remplir à tous les professeurs les modules qu'ils peuvent enseigner.
            for (int j = 0; j < professeurs.length; j++) {
                
                int nbre = (int) (Math.random() * (modules.length - 0 + 1)) + 0;
                if (professeurs[j].enseigneCeModule(modules[nbre])) {
                    continue;
                } else {
                    professeurs[j].ajouterModuleEnseigne(modules[nbre]);
                }
            }
        }
    }

    public static boolean tousModulesCouverts(Professeur[] profs, ModuleInfo[] modules) {
        boolean couvre = true;
        for (int i = 0; i < modules.length; i++) {
             //MR Ici c'est la méthode PeutEnseigneCeModule (on est pas encore dans la planification)
            if (modules[i].getProfesseur() == null) {
                couvre = false;
                break;
            }
        }
        return couvre;
    }
}
