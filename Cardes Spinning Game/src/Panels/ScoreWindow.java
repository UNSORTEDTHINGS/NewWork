package Panels;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Player.PlayersDashBoard;

import java.awt.Font;

public class ScoreWindow extends JPanel {

	/**
	 * Create the panel.
	 */
	public ScoreWindow(PlayersDashBoard playersDashBoard) {
		setLayout(new BorderLayout(0, 0));
		JTextArea scoreOutput = new JTextArea();
		scoreOutput.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scoreOutput.setEditable(false);
		JButton back = new JButton("BACK - PLAY AGAIN");
		back.addActionListener(b->StartWindow.switchTo(new GameWindow(playersDashBoard)));
		back.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(back, BorderLayout.SOUTH);
		playersDashBoard.readAllList(scoreOutput);
		add(new JScrollPane(scoreOutput), BorderLayout.CENTER);
		
	}

}
