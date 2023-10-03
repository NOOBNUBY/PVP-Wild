package com.noobnuby.plugin.utils

import com.noobnuby.plugin.Main
import com.noobnuby.plugin.commands.Start
import com.noobnuby.plugin.commands.Chat
import com.noobnuby.plugin.commands.Top
import io.github.monun.kommand.argument.TargetArgument.Companion.player
import io.github.monun.kommand.kommand
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextColor
import org.bukkit.entity.Player

object SetUpKommand {
    fun setupKommand() {
        val plugin = Main.instance

        plugin.kommand {
            register("chat") {
                require { it.isOp }
                then("enable") {
                    executes { Chat.enableChat(it) }
                }
                then("disable") {
                    executes { Chat.disableChat(it) }
                }
            }

            register("start") {
                require { it.isOp }
                executes { Start.startCommandHandler(it) }
            }

            register("top") {
                executes {
                    val player = it.sender as Player
                    it.sender.sendMessage(Component.text("지상으로 이동하였습니다.").color(NamedTextColor.YELLOW))
                    Top.TopCommandHandler(player)
                }
            }
        }
    }
}