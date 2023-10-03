package com.noobnuby.plugin.events

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.world.TimeSkipEvent

class DayChange:Listener {
    @EventHandler
    fun onDayChange(e: TimeSkipEvent) {
        e.isCancelled = true
    }
}