/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachineserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johnn
 */
public class Matchmaker {
    
    private ServerSocket serverSocket = null;
    private List<Client> connections = new ArrayList<>();
    private List<Game> games = new ArrayList<>();
    
    public Matchmaker(){
        try {
            serverSocket = new ServerSocket(666);
            System.out.println("Listening On 666");
            lookForConnections();
        } catch (IOException ex) {
            Logger.getLogger(Matchmaker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int addHost(Client c){
        games.add(new Game(c, games.size()));
        return games.size() - 1;
    }
    
    
    
    private void lookForConnections(){
        while(true){
            try {
                Socket s = serverSocket.accept();
                Client c = new Client(s, this);
                connections.add(c);
                System.out.println("Connected");
            } catch (IOException ex) {
                System.out.println("Connection Failed");
            }
            
        }
    }
}
