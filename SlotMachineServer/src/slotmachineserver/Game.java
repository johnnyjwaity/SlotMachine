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
    private Client p1;
    private Client p2;
    private int gameID;
    private boolean open = true;

    public Game(Client c, int id) {
        p1 = c;
        gameID = id;
    }
    
}
