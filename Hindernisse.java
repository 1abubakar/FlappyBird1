 import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;



public class Hindernisse extends Spielfigur {
 
	private int gapHorizontal = 550;
	private int gapVertical = 250;
	private int hindernisAnhzahl;
	private Random rand;
	private static ArrayList<Hindernisse> meineHindernisse = new ArrayList<>();
	
	public Hindernisse(ZeichenFlaeche14 zf, int x, int y, double height, double width, double speed, int hindernisAnhzahl) {
		super(zf, x, y, height, width, speed);
		this.hindernisAnhzahl = hindernisAnhzahl;
		meineHindernisse.add(this);
        rand = new Random();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void bewegung() {
    	x -= speed; 
    	zeichnen();
	}

	@Override
	public void zeichnen() {
		// überprüft ob hindernis verschwunden ist 
   	 if (x + width < 0) { // wenn ja, platziere es am rechten Rand und erzeugt neue hindernisse
        x += hindernisAnhzahl * gapHorizontal;
        height = rand.nextInt(400) + 10;
    }
		
		zf.loeschen(id);
  	    this.zf.loeschen(this.id);
	    this.zf.setzeGefuelltesRechteck(id, x, y, width, height, Color.BLACK); // zeichnet das obere Hindernis // zeichnet das untere Hindernis
	    this.zf.setzeGefuelltesRechteck(id, x, y + height + gapVertical, width, zf.getHeight() - height, Color.BLACK);
	    x -= 10; // wie schnell die Hindernisse sich bewegen
	}
	
	
    public void erzeugHindernisse() {
        x = zf.getWidth() + (meineHindernisse.size() * gapHorizontal);
        y = 0;
        height = rand.nextInt(200) + 10;
        width = 50;
        System.out.println("X: " + x + "  - Y: " + y + "    - Höhe: " + height + "   - Screen-Width: " + zf.getWidth() + "     - Screen-Heigth: " + zf.getHeight());
        
    }
    
    public void kollisionTesten(Kreis kreis) {
    	int hindernisOben[] = {x, y, (int) width, (int) height};
    	Kollision.checkCollision(kreis, hindernisOben);
    	
    	int hindernisUnten[] = {x, y + height + gapVertical, (int) width, (int) zf.getHeight() - height};
    	Kollision.checkCollision(kreis, hindernisUnten);
    	
    }
   
    public static ArrayList<Hindernisse> getHindernisse() {
    	return meineHindernisse;
    }

    

}
