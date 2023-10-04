package com.noobnuby.plugin.scoreboard

import com.noobnuby.plugin.Main
import com.noobnuby.plugin.WorldBorder.FarmingTime
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.scoreboard.DisplaySlot

class ScoreBorad {
    val scoreboard = Bukkit.getScoreboardManager().newScoreboard
    fun showScoreboard(player: Player) {
        val Time = FarmingTime()
        val objective = scoreboard.registerNewObjective("asdf", "", Component.text("PVP-Wild"))
        objective.displaySlot = DisplaySlot.SIDEBAR


        val score = objective.getScore("${ChatColor.YELLOW}Welcome to our server!")
        score.score = 1

        player.scoreboard = scoreboard
    }
}