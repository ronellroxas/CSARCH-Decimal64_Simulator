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
    private JLabel lblBase10;
    private JTextField tfExponent;
    private JButton btnInput; 

    public InputContainer(InputController controller) {
        //Initialize components
        lblInput = new JLabel("Decimal Input:");
        tfInput = new JTextField(10);
        lblBase10 = new JLabel("x10");
        tfExponent = new JTextField(3);

        btnInput = new JButton("Submit");

        //add to panel
        this.add(lblInput);
        this.add(tfInput);
        this.add(lblBase10);
        this.add(tfExponent);
        this.add(btnInput);

        controller.setTarget(tfInput, tfExponent);
        btnInput.addActionListener(controller);
    }
}
