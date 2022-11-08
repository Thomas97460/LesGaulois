package histoire;

import personnages.Commercant;
import personnages.Yakuza;
import personnages.Ronin;

public class HistoireTP4 {
	public static void main(String[] args) {
		System.out.println("~~~Scénario 1~~~ \n");
		Commercant marco = new Commercant("Marco", 20);
		marco.direBonjour();
		marco.seFaireExtorquer();
		marco.recevoir(15);
		marco.boire();
		
		System.out.println("\n \n ~~~Scénario 2~~~ \n");
		
		Yakuza yakuLeNoir = new Yakuza("Yaku Le Noir", "whisky", 30, "Warsong");
		yakuLeNoir.direBonjour();
		yakuLeNoir.extorquer(marco);
		
		System.out.println("\n \n ~~~Scénario 3~~~ \n");

		Ronin roro = new Ronin("Roro", "shochu", 60);
		roro.direBonjour();
		roro.donner(marco);
	}

}
