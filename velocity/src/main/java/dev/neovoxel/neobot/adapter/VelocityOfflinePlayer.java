package dev.neovoxel.neobot.adapter;

import com.velocitypowered.api.proxy.ProxyServer;
import com.velocitypowered.api.util.GameProfile;

public class VelocityOfflinePlayer extends OfflinePlayer {
    private final ProxyServer proxyServer;
    private final GameProfile gameProfile;

    public VelocityOfflinePlayer(ProxyServer proxyServer, GameProfile gameProfile) {
        super(gameProfile.getName(), gameProfile.getId());
        this.proxyServer = proxyServer;
        this.gameProfile = gameProfile;
    }

    @Override
    public boolean isOnline() {
        return proxyServer.getPlayer(gameProfile.getId()).isPresent();
    }
}
