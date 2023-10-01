package com.noobnuby.plugin.events

import com.noobnuby.plugin.utils.Variable
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent

class BreakBlock: Listener {
    @EventHandler
    fun onBreakBlock(e: BlockBreakEvent) {
        if(Variable.isGameStart == false) {
            e.isCancelled = true
        }
    }
}