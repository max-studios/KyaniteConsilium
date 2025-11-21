package com.maxstudios.kyaniteConsilium.events;

import com.maxstudios.kyaniteConsilium.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.List;
import java.util.Random;

public class EventPlayerLeave implements Listener {

    private final Main plugin;
    private final Random random = new Random();

    public EventPlayerLeave (Main plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerJoin(PlayerQuitEvent event) {

        boolean active = plugin.getConfig().getBoolean("custom-player-leave-messages.active");

        if (active) {

            List<String> messages = plugin.getConfig().getStringList("custom-player-leave-messages.messages");

            if (messages == null || messages.isEmpty()) {
                //nothing

                return;
            }
            event.setQuitMessage(null);
            int randomIndex = random.nextInt(messages.size());
            String random_message = messages.get(randomIndex);
            Bukkit.broadcastMessage(ChatColor.GRAY + "[" + ChatColor.RED + "-" + ChatColor.GRAY + "] " + ChatColor.YELLOW + event.getPlayer().getName() + " " + random_message);
        }
    }
}
