package me.devilkits.Utils;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class SemFome implements Listener {
	@EventHandler
	public void Fome(final FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}
}
