package com.noobnuby.plugin.events

import com.noobnuby.plugin.utils.Variable
import org.bukkit.event.Listener
import org.bukkit.event.entity.FoodLevelChangeEvent

class PlayerHunger:Listener {
    fun onPlayerHunger(e: FoodLevelChangeEvent) {
        if(Variable.isKillTimeStart == false) {
            e.isCancelled = true
        }
    }
}