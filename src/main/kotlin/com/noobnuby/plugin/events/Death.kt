package com.noobnuby.plugin.events

import org.bukkit.GameMode
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent

class Death: Listener {
    @EventHandler
    fun onDeath(e: PlayerDeathEvent) {
        val p = e.entity
        p.gameMode = GameMode.SPECTATOR
    }
}