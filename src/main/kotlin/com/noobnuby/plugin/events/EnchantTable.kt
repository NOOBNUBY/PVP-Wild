package com.noobnuby.plugin.events


import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.event.inventory.InventoryOpenEvent
import org.bukkit.inventory.EnchantingInventory
import org.bukkit.inventory.ItemStack







class EnchantTable:Listener {
    @EventHandler
    fun onInventoryOpen(e: InventoryOpenEvent) {
        if(e.inventory is EnchantingInventory) {
            e.inventory.setItem(1, ItemStack(Material.LAPIS_LAZULI,64))
        }
    }

    @EventHandler
    fun onInventoryClose(e: InventoryCloseEvent) {
        if (e.inventory is EnchantingInventory) {
            e.inventory.setItem(1, null)
        }
    }

    @EventHandler
    fun onInventoryClick(e: InventoryClickEvent) {
        if (e.inventory is EnchantingInventory) {
            if (e.slot == 1) e.isCancelled = true
        }
    }
}