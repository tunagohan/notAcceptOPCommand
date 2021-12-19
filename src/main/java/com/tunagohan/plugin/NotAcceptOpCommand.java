package com.tunagohan.plugin;
// NotAcceptOpCommand

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class NotAcceptOpCommand extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        // スケジューリングする
        new ExampleSelfCancelingTask(this, 60).runTaskTimer(this, 10, 20);
    }
}

