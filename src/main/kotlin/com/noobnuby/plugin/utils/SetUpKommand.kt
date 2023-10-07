package com.noobnuby.plugin.utils

import com.noobnuby.plugin.Main
import com.noobnuby.plugin.commands.Start
import com.noobnuby.plugin.commands.Chat
import com.noobnuby.plugin.commands.Top
import com.noobnuby.plugin.events.Death
import io.github.monun.kommand.kommand
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Sound
import org.bukkit.entity.Player

object SetUpKommand {
    fun setupKommand() {
        val plugin = Main.instance
        val TopCommandData = HashMap<Player, Boolean>()

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

                    if (!TopCommandData.containsKey(player)) {
                        TopCommandData[player] = true
                        player.sendMessage(Component.text("지상으로 이동하였습니다.").color(NamedTextColor.YELLOW))
                        Top.TopCommandHandler(player)
                    } else {
                        player.playSound(player.location,Sound.ENTITY_ENDERMAN_TELEPORT,0.5f,1f)
                        player.sendMessage(Component.text("이미 사용한 명령어입니다.").color(NamedTextColor.RED))
                    }
                }
            }
        }
    }
}