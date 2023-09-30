package com.noobnuby.plugin

import com.noobnuby.plugin.command.Start
import com.noobnuby.plugin.event.BreakBlock
import com.noobnuby.plugin.event.Death
import com.noobnuby.plugin.event.JoinQuit
import com.noobnuby.plugin.init.Schem
import com.sk89q.worldedit.WorldEdit
import com.sk89q.worldedit.bukkit.BukkitAdapter
import com.sk89q.worldedit.extent.clipboard.Clipboard
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats
import com.sk89q.worldedit.function.operation.Operation;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.math.BlockVector3
import com.sk89q.worldedit.regions.CuboidRegion
import com.sk89q.worldedit.session.ClipboardHolder
import com.sk89q.worldedit.world.block.BlockTypes
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.io.FileInputStream

class Main:JavaPlugin() {
    companion object {
        lateinit var instance: Main
            private set
    }

    //TODO : 몹 스폰 방지
    //TODO : 스코어보드
    //TODO : 킬로그
    override fun onEnable() {
        instance = this
        logger.info("Enable plugin!")
        saveResource("main.schem", false)

        server.pluginManager.apply {
            registerEvents(JoinQuit(),this@Main)
            registerEvents(Death(),this@Main)
            registerEvents(BreakBlock(),this@Main)
            getCommand("start")?.setExecutor(Start())
        }

        Schem().loadSchem()
    }
}