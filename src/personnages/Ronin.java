package personnages;

public class Ronin extends Humain {

    protected int honneur = 1;

    public Ronin(String nom, String boissonPreferee, int argent) {
        super(nom, boissonPreferee, argent);
    }

    public void donner(Commercant commercant, int somme) {
        if (somme > 0 && somme <= argent) {
            System.out.println(parler("Je donne " + somme + " sous à " + commercant.getNom() + "."));
            perdreArgent(somme);
            commercant.recevoir(somme);
        } else {
            System.out.println(parler("Je n’ai pas assez d’argent pour donner " + somme + " sous."));
        }
    }

    public void provoquer(Yakuza adversaire) {
        System.out.println(parler("Je t’affronte, " + adversaire.getNom() + " !"));
        // Comportement simplifié, ici on ne gère pas le combat en détail.
    }

}
