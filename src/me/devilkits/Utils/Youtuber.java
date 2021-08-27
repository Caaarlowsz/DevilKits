package me.devilkits.Utils;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginBase;

import com.sk89q.minecraft.util.commands.Command;

import me.devilkits.Main;

public class Youtuber implements Listener, CommandExecutor {
	public Main plugin;

	public Youtuber(final Main instance) {
		this.plugin = instance;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		final Player p = (Player) sender;
		if (((PluginBase) cmd).getName().equalsIgnoreCase("youtuber")) {
			p.sendMessage(this.plugin.getConfig().getString("Youtuber").replace("&", "§"));
		}
		return true;
	}

	public boolean onCommand(final CommandSender arg0, final org.bukkit.command.Command arg1, final String arg2,
			final String[] arg3) {
		return false;
	}
}
