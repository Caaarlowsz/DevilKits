package me.devilkits.Jumps;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import me.devilkits.Main;

public class Ferro implements Listener {
	public static Main plugin;
	public static ArrayList<String> Ferro;

	static {
		me.devilkits.Jumps.Ferro.Ferro = new ArrayList<String>();
	}

	public Ferro(final Main main) {
		me.devilkits.Jumps.Ferro.plugin = main;
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerJump1(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.IRON_BLOCK) {
			me.devilkits.Jumps.Ferro.Ferro.remove(p.getName());
			final Vector sponge = p.getLocation().getDirection().multiply(0).setY(2);
			p.setVelocity(sponge);
			me.devilkits.Jumps.Ferro.Ferro.add(p.getName());
		}
	}

	@EventHandler
	public void onFall(final EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			final Player p = (Player) e.getEntity();
			if (e.getCause().equals((Object) EntityDamageEvent.DamageCause.FALL)
					&& me.devilkits.Jumps.Ferro.Ferro.contains(p.getName())) {
				e.setCancelled(true);
				me.devilkits.Jumps.Ferro.Ferro.remove(p.getName());
			}
		}
	}
}
