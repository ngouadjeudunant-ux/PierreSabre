package personnages;

public class Samourai extends Ronin {

    private String seigneur;

    public Samourai(String seigneur, String nom, String boissonPreferee, int argent) {
        super(nom, boissonPreferee, argent);
        this.seigneur = seigneur;
    }

    @Override
    public void direBonjour() {
        super.direBonjour();
        System.out.println(parler("Je suis fier de servir le seigneur " + seigneur + "."));
    }

    // Surcharge de boire : on choisit une boisson au choix
    public void boire(String boisson) {
        System.out.println(parler("Qu’est-ce que je vais choisir comme boisson ? Tiens je vais prendre du "
                + boisson + "."));
    }

    // --------- Modifs TP5 ---------
    // Classe créée pour TP5 :
    // - Attribut seigneur.
    // - Redéfinition de direBonjour().
    // - Nouvelle méthode boire(String) qui surcharge boire().
}
