package me.devilkits.Utils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

public class Invsee implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Voce nao e um jogador!");
			return false;
		}
		final Player p = (Player) sender;
		if (commandLabel.equalsIgnoreCase("invsee")) {
			if (p.hasPermission("DevilKits.invsee")) {
				if (args.length == 0) {
					p.sendMessage(ChatColor.GRAY + "Digite " + ChatColor.GRAY + "/invsee <Player>");
				} else if (args.length == 1) {
					final Player target = p.getServer().getPlayer(args[0]);
					if (target != null) {
						p.sendMessage(ChatColor.GRAY + "Invetario aberto ");
						p.openInventory((Inventory) target.getInventory());
					} else {
						p.sendMessage(ChatColor.RED + "Jogador " + args[0] + "inexistente.");
					}
				} else {
					p.sendMessage(ChatColor.GRAY + "Digite " + ChatColor.GRAY + "/invsee <Player>");
				}
			} else {
				p.sendMessage(ChatColor.RED + "Sem permissao!");
			}
		}
		return false;
	}
}
