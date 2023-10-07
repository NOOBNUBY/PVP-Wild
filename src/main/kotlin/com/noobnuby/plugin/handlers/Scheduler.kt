package com.noobnuby.plugin.handlers

import com.noobnuby.plugin.Main
import com.noobnuby.plugin.scoreboard.ScoreBorad
import org.bukkit.Bukkit

object Scheduler {
    val plugin = Main.instance
    var timer = 0
    var minutes: Int = 0
    var seconds: String = "00"

    private var taskId : Int? = null
    fun runScheduler() {
        taskId = Bukkit.getScheduler().runTaskTimer(plugin, Runnable {
            timer++
            minutes = timer / 60
            val sec = timer % 60

            seconds = "$sec".padStart(2, '0')

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