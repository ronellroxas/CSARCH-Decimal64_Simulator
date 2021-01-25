package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.InputController;
import controller.OutputController;

/***
 * Creates the Output container including necessary components.
 */
public class OutputContainer extends JPanel{
    
    private JLabel lblOutput;
    private JTextArea tfOutput;
    private JButton btnOutput;
    private final int V_SPACING = 5;

    public OutputContainer(OutputController controller, InputController iController) {
        //Container Settings
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //Initialize components
        initializeOutputLabel();
        this.add(Box.createVerticalStrut(V_SPACING));
        initializeOutputField();
        this.add(Box.createVerticalStrut(V_SPACING));
        initializeOutputButton();

        controller.setTarget(tfOutput);
        iController.setOutput(tfOutput);

    }

    /***
     * This method initializes the Output Label.
     * Refactored for styling purposes.
     */
    private void initializeOutputLabel() {
        lblOutput = new JLabel("Decimal-64 Representation:");
        this.add(lblOutput);

        //Styling here
        lblOutput.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    /***
     * This method initializes the Output text field.
     * Refactored for styling purposes.
     */
    private void initializeOutputField() {
        tfOutput = new JTextArea(4, 50);
        tfOutput.setEditable(false);
        tfOutput.setBackground(Color.WHITE);
        this.add(tfOutput);

        //Styling here
    }

    /***
     * This method initializes the Output Button.
     * Refactored for styling purposes.
     */
    private void initializeOutputButton() {
        btnOutput = new JButton("Copy Results");
        this.add(btnOutput);

        //Styling here
        btnOutput.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

}
