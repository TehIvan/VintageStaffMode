package io.github.ivanix.vintagestaffmode.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.mineacademy.fo.annotation.AutoRegister;
import org.mineacademy.fo.plugin.SimplePlugin;
import org.mineacademy.fo.remain.Remain;

import java.util.UUID;

import static io.github.ivanix.vintagestaffmode.VintageStaffMode.vanishedPlayers;

@AutoRegister
public final class EventPlayerJoin implements Listener {

    @EventHandler
    protected void execute(PlayerJoinEvent event) {
        if (vanishedPlayers == null || vanishedPlayers.size() < 1) return;

        Player player = event.getPlayer();

        for (UUID uuid: vanishedPlayers) {
            Player vanishedPlayer = Remain.getPlayerByUUID(uuid);
            if (vanishedPlayer == null) continue;
            player.hidePlayer(SimplePlugin.getInstance(), vanishedPlayer);
        }
    }
}
