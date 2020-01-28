public class Cube {
//Attributs
    private TailleCube taille;
    private CouleurCube couleur;
    private Cube dessous;
    
//Constructeurs
    public Cube(CouleurCube couleur, TailleCube taille) {
    	this.couleur = couleur;
    	this.taille = taille;
    }

    public Cube() {
    	this.couleur = CouleurCube.rouge;
    	this.taille = TailleCube.moyen;
    }
    
//Getteur & setteur
    public TailleCube getTaille() {
        // Automatically generated method. Please do not modify this code.
        return this.taille;
    }

    private void setTaille(TailleCube value) {
        // Automatically generated method. Please do not modify this code.
        this.taille = value;
    }

    private CouleurCube getCouleur() {
        // Automatically generated method. Please do not modify this code.
        return this.couleur;
    }

    private void setCouleur(CouleurCube value) {
        // Automatically generated method. Please do not modify this code.
        this.couleur = value;
    }

    public Cube getDessous() {
        // Automatically generated method. Please do not modify this code.
        return this.dessous;
    }

    public void setDessous(Cube value) {
        // Automatically generated method. Please do not modify this code.
        this.dessous = value;
    }

//Méthodes
    public void poserSur() {
    }

    public void mettreSur(Cube cubeDessous) {
    	
    }

    public boolean verifPlusPetit(TailleCube taille) {
    	if(this.taille == TailleCube.petit) {
    		return true;
    	}
    	else if(this.taille == TailleCube.moyen) {
    		if(taille == TailleCube.petit) {
    			return false;
    		}
    		else {
    			return true;
    		}
    	}
    	else{
    		if(taille == TailleCube.grand) {
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }

    public Cube enleveDeDessus() {
    	Cube cubeDessous = this.dessous;
    	this.dessous = null;
    	return cubeDessous;
    }

    public Boolean estBonCube(CouleurCube couleur, TailleCube taille) {
    	if(this.couleur == couleur && this.taille == taille) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    public void afficherCube() {
    	if(this.taille == TailleCube.petit) {
    		System.out.println(" --- ");
    		System.out.println("| "+this.initialeCouleur()+" |");
    		System.out.println(" --- ");
    	}
    	else if(this.taille == TailleCube.moyen) {
    		System.out.println(" ------ ");
    		System.out.println("|   "+this.initialeCouleur()+"  |");
    		System.out.println("|      |");
    		System.out.println(" ------ ");
    	}
    	else {
    		System.out.println(" -------- ");
    		System.out.println("|        |");
    		System.out.println("|   "+this.initialeCouleur()+"    |");
    		System.out.println("|        |");
    		System.out.println(" -------- ");
    	}
    }
    
    
    public char initialeCouleur() {
    	CouleurCube colorC = this.couleur;
    	char initial;
    	
    	switch(colorC) {
    	case rouge:
    		initial = 'R';
    		break;
    	case vert:
    		initial = 'V';
    		break;
    	case jaune:
    		initial = 'J';
    		break;
    	case bleu:
    		initial = 'B';
    		break;
    	case violet:
    		initial = 'V';
    		break;
    	case cyan:
    		initial = 'C';
    		break;
    	case gris:
    		initial = 'G';
    		break;
    	case noir:
    		initial = 'N';
    		break;
    	default:
    		initial = '?';
    		break;
    	}
    	
    	return initial;
    }
}
