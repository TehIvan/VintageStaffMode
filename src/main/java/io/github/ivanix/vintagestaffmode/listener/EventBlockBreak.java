package io.github.ivanix.vintagestaffmode.listener;

import lombok.AccessLevel;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.mineacademy.fo.annotation.AutoRegister;
import org.mineacademy.fo.event.SimpleListener;

import static io.github.ivanix.vintagestaffmode.VintageStaffMode.vanishedPlayers;

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
