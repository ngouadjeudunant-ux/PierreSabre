package histoire;

import java.net.ProtocolFamily;

import personnages.Commercant;
import personnages.Humain;
import personnages.Yakuza;

public class HistoireTP4 {

	public static void main(String[] args) {

		System.out.println("Test Humain :");
		Humain prof = new Humain("Prof", "kombucha", 54);
		prof.direBonjour();
		prof.acheter("une boisson", 2);
		prof.boire();
		prof.acheter("un jeu", 12);
		prof.acheter("un kimono", 40);

		System.out.println("\nTest Commercant :");
		Commercant marco = new Commercant("Marco", 20);
		marco.direBonjour();
		marco.seFaireExtorquer();
		marco.recevoir(15);
		marco.boire();

		System.out.println("\nTest Yakuza :");
		Yakuza yaku = new Yakuza("Yaku", "saké", 30, "Shobu");
		yaku.direBonjour();
		yaku.extorquer(marco);

	}

}
