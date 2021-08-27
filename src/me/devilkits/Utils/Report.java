package me.devilkits.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.devilkits.Main;

public class Report implements CommandExecutor, Listener {
	public Main plugin;

	public Report(final Main main) {
		this.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("report")) {
			if (args.length == 0) {
				sender.sendMessage(ChatColor.RED + "/report Nick Denuncia");
			}
			if (args.length > 0) {
				sender.sendMessage(ChatColor.GRAY + "Report Enviado!");
				final StringBuilder string = new StringBuilder();
				for (int i = 0; i < args.length; ++i) {
					string.append(String.valueOf(args[i]) + " ");
				}
				final String mensagem = string.toString();
				Player[] arrayOfPlayer;
				for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, k = 0; k < j; ++k) {
					final Player staff = arrayOfPlayer[k];
					if (staff.hasPermission("DevilKits.report")) {
						staff.sendMessage("                 §6§l[§7Report§6§l]");
						staff.sendMessage(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
						staff.sendMessage(ChatColor.LIGHT_PURPLE + "REPORT DE: " + ChatColor.GRAY + sender.getName());
						staff.sendMessage(ChatColor.LIGHT_PURPLE + "MOTIVO: " + ChatColor.GRAY + mensagem);
						staff.sendMessage(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					}
				}
			}
		}
		return false;
	}
}
