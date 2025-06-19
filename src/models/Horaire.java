package models;

public class Horaire {
    public final int NBRE_DE_BLOCS = 6;
    //MR aurait pu être final
    private Bloc[] blocs;

    public Horaire() {
        blocs = new Bloc[NBRE_DE_BLOCS];
        Bloc B1S1 = new Bloc("B1S1");
        Bloc B2S1 = new Bloc("B2S1");
        Bloc B3S1 = new Bloc("B3S1");
        Bloc B4S2 = new Bloc("B4S2");
        Bloc B5S2 = new Bloc("B5S2");
        Bloc B6S2 = new Bloc("B6S2");
        blocs[0] = B1S1;
        blocs[1] = B2S1;
        blocs[2] = B3S1;
        blocs[3] = B4S2;
        blocs[4] = B5S2;
        blocs[5] = B6S2;
    }

    public boolean planifier(ModuleInfo[] modules, Professeur[] profs) {
       //MR Voir correction car il y a deux étapes différentes.
        boolean planificationReussi = false;
        for (int i = 0; i < modules.length; i++) {
            for (int j = 0; j < profs.length; j++) {
                for (int k = 0; k < blocs.length; k++) {
                    if (profs[j].enseigneCeModule(modules[i])) {
                        blocs[k].planifierModule(modules[i]);
                        planificationReussi = true;
                        
                        
                    }
                }

            }
        }
        return planificationReussi;
    }

    public void afficherHoraire(){
        for (int i = 0; i < blocs.length; i++) {
            blocs[i].afficherHoraire();
        }
    }

    public Bloc moduleDansQuelBloc(ModuleInfo module){
        int count = 0;
        for (int i = 0; i < blocs.length; i++) {
            //MR il commence à 1, donc le premier n'est jamais testé
            count++;
            if (blocs[i].contientModule(module)) {
                break;
            }
        }
        return blocs[count];
    }

}
