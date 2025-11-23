package personnages;

import javax.lang.model.element.NestingKind;

public class Humain {

	protected String nom;
	protected String boissonPreferee;
	protected int argent;

	// Mémoire de connaissances
	protected Humain[] memoire;
	protected int nbConnaissances = 0;
	private static final int TAILLE_MEMOIRE = 30;

	public Humain(String nom, String boissonPreferee, int quantiteArgent) {
		this.nom = nom;
		this.boissonPreferee = boissonPreferee;
		this.argent = quantiteArgent;
		this.memoire = new Humain[TAILLE_MEMOIRE];
	}

	public String getNom() {
		return nom;
	}

	public int getQuantiteArgent() {
		return argent;
	}

	protected String parler(String texte) {
		return "(" + nom + ") - " + texte;
	}

	public void direBonjour() {
		System.out.println(parler("Bonjour ! Je m’appelle " + nom + " et j’aime boire du " + boissonPreferee + "."));
	}

	public void boire() {
		System.out.println(parler("Mmmm, un bon verre de " + boissonPreferee + " ! Glou glou !"));
	}

	public void acheter(String bien, int prix) {
		if (prix > 0 && prix <= argent) {
			System.out.println(parler(
					"J’ai " + argent + " sous en poche. Je vais pouvoir m’offrir " + bien + " à " + prix + " sous."));
			perdreArgent(prix);
		} else {
			System.out.println(parler("Je n’ai plus que " + argent + " sous en poche. Je ne peux pas m’offrir " + bien
					+ " à " + prix + " sous."));
		}
	}

	protected void gagnerArgent(int gain) {
		if (gain > 0) {
			argent += gain;
		}
	}

	protected void perdreArgent(int perte) {
		if (perte > 0) {
			argent -= perte;
			if (argent < 0) {
				argent = 0;
			}
		}
	}

	// --------- TP5 : connaissances ---------

	public void faireConnaissanceAvec(Humain autreHumain) {
		this.direBonjour();
		autreHumain.repondre(this);
		this.memoriser(autreHumain);
		autreHumain.memoriser(this);
	}

	private void repondre(Humain humain) {
		// Ici, on répond juste en disant bonjour
		this.direBonjour();
	}

	protected void memoriser(Humain humain) {
		if (humain == null || humain == this) {
			return;
		}

		if (nbConnaissances < memoire.length) {
			memoire[nbConnaissances] = humain;
			nbConnaissances++;
		} else {
			// Mémoire pleine : on oublie le plus ancien (case 0) et on décale
			for (int i = 0; i < memoire.length - 1; i++) {
				memoire[i] = memoire[i + 1];
			}
			memoire[memoire.length - 1] = humain;
		}
	}

	public void listerConnaissances() {
		if (nbConnaissances == 0) {
			System.out.println(parler("Je ne connais encore personne."));
		} else {
			String texte = "Je connais beaucoup de monde dont : ";
			for (int i = 0; i < nbConnaissances; i++) {
				texte += memoire[i].getNom();
				if (i < nbConnaissances - 1) {
					texte += ", ";
				}
			}
			System.out.println(parler(texte));
		}
	}

	// --------- Modifs TP5 ---------
	// - Ajout de la mémoire : tableau Humain[] memoire et int nbConnaissances.
	// - Ajout de la méthode faireConnaissanceAvec(Humain).
	// - Ajout de la méthode privée repondre(Humain).
	// - Ajout de la méthode protégée memoriser(Humain).
	// - Ajout de la méthode publique listerConnaissances().
}
