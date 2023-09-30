package com.noobnuby.plugin.events

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.weather.WeatherChangeEvent
import org.bukkit.event.world.TimeSkipEvent

class WeatherChange: Listener {
    @EventHandler
    fun onWeatherChange(e: WeatherChangeEvent) {
        e.isCancelled = true
    }
}