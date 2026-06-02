package com.maxstudios.kyaniteConsilium;

import com.maxstudios.kyaniteConsilium.commands.CommandAboutKyanite;
import com.maxstudios.kyaniteConsilium.commands.CommandClock;
import com.maxstudios.kyaniteConsilium.commands.CommandKyaniteConsilium;
import com.maxstudios.kyaniteConsilium.events.EventPlayerJoin;
import com.maxstudios.kyaniteConsilium.events.EventPlayerLeave;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.saveDefaultConfig();
        register();
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + "KyaniteConsilium is loaded successfully!");
    }

    private void register() {
        //_____________________________________________________________________________________________EVENTS
        getServer().getPluginManager().registerEvents(new EventPlayerJoin(this), this);
        getServer().getPluginManager().registerEvents(new EventPlayerLeave(this), this);
        //_____________________________________________________________________________________________COMMANDS
        this.getCommand("kyaniteconsilium").setExecutor(new CommandKyaniteConsilium());
        this.getCommand("clock").setExecutor(new CommandClock());
        this.getCommand("about").setExecutor(new CommandAboutKyanite());
        //_____________________________________________________________________________________________
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + "KyaniteConsilium is disabled successfully!");
    }


}
