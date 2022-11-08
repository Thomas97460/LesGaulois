package personnages;

import java.util.Iterator;

public class Gaulois {
	
	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nbTrophees; 
	private Equipement[] trophees = new Equipement[100];
	 
	public Gaulois(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
	}


	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "'" + texte + "'");
	}
	
//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";		
//	}

	 private String prendreParole() { 
		 return "Le gaulois " + nom + " : ";
	 } 

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup(force / 3);
//	}
	

	 public void frapper(Romain romain) { 
		 System.out.println(nom  +  "  envoie  un  grand  coup  dans  la m�choire de " + romain.getNom());
		 Equipement [] equipementEjecte = romain.recevoirCoup((force  /  3)  * effetPotion); 
		 for  (int  i  =  0; equipementEjecte != null && i  <  equipementEjecte.length && nbTrophees<100;  i++,  nbTrophees++) {
			 this.trophees[nbTrophees] = equipementEjecte[i]; 
		 } 
	 }
	 
	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
		if(forcePotion != 1) {
			parler("Merci Druide, je sens que ma force est "  + forcePotion + " fois décuplée. ");
		}
	}

	public void faireUneDonnation(Musee musee) {
		System.out.println("Le gaulois Astérix : Je donne au musee tous mes trophees : ");
		for (int i = 0;  i < nbTrophees ; i++) {
			System.out.println("- " + trophees[i]);	
		}
		if (nbTrophees != 0) {
			for (int i = nbTrophees - 1; i >= 0; i--) {
				musee.DonnerTrophees(this, trophees[i]);
				this.trophees[i] = null;
			}
			nbTrophees = 0;
		}
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public static void main(String[] args) {
		
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain minus = new Romain("Minus", 4);
		asterix.prendreParole();
		asterix.parler("Test Parler");
		asterix.frapper(minus);
		asterix.boirePotion(3);
	}

}
