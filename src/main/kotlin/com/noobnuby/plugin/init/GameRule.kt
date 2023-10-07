package com.noobnuby.plugin.init

import org.bukkit.Bukkit
import org.bukkit.GameRule

class GameRule {
    fun setGameRule() {
        val world = Bukkit.getWorld("world")

        world?.time = 1000
        world?.setStorm(false)

        world?.setGameRule(GameRule.DO_DAYLIGHT_CYCLE,false)
        world?.setGameRule(GameRule.DO_WEATHER_CYCLE,false)
        world?.setGameRule(GameRule.DO_IMMEDIATE_RESPAWN,true)
    }
}