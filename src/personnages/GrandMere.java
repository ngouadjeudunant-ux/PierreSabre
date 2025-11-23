package personnages;

import java.util.Random;

public class GrandMere extends Humain {

    private static final int TAILLE_MEMOIRE_GRANDMERE = 5;
    private Random random = new Random();

    // Enum privée utilisée pour les ragots
    private enum TypeHumain {
        COMMERCANT, RONIN, YAKUZA, SAMOURAI, TRAITRE, GRANDMERE, HABITANT
    }

    public GrandMere(String nom, int argent) {
        super(nom, "tisane", argent);
        // On limite sa mémoire à 5
        this.memoire = new Humain[TAILLE_MEMOIRE_GRANDMERE];
    }

    @Override
    protected void memoriser(Humain humain) {
        if (humain == null || humain == this) {
            return;
        }

        if (nbConnaissances < memoire.length) {
            memoire[nbConnaissances] = humain;
            nbConnaissances++;
        } else {
            System.out.println(parler(
                    "Oh ma tête ! Je ne peux plus retenir le nom d'une personne supplémentaire !"));
            // Elle n'ajoute pas la nouvelle personne
        }
    }

    private String humainHasard() {
        TypeHumain[] types = TypeHumain.values();
        int index = random.nextInt(types.length);
        TypeHumain type = types[index];

        switch (type) {
        case COMMERCANT:
            return "commerçant";
        case RONIN:
            return "ronin";
        case YAKUZA:
            return "yakuza";
        case SAMOURAI:
            return "samouraï";
        case TRAITRE:
            return "traître";
        case GRANDMERE:
            return "grand-mère";
        default:
            return "habitant";
        }
    }

    public void ragoter() {
        for (int i = 0; i < nbConnaissances; i++) {
            Humain ami = memoire[i];
            if (ami instanceof Traitre) {
                System.out.println(parler("Je sais que " + ami.getNom() + " est un traître. Petit chenapan !"));
            } else {
                String type = humainHasard();
                System.out.println(parler("Je crois que " + ami.getNom() + " est un " + type));
            }
        }
    }

    // --------- Modifs TP5 ---------
    // Classe créée pour TP5 :
    // - Mémoire limitée à 5 personnes avec mémorisation spéciale.
    // - Méthode humainHasard() utilisant un enum privé TypeHumain.
    // - Méthode ragoter() qui commente sur chaque connaissance,
    //   et détecte les Traitre avec instanceof.
}
