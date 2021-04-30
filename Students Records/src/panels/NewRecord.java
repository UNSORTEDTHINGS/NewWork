package panels;

import student.Campus;
import student.Course;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class NewRecord extends JPanel {
    private final JComboBox<Campus> campusList;
    private final JButton backButton, addButton;
    private final JPanel panel;
    private final JTextField idInput,nameInput;
    private final JTextArea addedResult;

    /**
     * Constructor Initialize the contents.
     */
    public NewRecord(Course course) {
        setLayout(new BorderLayout(0, 0));
        panel = new JPanel(new GridLayout(4, 2, 0, 0));
        idInput = new JTextField();
        nameInput = new JTextField();
        campusList = new JComboBox<>(Campus.values());
        backButton = new JButton("GO BACK");
        addButton = new JButton("ADD STUDENT");
        addedResult = new JTextArea();
        registerButtonsListeners(course);
        NewStudentPanelComponents();

    }

    private void NewStudentPanelComponents() {
        add(new LabelFor("ADD NEW STUDENT "), BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(new JScrollPane(addedResult), BorderLayout.SOUTH);
        addToPanel(new LabelFor("STUDENT NAME"), nameInput
                , new LabelFor("STUDENT ID#"), idInput, new LabelFor("CAMPUS"), campusList
                , backButton, addButton);

    }

    private void addToPanel(JComponent... components) {
        for (JComponent c : components) {
            c.setFont(new Font("Tahoma", Font.PLAIN, 20));
            panel.add(c);
        }
        campusList.setSelectedIndex(-1);

        addedResult.setRows(8);
        addedResult.setEditable(false);
        addedResult.setFont(new Font("Tahoma", Font.PLAIN, 20));
        idInput.setHorizontalAlignment(SwingConstants.CENTER);
        nameInput.setHorizontalAlignment(SwingConstants.CENTER);

    }

    private void registerButtonsListeners(Course course) {

        addButton.addActionListener(a -> {
            try {
            course.newRecords(nameInput.getText(),Integer.parseInt(idInput.getText()),campusList).print(addedResult);

            addedResult.append("NEW STUDENT ADDED ON:\n" + LocalDate.now() + "\n");

            }catch (Exception n){JOptionPane.showMessageDialog(null,"Wrong Inputs ");}

        });



        backButton.addActionListener(a -> OptionsWindow.callBack());

    }


}
