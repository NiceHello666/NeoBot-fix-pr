package dev.neovoxel.neobot.adapter;

import net.kyori.adventure.text.Component;

public class VelocityPlayer extends Player {

    private final com.velocitypowered.api.proxy.Player player;

    public VelocityPlayer(com.velocitypowered.api.proxy.Player player) {
        super(player.getUsername(), player.getUniqueId());
        this.player = player;
    }

    @Override
    public void sendMessage(String message) {
        player.sendMessage(Component.text(message));
    }

    @Override
    public void kick(String message) {
        player.disconnect(Component.text(message));
    }

    @Override
    public boolean hasPermission(String node) {
        return player.hasPermission(node);
    }
}
