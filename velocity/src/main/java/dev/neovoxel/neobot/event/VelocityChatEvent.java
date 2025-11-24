package dev.neovoxel.neobot.event;

import com.velocitypowered.api.event.player.PlayerChatEvent;
import dev.neovoxel.neobot.adapter.VelocityPlayer;
import dev.neovoxel.neobot.game.event.ChatEvent;
import org.graalvm.polyglot.HostAccess;

public class VelocityChatEvent extends ChatEvent {
    private final PlayerChatEvent event;

    public VelocityChatEvent(PlayerChatEvent event) {
        super(new VelocityPlayer(event.getPlayer()), event.getMessage());
        this.event = event;
    }

    @HostAccess.Export
    public void disallow() {
        event.setResult(PlayerChatEvent.ChatResult.denied());
    }

}
