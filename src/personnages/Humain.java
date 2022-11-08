package personnages;

public class Humain {
	
	private String nom;
	private String boissonPreferee;
	private int quantiteArgent;
	
	public Humain(String nom, String boissonPreferee, int quantiteArgent) {
		this.nom = nom;
		this.boissonPreferee = boissonPreferee;
		this.quantiteArgent = quantiteArgent;
		assert this.quantiteArgent >= 0 : "L'argent de l'humain doit être positif";
	}
	
	protected void parler(String texte) {
		System.out.println("(" + this.nom + ") -  " + texte);
	}
	
	public void gagnerArgent(int gain) {
		this.quantiteArgent += gain;
	}
	
	public void prendreArgent(int perte) {
		this.quantiteArgent -= perte;
		assert  this.quantiteArgent >= 0 : "La quantité d'argent doit être positive" ;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getQuantiteArgent() {
		return quantiteArgent;
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + this.nom + " et j'aime boire du " + this.boissonPreferee);
	}
	
	public void boire() {
		parler("Mmmm, un bon verre de " + this.boissonPreferee + " ! GLOUPS !");
	}
	
	public void acheter(String bien, int prix) {
		if (this.quantiteArgent >= prix) {
			parler("J'ai " + this.quantiteArgent + " sous en poche. Je vais pouvoir m'offir " + bien + " à " + prix + " sous");
			this.prendreArgent(prix);
		}
		else {
			parler("Je n'ai que " + this.quantiteArgent + " sous en poche. Je ne vais pas pouvoir m'offir " + bien + " à " + prix + " sous");
		}
	}
	
	public static void main(String[] args) {
		Humain prof = new Humain("Prof", "kombucha", 54);
		
		prof.direBonjour();
		prof.acheter("un kombucha", 12);
		prof.boire();
		prof.acheter("un jeu à sous", 2);
		prof.acheter("un kimono", 50);
		
	}
}
