package com.mvye.lightningvision.tasks;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashSet;

public class LightningVisionTask extends BukkitRunnable {
    private static Plugin plugin;
    private Player player;

    private HashSet<Material> transparent;

    public LightningVisionTask(Plugin plugin, Player player) {
        this.plugin = plugin;
        this.player = player;
        transparent = new HashSet<Material>();
        transparent.add(Material.AIR);
    }

    @Override
    public void run() {
        if (!player.hasMetadata("lightningVision")) {
            this.cancel();
        }
        else {
            player.getWorld().strikeLightningEffect(player.getTargetBlock(transparent, 50).getLocation());
        }
    }
}
