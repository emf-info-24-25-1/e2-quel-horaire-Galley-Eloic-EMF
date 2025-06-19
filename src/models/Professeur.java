package models;

public class Professeur {
    //MR Manque les finals sur les deux premiers attributs
    private String nom;
    private String prenom;
    private ModuleInfo[] modulesEnseignes;

    public Professeur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        modulesEnseignes = new ModuleInfo[0];
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public ModuleInfo[] getModulesEnseignes() {
        return modulesEnseignes;
    }

    public boolean enseigneCeModule(ModuleInfo module) {
        boolean enseigne = false;
        for (int i = 0; i < modulesEnseignes.length; i++) {
            if (modulesEnseignes[i] == module) {
                enseigne = true;
                break;
            }
        }
        return enseigne;
    }

    public void ajouterModuleEnseigne(ModuleInfo module) {
        //MR regarde à nouveau le code pour ajouter dans un tableau dynamique
        ModuleInfo[] tableauTemp = new ModuleInfo[modulesEnseignes.length + 1];
        tableauTemp = modulesEnseignes;
        for (int i = 0; i < tableauTemp.length; i++) {
            if (tableauTemp[i] == null) {
                tableauTemp[i] = module;
                modulesEnseignes = tableauTemp;
                break;
            }
        }
    }

    public void viderModules() {
        //MR Il faut que le tableau soit de nouveau de taille 0
        for (int i = 0; i < modulesEnseignes.length; i++) {
            modulesEnseignes[i] = null;
        }
    }

    @Override
    public String toString() {
        return prenom + " " + nom.toUpperCase();
    }

}
