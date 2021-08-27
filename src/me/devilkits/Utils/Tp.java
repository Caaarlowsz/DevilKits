package me.devilkits.Utils;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Tp implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (cmd.getName().equalsIgnoreCase("tp")) {
			if (sender instanceof ConsoleCommandSender) {
				System.out.println("Console nao pode usar esse comando");
				return true;
			}
			final Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage(ChatColor.GRAY + "Use /tp <player> ou /tp <player> <player2>");
			} else if (args.length == 1) {
				if (p.hasPermission("DevilKits.tp") || p.isOp()) {
					final Player targetPlayer = p.getServer().getPlayer(args[0]);
					final Location tpLoc = targetPlayer.getLocation();
					p.teleport(tpLoc);
					p.sendMessage(ChatColor.GRAY + "Teleportado para " + targetPlayer.getDisplayName() + ChatColor.GRAY
							+ ".");
				} else {
					MsgUtil.a(p);
				}
			} else if (args.length == 2) {
				if (p.hasPermission("DevilKits.tp") || p.isOp()) {
					final Player targetPlayer = p.getServer().getPlayer(args[0]);
					final Player targetPlayer2 = p.getServer().getPlayer(args[1]);
					if (targetPlayer == null || targetPlayer2 == null) {
						p.sendMessage("§4oJogador Offline!");
					} else {
						final Location tpLoc2 = targetPlayer2.getLocation();
						targetPlayer.teleport(tpLoc2);
						p.sendMessage(ChatColor.GRAY + "Voce foi teleportado " + targetPlayer.getDisplayName()
								+ ChatColor.GRAY + " para " + targetPlayer2.getDisplayName() + ChatColor.RED + ".");
					}
				} else {
					MsgUtil.a(p);
				}
			}
		}
		return false;
	}
}
