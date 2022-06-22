package io.github.ivanix.vintagestaffmode.command;

import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.annotation.AutoRegister;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.plugin.SimplePlugin;
import org.mineacademy.fo.remain.Remain;

import static io.github.ivanix.vintagestaffmode.VintageStaffMode.vanishedPlayers;

@AutoRegister
public final class CommandStaffMode extends SimpleCommand {

    public CommandStaffMode() {
        super("staffmode/staff");
        setUsage("/staffmode");
        setPermission("vintage.staffmode");
        setDescription("Enable or disable staff mode");
    }

    @Override
    protected void onCommand() {
        checkConsole();

        Player player = getPlayer();
        boolean isVanished = vanishedPlayers.contains(player.getUniqueId());

        if (isVanished) {
            vanishedPlayers.remove(player.getUniqueId());

            for (Player pl: Remain.getOnlinePlayers()) {
                pl.showPlayer(SimplePlugin.getInstance(), player);
            }

            tellSuccess("Disabled staffmode successfully.");
            Remain.sendActionBar(player, "&c&lStaffmode: Disabled");
            return;
        } else {
            vanishedPlayers.add(player.getUniqueId());

            for (Player pl: Remain.getOnlinePlayers()) {
                pl.hidePlayer(SimplePlugin.getInstance(), player);
            }

            tellSuccess("Enabled staffmode successfully.");

            Common.runTimerAsync(20, 20, ActionBarRunnable(player));
        }
    }

    private Runnable ActionBarRunnable(Player player) {
        return () -> {
            if (vanishedPlayers.contains(player.getUniqueId())) {
                Remain.sendActionBar(player, "&a&lStaffmode is enabled");
            }
        };
    }
}
