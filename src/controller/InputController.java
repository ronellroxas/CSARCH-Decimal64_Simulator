package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Dec64;


public class InputController implements ActionListener {

    private JTextField tfInput;
    private JTextField tfExponent;
    private JTextArea tfOutput;
    private Dec64 dec64;

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = tfInput.getText();

        //set base 10
        try {
            Double.parseDouble(text);
            dec64.setBase10(text);
            
            //set exponent
            text = tfExponent.getText();
            dec64.setExponent(Integer.parseInt(text));
            dec64.fixInput();
            
            tfOutput.append(dec64.toString());
        }
        catch(NumberFormatException ne){
            dec64.setBase10(null);
            JOptionPane.showMessageDialog(tfInput, "Invalid Input/s.", "Input Conversion Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public InputController(Dec64 n) {
        this.dec64 = n;
    }

    public void setTarget(JTextField tfInput, JTextField tfExponent) {
        this.tfInput = tfInput;    
        this.tfExponent = tfExponent;
    }

    public void setOutput(JTextArea tfOutput) {
        this.tfOutput = tfOutput;
    }

}
