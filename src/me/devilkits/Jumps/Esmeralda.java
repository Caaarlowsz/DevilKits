package me.devilkits.Jumps;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import me.devilkits.Main;

public class Esmeralda implements Listener {
	public static Main plugin;
	public static ArrayList<String> Esmeralda;

	static {
		me.devilkits.Jumps.Esmeralda.Esmeralda = new ArrayList<String>();
	}

	public Esmeralda(final Main main) {
		me.devilkits.Jumps.Esmeralda.plugin = main;
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerJump1(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.EMERALD_BLOCK) {
			me.devilkits.Jumps.Esmeralda.Esmeralda.remove(p.getName());
			final Location loc = e.getTo().getBlock().getLocation();
			final Vector sponge = p.getLocation().getDirection().multiply(0).setY(3);
			p.setVelocity(sponge);
			p.playSound(loc, Sound.ORB_PICKUP, 6.0f, 1.0f);
			me.devilkits.Jumps.Esmeralda.Esmeralda.add(p.getName());
		}
	}

	@EventHandler
	public void onFall(final EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			final Player p = (Player) e.getEntity();
			if (e.getCause().equals((Object) EntityDamageEvent.DamageCause.FALL)
					&& me.devilkits.Jumps.Esmeralda.Esmeralda.contains(p.getName())) {
				e.setCancelled(true);
				me.devilkits.Jumps.Esmeralda.Esmeralda.remove(p.getName());
			}
		}
	}
}
