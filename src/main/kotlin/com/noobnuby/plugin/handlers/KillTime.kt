package com.noobnuby.plugin.handlers

import com.noobnuby.plugin.Main
import com.noobnuby.plugin.scoreboard.ScoreBorad
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit

object KillTime {
    val plugin = Main.instance
    private var taskId: Int? = null
    var timer = 10 //60 * 2
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
            var sec = timer % 60

            seconds = "$sec".padStart(2, '0')

            Bukkit.broadcast(Component.text("§a${minutes}:${seconds}"))

            when (wb.size) {
                400.0 -> wbSizeMin = 100.0
                100.0 -> wbSizeMin = 50.0
                50.0 -> wbSizeMin = 45.0
                5.0 -> wbSizeMin = 4.0
                1.0 -> stopSchedule()
            }

            if (timer <= 0) {
                wb.setSize(wb.size - wbSizeMin,5)
                timer = 10 //60 * 2
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