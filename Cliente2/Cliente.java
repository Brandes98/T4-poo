import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JButton;
import java.net.*;
import java.io.*;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cliente implements ActionListener{
    JFrame frame;
    
    JButton button;
    JPanel panel;

    boolean activo = false;
    Socket client;
    ObjectOutputStream output;

    public Cliente(){
        frame = new JFrame("Tarea Programada POO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button = new JButton("Encender");
        button.addActionListener(this);
        button.setActionCommand("encender");

        panel = new JPanel(new BorderLayout());   
        panel.add(button, BorderLayout.EAST);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("encender")){
            button.setText("Apagar");
            button.setActionCommand("apagar");
            activo = true;
        }
        else{
            button.setText("Encender");
            button.setActionCommand("encender");
            activo = false;
        }
        
        conectar();
    }

    public void conectar() {
        try{
            client = new Socket("127.0.0.1", 5555);
            output = new ObjectOutputStream(client.getOutputStream());

            //while (true) {
                output.writeObject(activo);
                output.flush();
                output.close();
                client.close();
                //Thread.sleep(1000);
            //}
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}

