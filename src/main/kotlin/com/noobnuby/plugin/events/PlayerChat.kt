package com.noobnuby.plugin.events

import com.noobnuby.plugin.utils.Variable
import io.papermc.paper.event.player.AsyncChatEvent
import org.bukkit.event.Listener

class PlayerChat: Listener {
    fun onPlayerChat(e: AsyncChatEvent) {
        if(Variable().ChatEnable == false) {
            e.isCancelled = false
        }
    }
}