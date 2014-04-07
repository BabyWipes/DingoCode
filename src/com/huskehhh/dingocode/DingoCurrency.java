package com.huskehhh.dingocode;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class DingoCurrency extends JavaPlugin {

    YamlConfiguration config = YamlConfiguration.loadConfiguration(new File("plugins/DingoCurrency/config.yml"));

    public void onEnable() {
        createConfig();
    }

    private void createConfig() {
        boolean exists = new File("plugins/DingoCurrency/config.yml").exists();
        if (!exists) {
            new File("plugins/iChat").mkdir();
            config.options().header("DingoCurrency, made by Husky!");
            config.set("MySQL.host", "localhost");
            config.set("MySQL.port", "3306");
            config.set("MySQL.user", "root");
            config.set("MySQL.password", "root");
            config.set("MySQL.database", "database");
            try {
                config.save("plugins/DingoCurrency/config.yml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
