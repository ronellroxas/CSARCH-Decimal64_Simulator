package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;

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
            //set exponent
            int exponent = Integer.parseInt(tfExponent.getText());
            if(exponent > 369 || exponent < -398) {
                dec64.isInfinity(text);
            }
            else {
                Double.parseDouble(text);
                dec64.setBase10(text);
                dec64.setExponent(exponent);
                dec64.fixInput();
            }
            
        }
        catch(Exception ne){
            dec64.isNaN(text);
        }
        finally {
            tfOutput.setText("");
            tfOutput.append(dec64.toString());
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
