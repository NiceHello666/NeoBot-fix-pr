package dev.neovoxel.neobot.adapter;

import com.velocitypowered.api.command.CommandSource;
import net.kyori.adventure.text.Component;
import org.graalvm.polyglot.HostAccess;

public class VelocityCommandSender extends CommandSender {
    private final CommandSource source;

    public VelocityCommandSender(CommandSource source) {
        super("Velocity/CommandSource");
        this.source = source;
    }

    @HostAccess.Export
    @Override
    public void sendMessage(String message) {
        source.sendMessage(Component.text(message));
    }

    @HostAccess.Export
    @Override
    public boolean hasPermission(String node) {
        return source.hasPermission(node);
    }
}
