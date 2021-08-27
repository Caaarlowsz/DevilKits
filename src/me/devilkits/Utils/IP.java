package me.devilkits.Utils;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class IP implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("ip")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "Comando para players!");
                return true;
            }
            final Player player = (Player)sender;
            player.sendMessage(ChatColor.GRAY + "Ip: " + Bukkit.getServer().getIp());
        }
        return false;
    }
}
