import java.awt.*;

/**
	Esta classe representa um placar no jogo. A classe princial do jogo (Pong)
	instancia dois objeto deste tipo, cada um responsável por gerenciar a pontuação
	de um player, quando a execução é iniciada.
*/

public class Score {
	private final String playerId;
	private int score;
	private Color color;

	/**
		 Construtor da classe Score.

		 @param playerId uma string que identifica o player ao qual este placar está associado.
	 */

	//esse metodo cria o Score dos players manualmente pq não recebe o objeto Player para ter acesso
	//dinamicamente aos atributos
	public Score(String playerId){
		this.playerId = playerId;
		this.score = 0;
		if(this.playerId.trim().equals("Player 1")) {
			this.color = Color.GREEN;
		} else {
			this.color = Color.BLUE;
		}
	}

	/**
	 	Método de desenho do placar.
	 */
	public void draw(){
		GameLib.setColor(this.color);
		if(this.playerId.trim().equals("Player 1")) {
			GameLib.drawText("" + this.score, 70, GameLib.ALIGN_LEFT);
		} else {
			GameLib.drawText("" + this.score, 70, GameLib.ALIGN_RIGHT);
		}
	}

	/**
	 	Método que incrementa em 1 unidade a contagem de pontos.
	 */
	public void inc(){
		this.score += 1;
	}

	/**
		 Método que devolve a contagem de pontos mantida pelo placar.

		 @return o valor inteiro referente ao total de pontos.
	 */
	public int getScore(){
		return this.score;
	}
}
