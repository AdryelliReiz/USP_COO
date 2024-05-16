import java.awt.*;
import java.util.Random;

/**
	Esta classe representa a bola usada no jogo. A classe princial do jogo (Pong)
	instancia um objeto deste tipo quando a execução é iniciada.
*/

public class Ball {
	/**
		Construtor da classe Ball. Observe que quem invoca o construtor desta classe define a velocidade da bola 
		(em pixels por millisegundo), mas não define a direção deste movimento. A direção do movimento é determinada 
		aleatóriamente pelo construtor.

		@param cx coordenada x da posição inicial da bola (centro do retangulo que a representa).
		@param cy coordenada y da posição inicial da bola (centro do retangulo que a representa).
		@param width largura do retangulo que representa a bola.
		@param height altura do retangulo que representa a bola.
		@param color cor da bola.
		@param speed velocidade da bola (em pixels por millisegundo).
	*/
	private double cx;
	private double cy;
	private double width;
	private double height;
	private Color color;
	private double speed;
	private double speedX;
	private double speedY;


	public Ball(double cx, double cy, double width, double height, Color color, double speed){
		this.cx = cx;
		this.cy = cy;
		this.width = width;
		this.height = height;
		this.color = color;

		this.setAngle(speed);
	}

	public void setAngle(double speed) {
		double minAngle = Math.toRadians(-45);
		double maxAngle = Math.toRadians(45);
		double angleRange = maxAngle - minAngle;
		double angle = Math.random() * angleRange + minAngle;
		this.speedX = speed * Math.cos(angle);
		this.speedY = speed * Math.sin(angle);
		this.speed = speed;
		System.out.println(this.speedX + " " + this.speedY + " " + " angulo: " + angle);
	}


	/**
		Método chamado sempre que a bola precisa ser (re)desenhada.
	*/

	public void draw(){

		GameLib.setColor(Color.YELLOW);
		GameLib.fillRect(this.cx, this.cy, this.width, this.height);
	}

	/**
		Método chamado quando o estado (posição) da bola precisa ser atualizado.
		
		@param delta quantidade de millisegundos que se passou entre o ciclo anterior de atualização do jogo e o atual.
	*/

	public void update(long delta){
		this.cx += this.speedX * delta;
		this.cy += this.speedY * delta;
	}

	/**
		Método chamado quando detecta-se uma colisão da bola com um jogador.
	
		@param playerId uma string cujo conteúdo identifica um dos jogadores.
	*/

	public void onPlayerCollision(String playerId){
		this.speedX = - (this.speedX);
		Random rand = new Random();
		double angleChange = (rand.nextDouble() - 0.5) * Math.PI / 8;
		double speed = Math.sqrt(this.speedX * this.speedX + this.speedY * this.speedY);
		double angle = Math.atan2(this.speedY, this.speedX) + angleChange;
		this.speedX = speed * Math.cos(angle);
		this.speedY = speed * Math.sin(angle);
	}

	/**
		Método chamado quando detecta-se uma colisão da bola com uma parede.

		@param wallId uma string cujo conteúdo identifica uma das paredes da quadra.
	*/

	public void onWallCollision(String wallId){
		if (wallId.equals("Top") || wallId.equals("Bottom")) {
			this.speedY = -this.speedY;
		} else  {
			//CONCERTAR ISSO (DIRECTION OF BALL)
			this.setAngle(-(this.speed));
			this.cy = 300;
			if (wallId.equals("Left")){
				this.cx = 200;
			}
			else if(wallId.equals("Right")) {
				this.cx = 600;
			}
		}
	}

	public boolean checkCollision(Wall wall){
		double ballLeft = this.cx - this.width / 2;
		double ballRight = this.cx + this.width / 2;
		double ballTop = this.cy - this.height / 2;
		double ballBottom = this.cy + this.height / 2;

		double wallLeft = wall.getCx() - wall.getWidth() / 2;
		double wallRight = wall.getCx() + wall.getWidth() / 2;
		double wallTop = wall.getCy() - wall.getHeight() / 2;
		double wallBottom = wall.getCy() + wall.getHeight() / 2;

        return ballRight >= wallLeft && ballLeft <= wallRight && ballBottom >= wallTop && ballTop <= wallBottom;
    }

	public boolean checkCollision(Player player){
		double ballLeft = this.cx - this.width / 2;
		double ballRight = this.cx + this.width / 2;
		double ballTop = this.cy - this.height / 2;
		double ballBottom = this.cy + this.height / 2;

		double playerLeft = player.getCx() - player.getWidth() / 2;
		double playerRight = player.getCx() + player.getWidth() / 2;
		double playerTop = player.getCy() - player.getHeight() / 2;
		double playerBottom = player.getCy() + player.getHeight() / 2;

		return ballRight >= playerLeft && ballLeft <= playerRight && ballBottom >= playerTop && ballTop <= playerBottom;
	}
	
	public double getCx(){
		return this.cx;
	}

	public double getCy(){
		return this.cy;
	}

	public double getSpeed(){
		return Math.sqrt(this.speedX * this.speedX + this.speedY * this.speedY);
	}

}
