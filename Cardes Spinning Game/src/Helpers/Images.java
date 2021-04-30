package Helpers;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Images {
	
	
	static ImageIcon[] image = {new ImageIcon("Images/1.png"),
			new ImageIcon("Images/2.png"),
			new ImageIcon("Images/3.png"),
			new ImageIcon("Images/4.png"),
			new ImageIcon("Images/5.png"),
			new ImageIcon("Images/6.png"),
			new ImageIcon("Images/7.png"),
			new ImageIcon("Images/8.png"),
			new ImageIcon("Images/9.png"),
			new ImageIcon("Images/10.png"),
			new ImageIcon("Images/11.png"),
			new ImageIcon("Images/12.png")};

	public static ImageIcon FOR(int genr) {
		return 	new ImageIcon(image[genr].getImage().getScaledInstance(120, 190, Image.SCALE_SMOOTH))
;
		
	}
}

