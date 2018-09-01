package network;

import slotmachineserver.NetData;

public interface HostMessageDelegate {
    void onMessage(NetData n);
}
