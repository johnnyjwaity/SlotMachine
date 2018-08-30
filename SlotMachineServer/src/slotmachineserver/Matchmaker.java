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
    private Map<String, Client> openHosts = new HashMap<>();
    
    public Matchmaker(){
        try {
            serverSocket = new ServerSocket(666);
            System.out.println("Listening On 666");
            lookForConnections();
        } catch (IOException ex) {
            Logger.getLogger(Matchmaker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addHost(Client c, String name){
        openHosts.put(name, c);
    }
    
    public NetData getHostNames(){
        NetData n = new NetData(NetType.CurrentHosts);
        List<String> names = new ArrayList<>();
        for(String name : openHosts.keySet()){
            names.add(name);
        }
        n.setStringList(names);
        return n;
    }
    
    private void lookForConnections(){
        while(true){
            try {
                Socket s = serverSocket.accept();
                Client c = new Client(s);
                connections.add(c);
                System.out.println("Connected");
            } catch (IOException ex) {
                System.out.println("Connection Failed");
            }
            
        }
    }
}
