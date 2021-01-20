package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Dec64;


public class InputController implements ActionListener {

    private JTextField tfInput;
    private JTextField tfOutput;
    private Dec64 dec64;

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = tfInput.getText();

        try {
            dec64.setBase10(Integer.parseInt(text));
            tfOutput.setText(String.valueOf(dec64.getBase10()));
        }
        catch(NumberFormatException ne){
            dec64.setBase10(null);
            JOptionPane.showMessageDialog(tfInput, "Input is not a valid number.", "Input Conversion Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public InputController(Dec64 n) {
        this.dec64 = n;
    }

    public void setTarget(JTextField tfInput) {
        this.tfInput = tfInput;    
    }

    public void setOutput(JTextField tfOutput) {
        this.tfOutput = tfOutput;
    }
}
