package personnages;

public class Yakuza extends Humain {

	private String clan;
	private int reputation = 0;
	
	public Yakuza(String nom, String boissonPreferee, int quantiteArgent, String clan) {
		super(nom, boissonPreferee, quantiteArgent);
	}
	
	public void extorquer(Commercant victime) {
		int argentVole = victime.seFaireExtorquer();
		String victimeNom = victime.getNom();
		parler("Tiens, tiens, ne serait-ce pas un faible marchant qui passe par là");
		parler(victimeNom + ", si tu tiens à la vie donne moi ta bourse !");
		this.gagnerArgent(argentVole);
		parler("J'ai piqué les " + argentVole + " sous de " + victimeNom + ", ce qui me fait " + this.getQuantiteArgent() + "dans ma poche. Hi ! Hi !");
	}
	
	public void gagnerReputation(int gain) {
		this.reputation += gain;
	}
	
	public void perdreReputation(int gain) {
		if(this.reputation - gain >= 0) {
			this.reputation -= gain;
		}
	}
	
	public int perdre() {
		int argentPerdu = this.getQuantiteArgent();
		this.prendreArgent(argentPerdu);
		this.perdreReputation(1);
		parler("J'ai perdu");
		return argentPerdu;
	}
	
	public void gagner(int gain) {
		this.gagnerArgent(gain);
		this.gagnerReputation(1);
		parler("J'ai gagné");
	}
	
}
