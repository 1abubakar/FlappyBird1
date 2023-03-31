import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Kreis extends Spielfigur {
//	Attribute
//	int imageId = 0; 
//	
//	String kreisBild = "bilder/luffy.png" ;
//	Image luffyBild;


	//konstruktor

	public Kreis(ZeichenFlaeche14 zf, int x, int y, int height, int width, double velY) {
		super(zf, x, y, height, width, velY);
		// TODO Auto-generated constructor stub
	}

//	Methoden


	@Override
	public void bewegung() {
		System.out.println("Bewegt");
		y +=  velY; 
		zeichnen();
	}
	

	@Override
	public void zeichnen() {
		zf.loeschen(id);
		
		System.out.println("zeichnet");

		zf.setzeGefuellteElipse(id, x, y, height, width, Color.BLACK);
	}
	

}
