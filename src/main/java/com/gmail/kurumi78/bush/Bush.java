package com.gmail.kurumi78.bush;

import com.gmail.kurumi78.bush.events.BushClick;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Bush extends JavaPlugin {

    @Override
    public void onEnable() {

        Bukkit.getPluginManager().registerEvents(new BushClick(), this);
        int pluginId = 9172; // <-- Replace with the id of your plugin!
        Metrics metrics = new Metrics(this, pluginId);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
