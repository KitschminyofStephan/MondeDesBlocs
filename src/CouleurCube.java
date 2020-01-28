
import java.io.*;

public enum CouleurCube
{
 rouge, vert, jaune, bleu, violet, cyan, gris, noir;
 
 public static CouleurCube getCouleur(String coulSaisie) {
		for (CouleurCube c:CouleurCube.values())
			if (c.name().equalsIgnoreCase(coulSaisie))
				return c;		
		return CouleurCube.rouge;
	}

public static void testCouleur() {
	for (CouleurCube c:CouleurCube.values())
		Monde.ecrire(c,"test couleur");	
    }
}

