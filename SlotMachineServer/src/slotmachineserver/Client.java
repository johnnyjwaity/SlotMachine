/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachineserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johnn
 */
public class Client{
    
    private Socket s;
    private Listener listener;
    
    public Client(Socket s){
        listener = new Listener(s, this);
        this.s = s;
        Thread t = new Thread(listener);
        t.start();
    }

    
    public void sendMessage(NetData d){
        try {
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            out.writeObject(d);
            out.flush();
        } catch (IOException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }
    
    public void proccessMessage(NetData n){
        System.out.println(n.getType());
    }
    
    
}
class Listener implements Runnable{
    
    private Socket s;
    private Client c;

    public Listener(Socket s, Client c) {
        this.s = s;
        this.c = c;
    }
    
    
    
    @Override
    public void run() {
        listen();
    }
    
    private void listen(){
        try {
            while(true){
                ObjectInputStream stream = new ObjectInputStream(s.getInputStream());
                NetData input = (NetData) stream.readObject();
                c.proccessMessage(input);
            }
        } catch (IOException ex) {
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}