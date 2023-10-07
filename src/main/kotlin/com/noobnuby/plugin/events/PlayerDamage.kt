package com.noobnuby.plugin.events

import com.noobnuby.plugin.utils.Variable
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageEvent

class PlayerDamage:Listener {
    @EventHandler
    fun onPlayerDamage(e: EntityDamageEvent) {
        if(e.entity is Player) {
            if(!Variable.isKillTimeStart) {
                e.isCancelled = true
            }
        }
    }
}