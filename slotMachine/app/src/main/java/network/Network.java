package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import slotmachineserver.NetData;
import slotmachineserver.NetType;

public class Network implements Runnable {

    private String server;
    private int port;
    private Socket s;
    private Listener listener;

    private NetworkDelegate networkDelegate;

    public static Network sharedInstance;


    public Network(String server, int port){
        this.server = server;
        this.port = port;
        sharedInstance = this;
    }

    public void sendMessage(NetData data){
        Thread t = new Thread(new Send(data, s));
        t.start();

    }

    public void interpretData(NetData d){
        if(d.getType() == NetType.Host){
            if(networkDelegate != null){
                networkDelegate.onHostMessage(d);
            }
        }
        else if (d.getType() == NetType.Join) {
            if(networkDelegate != null){
                networkDelegate.onJoinMessage(d);
            }
        }


    }


    @Override
    public void run() {
        try{
            s = new Socket(server, port);
            listener = new Listener(s);
            Thread t = new Thread(listener);
            t.start();

        }catch (IOException ex){
            System.out.println(ex.getLocalizedMessage());
        }
    }


    public NetworkDelegate getNetworkDelegate() {
        return networkDelegate;
    }

    public void setNetworkDelegate(NetworkDelegate networkDelegate) {
        this.networkDelegate = networkDelegate;
    }
}

class Send implements Runnable{

    private NetData msg;
    private Socket s;

    public Send(NetData msg, Socket s){
        this.msg = msg;
        this.s = s;
    }

    @Override
    public void run() {
        try{
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            out.writeObject(msg);
            out.flush();
        }catch(IOException ex){
            System.out.println(ex.getLocalizedMessage());
        }
    }
}

class Listener implements Runnable {

    private Socket s;

    public Listener(Socket s){
        this.s = s;
    }

    @Override
    public void run() {
        listen();
    }

    private void listen(){
        while(true){
            try{
                ObjectInputStream in = new ObjectInputStream(s.getInputStream());
                NetData msg = (NetData) in.readObject();
                Network.sharedInstance.interpretData(msg);
            }catch (IOException ex){
                System.out.println(ex.getLocalizedMessage());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
