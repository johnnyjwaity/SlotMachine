/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachineserver;

/**
 *
 * @author johnn
 */
public class Game {
    private final Client p1;
    private Client p2;
    private final int gameID;
    private boolean open = true;

    public Game(Client c, int id) {
        p1 = c;
        p1.setMyGame(this);
        gameID = id;
    }
    
    public void addClient(Client c){
        p2 = c;
        p2.setMyGame(this);
        open = false;
        p1.sendMessage(new NetData(NetType.PlayerJoined));
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public int getGameID() {
        return gameID;
    }
    
    
    
    
}
