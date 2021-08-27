package me.devilkits.Kits;

import org.bukkit.event.*;
import me.devilkits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.meta.*;

public class Gladiator implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Gladiator(final Main main) {
        Gladiator.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("gladiator")) {
            if (!Main.usandokit.contains(p.getName()) && p.hasPermission("kit.gladiator")) {
                p.sendMessage("§7Voce pegou o Kit : §6Gladiator");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                Main.usandokit.add(p.getName());
                Main.gladiator.add(sender.getName());
                p.getInventory().clear();
                final ItemStack espada = new ItemStack(Material.WOOD_SWORD);
                final ItemMeta espadameta = espada.getItemMeta();
                espadameta.setDisplayName("§cSword");
                espada.addEnchantment(Enchantment.DURABILITY, 3);
                p.getInventory().addItem(new ItemStack[] { espada });
                final ItemStack bow = new ItemStack(Material.IRON_FENCE);
                final ItemMeta bowmeta = bow.getItemMeta();
                bowmeta.setDisplayName("§6Shadow Game");
                bow.setItemMeta(bowmeta);
                p.getInventory().addItem(new ItemStack[] { bow });
                Main.giveSoup(p, 36);
            }
            return true;
        }
        return false;
    }
}
