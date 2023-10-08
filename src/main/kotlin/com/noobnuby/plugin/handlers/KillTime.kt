package com.noobnuby.plugin.handlers

import com.noobnuby.plugin.Main
import com.noobnuby.plugin.scoreboard.ScoreBorad
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.ChatColor

object KillTime {
    val plugin = Main.instance
    private var taskId: Int? = null
    val initTimer = 60 * 2
    var timer = initTimer
    var minutes: Int = 0
    var seconds: String = "00"

    fun startSchedule() {
        taskId = Bukkit.getScheduler().runTaskTimer(this.plugin, Runnable {
            var world = Bukkit.getWorld("world")
            var wbSizeMin = 200.0

            if (world == null) {
                world = Bukkit.getWorlds().filter { it.doesBedWork() }[0]!!
            }

            timer--

            val wb = world.worldBorder
            minutes  = timer / 60
            val sec = timer % 60

            seconds = "$sec".padStart(2, '0')

            when (wb.size) {
                399.0 -> wbSizeMin = 100.0
                99.0 -> wbSizeMin = 50.0
                49.0 -> wbSizeMin = 44.0
                5.0 -> wbSizeMin = 4.0
                1.0 -> stopSchedule()
            }

            if (timer <= 0) {
                wb.setSize(wb.size - wbSizeMin,30)
                timer = initTimer
            }
        }, 0, 20).taskId // 2 minutes
    }

    fun stopSchedule() {
        if (taskId != null) {
            Bukkit.getScheduler().cancelTask(taskId!!)

            taskId = null
        }
    }
}