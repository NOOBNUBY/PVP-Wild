package com.noobnuby.plugin.events

import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntitySpawnEvent

class MobSpawn: Listener {
    @EventHandler
    fun doMobSpawning(e: EntitySpawnEvent) {
        if (e.entityType == EntityType.DROPPED_ITEM) return
        e.isCancelled = true
    }
}