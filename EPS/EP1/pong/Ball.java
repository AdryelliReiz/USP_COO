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
	 	@param directionX direção da bola no eixo X (em pixels por millisegundo).
	 	@param directionY direção da bola no eixo Y (em pixels por millisegundo).
	*/
	private double cx;
	private double cy;
	private double width;
	private double height;
	private Color color;
	private double speed;
	//optei por usar mais dois atributos na minha classe
    private double directionX;
    private double directionY;

    private static final String TOP = "Top";
    private static final String BOTTOM = "Bottom";
    private static final String LEFT = "Left";
    private static final String RIGHT = "Right";

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


	public Ball(double cx, double cy, double width, double height, Color color, double speed){
		this.cx = cx;
		this.cy = cy;
		this.width = width;
		this.height = height;
		this.color = color;
		this.speed = speed;

		this.setInitialDirection();
	}

	/**
		 Método chamado quando o estado (posição) da bola precisa ser atualizado.

		 @param speed velocidade inicial da bola.
	 */

	//metodo que vai calcular de forma aleatoria a direção que a bola deve seguir no inicio de cada partida
	public void setInitialDirection() {
		double minAngle;
		double maxAngle;
		//se for a primeira rodada
		if(this.directionX == 0 && this.directionY == 0) {
			//escolhe um lado de forma aleatoria
			double random = Math.random();
			if(random > 0.5) {
				this.directionX = -1;
			} else {
				this.directionY = 1;
			}
		}
		//começa do lado que foi marcado ponto
		//escolhe os angulos max e min em um intervalo determinado levando em conta a direção que a bola estava seguindo
		if(this.directionX > 0) {
			minAngle = Math.toRadians(150);
			maxAngle = Math.toRadians(210);
		} else {
			minAngle = Math.toRadians(-30);
			maxAngle = Math.toRadians(30);
		}
        //calcula o angulo e seta a direção que a bola deve seguir
		double angleRange = maxAngle - minAngle;
		double angle = Math.random() * angleRange + minAngle;
		this.directionX = this.speed * Math.cos(angle);
		this.directionY = this.speed * Math.sin(angle);
	}


	/**
		Método chamado sempre que a bola precisa ser (re)desenhada.
	*/

	public void draw(){
		GameLib.setColor(this.color);
		GameLib.fillRect(this.cx, this.cy, this.width, this.height);
	}

	/**
		Método chamado quando o estado (posição) da bola precisa ser atualizado.

		@param delta quantidade de millisegundos que se passou entre o ciclo anterior de atualização do jogo e o atual.
	*/

	public void update(long delta){
		this.cx += this.directionX * delta;
		this.cy += this.directionY * delta;
	}

	/**
		Método chamado quando detecta-se uma colisão da bola com um jogador.

		@param playerId uma string cujo conteúdo identifica um dos jogadores.
	*/

	//o calculo do angulo está limitado pelo parametro do metodo
	public void onPlayerCollision(String playerId) {
		Random rand = new Random();
		double angleChange = (rand.nextDouble() - 0.5) * Math.PI / 8;
		double speed = Math.sqrt(this.directionX * this.directionX + this.directionY * this.directionY);
		double angle = Math.atan2(this.directionY, -(this.directionX)) + angleChange;
		this.directionX = speed * Math.cos(angle);
		this.directionY = speed * Math.sin(angle);
	}

	/**
		Método chamado quando detecta-se uma colisão da bola com uma parede.

		@param wallId uma string cujo conteúdo identifica uma das paredes da quadra.
	*/

    public void onWallCollision(String wallId) {
        if (TOP.equals(wallId) || BOTTOM.equals(wallId)) {
            this.directionY = -this.directionY;
        } else if (LEFT.equals(wallId) || RIGHT.equals(wallId)) {
            //Bateu nas paredes da esquerda ou direita? Então pontuou
            //Logo, seta um novo angulo e posição para a bolinha começar (nova rodada!)
            //A bola começa do lado que foi pontuado e vai na direção do player que marcou
            setInitialDirection();
            //setar posição da bolinha no inicio da rodada
            this.cy = 300;
            this.cx = LEFT.equals(wallId) ? 100 : 700;
        }
    }

	/**
		 Método que verifica se houve colisão da bola com uma parede.

		 @param wall referência para uma instância de Wall contra a qual será verificada a ocorrência de colisão da bola.
		 @return um valor booleano que indica a ocorrência (true) ou não (false) de colisão.
	 */
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

	/**
		 Método que verifica se houve colisão da bola com um jogador.

		 @param player referência para uma instância de Player contra o qual será verificada a ocorrência de colisão da bola.
		 @return um valor booleano que indica a ocorrência (true) ou não (false) de colisão.
	 */
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

	/**
		 Método que devolve a coordenada x do centro do retângulo que representa a bola.
		 @return o valor double da coordenada x.
	 */
	public double getCx(){
		return this.cx;
	}

	/**
		 Método que devolve a coordenada y do centro do retângulo que representa a bola.
		 @return o valor double da coordenada y.
	 */
	public double getCy(){
		return this.cy;
	}

	/**
		 Método que devolve a velocidade da bola.
		 @return o valor double da velocidade.
	 */
	public double getSpeed(){
		return this.speed;
	}

}
