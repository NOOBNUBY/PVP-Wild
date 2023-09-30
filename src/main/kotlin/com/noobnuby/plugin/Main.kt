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

//    private fun loadSchematicAtLocation() {
//        val file = File(dataFolder, "main.schem")
//        val bukkitWorld = server.getWorld("world") // Bukkit's world object
//
//        if (!file.exists()) {
//            logger.info("main.schem 파일이 data 폴더 내부에 존재하지 않습니다.")
//            return
//        }
//
//        try {
//            val format = ClipboardFormats.findByFile(file)
//
//            if (format == null) {
//                logger.severe("Unable to determine the format of the schematic file.")
//                return
//            }
//
//            var clipboard: Clipboard? = null
//
//            FileInputStream(file).use { fis ->
//                val reader = format.getReader(fis)
//                clipboard = reader.read()
//            }
//
//            // Convert Bukkit's world to WorldEdit's world.
//            val worldEditWorld = BukkitAdapter.adapt(bukkitWorld)
//
//            WorldEdit.getInstance().newEditSession(worldEditWorld).use { editSession ->
//                val operation: Operation = ClipboardHolder(clipboard)
//                    .createPaste(editSession)
//                    .to(BlockVector3.at(0.0, 150.0, 0.0))
//                    .ignoreAirBlocks(false)
//                    .build()
//
//                Operations.complete(operation)
//            }
//
//            logger.info("Schematic was successfully pasted at the location.")
//
//        } catch (e: Exception) {
//            e.printStackTrace()
//            logger.severe("Failed to load and paste the schematic.")
//        }
//    }
//
//    private fun removeSchematicAtLocation() {
//        val bukkitWorld = server.getWorld("world") // Bukkit's world object
//
//        // Convert Bukkit's world to WorldEdit's world.
//        val worldEditWorld = BukkitAdapter.adapt(bukkitWorld)
//
//        // Define the region you want to clear.
//        // This should be the same size and in the same location as your pasted schematic.
//        val minPoint = BlockVector3.at(0.0, 80.0, 0.0)
//        val maxPoint = BlockVector3.at(10.0, 90.0, 10.0)
//        val regionToClear = CuboidRegion(minPoint, maxPoint)
//
//        WorldEdit.getInstance().newEditSession(worldEditWorld).use { editSession ->
//            editSession.setBlocks(regionToClear, BlockTypes.AIR?.defaultState)
//        }
//
//        logger.info("Schematic area was successfully cleared.")
//    }
}