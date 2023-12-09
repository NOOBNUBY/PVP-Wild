package com.noobnuby.plugin.events

import com.noobnuby.plugin.utils.Variable.isKillTimeStart
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.potion.PotionType


class PlayerMove: Listener {
    @EventHandler
    fun isPlayerDown(e:PlayerMoveEvent) {

        val p = e.player

        if(isKillTimeStart) {
            if(p.location.y <= 55) {
                p.addPotionEffect(PotionEffect(PotionEffectType.WITHER, Int.MAX_VALUE, 0, true, false))
            }
            else {
                if(p.hasPotionEffect(PotionEffectType.WITHER)) {
                    p.removePotionEffect(PotionEffectType.WITHER)
                }
            }
        }
    }
}