package com.noobnuby.plugin.init

import com.noobnuby.plugin.Main
import com.sk89q.worldedit.WorldEdit
import com.sk89q.worldedit.bukkit.BukkitAdapter
import com.sk89q.worldedit.extent.clipboard.Clipboard
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats
import com.sk89q.worldedit.function.operation.Operation
import com.sk89q.worldedit.function.operation.Operations
import com.sk89q.worldedit.math.BlockVector3
import com.sk89q.worldedit.session.ClipboardHolder
import org.bukkit.Bukkit
import java.io.File
import java.io.FileInputStream


class Schem {
    fun loadSchem() {
        val file = File(Main.instance.dataFolder, "main.schem")
        val world = BukkitAdapter.adapt(Main.instance.server.getWorld("world"))
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
}