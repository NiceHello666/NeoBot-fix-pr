package dev.neovoxel.neobot.adapter;

import com.velocitypowered.api.command.CommandManager;
import com.velocitypowered.api.command.CommandMeta;
import com.velocitypowered.api.command.SimpleCommand;
import dev.neovoxel.neobot.command.CommandProvider;
import dev.neovoxel.neobot.NeoBotVelocity;

public class VelocityCommandProvider extends CommandProvider implements SimpleCommand {
    private final NeoBotVelocity plugin;

    public VelocityCommandProvider(NeoBotVelocity plugin) {
        super(plugin);
        this.plugin = plugin;
    }

    @Override
    public void execute(Invocation invocation) {
        this.onCommand(new VelocityCommandSender(invocation.source()), invocation.arguments());
    }

    @Override
    public void registerCommand() {
        CommandManager commandManager = plugin.getProxyServer().getCommandManager();
        CommandMeta commandMeta = commandManager.metaBuilder("neobot").plugin(plugin).build();
        commandManager.register(commandMeta, this);
    }
}
