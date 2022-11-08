package personnages;

public class Village { 
	
	private String nom; 
	private Chef chef; 
	private Gaulois[] villageois;
	private int nbVillageois;
	
	public Village(String nom, int nbVillaegoisMaximum) { 
		this.nom = nom; 
		this.nbVillageois = 0;
		this.villageois = new Gaulois[nbVillaegoisMaximum];
	} 
	
	public void setChef(Chef chef) { 
		this.chef = chef; 
	} 
	
	public String getNom() { 
		return this.nom; 
	} 
	
	public void ajouterHabitant(Gaulois gaulois) {
		this.villageois[nbVillageois] = gaulois;
		this.nbVillageois++;
	}
	
	public Gaulois trouverHabitant(int numero) {
		return this.villageois[numero];
	}
	
	public  void afficherVillageois() {

		String aff = "Dans le village du chef "+ this.chef.getNom();
		aff += " vivent les légendaires gaulois :";
		for (int i = 0; i < this.nbVillageois; i++) {
			aff += "\n - " + this.trouverHabitant(i).getNom();
		}
		System.out.println(aff);
	}
	
	public static void main(String[] args) {
		Village villageTest = new Village("Village des Irréductible", 30);
//		 Gaulois gaulois = villageTest.trouverHabitant(); Exception ArrayIndexOutOfBoundsException
		Chef abraracourcix = new Chef("Abraracourcix", 6, 5, villageTest);
		villageTest.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 25);
		villageTest.ajouterHabitant(asterix);
		
//		 Gaulois gaulois = villageTest.trouverHabitant(1);
//		 System.out.println(gaulois); Affiche null car aucun objet Gaulois en position 1
		
		villageTest.ajouterHabitant(obelix);
		villageTest.afficherVillageois();		
	}
}