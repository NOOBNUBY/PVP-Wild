package com.noobnuby.plugin.commands

import com.noobnuby.plugin.utils.Variable
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit
import io.github.monun.kommand.KommandContext

object Chat {
    fun enableChat(ctx: KommandContext) {
        Bukkit.broadcast(Component.text("채팅이 활성화되었습니다.").color(NamedTextColor.GREEN))
        Variable.ChatEnable = true
    }

    fun disableChat(ctx: KommandContext) {
        Bukkit.broadcast(Component.text("채팅이 비활성화되었습니다.").color(NamedTextColor.RED))
        Variable.ChatEnable = false
    }
}