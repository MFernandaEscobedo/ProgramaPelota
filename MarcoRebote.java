package Pelota;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MarcoRebote extends JFrame{
     private LaminaPelota lamina;
     Thread t;
     
    public MarcoRebote() {

        setBounds(600, 300, 400, 350);
        setTitle("Rebotes");
        lamina = new LaminaPelota();
        add(lamina, BorderLayout.CENTER);
        JPanel laminaBotones = new JPanel();

        ponerBoton(laminaBotones, "Start", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evento) {
                comienza_el_juego();
            }

        });

        ponerBoton(laminaBotones, "Exit", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evento) {
                System.exit(0);
            }
        });
        
        ponerBoton(laminaBotones, "Stop", new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                detener();
            }
        });

        add(laminaBotones, BorderLayout.SOUTH);
    }

    //Ponemos botones
    public void ponerBoton(Container c, String titulo, ActionListener oyente) {
        JButton boton = new JButton(titulo);
        c.add(boton);
        boton.addActionListener(oyente);
    }

    //Añade pelota y la bota 1000 veces
    public void comienza_el_juego() {
        Pelota pelota = new Pelota();
        lamina.add(pelota);
        
        Runnable r = new MultipleThreads(pelota, lamina);
        
        t= new Thread(r);
        t.start();
    }
    
    public void detener(){
        t.interrupt();
    }
}
