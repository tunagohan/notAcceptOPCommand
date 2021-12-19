package com.tunagohan.plugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class ExampleSelfCancelingTask extends BukkitRunnable {

    private final JavaPlugin plugin;

    private int counter;

    public ExampleSelfCancelingTask(JavaPlugin plugin, int counter) {
        this.plugin = plugin;
        if (counter < 1) {
            throw new IllegalArgumentException("counter には1以上を指定してください。");
        } else {
            this.counter = counter;
        }
    }

    @Override
    public void run() {
        // ここに、スケジュールの処理内容を実装します。
        if (counter < 0) {
            for(Player player : Bukkit.getOnlinePlayers()){
                if(player.isOp()) {
                    plugin.getLogger().warning(player.getDisplayName() + "is OP");
                    player.setOp(false);
                    plugin.getLogger().warning(player.getDisplayName() + "OP Disabled");
                }
            }
        } else {
            counter--;
        }
    }
}
