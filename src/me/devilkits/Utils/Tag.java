package me.devilkits.Utils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Tag implements Listener, CommandExecutor {
	@EventHandler
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("tag")) {
			if (args.length == 0) {
				p.sendMessage(ChatColor.GRAY + "Use: (Normal | Vip | Pro | Youtuber | Mod | Trial | Admin | Dono)");
				return true;
			}
			if (args[0].equalsIgnoreCase("normal")) {
				if (p.hasPermission("DevilKits.tag.normal")) {
					p.sendMessage(ChatColor.GRAY + "Tag Alterada");
					p.setDisplayName(ChatColor.WHITE + p.getName() + ChatColor.WHITE);
					p.setPlayerListName(ChatColor.WHITE + p.getName() + ChatColor.WHITE);
				} else {
					p.sendMessage(ChatColor.RED + "Voce nao tem essa tag!");
				}
			} else if (args[0].equalsIgnoreCase("Vip")) {
				if (p.hasPermission("DevilKits.tag.Vip")) {
					p.sendMessage(ChatColor.GRAY + "Tag Alterada");
					p.setDisplayName(ChatColor.GREEN + p.getName() + ChatColor.WHITE);
					p.setPlayerListName(ChatColor.GREEN + p.getName() + ChatColor.WHITE);
				} else {
					p.sendMessage(ChatColor.RED + "Voce nao tem essa tag!");
				}
			} else if (args[0].equalsIgnoreCase("pro")) {
				if (p.hasPermission("DevilKits.tag.pro")) {
					p.sendMessage(ChatColor.GRAY + "Tag Alterada");
					p.setDisplayName(ChatColor.GOLD + p.getName() + ChatColor.WHITE);
					p.setPlayerListName(ChatColor.GOLD + p.getName() + ChatColor.WHITE);
				} else {
					p.sendMessage(ChatColor.RED + "Voce nao tem essa tag!");
				}
			} else if (args[0].equalsIgnoreCase("youtuber")) {
				if (p.hasPermission("DevilKits.tag.youtuber")) {
					p.sendMessage(ChatColor.GRAY + "Tag Alterada");
					p.setDisplayName(ChatColor.GRAY + p.getName() + ChatColor.WHITE);
					p.setPlayerListName(ChatColor.GRAY + p.getName() + ChatColor.WHITE);
				} else {
					p.sendMessage(ChatColor.RED + "Voce nao tem essa tag!");
				}
			} else if (args[0].equalsIgnoreCase("trial")) {
				if (p.hasPermission("DevilKits.tag.trial")) {
					p.sendMessage(ChatColor.GRAY + "Tag Alterada");
					p.setDisplayName(ChatColor.LIGHT_PURPLE + p.getName() + ChatColor.WHITE);
					p.setPlayerListName(ChatColor.LIGHT_PURPLE + p.getName() + ChatColor.WHITE);
				} else {
					p.sendMessage(ChatColor.RED + "Voce nao tem essa tag!");
				}
			} else if (args[0].equalsIgnoreCase("mod")) {
				if (p.hasPermission("DevilKits.tag.mod")) {
					p.sendMessage(ChatColor.GRAY + "Tag Alterada");
					p.setDisplayName(ChatColor.DARK_PURPLE + p.getName() + ChatColor.WHITE);
					p.setPlayerListName(ChatColor.DARK_PURPLE + p.getName() + ChatColor.WHITE);
				} else {
					p.sendMessage(ChatColor.RED + "Voce nao tem essa tag!");
				}
			} else if (args[0].equalsIgnoreCase("admin")) {
				if (p.hasPermission("DevilKits.tag.admin")) {
					p.sendMessage(ChatColor.GRAY + "Tag Alterada");
					p.setDisplayName(ChatColor.RED + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("§c" + p.getName() + ChatColor.WHITE);
				} else {
					p.sendMessage(ChatColor.RED + "Voce nao tem essa tag!");
				}
			} else if (args[0].equalsIgnoreCase("dono")) {
				if (p.hasPermission("DevilKits.tag.dono")) {
					p.sendMessage(ChatColor.GRAY + "Tag Alterada");
					p.setDisplayName("§4§o" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("§4" + p.getName() + ChatColor.WHITE);
				} else {
					p.sendMessage(ChatColor.RED + "Voce nao tem essa tag!");
				}
			}
		}
		return false;
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void j(final PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		p.setPlayerListName(p.getName());
	}
}
