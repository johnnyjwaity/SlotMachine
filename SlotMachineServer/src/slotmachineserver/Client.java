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
    private Matchmaker m;
    private Game myGame;
    
    public Client(Socket s, Matchmaker m){
        listener = new Listener(s, this);
        this.s = s;
        this.m = m;
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
        switch(n.getType()){
            case Host:
                int id = m.addHost(this);
                NetData d = new NetData(NetType.Host);
                d.setiData(id);
                sendMessage(d);
                break;
            case Join:
                Game g = m.findOpenGame(n.getiData());
                if(g != null){
                    g.addClient(this);
                    NetData j = new NetData(NetType.Join);
                    j.setiData(1);
                    sendMessage(j);
                }
        }
    }

    public void setMyGame(Game myGame) {
        this.myGame = myGame;
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