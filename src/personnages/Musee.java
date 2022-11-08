package personnages;

public class Musee {

	private int nbMaxTrophees = 200;
	private Equipement[] trophees = new Equipement[200];
	private int nbTrophees = 0;
	
	public void DonnerTrophees(Gaulois gauloisDonateur, Equipement equipementDon) {
		this.trophees[nbTrophees] = equipementDon;
		nbTrophees ++;
	}
	
}
