package com.maxstudios.kyaniteConsilium.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CommandKyaniteConsilium implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        sender.sendMessage("_________________________________");
        sender.sendMessage("         KYANITECONSILIUM        ");
        sender.sendMessage("            is active            ");
        sender.sendMessage("_________________________________");
        return true;
    }
}
