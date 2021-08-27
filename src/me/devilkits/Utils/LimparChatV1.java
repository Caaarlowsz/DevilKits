package me.devilkits.Utils;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class LimparChatV1 implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Voce nao e um jogador!");
            return false;
        }
        final Player p = (Player)sender;
        if (commandLabel.equalsIgnoreCase("cc")) {
            if (p.hasPermission("DevilKits.limparchat")) {
                final Player player = (Player)sender;
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "                    §7Chat Limpo!");
            }
            return false;
        }
        return false;
    }
}
