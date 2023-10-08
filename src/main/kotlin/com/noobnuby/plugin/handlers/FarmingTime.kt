package com.noobnuby.plugin.handlers

import com.noobnuby.plugin.Main
import com.noobnuby.plugin.commands.Top
import com.noobnuby.plugin.utils.Variable
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit
import org.bukkit.Sound
import java.time.Duration

object FarmingTime {
    val plugin = Main.instance
    var timer: Int = 25 * 60
    var minutes: Int = 0
    var seconds: String = "00"
    private var taskId: Int? = null

    fun startSchedule() {
        taskId = Bukkit.getScheduler().runTaskTimer(this.plugin, Runnable {
            if (timer <= 0) {
                stopSchedule()
                Bukkit.broadcast(Component.text("킬 타임이 시작되었습니다!").color(NamedTextColor.RED))
                Variable.isKillTimeStart = true

                Bukkit.getOnlinePlayers().forEach {
                    Top.TopCommandHandler(it)
                    it.playSound(it.location, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5f, 1f)
                    it.showTitle(net.kyori.adventure.title.Title.title(Component.text("킬타임 시작!").color(NamedTextColor.RED),Component.empty(),
                        net.kyori.adventure.title.Title.Times.of(Duration.ofMillis(500), Duration.ofSeconds(1), Duration.ofMillis(500))))
                }
                Scheduler.stopScheduler()
                Main.instance.killTimeHandler.startSchedule()
                Scheduler.runScheduler()
            }

            timer--

            minutes = timer / 60
            val sec = timer % 60

            seconds = "$sec".padStart(2, '0')
        }, 0, 20).taskId
    }

    fun stopSchedule() {
        if (taskId != null) {
            Bukkit.getScheduler().cancelTask(taskId!!)

            taskId = null
        }
    }
}