package dev.neovoxel.neobot.adapter;

import lombok.Getter;
import org.graalvm.polyglot.HostAccess;

import java.util.UUID;

@Getter
public abstract class OfflinePlayer {
    private final String name;
    private final UUID uuid;

    protected OfflinePlayer(String name, UUID uuid) {
        this.name = name;
        this.uuid = uuid;
    }

    @HostAccess.Export
    public abstract boolean isOnline();
}
