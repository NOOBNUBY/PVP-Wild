package com.noobnuby.plugin.scoreboard

import com.noobnuby.plugin.Main
import org.bukkit.Bukkit

object ScoreboardSchedule {
    private var taskId: Int? = null

    fun run() {
        taskId = Bukkit.getScheduler().runTaskTimer(Main.instance, Runnable {
            Bukkit.getOnlinePlayers().forEach { player ->
                ScoreBorad().showScoreboard(player)
            }
        }, 0, 5).taskId
    }

    fun stop() {
        Bukkit.getScheduler().cancelTask(taskId!!)
    }
}