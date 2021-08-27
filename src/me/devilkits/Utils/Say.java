package me.devilkits.Utils;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Say implements CommandExecutor {
	public boolean onCommand(final CommandSender Sender, final Command command, final String commandLabel,
			final String[] args) {
		if (command.getName().equalsIgnoreCase("say") && Sender.hasPermission("DevilKits.say") && args.length > 0) {
			final StringBuffer me = new StringBuffer();
			for (int i = 0; i < args.length; ++i) {
				me.append(String.valueOf(args[i]) + " ");
			}
			Bukkit.broadcastMessage("§9> " + (Object) me);
		}
		return false;
	}
}
