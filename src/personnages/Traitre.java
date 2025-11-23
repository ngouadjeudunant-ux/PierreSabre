package personnages;

import java.util.Random;

public class Traitre extends Samourai {

    private int niveauTraitrise = 0;
    private Random random = new Random();

    public Traitre(String seigneur, String nom, String boissonPreferee, int argent) {
        super(seigneur, nom, boissonPreferee, argent);
    }

    @Override
    public void direBonjour() {
        super.direBonjour();
        System.out.println(parler("Mais je suis un traître et mon niveau de traîtrise est : "
                + niveauTraitrise + ". Chut !"));
    }

    public void ranconner(Commercant commercant) {
        if (niveauTraitrise < 3) {
            int argentCommercant = commercant.getQuantiteArgent();
            int argentRanconner = argentCommercant * 2 / 10;

            System.out.println(parler(
                    "Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne-moi "
                            + argentRanconner + " sous ou gare à toi !"));

            commercant.perdreArgent(argentRanconner);
            this.gagnerArgent(argentRanconner);

            System.out.println(commercant.parler("Tout de suite grand " + getNom() + "."));

            niveauTraitrise++;
        } else {
            System.out.println(parler(
                    "Mince je ne peux plus rançonner personne sinon un samouraï risque de me démasquer !"));
        }
    }

    public void faireLeGentil() {
        if (nbConnaissances < 1) {
            System.out.println(parler("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif."));
        } else {
            int indexAmi = random.nextInt(nbConnaissances);
            Humain ami = memoire[indexAmi];

            int don = argent / 20;

            System.out.println(parler(
                    "Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec "
                            + ami.getNom() + "."));
            System.out.println(parler("Bonjour l'ami ! Je voudrais vous aider en vous donnant "
                    + don + " sous."));

            ami.gagnerArgent(don);
            this.perdreArgent(don);

            System.out.println(ami.parler("Merci " + getNom() + ". Vous êtes quelqu'un de bien."));

            if (niveauTraitrise > 0) {
                niveauTraitrise--;
            }
        }
    }

    // --------- Modifs TP5 ---------
    // Classe créée pour TP5 :
    // - Attribut niveauTraitrise et Random random.
    // - Redéfinition de direBonjour() pour afficher le niveau de traîtrise.
    // - Méthode ranconner(Commercant) suivant le diagramme de séquence.
    // - Méthode faireLeGentil() suivant le diagramme de séquence + Random.
}

