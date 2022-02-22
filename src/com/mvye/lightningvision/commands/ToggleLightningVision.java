package com.mvye.lightningvision.commands;

import com.mvye.lightningvision.tasks.LightningVisionTask;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ToggleLightningVision implements CommandExecutor {
    private static Plugin plugin;

    public ToggleLightningVision(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!(sender instanceof Player))
            return true;
        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("lightningVision")) {
            if (player.hasMetadata("lightningVision")) {
                player.removeMetadata("lightningVision", plugin);
                player.sendMessage(ChatColor.GOLD + "DEACTIVATING LIGHTING VISION");
            }
            else {
                player.setMetadata("lightningVision", new FixedMetadataValue(plugin, 0));
                new LightningVisionTask(plugin, player).runTaskTimer(plugin, 0, 10);
                player.sendMessage(ChatColor.GOLD + "ACTIVATING LIGHTNING VISION");
            }
        }
        return false;
    }
}
