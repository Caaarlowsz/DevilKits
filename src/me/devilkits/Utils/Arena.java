package me.devilkits.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Arena implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] args) {
		final Player p = (Player) sender;
		if (p.hasPermission("DevilKits.arena") && cmd.getName().equalsIgnoreCase("arena")) {
			if (args.length == 0) {
				p.sendMessage("§cUse: /arena <Jogador>");
			}
			if (args.length == 1) {
				final Player o = Bukkit.getPlayer(args[0]);
				if (o != null) {
					o.getLocation().add(0.0, 13.0, 0.0).getBlock().setType(Material.BEDROCK);
					o.getLocation().add(0.0, 11.0, 1.0).getBlock().setType(Material.BEDROCK);
					o.getLocation().add(1.0, 11.0, 0.0).getBlock().setType(Material.BEDROCK);
					o.getLocation().add(0.0, 11.0, -1.0).getBlock().setType(Material.BEDROCK);
					o.getLocation().add(-1.0, 11.0, 0.0).getBlock().setType(Material.BEDROCK);
					o.getLocation().add(0.0, 10.0, 0.0).getBlock().setType(Material.BEDROCK);
					o.teleport(o.getLocation().add(0.0, 11.0, -0.05));
					p.sendMessage("§7Arena criada");
					Player[] arrayOfPlayer;
					for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
						final Player p2 = arrayOfPlayer[i];
						if (p2.hasPermission("DevilKits.arena")) {
							p2.sendMessage(
									ChatColor.GRAY + sender.getName() + " Criou Uma Arena Com " + o.getDisplayName());
						}
					}
				} else {
					p.sendMessage("§cJogador offline");
				}
			}
		} else {
			p.sendMessage("§cSem permissao");
		}
		return false;
	}
}
