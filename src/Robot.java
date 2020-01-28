public class Robot {
//Attributs
    private Table table;
    public Cube cubeTenu;
    
//Constructeurs
    public Robot(Table tab) {
    	this.table = tab;
    }
    
//Getteur & Seteur
    public Table getTable() {
        // Automatically generated method. Please do not modify this code.
        return this.table;
    }

    public void setTable(Table value) {
        // Automatically generated method. Please do not modify this code.
        this.table = value;
    }

    public Cube getCubeTenu() {
        // Automatically generated method. Please do not modify this code.
        return this.cubeTenu;
    }

    public void setCubeTenu(Cube value) {
        // Automatically generated method. Please do not modify this code.
        this.cubeTenu = value;
    }

//Méthodes public
    public void afficherRobot() {
		//afficher le robot
    	
    	System.out.println("========\\");
    	if(!verifPinceVide()) {
    		cubeTenu.afficherCube();
    	}
    	System.out.println("========/");
    	
    }
    
    public void creerCube() {
    	//Création d'un cube par défault
    	if(verifPinceVide()) {
    		Cube c = new Cube();
    		updatePince(c);
    		
    	}
    }
    
    public void creerCube(CouleurCube couleur, TailleCube taille) {
    	//Création d'un cube avec un taille et couleur entré par l'utilisateur
    	if(verifPinceVide()) {
    		Cube c = new Cube(couleur, taille);
        	this.updatePince(c);
    	}
    }
    
    public void detruireCube() {
    	//Détruit le cube tenu par le robot
    	if(!verifPinceVide()) {
    		updatePince();
    	}
    }
    
    public void prendreCube(CouleurCube couleur, TailleCube taille) {
    	//Prendre un cube de la table qui est en sommet
    	if(verifPinceVide()) {
    		System.out.println("prendre cube if");
    		Cube c = this.table.prendreCube(couleur, taille);
    		updatePince(c);
    	}
    }
    
    public void poserCubeTable() {
    	//Poser le cube tenu dans la pince sur la table, nouvelle pile de cube
    	if(!verifPinceVide()) {
    		this.table.poseCube(this.cubeTenu);
    		updatePince();
    	}
    }

    
//Méthodes private
    private boolean verifPinceVide() {
    	//Vérifier si le robot tient un cube ou non (True = vide / False = tient un cube)
    	if(cubeTenu == null) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    private void updatePince(Cube c) {
    	//MAJ de la pince du robot pour lui faire tenir le cube c
    	this.cubeTenu = c;
    }
    
    private void updatePince() {
    	//MAJ de la pince du robot pour qu'elle ne tienne rien
    	this.cubeTenu = null;
    }

//Other


    public void poserCubeCube(CouleurCube couleur, TailleCube taille) {
    		if(!verifPinceVide()) {
    			if(this.cubeTenu.verifPlusPetit(taille)) {
    				this.table.poserSurCube(couleur, taille, this.cubeTenu);
    			}
    			
    		}
    }

  


	
}
