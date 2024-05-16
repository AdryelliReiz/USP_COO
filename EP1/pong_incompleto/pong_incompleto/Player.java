import java.awt.*;

/**
	Esta classe representa os jogadores (players) do jogo. A classe princial do jogo (Pong)
	instancia dois objetos deste tipo quando a execução é iniciada.
*/

public class Player {
	private double cx;
	private double cy;
	private double width;
	private double height;
	private Color color;
	private String id;
	private double [] v_limit;
	private double speed;

	public Player(double cx, double cy, double width, double height, Color color, String id, double [] v_limit, double speed){
		this.cx = cx;
		this.cy = cy;
		this.width = width;
		this.height = height;
		this.color = color;
		this.id = id;
		this.v_limit = v_limit;
		this.speed = speed;
	}

	public void draw(){
		GameLib.setColor(Color.GREEN);
		GameLib.fillRect(this.cx, this.cy, this.width, this.height);
	}

	public void moveUp(long delta){
		if(GameLib.isKeyPressed(GameLib.KEY_A) || GameLib.isKeyPressed(GameLib.KEY_K)) {
			double value = this.cy - (this.speed * delta);
			if(value - (this.height / 2) < this.v_limit[0]) {
				this.cy = this.v_limit[0] + (this.height / 2);
			} else {
				this.cy = value;
			}
		}
	}

	public void moveDown(long delta){
		if(GameLib.isKeyPressed(GameLib.KEY_Z) || GameLib.isKeyPressed(GameLib.KEY_M)) {
			double value = this.cy + (this.speed * delta) ;
			if(value + (this.height / 2) > this.v_limit[1]) {
				this.cy = this.v_limit[1] - (this.height / 2);
			} else {
				this.cy = value;
			}
		}
	}

	public String getId() { 
		return this.id;
	}

	public double getWidth() {
		return this.width;
	}

	public double getHeight() { 
		return this.height;
	}

	public double getCx() { 
		return this.cx;
	}

	public double getCy() { 
		return this.cy;
	}
}

