package com.noobnuby.plugin.events

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntitySpawnEvent

class MobSpawn: Listener {
    @EventHandler
    fun doMobSpawning(e: EntitySpawnEvent) {
        e.isCancelled = true
    }
}