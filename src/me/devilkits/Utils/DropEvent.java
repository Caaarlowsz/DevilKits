package me.devilkits.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.plugin.Plugin;

import me.devilkits.Main;

public class DropEvent implements Listener {
	public static Main plugin;

	public DropEvent(final Main main) {
		DropEvent.plugin = main;
	}

	@EventHandler
	public void onItemDrop(final ItemSpawnEvent e) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) DropEvent.plugin, (Runnable) new Runnable() {
			@Override
			public void run() {
				e.getEntity().remove();
				e.getLocation().getWorld().playEffect(e.getEntity().getLocation(), Effect.ENDER_SIGNAL, 7);
			}
		}, 5L);
	}
}
