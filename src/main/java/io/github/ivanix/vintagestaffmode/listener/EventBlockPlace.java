package io.github.ivanix.vintagestaffmode.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import static io.github.ivanix.vintagestaffmode.VintageStaffMode.vanishedPlayers;

public final class EventBlockPlace implements Listener {

    @EventHandler
    protected void execute(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        boolean isVanished = vanishedPlayers.contains(player.getUniqueId());

        if (isVanished) {
            event.setCancelled(true);
        }
    }
}
