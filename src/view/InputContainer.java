package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controller.InputController;

/***
 * Creates the input container including necessary components.
 */
public class InputContainer extends JPanel{
    
    //Components
    private JLabel lblInput;
    private JTextField tfInput;
    private JButton btnInput; 

    public InputContainer(InputController controller) {
        //Initialize components
        initializeInputLabel();
        initializeInputField();
        initializeInputButton();

        controller.setTarget(tfInput);
        btnInput.addActionListener(controller);
    }

    /***
     * This method initializes the Input Label.
     * Refactored for styling purposes.
     */
    private void initializeInputLabel() {
        lblInput = new JLabel("Decimal Input:");
        this.add(lblInput);

        //Styling here
    }

    /***
     * This method initializes the Input text field.
     * Refactored for styling purposes.
     */
    private void initializeInputField() {
        tfInput = new JTextField(10);
        this.add(tfInput);

        //Styling here
    }

    /***
     * This method initializes the Input Button.
     * Refactored for styling purposes.
     */
    private void initializeInputButton() {
        btnInput = new JButton("Submit");
        this.add(btnInput);

        //Styling here
    }

}
