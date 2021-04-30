package Panels;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Player.PlayersDashBoard;

import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StartWindow extends JFrame {

	public static JLayeredPane layeredPane;
	private JLabel info;
	private JButton startButton;
	private JPanel welcome;



	/**
	 * Create the frame.
	 */
	public StartWindow(PlayersDashBoard dashBoard) {
		GameWindow gamePanel = new GameWindow(dashBoard);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(400,300));
		layeredPane = new JLayeredPane();
		setContentPane(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		welcome = new JPanel(new BorderLayout(0, 0));
		startButton = new JButton("LETS PLAY");
	    startButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		layeredPane.add(welcome);
		info = new JLabel("CLICK LETS PLAY TO START");
		welcome.add(startButton, BorderLayout.SOUTH);
		info.setFont(new Font("Tahoma", Font.PLAIN, 24));
		info.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.add(info, BorderLayout.CENTER);
		startButton.addActionListener(s-> switchTo(gamePanel));
		dashBoard.loadRecordInfo();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
					dashBoard.writeData();
			}
		});
		pack();
		
	}
	
	public static void switchTo(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}

}
