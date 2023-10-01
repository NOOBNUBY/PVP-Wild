package com.noobnuby.plugin.command

import com.ibm.icu.text.CaseMap.Title
import com.noobnuby.plugin.Main
import com.noobnuby.plugin.init.Schem
import com.noobnuby.plugin.utils.Variable
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextColor
import org.bukkit.Bukkit
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
import sun.audio.AudioPlayer.player
import java.sql.Time
import java.time.Duration


class Start:CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (command.name.equals("start", ignoreCase = true)) {
            if (sender is Player) {
                if (sender.isOp) {
                    for (p in getServer().getOnlinePlayers()) {
                        p.showTitle(net.kyori.adventure.title.Title.title(Component.text("게임 시작!").color(NamedTextColor.GREEN),Component.empty(),
                            net.kyori.adventure.title.Title.Times.of(Duration.ofMillis(500),Duration.ofSeconds(1),Duration.ofMillis(500))))
                        p.addPotionEffect(PotionEffect(PotionEffectType.NIGHT_VISION, Int.MAX_VALUE,9))
                        p.playSound(p.location, Sound.ENTITY_ARROW_SHOOT, 0.5f, 1f)
                        p.inventory.addItem(ItemStack(Material.BOOKSHELF,64))
                        p.inventory.addItem(ItemStack(Material.ENCHANTING_TABLE,1))
                        p.inventory.addItem(ItemStack(Material.BREAD,16))
                    }

                    Variable().isGameStart = true

                    getWorld("world")?.worldBorder?.setCenter(0.0,0.0)
                    getWorld("world")?.worldBorder?.setSize(1000.0)
                    Schem().deleteSchem()
                    sender.sendMessage(Component.text("게임 시작!"))
                }
            }
            return true
        }
        return false
    }
}