package Pelota;

import java.awt.Component;

public class MultipleThreads implements Runnable{
    private final Pelota pelota;
    private final Component componente;
    
    public MultipleThreads(Pelota p, Component comp){
        pelota=p;
        componente=comp;
    }

    @Override
    public void run() {
        
        
        while(!Thread.interrupted()){
            pelota.mueve_pelota(componente.getBounds());
            componente.paint(componente.getGraphics());
            
//            try{
//                Thread.sleep(4);
//            }catch(Exception e){
//                System.out.println("error"+e);
//            }
        }
    }
    
}
