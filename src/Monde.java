import in.keyboard.Keyboard;

public class Monde {
	
//	public static final int rouge = 31;
//	public static final int vert = 32;
//	public static final int jaune = 33;
//	public static final int bleu = 34;
//	public static final int violet = 35;
//	public static final int cyan = 36;
//	public static final int gris = 37;
//	public static final int noir = 38;
	
	public static void ecrire(CouleurCube coul, String s) {
		System.out.printf("\033[%d;1m%s\033[0m\n", coul.ordinal()+31, s);
	}
	
	public static void main(String[] args) {
//		Couleur.testCouleur();
		Table tab = new Table();
		Robot D2R2 = new Robot(tab);
		char c = ' ';
		CouleurCube coul;
		TailleCube tc;
		do {
		System.out.println("1 - creer un cube");
		System.out.println("2 - détruire un cube");
		System.out.println("3 - prendre un cube");
		System.out.println("4 - poser un cube sur la table");
		System.out.println("5 - poser un cube sur un cube");
		System.out.println("f - fin du monde");
		System.out.print("Votre choix : ");
		c = Keyboard.getChar();
		switch (c) {
		case '1': 
			//Creer un cube
			System.out.print("Couleur du cube : ");
			coul = CouleurCube.getCouleur(Keyboard.getString());
			System.out.print("Taille (grand/moyen/petit) : ");
			tc = TailleCube.getTaille(Keyboard.getString());
			D2R2.creerCube(coul, tc);
			break;
		case '2':
			//détruire un cube
			System.out.println("Le cube tenu par le robot va être détruit ");
			D2R2.detruireCube();
			break;
		case '3':
			//prendre un cube
			System.out.print("Couleur du cube : ");
			coul = CouleurCube.getCouleur(Keyboard.getString());
			System.out.print("Taille (grand/moyen/petit) : ");
			tc = TailleCube.getTaille(Keyboard.getString());
			D2R2.prendreCube(coul, tc);
			break;
		case '4':
			//poser un cube sur la table
			D2R2.poserCubeTable();
			break;
		case '5':
			//poser un cube sur un cube
			System.out.print("Couleur du cube sur lequel se poser : ");
			coul = CouleurCube.getCouleur(Keyboard.getString());
			System.out.print("Taille (grand/moyen/petit) du cube sur lequel se poser : ");
			tc = TailleCube.getTaille(Keyboard.getString());
			D2R2.poserCubeCube(coul, tc);
			break;
		}
		afficherMonde(D2R2, tab);
		} while (c != 'f');
	}

	private static void afficherMonde(Robot R, Table T) {
		System.out.println("Etat du monde :");
		R.afficherRobot();
		T.afficherTable();
	}



	
	
	
	
}