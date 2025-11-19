package dev.neovoxel.neobot.adapter;

import com.velocitypowered.api.command.CommandSource;
import net.kyori.adventure.text.Component;

public class VelocityCommandSender extends CommandSender {
    private final CommandSource source;

    public VelocityCommandSender(CommandSource source) {
        super("Velocity/CommandSource");
        this.source = source;
    }


    @Override
    public void sendMessage(String message) {
        source.sendMessage(Component.text(message));
    }

    @Override
    public boolean hasPermission(String node) {
        return source.hasPermission(node);
    }
}
