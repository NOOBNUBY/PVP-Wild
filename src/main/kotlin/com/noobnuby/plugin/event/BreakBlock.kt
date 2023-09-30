package com.noobnuby.plugin.event

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent

class BreakBlock: Listener {
    @EventHandler
    fun onBreakBlock(e: BlockBreakEvent) {
        e.isCancelled = true
    }
}