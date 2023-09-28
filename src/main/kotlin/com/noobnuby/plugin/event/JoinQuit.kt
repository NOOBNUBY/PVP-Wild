package com.noobnuby.plugin.event

import org.bukkit.Location
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class JoinQuit: Listener {
    @EventHandler
    fun onJoin(e: PlayerJoinEvent) {
        val p = e.player
        e.joinMessage()
        p.teleport(Location(p.world,0.0,80.0,0.0))
    }

    @EventHandler
    fun onQuit(e: PlayerQuitEvent) {
        e.quitMessage()
    }
}