import java.awt.*;

/**
	Esta classe representa um placar no jogo. A classe princial do jogo (Pong)
	instancia dois objeto deste tipo, cada um responsável por gerenciar a pontuação
	de um player, quando a execução é iniciada.
*/

public class Score {
	private final String playerId;
	private int score;

	public Score(String playerId){
		this.playerId = playerId;
		this.score = 0;
	}

	public void draw(){
		if(this.playerId.trim().equals("Player 1")) {
			GameLib.drawText(this.playerId + " " + this.score, 70, GameLib.ALIGN_LEFT);
		} else {
			GameLib.drawText(this.playerId + " " + this.score, 70, GameLib.ALIGN_RIGHT);
		}

	}

	public void inc(){
		this.score += 1;
	}

	public int getScore(){
		return this.score;
	}
}
