package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import model.Dec64;

public class OutputController implements ActionListener {

    private JTextArea tfOutput;
    private Dec64 dec64;

    @Override
    public void actionPerformed(ActionEvent e) {
        String myString = tfOutput.getText();
        StringSelection stringSelection = new StringSelection(myString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        JOptionPane.showMessageDialog(tfOutput, "Result copied to clipboard", "Results copied!", JOptionPane.INFORMATION_MESSAGE);
    }

    public OutputController(Dec64 n) {
        this.dec64 = n;
    }

    public void setTarget(JTextArea tfOutput) {
        this.tfOutput = tfOutput;
    }
     
}
