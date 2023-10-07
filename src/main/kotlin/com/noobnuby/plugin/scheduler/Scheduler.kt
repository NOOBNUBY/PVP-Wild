package com.noobnuby.plugin.scheduler

import com.noobnuby.plugin.Main
import com.noobnuby.plugin.handlers.FarmingTime
import com.noobnuby.plugin.handlers.KillTime
import com.noobnuby.plugin.scoreboard.ScoreBorad
import org.bukkit.Bukkit

class Scheduler() {
    val plugin = Main.instance

    private var taskId : Int? = null
    fun runScheduler() {
        taskId = Bukkit.getScheduler().runTaskTimer(this.plugin, Runnable {
            Bukkit.getOnlinePlayers().forEach {
                ScoreBorad().showScoreboard(it)
            }
        },0,20).taskId
    }

    fun stopScheduler() {
        if (taskId != null) {
            Bukkit.getScheduler().cancelTask(taskId!!)

            taskId = null
        }
    }
}