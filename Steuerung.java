import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class Steuerung implements KeyListener {
	
//	Attribute 

	private ZeichenFlaeche14 zf; 
	private Spielfigur sp;		
	private ArrayList<Hindernisse> hn = new ArrayList<Hindernisse>();	
	private Kreis kreis;  
	private boolean gameStartet = false;
	private int score = 0; 
	private int hindernisAnhzahl = 8;
	
	//Kollistionserkennung 
	


//	Methoden
	public Steuerung(){
		this.zf = new ZeichenFlaeche14(); 
		this.zf.macheZeichenFlaecheSichtbar();
		this.zf.stopAutomatischesZeichnen();
		this.zf.requestFocus();
		this.zf.addKeyListener(this);
		
		
		kreis = new Kreis(zf, 160, 160, 50, 50, 0);
		
		
		for(int i = 0; i < hindernisAnhzahl; i++) {
			new Hindernisse(zf, 0, 0, 50, 0, 0, hindernisAnhzahl);
			hn = Hindernisse.getHindernisse();
			hn.get(i).erzeugHindernisse();
			hn.get(i).zeichnen();
		}
		kreis.zeichnen();
	}
	
	public void starte(){
		
		
//  	Game Loop
  		while (true){
  			
  			kreis.bewegung();
  			
  			for(int i = 0; i < hindernisAnhzahl; i++) {
  				hn.get(i).bewegung();
  				hn.get(i).kollisionTesten(kreis);
  			}
  			
//			Renden
  			zf.manualPaint();
  		
//			Pause
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {}
		}
			
		}

	
	private boolean checkCollision(Kreis kreis2, ArrayList<Hindernisse> hn2) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void keyPressed(KeyEvent event) {
		
		if(event.getKeyCode() == KeyEvent.VK_SPACE){
			if(!gameStartet) {
				System.out.println("Yoooooooo");
				gameStartet = true;
				starte();
				kreis.setVelY(-5);
			}
////			if(gameStartet) {
////				gameStartet = true; // wenn taste gedrückt wird starte das Spiel
////				starte();
			else {
				System.out.println();
				kreis.setVelY(5);
			}
		}
		

	
	}
	@Override
	public void keyReleased(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_SPACE){
			kreis.setVelY(5); // fällt runter wenn taste nicht gedruckt wird
		}

	}
	  
	@Override
	public void keyTyped(KeyEvent event) {}
	
	
}
