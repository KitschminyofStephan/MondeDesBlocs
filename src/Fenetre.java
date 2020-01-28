import java.awt.*;

public class Fenetre {
	public Fenetre() {
		Frame f = new Frame("Monde des blocs");
		Canvas c = new Affichage();
		c.resize(new Dimension(200, 200));
		f.add("center", c);
		f.resize(200,120);
		f.show();
		 c.paint(c.getGraphics()); 
	}
}
