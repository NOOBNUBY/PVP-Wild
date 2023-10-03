package com.noobnuby.plugin.commands

import io.github.monun.kommand.KommandContext
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.entity.Player

object Top {
    fun TopCommandHandler(p: Player) {
        val location = p.location
        val world = p.world
        val highestBlock = world.getHighestBlockAt(location)
        val topLocation = highestBlock.location.add(0.5, 1.0, 0.5).apply {
            yaw = location.yaw
            pitch = location.pitch
        }

        p.teleport(topLocation)
    }
}