package com.noobnuby.plugin.events

import com.noobnuby.plugin.Main
import com.noobnuby.plugin.utils.Variable
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent

class Death: Listener {
    companion object {
        val killCount = HashMap<Player, Int>()
        var playersRemaining = 0
    }

    @EventHandler
    fun onDeath(e: PlayerDeathEvent) {

        val p = e.entity
        val k = p.killer

        p.gameMode = GameMode.SPECTATOR

        if (k != null) {
            killCount[k] = killCount.getOrDefault(k,0) + 1
            e.deathMessage(Component.text("§c§l${k.name} §r님이 §d§l${p.name} §r님을 처치했습니다!"))
        }

        playersRemaining = 0
        for (player in Bukkit.getOnlinePlayers()) {
            if (player.gameMode == GameMode.SURVIVAL) {
                playersRemaining++
            }
        }

        if (playersRemaining < 2) {

            Variable.lastStandingPlayer = Bukkit.getOnlinePlayers().filter { it.gameMode == GameMode.SURVIVAL }[0]!!

            Main.instance.gameEndHandler.run()
        }
    }
}