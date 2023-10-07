package com.noobnuby.plugin.scoreboard

import com.noobnuby.plugin.Main
import com.noobnuby.plugin.handlers.FarmingTime
import com.noobnuby.plugin.events.Death
import com.noobnuby.plugin.handlers.KillTime
import com.noobnuby.plugin.handlers.Scheduler
import com.noobnuby.plugin.utils.Variable
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.GameMode
import org.bukkit.entity.Player
import org.bukkit.scoreboard.DisplaySlot

class ScoreBorad {
    val scoreboard = Bukkit.getScoreboardManager().newScoreboard
    val plugin = Main.instance
    val objective = scoreboard.registerNewObjective("asdf", "", Component.text("PVP-Wild"))

    fun showScoreboard(player: Player) {
        val farmingTime = FarmingTime
        val killTime = KillTime
        val time = Scheduler
        var numPlayer = 0
        val wb = Bukkit.getWorld("world")?.worldBorder!!

        val wbsize = if(wb.size > 5) wb.size + 1 else wb.size

        val kill = if (Death.killCount[player] == null) 0 else Death.killCount[player]

        Bukkit.getOnlinePlayers().forEach {
            if (it.gameMode == GameMode.SURVIVAL) {
                numPlayer ++
            }
        }

        objective.displaySlot = DisplaySlot.SIDEBAR

        objective.getScore("${ChatColor.YELLOW}===============").score = 10
        objective.getScore("◆ 게임 시간 ▶ ${ChatColor.GREEN}${time.minutes}:${time.seconds}").score = 9
        if (!Variable.isKillTimeStart)
            objective.getScore("◆ 남은 자원시간 ▶ ${ChatColor.GREEN}${farmingTime.minutes}:${farmingTime.seconds}").score = 8
        else
            objective.getScore("◆ 자기장 축소 ▶ ${ChatColor.GREEN}${killTime.minutes}:${killTime.seconds}").score = 8
        objective.getScore("").score = 7
        objective.getScore("⚔ 현재 킬 ▶ ${ChatColor.GREEN}${kill}").score = 6
        objective.getScore("⚔ 남은 플레이어 ▶ ${ChatColor.GREEN}${numPlayer}").score = 5
        objective.getScore(" ").score = 4
        objective.getScore("◆ 자기장 크기 > ${ChatColor.GREEN}${wbsize.toInt()}").score = 3
        objective.getScore("◆ 현재 Y 좌표 > ${ChatColor.GREEN}${player.location.y.toInt()}").score = 2
        objective.getScore("${ChatColor.YELLOW}=============== ").score = 1

        player.scoreboard = scoreboard
    }
}