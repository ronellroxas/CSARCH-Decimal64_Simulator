package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import model.Dec64;

public class OutputController implements ActionListener {

    private JTextArea tfOutput;
    private Dec64 dec64;

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public OutputController(Dec64 n) {
        this.dec64 = n;
    }

    public void setTarget(JTextArea tfOutput) {
        this.tfOutput = tfOutput;
    }
    
}
