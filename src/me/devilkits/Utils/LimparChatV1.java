package me.devilkits.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class LimparChatV1 implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Voce nao e um jogador!");
			return false;
		}
		final Player p = (Player) sender;
		if (commandLabel.equalsIgnoreCase("cc")) {
			if (p.hasPermission("DevilKits.limparchat")) {
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "                    �7Chat Limpo!");
			}
			return false;
		}
		return false;
	}
}
