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
            e.deathMessage(Component.text("§c§l${k.name} §r님이 §d§l${p.name} §r님을 처치했습니다!"))
        }
    }
}