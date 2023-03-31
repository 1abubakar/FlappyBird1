
public abstract class Spielfigur {
	
//	Attribute 
	
	protected int id;
	protected static int idZaehler = 0;
	protected ZeichenFlaeche14 zf; 
	protected int x ; 
	protected int y ; 
	protected double velY ;
	protected double speed; 
	protected int height; 
	protected int width; 

	
//	Konstruktor 
	
	public Spielfigur(ZeichenFlaeche14 zf, int x, int y, int height, int width, int velY){ 
		this.id = idZaehler;
		this.idZaehler++;
		this.zf = zf; 
		this.x = x; 
		this.y = y; 
		this.height = height; 
		this.width = width;
		this.velY = velY; 
		
	}
	public Spielfigur(ZeichenFlaeche14 zf, int x, int y, double height, double width, double speed){ //Konstruktor für Hindernisse
		this.zf = zf; 
		this.x = x ; 
		this.y = y;
		this.speed = speed; 
		this.height = (int) height; 
		this.width = (int) width;
		this.id = idZaehler; 
		this.idZaehler++; 
		
	}

	
	//	Methoden
	
	public abstract void bewegung();
	public abstract void zeichnen();
	
	
	public ZeichenFlaeche14 getZf() {
		return zf;
	}
	
	
	//Getter und Setter
	
	public void setZf(ZeichenFlaeche14 zf) {
		this.zf = zf;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public double getVelY() {
		return velY;
	}
	public void setVelY(double velY) {
		this.velY = velY;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public int getId() {
		return id;
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	


}
