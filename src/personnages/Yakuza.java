package personnages;

public class Yakuza extends Humain {
	private String clan;
    private int reputation = 0;

    public Yakuza(String nom, String boissonPreferee, int argent, String clan) {
        super(nom, boissonPreferee, argent);
        this.clan = clan;
    }

    @Override
    public void direBonjour() {
        super.direBonjour();
        System.out.println(parler("Mon clan est celui de " + clan + "."));
    }

    public void extorquer(Commercant victime) {
        System.out.println(parler("Tiens, tiens, ne serait-ce pas un faible marchand ?"));
        System.out.println(parler("Je te prends tout ce que tu as !"));

        int argentVole = victime.seFaireExtorquer();
        gagnerArgent(argentVole);
        reputation++;

        System.out.println(parler("J’ai gagné " + argentVole + " sous !"));
    }

    public int perdre() {
        int argentPerdu = this.argent;
        this.argent = 0;
        reputation--;
        System.out.println(parler("J’ai perdu un duel !"));
        return argentPerdu;
    }

    public void gagner(int gain) {
        gagnerArgent(gain);
        reputation++;
        System.out.println(parler("Ce combat est mien !"));
    }

    // --------- Modifs TP5 ---------
    // - Redéfinition de direBonjour() pour ajouter l’annonce du clan (partie 2 du TP5).
    // - Le reste vient du TP4 (extorquer, perdre, gagner).
}
