import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
public class Interfaz {
    JFrame frame;
    JLabel blinker;
    JPanel panel;
    Thread hilo;
    Servidor servidor;
    public Interfaz()
    {
        frame = new JFrame("Tarea Programada POO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        blinker = new JLabel();
        blinker.setPreferredSize(new Dimension(100, 100));
        blinker.setOpaque(true);
        blinker.setBackground(Color.WHITE);

        panel = new JPanel(new BorderLayout());
        panel.add(blinker, BorderLayout.WEST);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        servidor=new Servidor();
        hilo=new Thread(servidor);
        hilo.start();
        while(true)
            blink();
    }

    private void blink()
    {

        System.out.println(servidor.activo);
        while( servidor.activo==true){
            try {
                blinker.setBackground(Color.YELLOW);
                Thread.sleep(500);
                blinker.setBackground(Color.WHITE);
                Thread.sleep(500);
            } catch (InterruptedException e) {   
                e.printStackTrace();
            }
        }    
    }
    
       
   
}

