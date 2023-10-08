package com.noobnuby.plugin.AutoSmelt

import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.inventory.ItemStack
import java.util.*

class OreBreak : Listener {
    @EventHandler
    fun onBlockBreak(e: BlockBreakEvent) {
        val p = e.player
        val block = e.block.type
        val hand: ItemStack = e.player.inventory.itemInMainHand
        val rd = Random()

        if (!hand.containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)) return
        if (p.gameMode != GameMode.SURVIVAL) return
        e.isDropItems = false


        if (block == Material.IRON_ORE || block == Material.GOLD_ORE || block == Material.EMERALD_ORE) {
            var amount = 1

            when (hand.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS)) {
                1 -> if (rd.nextDouble() <= 0.33) amount += 1
                2 -> if (rd.nextDouble() <= 0.50) amount += (rd.nextInt(2) + 1)
                3 -> if (rd.nextDouble() <= 0.60) amount += (rd.nextInt(3) + 1)
            }

            var stack: ItemStack = when (block) {
                Material.IRON_ORE -> ItemStack(Material.IRON_INGOT)
                Material.GOLD_ORE -> ItemStack(Material.GOLD_INGOT)
                Material.EMERALD_ORE -> ItemStack(Material.DIAMOND)
                else -> return
            }

            for (i: Int in 1..amount) {
                e.block.world.dropItemNaturally(e.block.location, stack)
            }
        }
    }
}