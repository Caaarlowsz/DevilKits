package me.devilkits.Utils;

import me.devilkits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

public class Head implements CommandExecutor
{
    public Head(final Main main) {
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.equalsIgnoreCase("head") && p.isOp()) {
            if (args.length == 0) {
                p.sendMessage("§7/head <§cjogador§7>");
                return true;
            }
            final ItemStack s = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
            final SkullMeta smeta = (SkullMeta)s.getItemMeta();
            smeta.setOwner(args[0]);
            s.setItemMeta((ItemMeta)smeta);
            p.getInventory().addItem(new ItemStack[] { s });
            p.updateInventory();
        }
        return false;
    }
}
