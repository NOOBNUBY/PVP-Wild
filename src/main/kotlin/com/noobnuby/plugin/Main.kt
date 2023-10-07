package com.noobnuby.plugin

import com.noobnuby.plugin.AutoSmelt.OreBreak
import com.noobnuby.plugin.events.*
import com.noobnuby.plugin.handlers.GameEnd
import com.noobnuby.plugin.init.Schem
import com.noobnuby.plugin.init.GameRule
import com.noobnuby.plugin.utils.SetUpKommand
import com.noobnuby.plugin.handlers.KillTime
import com.noobnuby.plugin.scheduler.Scheduler
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    companion object {
        lateinit var instance: Main
            private set
    }

    lateinit var killTimeHandler: KillTime
    lateinit var Scheduler: Scheduler
    lateinit var gameEndHandler: GameEnd

    //TODO : 명령어 방지
    override fun onEnable() {
        instance = this
        killTimeHandler = KillTime
        gameEndHandler = GameEnd()
        Scheduler = Scheduler()

        logger.info("Enable plugin!")
        saveResource("main.schem", false)

        server.pluginManager.apply {
            registerEvents(JoinQuit(), this@Main)
            registerEvents(Death(), this@Main)
            registerEvents(BreakBlock(), this@Main)
            registerEvents(BlockOnPlace(), this@Main)
            registerEvents(PlayerChat(), this@Main)
            registerEvents(OreBreak(),this@Main)
            registerEvents(PlayerDamage(),this@Main)
            registerEvents(PlayerHunger(),this@Main)
            registerEvents(EnchantTable(),this@Main)
        }

        GameRule().setGameRule()
        Schem().loadSchem()
        SetUpKommand.setupKommand()
    }
}