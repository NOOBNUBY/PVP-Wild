package com.noobnuby.plugin.events

import com.noobnuby.plugin.utils.Variable
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.FoodLevelChangeEvent

class PlayerHunger:Listener {
    @EventHandler
    fun onPlayerHunger(e: FoodLevelChangeEvent) {
        if(!Variable.isKillTimeStart) {
            e.isCancelled = true
        }
    }
}