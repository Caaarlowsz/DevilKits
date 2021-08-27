package me.devilkits.Utils;

import org.bukkit.ChatColor;

import me.devilkits.Main;

public abstract class mensagemdekit {
	public static String TEMMSG;

	static {
		mensagemdekit.TEMMSG = ChatColor.translateAlternateColorCodes('&', "Voce ja tem esse kit");
	}

	public mensagemdekit(final Main plugin) {
	}
}
