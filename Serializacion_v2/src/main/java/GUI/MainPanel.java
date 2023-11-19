package GUI;
import org.example.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MainPanel extends JPanel {
    private TextField textField;
    private JLabel info;
    private JButton guardar;
    private JButton cargar;
    private Contenido contenido;
    private JLabel numero;

    public MainPanel(){
        textField = new TextField();
        info = new JLabel("Ingrese un numero: ");
        numero = new JLabel("Aqui aparecerá su numero: ");
        guardar = new JButton("Guardar");
        cargar = new JButton("Cargar");
        contenido = new Contenido();

        setBounds(0,0,450,450);
        setLayout(null);



        numero.setBounds(50,250,175,25);
        numero.setVisible(true);

        info.setBounds(50,125,175,25);
        info.setVisible(true);
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contenido.setNumero(textField.getText());
            }
        });
        textField.setBounds(50,150,150,50);
        textField.setVisible(true);



        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileOutputStream fileSave = new FileOutputStream("src\\main\\java\\Saves\\contenido.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileSave);
                    out.writeObject(contenido);
                    out.close();
                    fileSave.close();

                    System.out.println("guardado");


                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        guardar.setBounds(300, 100,100,50);
        guardar.setVisible(true);

        cargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contenido contenidoLoad = null;
                //FileInputStream fileLoad = null;

                try {
                    FileInputStream fileLoad = new FileInputStream("src\\main\\java\\Saves\\contenido.ser");
                    ObjectInputStream in = new ObjectInputStream(fileLoad);

                    contenidoLoad = (Contenido) in.readObject();
                    fileLoad.close();
                    in.close();

                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                numero.setText(contenidoLoad.getNumero());



            }
        });
        cargar.setBounds(300, 200,100,50);
        cargar.setVisible(true);

        add(textField);
        add(guardar);
        add(cargar);
        add(info);
        add(numero);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 450);
        frame.setLayout(new BorderLayout());

        MainPanel mainPanel = new MainPanel();
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }



}
