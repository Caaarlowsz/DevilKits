package me.devilkits.Utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.devilkits.Main;

public class GanharMoney implements Listener {
	@EventHandler
	public void Morrer(final PlayerDeathEvent e) {
		final Player p = e.getEntity();
		e.setDeathMessage((String) null);
		if (p.getKiller() instanceof Player) {
			final Player killer = p.getKiller();
			Main.econ.depositPlayer(killer.getName(), 100.0);
			killer.sendMessage(ChatColor.GOLD + "Foi depositado 100 creditos em sua conta");
		}
		e.getDrops().clear();
	}

	@EventHandler
	public void Morrer2(final PlayerDeathEvent e) {
		final Player p = e.getEntity();
		e.setDeathMessage((String) null);
		Main.econ.withdrawPlayer(p.getName(), 30.0);
		p.sendMessage("§7Foi descontado 30 creditos por ter morrido");
	}
}
