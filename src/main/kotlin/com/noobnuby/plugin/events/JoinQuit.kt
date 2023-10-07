package com.noobnuby.plugin.events

import com.noobnuby.plugin.scoreboard.ScoreBorad
import net.kyori.adventure.text.Component
import org.bukkit.Location
import org.bukkit.attribute.Attribute
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class JoinQuit: Listener {
    @EventHandler
    fun onJoin(e: PlayerJoinEvent) {
        val p = e.player
        val attribute = p.getAttribute(Attribute.GENERIC_ATTACK_SPEED)

        e.joinMessage(Component.text(""))
        p.teleport(Location(p.world,0.0,150.0,0.0))
        e.player.setBedSpawnLocation(Location(p.world,0.0,150.0,0.0),true)
        ScoreBorad().showScoreboard(p)

        attribute?.baseValue = 16.0
    }

    @EventHandler
    fun onQuit(e: PlayerQuitEvent) {
        e.quitMessage(Component.text(""))
    }
}