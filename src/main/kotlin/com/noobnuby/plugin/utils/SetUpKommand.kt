package com.noobnuby.plugin.utils

import com.noobnuby.plugin.Main
import com.noobnuby.plugin.commands.Start
import com.noobnuby.plugin.commands.Chat
import io.github.monun.kommand.kommand

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
        }

    }
}