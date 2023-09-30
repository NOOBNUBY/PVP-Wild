package com.noobnuby.plugin.command

import net.kyori.adventure.text.Component
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class Start:CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if(command.equals("start")) {
            if(sender is Player) {
                val p:Player = sender
                p.sendMessage(Component.text("start game!"))
            }
        }
        return true
    }
}