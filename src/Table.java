import java.util.ArrayList;
import java.util.List;

public class Table {
//Attributs
    private List<Cube> cubeEnHaut = new ArrayList<Cube> ();

//Constructeurs
    public Table() {
    	
    }
    
//Getteur & Setteur
    public List<Cube> getCubeEnHaut() {
        // Automatically generated method. Please do not modify this code.
        return this.cubeEnHaut;
    }

    public void setCubeEnHaut(List<Cube> value) {
        // Automatically generated method. Please do not modify this code.
        this.cubeEnHaut = value;
    }
  
//Méthodes
    public void poseCube(Cube c) {
    	//pose un cube sur la table
    	updateCubeSurTable(c);
    }

    private void updateCubeSurTable(Cube c) {
    	//ajoute un cube dans la liste 
    	this.cubeEnHaut.add(c);
    }

    public void poserSurCube(CouleurCube couleur, TailleCube taille, Cube cubeAposer) {
    	Cube receveur = getSommet(couleur, taille);
    	if(receveur != null) {
    		updateCubeSurCube(cubeAposer, receveur);
    	}
    }

    public Cube getSommet(CouleurCube couleur, TailleCube taille) {
    	Cube cubeAprendre = null;
    	for(int i=0; i<cubeEnHaut.size(); i++) {
    		if(cubeEnHaut.get(i).estBonCube(couleur, taille)) {
    			Cube cubeNewSommet;
    			cubeAprendre = cubeEnHaut.get(i);
    			//cas ou il y en a pas un dessous le cube il faut le retirer complet de la table
    			cubeNewSommet = updateRetirer(cubeAprendre);
    			if(cubeNewSommet == null) {
    				cubeEnHaut.remove(i);
    			}
    			else {
    				cubeEnHaut.set(i, cubeNewSommet);
    			}
    			
    		}
    	}
    	return cubeAprendre;
    }

    public Cube prendreCube(CouleurCube couleur, TailleCube taille) {
    	Cube c = null;
    	c = getSommet(couleur, taille);
    	c.afficherCube();
    	return c;
    }

    public void updateCubeSurCube(Cube cubeDessus, Cube cubeDessous) {
    	//place le cube sur le cube du sommet
    	cubeDessus.setDessous(cubeDessous);
    	
    	//remplace le sommet dans la liste 
    	for(int i=0; i<cubeEnHaut.size(); i++) {
    		if(cubeEnHaut.get(i) == cubeDessous) {
    			cubeEnHaut.set(i, cubeDessus);
    		}
    	}
    	
    	
    }

    public Cube updateRetirer(Cube cube) {
    	Cube cubeDeDessous = null;
    	
    	if(cube.getDessous()!=null) {
    		cubeDeDessous = cube.enleveDeDessus();
    	}
    	
    	return cubeDeDessous;
    }

	public void afficherTable() {
		System.out.println(" ||");
		System.out.println("=||");
		
		for(int i = 0; i<cubeEnHaut.size(); i++) {
			System.out.println(" ||");
			cubeEnHaut.get(i).afficherCube();
			Cube suivant = cubeEnHaut.get(i).getDessous();
			while(suivant != null) {
				suivant.afficherCube();
				suivant = suivant.getDessous();
			}
		}
		
		System.out.println("=||");
		System.out.println(" ||");
	}

}
