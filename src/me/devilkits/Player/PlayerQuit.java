package me.devilkits.Player;

import org.bukkit.event.player.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class PlayerQuit implements Listener
{
    @EventHandler
    public void Quit(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        p.getInventory().clear();
        p.teleport(p.getWorld().getSpawnLocation());
    }
}
