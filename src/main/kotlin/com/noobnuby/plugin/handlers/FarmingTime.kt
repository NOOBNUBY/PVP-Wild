package com.noobnuby.plugin.handlers

import com.noobnuby.plugin.Main
import com.noobnuby.plugin.commands.Top
import com.noobnuby.plugin.scoreboard.ScoreBorad
import com.noobnuby.plugin.scoreboard.ScoreboardSchedule
import com.noobnuby.plugin.utils.Variable
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit
import org.bukkit.Bukkit.getServer
import org.bukkit.scheduler.BukkitRunnable

object FarmingTime {
    var timer: Int = 10 //25 * 60
    var minutes: Int = 0
    var seconds: String = "00"

    fun farmingTime() {

        object : BukkitRunnable() {
            override fun run() {
                timer--

                if (timer == 0) {
                    this.cancel()
                    Bukkit.broadcast(Component.text("킬 타임이 시작되었습니다!").color(NamedTextColor.RED))
                    Variable.isKillTimeStart = true
                    for (p in getServer().onlinePlayers) {
                        Top.TopCommandHandler(p)
                    }

                    Main.instance.killTimeHandler.startSchedule()

                    return
                }

                minutes = timer / 60
                var sec = timer % 60

                seconds = "$sec".padStart(2, '0')
                Bukkit.broadcast(Component.text("§a$minutes:$seconds"))
            }
        }.runTaskTimer(Main.instance, 0L, 20L)
    }
}