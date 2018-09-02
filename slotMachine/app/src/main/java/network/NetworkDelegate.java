package network;

import slotmachineserver.NetData;

public interface NetworkDelegate {
    void onHostMessage(NetData n);
}
