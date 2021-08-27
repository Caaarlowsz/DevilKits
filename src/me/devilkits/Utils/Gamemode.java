package me.devilkits.Utils;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (cmd.getName().equalsIgnoreCase("gm") || cmd.getName().equalsIgnoreCase("gamemode")) {
			if (sender instanceof ConsoleCommandSender) {
				System.out.println("Console nao pode usar esse comando");
				return true;
			}
			final Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage(ChatColor.GRAY + "O seu modo de gamemode atual §c" + p.getGameMode() + "§7.");
			} else if (args.length == 1) {
				if (p.hasPermission("DevilKits.gm") || p.isOp()) {
					if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("criativo")) {
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage(ChatColor.GRAY + "Seu gamemode agora esta em §ccriativo§7.");
					} else if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("sobrevivencia")) {
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage(ChatColor.GRAY + "Seu gamemode agora esta em §csobrevivencia§7.");
					} else {
						p.sendMessage(ChatColor.RED + "Nao encontrado este gamemode.");
					}
				} else {
					MsgUtil.a(p);
				}
			}
		}
		return false;
	}
}
