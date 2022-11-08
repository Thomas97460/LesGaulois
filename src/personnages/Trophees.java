package personnages;

public class Trophees {

	private Gaulois gaulois;
	private Equipement equipement;
	
	public Trophees() {
		
	}
	
	public Equipement getEquipement() {
		return equipement;
	}
	
	public Gaulois getGaulois() {
		return gaulois;
	}
	
	public String donnerNnom() {
		return gaulois.getNom();
	}
	
}
