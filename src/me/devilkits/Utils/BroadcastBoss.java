package me.devilkits.Utils;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import me.confuser.barapi.*;

public class BroadcastBoss implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String commandLabel, final String[] args) {
        final Player player = (Player)sender;
        if ((commandLabel.equalsIgnoreCase("bcb") || commandLabel.equalsIgnoreCase("broadboss")) && player.hasPermission("dutils.bb")) {
            if (args.length >= 1) {
                String bcast = "";
                for (int x = 0; x < args.length; ++x) {
                    bcast = String.valueOf(bcast) + args[x] + " ";
                }
                bcast = ChatColor.translateAlternateColorCodes('&', bcast);
                BarAPI.setMessage(player, "§6BROADCAST >" + ChatColor.RESET + bcast, 5);
            }
            else {
                sender.sendMessage(ChatColor.GRAY + "Use: /bb [mensagem]");
            }
        }
        return false;
    }
}
