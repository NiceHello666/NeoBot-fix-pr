package dev.neovoxel.neobot.adapter.executor;

import dev.neovoxel.neobot.adapter.RemoteExecutor;
import dev.neovoxel.neobot.util.ReflectionUtil;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.graalvm.polyglot.HostAccess;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DedicatedExecutor implements RemoteExecutor {

    private Object dedicatedClass;
    private Method method;
    private String message = "";

    @HostAccess.Export
    @Override
    public boolean init() {
        try {
            Server server = Bukkit.getServer();
            dedicatedClass = ReflectionUtil.findFieldByType(server, "DedicatedServer");
            if (dedicatedClass == null) return false;
            method = dedicatedClass.getClass().getMethod("runCommand", String.class);
            return true;
        } catch (Exception ignored) {}
        return false;
    }

    @HostAccess.Export
    @Override
    public void execute(String command) {
        try {
            message = (String) method.invoke(dedicatedClass, command);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @HostAccess.Export
    @Override
    public String getResult() {
        return message;
    }
}
