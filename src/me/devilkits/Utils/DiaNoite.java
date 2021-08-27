package me.devilkits.Utils;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class DiaNoite implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cUse este comando in-game.");
            return true;
        }
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("dia")) {
            if (!p.hasPermission("DevilKits.dianoite")) {
                p.sendMessage("§7Sem permissao!");
                return true;
            }
            final World m = p.getWorld();
            m.setTime(1000L);
            p.sendMessage("§7Tempo alterado para §cDia");
        }
        if (cmd.getName().equalsIgnoreCase("noite")) {
            if (!p.hasPermission("DevilKits.dianoite")) {
                p.sendMessage("§7Sem permissao!");
                return true;
            }
            final World m = p.getWorld();
            m.setTime(14000L);
            p.sendMessage("§7Tempo alterado para §cNoite");
        }
        return false;
    }
}
