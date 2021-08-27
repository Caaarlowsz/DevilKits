package me.devilkits.Utils;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;

public class ClearInv implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("clear") && args.length == 0) {
            if (p.hasPermission("DevilKits.clear") || p.isOp()) {
                final Inventory inv = (Inventory)p.getInventory();
                inv.clear();
                p.sendMessage(ChatColor.GRAY + "Inventario limpo");
            }
            else {
                MsgUtil.a(p);
            }
        }
        return false;
    }
}
