package com.noobnuby.plugin

import com.noobnuby.plugin.event.Death
import com.noobnuby.plugin.event.JoinQuit
import org.bukkit.plugin.java.JavaPlugin

class Main:JavaPlugin() {
    override fun onEnable() {
        logger.info("Enable plugin!")
        server.pluginManager.apply {
            registerEvents(JoinQuit(),this@Main)
            registerEvents(Death(),this@Main)
        }
    }
}