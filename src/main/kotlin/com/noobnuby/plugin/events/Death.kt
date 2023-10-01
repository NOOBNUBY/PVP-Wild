package com.noobnuby.plugin.events

import net.kyori.adventure.text.Component
import org.bukkit.GameMode
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent

class Death: Listener {
    @EventHandler
    fun onDeath(e: PlayerDeathEvent) {
        val p = e.entity
        val k = p.killer
        p.gameMode = GameMode.SPECTATOR

        if(k != null) {
            e.deathMessage(Component.text("${k.name} 님이 ${p.name} 님을 처치했습니다!"))
        }
    }
}