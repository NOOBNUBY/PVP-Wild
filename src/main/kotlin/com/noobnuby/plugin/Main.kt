package com.noobnuby.plugin

import com.noobnuby.plugin.AutoSmelt.OreBreak
import com.noobnuby.plugin.events.*
import com.noobnuby.plugin.init.Schem
import com.noobnuby.plugin.utils.SetUpKommand
import io.github.monun.kommand.kommand
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    companion object {
        lateinit var instance: Main
            private set
    }

    //TODO : 스코어보드
    //TODO : 명령어 방지
    //TODO : 몹 스폰 방지 이벤트 개선
    //TODO : 인첸트 테이블 청금석 없이도 되게
    //TODO : 공속제거
    override fun onEnable() {
        instance = this
        logger.info("Enable plugin!")
        saveResource("main.schem", false)

        server.pluginManager.apply {
            registerEvents(JoinQuit(), this@Main)
            registerEvents(Death(), this@Main)
            registerEvents(BreakBlock(), this@Main)
            registerEvents(MobSpawn(), this@Main)
            registerEvents(WeatherChange(), this@Main)
            registerEvents(BlockOnPlace(), this@Main)
            registerEvents(PlayerChat(), this@Main)
            registerEvents(OreBreak(),this@Main)
            registerEvents(PlayerDamage(),this@Main)
            registerEvents(PlayerHunger(),this@Main)
            registerEvents(DayChange(),this@Main)
            registerEvents(EnchantTable(),this@Main)
        }

        Schem().loadSchem()
        SetUpKommand.setupKommand()
    }
}