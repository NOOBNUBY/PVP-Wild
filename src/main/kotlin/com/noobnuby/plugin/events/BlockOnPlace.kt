package com.noobnuby.plugin.events

import org.bukkit.Sound
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent

class BlockOnPlace: Listener {
    @EventHandler
    fun onBlockPlace(e: BlockPlaceEvent) {
        if(e.blockPlaced.location.y >= 100) {
            e.isCancelled = true
            e.player.playSound(e.player.location, Sound.ENTITY_ENDERMAN_TELEPORT, 0.5f, 1f)
            e.player.sendMessage(Component.text("Y 좌표 100 이상에서는 블럭을 설치할 수 없습니다.").color(NamedTextColor.RED))
        }
    }
}