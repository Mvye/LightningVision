package com.mvye.lightningvision.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class LightningVisionEvents implements Listener {
    private static Plugin plugin;

    public LightningVisionEvents(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public static void onPlayerLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if (player.hasMetadata("lightningVision")) {
            player.removeMetadata("lightningVision", plugin);
        }
    }
}
