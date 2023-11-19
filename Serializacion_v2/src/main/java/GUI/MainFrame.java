package GUI;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private MainPanel mainPanel;

    public MainFrame(){
        super("Test");
        setBounds(0, 0, 450, 450);
        setLayout(new BorderLayout());

        mainPanel = new MainPanel();
        add(mainPanel, BorderLayout.CENTER);

        mainPanel.setVisible(true); // Asegúrate de establecer la visibilidad del panel principal

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main (String[] args){
        MainFrame mainFrame = new MainFrame();
    }


}
