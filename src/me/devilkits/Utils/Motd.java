package me.devilkits.Utils;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import me.devilkits.Main;

public class Motd implements Listener {
	public Main plugin;

	public Motd(final Main instance) {
		this.plugin = instance;
	}

	@EventHandler
	public void motd(final ServerListPingEvent e) {
		final String MSG_Motd = this.plugin.getConfig().getString("Motd");
		e.setMotd(MSG_Motd.replace("&", "§"));
	}
}
