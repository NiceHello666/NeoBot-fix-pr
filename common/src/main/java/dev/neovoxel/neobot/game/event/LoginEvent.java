package dev.neovoxel.neobot.game.event;

import lombok.Getter;
import org.graalvm.polyglot.HostAccess;

import java.util.UUID;

@Getter
public abstract class LoginEvent {
    private final String name;
    private final UUID uuid;

    protected LoginEvent(String name, UUID uuid) {
        this.name = name;
        this.uuid = uuid;
    }

    @HostAccess.Export
    public String getName() {
        return name;
    }

    @HostAccess.Export
    public UUID getUuid() {
        return uuid;
    }

    public abstract void disallow(String reason);
}
