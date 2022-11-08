package personnages;

public class Commercant extends Humain {

	public Commercant(String nom, int quantiteArgent) {
		super(nom, "thé", quantiteArgent);
	}
	
	public int seFaireExtorquer() {
		int argentVole = super.getQuantiteArgent();
		super.prendreArgent(argentVole);
		super.parler("J'ai tout perdu ! Le monde est trop injuste ...");
		return argentVole;
	}
	
	public void recevoir(int argent) {
		super.gagnerArgent(argent);
		super.parler(argent + " sous ! Je te remercie généreux donateur !");
	}
}