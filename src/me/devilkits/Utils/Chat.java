package me.devilkits.Utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {
	@EventHandler
	public void onPlayerChatRank(final AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		e.setFormat(String.valueOf(p.getDisplayName()) + ChatColor.GOLD + " » " + ChatColor.RESET
				+ e.getMessage().replace("&", "§"));
	}
}
