package me.devilkits.Kits;

import org.bukkit.event.*;
import me.devilkits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.meta.*;

public class Infernor implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Infernor(final Main main) {
        Infernor.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("infernor")) {
            if (!Main.usandokit.contains(p.getName()) && p.hasPermission("kit.infernor")) {
                p.sendMessage("§7Voce pegou o Kit : §6Infernor");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                Main.usandokit.add(p.getName());
                Main.infernor.add(sender.getName());
                p.getInventory().clear();
                final ItemStack espada = new ItemStack(Material.STONE_SWORD);
                final ItemMeta espadameta = espada.getItemMeta();
                espadameta.setDisplayName("§cSword");
                espada.addEnchantment(Enchantment.DURABILITY, 3);
                p.getInventory().addItem(new ItemStack[] { espada });
                p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.NETHER_FENCE) });
                Main.giveSoup(p, 34);
            }
            return true;
        }
        return false;
    }
}
