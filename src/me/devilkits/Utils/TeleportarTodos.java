package me.devilkits.Utils;

import org.bukkit.event.*;
import org.bukkit.entity.*;
import org.bukkit.command.*;
import org.bukkit.*;

public class TeleportarTodos implements CommandExecutor, Listener
{
    public void tpall(final Player p, final Player p2) {
        p2.teleport(p.getLocation());
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("tpall")) {
            final Player p = (Player)sender;
            if (p.hasPermission("DevilKits.tpall")) {
                p.sendMessage(ChatColor.GRAY + "Teleportados!");
                Player[] arrayOfPlayer;
                for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
                    final Player p2 = arrayOfPlayer[i];
                    this.tpall(p, p2);
                }
            }
        }
        return false;
    }
}
