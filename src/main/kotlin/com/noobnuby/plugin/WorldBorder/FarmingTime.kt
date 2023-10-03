package com.noobnuby.plugin.WorldBorder

import com.noobnuby.plugin.Main
import com.noobnuby.plugin.scoreboard.ScoreBorad
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.scoreboard.Score
import kotlin.math.min

class FarmingTime {
    var minutes: Int = 0
    var seconds: Int = 0

    fun farmingTime() {
        var timer: Int = 25 * 60

        object : BukkitRunnable() {
            override fun run() {
                if (timer <= 0) {
                    this.cancel()
                    Bukkit.broadcast(Component.text("stop"))
                    return
                }

                minutes = timer / 60
                seconds = timer % 60

                val formattedSeconds = if (seconds < 10) "0$seconds" else "$seconds"
                Bukkit.broadcast(Component.text("§a$minutes:$formattedSeconds"))

                timer--
            }
        }.runTaskTimer(Main.instance, 0L, 20L)
    }
}