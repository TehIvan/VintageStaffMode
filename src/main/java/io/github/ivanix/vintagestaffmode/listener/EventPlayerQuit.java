package io.github.ivanix.vintagestaffmode.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.mineacademy.fo.annotation.AutoRegister;

import static io.github.ivanix.vintagestaffmode.VintageStaffMode.vanishedPlayers;

@AutoRegister
public final class EventPlayerQuit implements Listener {

    @EventHandler
    protected void execute(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if (vanishedPlayers.contains(player.getUniqueId())) {
            vanishedPlayers.remove(player.getUniqueId());
        }
    }
}
