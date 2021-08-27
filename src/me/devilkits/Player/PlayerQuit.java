package me.devilkits.Player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {
	@EventHandler
	public void Quit(final PlayerQuitEvent e) {
		final Player p = e.getPlayer();
		p.getInventory().clear();
		p.teleport(p.getWorld().getSpawnLocation());
	}
}
