package personnages;

import javax.lang.model.element.NestingKind;

public class Humain {
	
	private String nom; 
	private String boissonPreferee; 
	private int quantiteArgent;
	
	public String getNom() {
		return nom;
	}

	public int getQuantiteArgent() {
		return quantiteArgent;
	}

	public Humain(String nom, String boissonPreferee, int quantiteArgent) {
		super();
		this.nom = nom;
		this.boissonPreferee = boissonPreferee;
		this.quantiteArgent = quantiteArgent;
	} 
	
	private String parler(String texte){
		return "(" + nom + ") - " + texte ;
	}
	
	public void direBonjour() {
		System.out.println(parler("Bonjour ! je m'apple "  + nom + " et j'aime boire du " + boissonPreferee));	
	}
	
	public void boire() {
		System.out.println(parler("Mmmm, un bon verre de " + boissonPreferee + "! Glous !" )); 
	}
	
	public void acheter(String bien, int prix) {
		if(prix > 0 && prix <= quantiteArgent) {
			
			System.out.println(parler("J'ai " + quantiteArgent + " sous en poche. Je vais pouvoir m'offrir " + bien + " à " + prix + " sous."));
			perdreArgent(prix);
		}else {
			System.out.println(parler("J'ai plus que " + quantiteArgent + " sous en poche. Je ne peux pas m'offrir " + bien + " à " + prix + " sous."));
		}
		
	}
	
	private void gagnerArgent(int gain) {
		if(gain > 0) {
			quantiteArgent+= gain; 
		}
	}
	
	private void perdreArgent(int perte) {
		if (perte > 0) {
			quantiteArgent-= perte; 
		}
	}
	
	

}
