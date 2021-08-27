package me.devilkits.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.devilkits.Main;

public class ChatStaff implements CommandExecutor, Listener {
	public Main plugin;

	public ChatStaff(final Main main) {
		this.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase(".")) {
			if (args.length == 0) {
				sender.sendMessage(ChatColor.GRAY + "/. <mensagem>");
			}
			if (args.length > 0) {
				final StringBuilder string = new StringBuilder();
				for (int i = 0; i < args.length; ++i) {
					string.append(String.valueOf(args[i]) + " ");
				}
				final String mensagem = string.toString();
				Player[] arrayOfPlayer;
				for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, k = 0; k < j; ++k) {
					final Player staff = arrayOfPlayer[k];
					if (staff.hasPermission("DevilKits.chatstaff")) {
						staff.sendMessage(
								"§7[§4STAFF§7]§9 " + sender.getName() + ": " + ChatColor.DARK_PURPLE + mensagem);
					} else {
						sender.sendMessage(ChatColor.RED + "Voce nao tem permissao de falar no chat da staff!");
					}
				}
			}
		}
		return false;
	}
}
