

import java.awt.EventQueue;

import Panels.StartWindow;
import Player.PlayersDashBoard;

public class Runner {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

					StartWindow frame = new StartWindow(new PlayersDashBoard());
					frame.setVisible(true);

	}


}
