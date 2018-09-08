package network;

import slotmachineserver.NetData;

public interface NetworkDelegate {
    void onHostMessage(NetData n);
    void onJoinMessage(NetData n);
    void onPlayerJoinedMessage(NetData n);
}
