import java.awt.Color;
import java.util.ArrayList;

public class Kollision {
	public static boolean checkCollision(Kreis kreis, int hindernis[]) { // s1: erste sp; s2: zweite sp // Prüft ob die zwei sp objekten überlappen bzw. berühren
		
		int spX = kreis.getX();
		int spY = kreis.getY();
		int spBreite = (int) kreis.getWidth();
		int spHoehe = (int) kreis.getHeight();
		int hnX = hindernis[0];
		int hnY = hindernis[1];
		int hnBreite = hindernis[2];
		int hnHoehe = hindernis[3];
		
	    	if (spX < hnX + hnBreite && spX + spBreite > hnX && spY < hnY + hnHoehe && spY + spHoehe > hnY) {
//		        score++; 
//		        zf.setzeText(0, "Score: " + score, 50, 50, 20, Color.BLACK); //Update score text
	    		System.out.println("Kollision!!!");
		        return true;
		    }
	    return false;
	}
}
