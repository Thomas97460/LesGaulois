package personnages;

public class Ronin extends Humain {

	private int honneur = 1;
	
	public Ronin(String nom, String boissonPreferee, int quantiteArgent) {
		super(nom, boissonPreferee, quantiteArgent);
	}
	
	public void donner(Commercant beneficiaire) {
		int argentDon = this.getQuantiteArgent() / 10;
		if(argentDon > 0) {
			this.parler(beneficiaire.getNom() + " prend ces " + argentDon + " sous");
			this.prendreArgent(argentDon);
			beneficiaire.recevoir(argentDon);
		}
	}
	
}
