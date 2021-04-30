package Panels;

import javax.swing.JPanel;
import javax.swing.Timer;

import Helpers.Images;
import Helpers.Status;
import Player.PlayersDashBoard;

import java.awt.GridLayout;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.BorderLayout;

public class GameWindow extends JPanel{
	//fields
	private JLabel leftCard,middleCard,rightCard;
	private JButton play,stop;
	private int leftGenr,middleGenr,rightGenr;
	private JPanel cardsBoard,controllers;
	private Timer timer;
	//Constructor
	public GameWindow(PlayersDashBoard dash) {
		setLayout(new BorderLayout(0, 0));
		cardsBoard = new JPanel(new GridLayout(1, 0, 0, 0));
		controllers = new JPanel(new GridLayout(1, 0, 0, 0));
		play = new JButton("PLAY");
		stop = new JButton("STOP");
		stop.setEnabled(false);
		leftCard = new JLabel();
		middleCard = new JLabel();
		rightCard = new JLabel();
		addComponents(dash);
		gameAction();
	}
	//adding Panel Components and set fonts
	private void addComponents(PlayersDashBoard dash) {
		cardsBoard.add(leftCard); 
		cardsBoard.add(middleCard);
		cardsBoard.add(rightCard);
		controllers.add(play);
		controllers.add(stop);
		add(cardsBoard,BorderLayout.CENTER);
		add(controllers,BorderLayout.SOUTH);
		play.addActionListener(pl->play());
		stop.addActionListener(st->stop(dash));
		play.setFont(new Font("Tahoma", Font.PLAIN, 24));
		stop.setFont(new Font("Tahoma", Font.PLAIN, 24));
	}

	private void gameAction() {
		leftGenr = new Random().nextInt(11)+1;
		middleGenr = new Random().nextInt(11)+1;
		rightGenr = new Random().nextInt(11)+1;
		leftCard.setIcon(Images.FOR(leftGenr));
		middleCard.setIcon(Images.FOR(middleGenr));
		rightCard.setIcon(Images.FOR(rightGenr));
		

	}
	//To find if two or three cards has same numbers
	public static int countDistinct(int ... values) {
		return (int) Arrays.stream(values).distinct().count();
	}
	private void gameRules(PlayersDashBoard dash) {
		try {
		String playerName = ""; 
		int sum = leftGenr+middleGenr+rightGenr;
		if(countDistinct(leftGenr,rightGenr,middleGenr) == 1 && leftGenr == 1){
		} 
		else if(countDistinct(leftGenr,rightGenr,middleGenr) == 1) {
			playerName = JOptionPane.showInputDialog(Status.ALL_CARDS.getComment()+"["+sum+"] ,ENTER YOUR NAME ");
		} 
		else if(countDistinct(leftGenr,rightGenr,middleGenr) == 2) {
			playerName =JOptionPane.showInputDialog(Status.TWO_CARDS.getComment()+"["+sum+"] ,ENTER YOUR NAME ");
		}
		else {
			playerName =JOptionPane.showInputDialog(Status.NONE.getComment()+"["+sum+"] ,ENTER YOUR NAME ");
		}
		if(!playerName.isEmpty()) {
			dash.newRecords(playerName, sum);
			StartWindow.switchTo(new ScoreWindow(dash));
			reset();
		}
		}catch(Exception g) {reset();}
	}

	private void stop(PlayersDashBoard dash) {
		play.setEnabled(false);
		stop.setEnabled(false);
		timer.stop();
		gameRules(dash);
	}
	private void play() {
		timer = new Timer(80,p->gameAction());
		stop.setEnabled(true);
		timer.start();
		play.setEnabled(false);
	}
	private void reset() {
		leftCard.setIcon(null); 
		rightCard.setIcon(null);
		middleCard.setIcon(null);
		play.setEnabled(true);
	}


}
