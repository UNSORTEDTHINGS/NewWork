import panels.OptionsWindow;
import student.Course;

import javax.swing.*;
import java.awt.*;

public class ProgramRunner {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        OptionsWindow window = new OptionsWindow(new Course());
        window.setPreferredSize(new Dimension(450, 400));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.pack();

    }
}
