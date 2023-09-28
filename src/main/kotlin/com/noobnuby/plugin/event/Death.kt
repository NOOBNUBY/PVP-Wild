package com.noobnuby.plugin.event

import org.bukkit.GameMode
import org.bukkit.Location
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent

class Death: Listener {
    @EventHandler
    fun onDeath(e: PlayerDeathEvent) {
        val p = e.entity

        p.gameMode = GameMode.SPECTATOR
        p.teleport(Location(p.world,0.0,100.0,0.0))
    }
}