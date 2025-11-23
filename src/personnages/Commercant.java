package personnages;

public class Commercant extends Humain {

	public Commercant(String nom, int argent) {

		super(nom, "thé", argent);
	}
	
	public int seFaireExtorquer() {
		int sommeExtorquee = getQuantiteArgent(); 
		perdreArgent(sommeExtorquee); 
		System.out.println(parler("J'ai tout perdu! Le monde est trop injuste..."));
		return sommeExtorquee; 
	}
	
	public void recevoir(int argent) {
		gagnerArgent(argent);
		System.out.println(parler(argent + " sous ! Je te remercie généreux donateur!"));
	}
	


}
