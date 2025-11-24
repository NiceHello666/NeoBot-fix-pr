package dev.neovoxel.neobot.adapter;

import org.graalvm.polyglot.HostAccess;

public interface RemoteExecutor {
    @HostAccess.Export
    boolean init();
    @HostAccess.Export
    void execute(String command);
    @HostAccess.Export
    String getResult();
}
