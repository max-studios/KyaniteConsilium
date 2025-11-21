package com.maxstudios.kyaniteConsilium.events;


import com.maxstudios.kyaniteConsilium.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;
import java.util.Random;


public class EventPlayerJoin implements Listener {

    private final Main plugin;
    private final Random random = new Random();

    public EventPlayerJoin (Main plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        boolean active_cpj = plugin.getConfig().getBoolean("custom-player-join-messages.active");
        boolean active_fpm = plugin.getConfig().getBoolean("first-player-join-message.active");


        // _____________________________________________________ Custom Player Join
        if (active_cpj) {

            List<String> messages = plugin.getConfig().getStringList("custom-player-join-messages.messages");
            if (messages == null || messages.isEmpty()) {
                //nothing

                return;
            }
            event.setJoinMessage(null);
            int randomIndex = random.nextInt(messages.size());
            String random_message = messages.get(randomIndex);
            Bukkit.broadcastMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] " + ChatColor.YELLOW + event.getPlayer().getName() + " " + random_message);
        }
        // _____________________________________________________ First Player Join Message
        if (active_fpm) {
            if (!event.getPlayer().hasPlayedBefore()) {

                String message = plugin.getConfig().getString("first-player-join-message.message");
                if (message == null || message.isEmpty()) {
                    //nothing

                    return;
                }
                Bukkit.broadcastMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] " + ChatColor.YELLOW + event.getPlayer().getName() + " " + message);
            }
        }
        // _____________________________________________________
    }
}
