package me.devilkits.Utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

import me.devilkits.Main;

public class CombatLog implements Listener {
	public Plugin plugin;
	public static List<String> Sair;
	Config config;

	static {
		CombatLog.Sair = new ArrayList<String>();
	}

	public CombatLog(final Main plugin) {
		this.config = Config.getInstance();
		this.plugin = (Plugin) plugin;
	}

	@EventHandler
	public void onEntityDamage(final EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
			final Player p = (Player) e.getEntity();
			final Player hitter = (Player) e.getDamager();
			if (!CombatLog.Sair.contains(p.getName()) && !CombatLog.Sair.contains(hitter.getName())) {
				CombatLog.Sair.add(p.getName());
				CombatLog.Sair.add(hitter.getName());
				Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, (Runnable) new Runnable() {
					@Override
					public void run() {
						CombatLog.Sair.remove(p.getName());
						CombatLog.Sair.remove(hitter.getName());
					}
				}, 350L);
			}
		}
	}

	@EventHandler
	public void onPlayerExit(final PlayerQuitEvent e) {
		final Player p = e.getPlayer();
		if (CombatLog.Sair.contains(p.getName())) {
			p.setHealth(0.0);
			final World w = Bukkit.getServer().getWorld(this.config.getData().getString("SPAWN.World"));
			final double x = this.config.getData().getDouble("SPAWN.X");
			final double y = this.config.getData().getDouble("SPAWN.Y");
			final double z = this.config.getData().getDouble("SPAWN.Z");
			p.teleport(new Location(w, x, y, z));
			Bukkit.broadcastMessage("§7" + p.getName() + "§c Deslogou tretando e morreu!!");
		}
	}

	@EventHandler
	public void onMe2(final PlayerCommandPreprocessEvent event) {
		final Player p = event.getPlayer();
		if (CombatLog.Sair.contains(p.getName()) && (event.getMessage().toLowerCase().startsWith("/spawn")
				|| event.getMessage().toLowerCase().startsWith("/fps")
				|| event.getMessage().toLowerCase().startsWith("/hg")
				|| event.getMessage().toLowerCase().startsWith("/set")
				|| event.getMessage().toLowerCase().startsWith("/lava")
				|| event.getMessage().toLowerCase().startsWith("/textura")
				|| event.getMessage().toLowerCase().startsWith("/suicide")
				|| event.getMessage().toLowerCase().startsWith("/morrer")
				|| event.getMessage().toLowerCase().startsWith("/hg")
				|| event.getMessage().toLowerCase().startsWith("/knock")
				|| event.getMessage().toLowerCase().startsWith("/mlg")
				|| event.getMessage().toLowerCase().startsWith("/1v1"))) {
			event.setCancelled(true);
		}
	}
}
