package services;

import models.*;

public class ServiceFormationMaitres {
    public static void attribuerModules(Professeur[] professeurs, ModuleInfo[] modules) {
        for (int i = 0; i < modules.length; i++) {
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
            if (modules[i].getProfesseur() == null) {
                couvre = false;
                break;
            }
        }
        return couvre;
    }
}
