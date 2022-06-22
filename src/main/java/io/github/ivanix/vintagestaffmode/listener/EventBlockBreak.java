package io.github.ivanix.vintagestaffmode.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.mineacademy.fo.annotation.AutoRegister;

import static io.github.ivanix.vintagestaffmode.VintageStaffMode.vanishedPlayers;

@AutoRegister
public final class EventBlockBreak implements Listener {

    @EventHandler
    protected void execute(BlockBreakEvent event) {
        Player player = event.getPlayer();
        boolean isVanished = vanishedPlayers.contains(player.getUniqueId());

        if (isVanished) {
            event.setCancelled(true);
        }
    }
}
