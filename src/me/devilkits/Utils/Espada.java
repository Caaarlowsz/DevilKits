package me.devilkits.Utils;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;

public class Espada implements Listener, CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            if (cmd.getName().equalsIgnoreCase("Espada")) {
                player.playSound(player.getLocation(), Sound.BAT_DEATH, 4.0f, 4.0f);
                player.sendMessage("§7Voce Recebeu uma Espada");
            }
            final ItemStack espada = new ItemStack(Material.WOOD_SWORD, 1);
            player.getInventory().addItem(new ItemStack[] { espada });
        }
        return true;
    }
}
