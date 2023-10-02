package com.noobnuby.plugin.AutoSmelt

import com.noobnuby.plugin.utils.Variable
import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.inventory.ItemStack

class OreBreak: Listener {
    @EventHandler
    fun onBlockBreak(e: BlockBreakEvent) {
        val p = e.player
        val block = e.block.type
        val hand: ItemStack = e.player.inventory.itemInMainHand

        if(p.gameMode != GameMode.SURVIVAL) return
        if(Variable.isGameStart != true) return

        when {
            hand.containsEnchantment(Enchantment.SILK_TOUCH) -> return
            block == Material.IRON_ORE || block == Material.GOLD_ORE || block == Material.EMERALD_ORE -> {
                e.isDropItems = false

                for (i in e.block.getDrops(hand)) {
                    if (block.name.endsWith("IRON_ORE")) i.type = Material.IRON_INGOT
                    if (block.name.endsWith("GOLD_ORE")) i.type = Material.GOLD_INGOT
                    if (block.name.endsWith("EMERALD_ORE")) i.type = Material.DIAMOND

                    e.block.world.dropItemNaturally(e.block.location, i)
                }
            }
        }
    }
}