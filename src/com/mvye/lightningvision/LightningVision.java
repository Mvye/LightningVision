package com.mvye.lightningvision;

import com.mvye.lightningvision.commands.ToggleLightningVision;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class LightningVision extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("lightningVision").setExecutor(new ToggleLightningVision(this));
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[LightningVision] Testing");
    }
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[LightningVision]: Plugin is disabled!");
    }
}
