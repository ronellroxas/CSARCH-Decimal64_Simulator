package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import model.Dec64;

public class OutputController implements ActionListener {

    private JTextField tfOutput;
    private Dec64 dec64;

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public OutputController(Dec64 n) {
        this.dec64 = n;
    }

    public void setTarget(JTextField tfOutput) {
        this.tfOutput = tfOutput;
    }
    
}
