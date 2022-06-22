package io.github.ivanix.vintagestaffmode;

import io.github.ivanix.vintagestaffmode.command.CommandStaffMode;
import io.github.ivanix.vintagestaffmode.listener.EventBlockBreak;
import io.github.ivanix.vintagestaffmode.listener.EventBlockPlace;
import io.github.ivanix.vintagestaffmode.listener.EventPlayerJoin;
import io.github.ivanix.vintagestaffmode.listener.EventPlayerQuit;
import org.mineacademy.fo.plugin.SimplePlugin;

import java.util.ArrayList;
import java.util.UUID;

public final class VintageStaffMode extends SimplePlugin {

    public static ArrayList<UUID> vanishedPlayers = new ArrayList<>();

    @Override
    protected void onPluginStart() {
    }

    @Override
    protected void onReloadablesStart() {
        registerCommand(new CommandStaffMode());
        registerEvents(new EventBlockBreak());
        registerEvents(new EventBlockPlace());
        registerEvents(new EventPlayerJoin());
        registerEvents(new EventPlayerQuit());
    }

    public static VintageStaffMode getInstance() {
        return (VintageStaffMode) SimplePlugin.getInstance();
    }
}
