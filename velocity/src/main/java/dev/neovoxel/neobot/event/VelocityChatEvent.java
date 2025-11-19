package dev.neovoxel.neobot.event;

import com.velocitypowered.api.event.player.PlayerChatEvent;
import dev.neovoxel.neobot.adapter.VelocityPlayer;
import dev.neovoxel.neobot.game.event.ChatEvent;

public class VelocityChatEvent extends ChatEvent {
    private final PlayerChatEvent event;

    public VelocityChatEvent(PlayerChatEvent event) {
        super(new VelocityPlayer(event.getPlayer()), event.getMessage());
        this.event = event;
    }

    public void disallow() {
        event.setResult(PlayerChatEvent.ChatResult.denied());
    }

}
