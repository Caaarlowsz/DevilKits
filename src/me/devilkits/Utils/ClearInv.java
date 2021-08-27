package me.devilkits.Utils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ClearInv implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("clear") && args.length == 0) {
			if (p.hasPermission("DevilKits.clear") || p.isOp()) {
				final Inventory inv = (Inventory) p.getInventory();
				inv.clear();
				p.sendMessage(ChatColor.GRAY + "Inventario limpo");
			} else {
				MsgUtil.a(p);
			}
		}
		return false;
	}
}
