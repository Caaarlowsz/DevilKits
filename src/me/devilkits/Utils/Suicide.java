package me.devilkits.Utils;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Suicide implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		if (cmd.equalsIgnoreCase("morrer")) {
			final Player player = (Player) sender;
			Bukkit.broadcastMessage("§7" + player.getName() + " §cse suicidou");
			player.setHealth(0.0);
		}
		return false;
	}
}
