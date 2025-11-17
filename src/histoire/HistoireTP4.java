package histoire;

import java.net.ProtocolFamily;

import personnages.Commercant;
import personnages.Humain;

public class HistoireTP4 {

	public static void main(String[] args) {
		
		System.out.println("Test 1.c classe Humain");
		
		Humain prof = new Humain("Prof", "kombucha", 54); 
		
		prof.direBonjour();
		prof.acheter("une boisson", 2);
		prof.boire();
		prof.acheter("un jeu", 12);
		prof.acheter("un kimono", 40);
		
		System.out.println("Test 2.1.b classe Commercant");
		
		Commercant marko = new Commercant("Marko", 20); 
		marko.direBonjour();
		marko.seFaireExtorquer(); 
		marko.recevoir(15);
		marko.boire();
		
		System.out.println();

	}

}
