package com.noobnuby.plugin.init

import com.noobnuby.plugin.Main
import com.sk89q.worldedit.WorldEdit
import com.sk89q.worldedit.bukkit.BukkitAdapter
import com.sk89q.worldedit.extent.clipboard.Clipboard
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats
import com.sk89q.worldedit.function.operation.Operation
import com.sk89q.worldedit.function.operation.Operations
import com.sk89q.worldedit.math.BlockVector3
import com.sk89q.worldedit.regions.CuboidRegion
import com.sk89q.worldedit.session.ClipboardHolder
import com.sk89q.worldedit.world.block.BlockTypes
import org.bukkit.Bukkit
import java.io.File
import java.io.FileInputStream


class Schem {

    private val world = BukkitAdapter.adapt(Main.instance.server.getWorld("world"))

    fun loadSchem() {
        val file = File(Main.instance.dataFolder, "main.schem")
        var clipboard: Clipboard

        try {
            if (!file.exists()) {
                Bukkit.getLogger().severe("main.schem 파일이 data 폴더 내부에 존재하지 않습니다.")
                return
            }

            val format = ClipboardFormats.findByFile(file)
            format!!.getReader(FileInputStream(file)).use { reader -> clipboard = reader.read() }



            WorldEdit.getInstance().newEditSession(world).use { editSession ->
                val operation: Operation = ClipboardHolder(clipboard)
                    .createPaste(editSession)
                    .to(BlockVector3.at(0, 150, 0)) // configure here
                    .build()
                Operations.complete(operation)
            }

            Bukkit.getLogger().info("성공적으로 main.schem을 불러왔습니다!")

        } catch (e: Exception) {
            e.printStackTrace()
            Bukkit.getLogger().severe("Failed to load and paste the schematic.")
        }
    }

    fun deleteSchem() {
        val minPoint = BlockVector3.at(-10.0, 149.0, -10.0)
        val maxPoint = BlockVector3.at(10.0, 159.0, 10.0)
        val regionToClear = CuboidRegion(minPoint, maxPoint)

        WorldEdit.getInstance().newEditSession(world).use { editSession ->
            editSession.setBlocks(regionToClear, BlockTypes.AIR?.defaultState)
        }

        Bukkit.getLogger().info("성공적으로 Schem구조물이 없앴습니다!")
    }
}