package histoire;

import java.net.ProtocolFamily;

import personnages.Humain;

public class HistoireTP4 {

	public static void main(String[] args) {

		Humain prof = new Humain("Prof", "kombucha", 54); 
		
		prof.direBonjour();
		prof.acheter("une boisson", 2);
		prof.boire();
		prof.acheter("un jeu", 12);
		prof.acheter("un kimono", 40);

	}

}
