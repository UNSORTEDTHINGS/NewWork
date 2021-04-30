package Player;

import javax.swing.JTextArea;

public class Player {

	String name;
	int score;
	public Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected int getScore() {
		return score;
	}
	protected void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Player [name=" + name + ", score=" + score + "]";
	}
	
	public void print(JTextArea text) {
		 text.append("PLAYER NAME \tSCORE\n"
				+ "******************************\n"
				+ name.toUpperCase()+"\t\t["+score+"]\n"
				+ "******************************\n");
	}
	
}
