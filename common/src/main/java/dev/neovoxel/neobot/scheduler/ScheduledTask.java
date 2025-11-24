package dev.neovoxel.neobot.scheduler;

import org.graalvm.polyglot.HostAccess;

public interface ScheduledTask {
    @HostAccess.Export
    void cancel();
}
