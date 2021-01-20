package view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.InputController;
import controller.OutputController;

import model.Dec64;

public class MainFrame extends JFrame{
    
    private JPanel mainPanel;
    private InputController iController;
    private OutputController oController;

    private Dec64 dec64;

    public MainFrame(int w, int h) {
        //basic settings
        this.setTitle("Decimal 64 Simulator");
        this.setSize(w, h);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        //Add main panel with borders
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(w, h));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        mainPanel.setBorder(padding);
        this.add(mainPanel);

        //initialize model
        dec64 = new Dec64();

        //Initialize Controllers
        iController = new InputController(dec64);
        oController = new OutputController(dec64);

        //Add other individual components
        addComponents();
    }

    private void addComponents() {
        mainPanel.add(new InputContainer(iController));    //input container
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(new OutputContainer(oController, iController));   //output container
    }
}
