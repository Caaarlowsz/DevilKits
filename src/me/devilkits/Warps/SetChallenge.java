package me.devilkits.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.devilkits.Main;

public class SetChallenge implements CommandExecutor {
	public static Main plugin;

	public SetChallenge(final Main main) {
		SetChallenge.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("setchallenge") && sender instanceof Player) {
			if (!sender.hasPermission("DevilKits.setwarp")) {
				final Player p1 = (Player) sender;
				p1.sendMessage("?cVoce nao tem permissao!");
			}
			if (sender.hasPermission("DevilKits.setwarp")) {
				final Player p1 = (Player) sender;
				SetChallenge.plugin.getConfig().set("challenge.x", (Object) p1.getLocation().getX());
				SetChallenge.plugin.getConfig().set("challenge.y", (Object) p1.getLocation().getY());
				SetChallenge.plugin.getConfig().set("challenge.z", (Object) p1.getLocation().getZ());
				SetChallenge.plugin.getConfig().set("challenge.pitch", (Object) p1.getLocation().getPitch());
				SetChallenge.plugin.getConfig().set("challenge.yaw", (Object) p1.getLocation().getYaw());
				SetChallenge.plugin.getConfig().set("challenge.world", (Object) p1.getLocation().getWorld().getName());
				SetChallenge.plugin.saveConfig();
				p1.sendMessage("?7Warp Challenge setada com sucesso");
			}
		}
		return false;
	}
}
