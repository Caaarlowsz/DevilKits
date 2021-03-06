package me.devilkits.Utils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.devilkits.Main;

public class MsgJoinQuit implements Listener {
	public Main plugin;

	public MsgJoinQuit(final Main instance) {
		this.plugin = instance;
	}

	@EventHandler
	public void quandoEntrar(final PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		final String Msg_Join = this.plugin.getConfig().getString("Msg_Join");
		e.setJoinMessage(Msg_Join.replace("%join%", p.getName()).replace("&", "?"));
	}

	@EventHandler
	public void quandoSair(final PlayerQuitEvent e) {
		final Player p = e.getPlayer();
		final String Msg_Leave = this.plugin.getConfig().getString("Msg_Leave");
		e.setQuitMessage(Msg_Leave.replace("%leave%", p.getName()).replace("&", "?"));
	}
}
