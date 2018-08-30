/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachineserver;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author johnn
 */
public class NetData implements Serializable {
    private NetType t;
    private List<String> stringList;

    public NetData(NetType t) {
        this.t = t;
    }
    
    public void setStringList(List<String> sL){
        stringList = sL;
    }

    public NetType getType() {
        return t;
    }
    
    
    
    
}

