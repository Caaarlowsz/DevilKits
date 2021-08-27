package me.devilkits.Utils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.confuser.barapi.BarAPI;

public class Coder implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command command, final String label,
			final String[] args) {
		if (label.equalsIgnoreCase("coder")) {
			final Player p = (Player) sender;
			BarAPI.setMessage(p, "§6Coder: DevilSecktor", 3);
		}
		return false;
	}
}
