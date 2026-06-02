package com.maxstudios.kyaniteConsilium.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class CommandAboutKyanite : CommandExecutor {
    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String?>
    ): Boolean {
        sender.sendMessage("[Kyanite] visit me on GitHub: max-studios!")
        return true
    }
}