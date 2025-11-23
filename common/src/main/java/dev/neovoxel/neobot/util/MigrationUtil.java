package dev.neovoxel.neobot.util;

import dev.neovoxel.jarflow.JarFlow;
import dev.neovoxel.jarflow.dependency.Dependency;
import dev.neovoxel.neobot.NeoBot;
import org.json.JSONObject;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

public class MigrationUtil {
    public static void loadLibrary() throws Throwable {
        Dependency snakeYaml = Dependency.builder()
                .groupId("org.yaml")
                .artifactId("snakeyaml")
                .version("2.5")
                .relocate("org.yaml", "dev.neovoxel.libraries.org.yaml")
                .build();
        JarFlow.loadDependency(snakeYaml);
    }

    public static JSONObject parseOriginConfig(NeoBot plugin, String config) throws FileNotFoundException {
        if (plugin.getDataFolder().toPath().resolve("..").resolve("AQQBot").toFile().exists()) {
            File configFile = new File(plugin.getDataFolder().toPath().resolve("..").resolve("AQQBot").toFile(),
                    config + ".yml");
            Yaml yaml = new Yaml();
            Map<String, Object> data = yaml.load(new FileInputStream(configFile));
            return new JSONObject(data);
        } else if (plugin.getDataFolder().toPath().resolve("..").resolve("aqqbot").toFile().exists()) {
            File configFile = new File(plugin.getDataFolder().toPath().resolve("..").resolve("aqqbot").toFile(),
                    config + ".yml");
            Yaml yaml = new Yaml();
            Map<String, Object> data = yaml.load(new FileInputStream(configFile));
            return new JSONObject(data);
        } else return null;
    }
}
