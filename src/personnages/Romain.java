package personnages;

public class Romain {

	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement;

	public Romain(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
		this.nbEquipement = 0;
		this.equipements = new Equipement[2];
		assert this.force > 0 : "Le param�tre force doit �tre positif";
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "'" + texte + "'");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

//	public void recevoirCoup(int forceCoup) {
//		assert this.force > 0 : "Le param�tre force doit �tre positif";
//		int forceStart = this.force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("A�e");
//		}
//		else {
//			parler("J'abandonne...");
//		}
//		assert (forceStart>force && forceStart!=force) : "La force doit diminuer apr�s recevoir Coup";
//	}
	

	 private int calculResistanceEquipement(int forceCoup) { 
		 String texte = "Ma force est  de " + this.force + ", et la force du coup est de " + forceCoup;
		 parler(texte);
		 int resistanceEquipement = 0; 
		 if (nbEquipement != 0) { 
			texte += "\nMais heureusement, grace � mon �quipement sa force est diminu� de "; 
					 for (int i = 0; i < nbEquipement; i++) { 
						 if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) { 
							 resistanceEquipement += 8; 
						 } 
						 else { 
//							 System.out.println("Equipement casque"); 
							 resistanceEquipement += 5; 
						 } 
					 } 
			 texte += resistanceEquipement + "!"; 
		 } 
		 if (forceCoup < resistanceEquipement) {
			forceCoup = 0;
		}
		 else {
			 forceCoup -= resistanceEquipement; 			
		}
		 return forceCoup; 
	 }
	 

	 private Equipement[] ejecterEquipement() { 
		 Equipement[] equipementEjecte = new Equipement[nbEquipement]; 
		 System.out.println("L'�quipement  de  "  +  nom  +  " s'envole sous la force du coup."); 

		 int nbEquipementEjecte = 0; 
		 for (int i = 0; i < nbEquipement; i++) {
			 if (equipements[i] != null) { 
				 equipementEjecte[nbEquipementEjecte]  = equipements[i]; 
				 nbEquipementEjecte++; 
				 equipements[i] = null; 
			 }
		 }
		 nbEquipement = 0;
		 return equipementEjecte; 
	 }


	 public Equipement[] recevoirCoup(int forceCoup) { 
		 Equipement[] equipementEjecte = null; 
		 // pr�condition 
		 assert force > 0; 
		 int oldForce = force;
		 
		 forceCoup = calculResistanceEquipement(forceCoup);
		 
		 force -= forceCoup; 
		 //  if (force > 0) { 
		 //  	parler("A�e"); 
		 //  } else { 
		 //  	equipementEjecte = ejecterEquipement(); 
		 //  	parler("J'abandonne..."); 
		 //  } 
		 if (force > 0) { 
				 parler("A�e");
		 }
		else {
				 equipementEjecte = ejecterEquipement(); 
				 parler("J'abandonne..."); 				 
				 force = 0;
		 } 
		 // post condition la force � diminuer 
		 assert force < oldForce; 
		 return equipementEjecte; 
	 }
	 
	public void sEquiper(Equipement equip) {
		String leSoldat = "Le soldat ";
		switch (this.nbEquipement) {
			case 0 :
				System.out.println(leSoldat + this.nom + " s'�quipe avec un " + equip);
				this.equipements[0] = equip;
				this.nbEquipement = 1;
				break;
			case 1 :
				if (this.equipements[0] == equip) {
					System.out.println(leSoldat + this.nom + " poss�de d�j� un " + equip);
				}
				else {
					System.out.println(leSoldat + this.nom + " s'�quipe avec un " + equip);
					this.equipements[1] = equip;
					this.nbEquipement = 2;
				}
				break;
			default :
				System.out.println(leSoldat + this.nom + " est d�j� bien prot�g� !");
		}
	}
		
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		
	}
}
