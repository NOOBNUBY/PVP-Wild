package com.noobnuby.plugin.commands

import com.noobnuby.plugin.init.Schem
import com.noobnuby.plugin.utils.Variable
import io.github.monun.kommand.KommandContext
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit.getServer
import org.bukkit.Bukkit.getWorld
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import java.time.Duration


object Start {
    fun startCommandHandler(ctx: KommandContext) {
        for (p in getServer().onlinePlayers) {
            p.showTitle(net.kyori.adventure.title.Title.title(Component.text("게임 시작!").color(NamedTextColor.GREEN),Component.empty(),
                net.kyori.adventure.title.Title.Times.of(Duration.ofMillis(500),Duration.ofSeconds(1),Duration.ofMillis(500))))
            p.addPotionEffect(PotionEffect(PotionEffectType.NIGHT_VISION, Int.MAX_VALUE,9,true, false))
            p.playSound(p.location, Sound.ENTITY_ARROW_SHOOT, 0.5f, 1f)
            p.giveExpLevels(50)
            p.inventory.addItem(ItemStack(Material.BOOKSHELF,64))
            p.inventory.addItem(ItemStack(Material.ENCHANTING_TABLE,1))
            p.inventory.addItem(ItemStack(Material.BREAD,16))
        }

        Variable.isGameStart = true

        getWorld("world")?.worldBorder?.setCenter(0.0,0.0)
        getWorld("world")?.worldBorder?.size = 1000.0
        Schem().deleteSchem()
        ctx.sender.sendMessage(Component.text("게임 시작!"))
    }
}