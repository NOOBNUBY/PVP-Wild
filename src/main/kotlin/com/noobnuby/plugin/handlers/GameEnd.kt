package com.noobnuby.plugin.handlers

import com.noobnuby.plugin.Main
import com.noobnuby.plugin.scoreboard.ScoreboardSchedule
import com.noobnuby.plugin.utils.Variable
import net.kyori.adventure.title.Title
import org.bukkit.Bukkit
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.ChatColor
import org.bukkit.Sound

class GameEnd {
    val plugin = Main.instance

    fun run() {
        ScoreboardSchedule.stop()
        plugin.killTimeHandler.stopSchedule()

        Bukkit.getOnlinePlayers().forEach {
            it.playSound(it.location, Sound.UI_TOAST_CHALLENGE_COMPLETE, 0.5f, 1f)
            it.showTitle(
                Title.title(
                    Component.text("게임 끝!").color(NamedTextColor.RED), // Title
                    Component.text(Variable.lastStandingPlayer!!.name)
                        .color(NamedTextColor.YELLOW)
                        .append(
                            Component.text("(이)가 승리했습니다!").color(NamedTextColor.WHITE)
                        ) // Subtitle
                )
            )
        }

        Variable.lastStandingPlayer = null
    }
}