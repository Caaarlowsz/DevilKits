package me.devilkits.Kits;

import org.bukkit.event.*;
import me.devilkits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.meta.*;

public class Urgal implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Urgal(final Main main) {
        Urgal.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("Urgal")) {
            if (!Main.usandokit.contains(p.getName()) && p.hasPermission("kit.Urgal")) {
                p.sendMessage("�7Voce pegou o Kit : �6Urgal");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                Main.usandokit.add(p.getName());
                Main.urgal.add(sender.getName());
                p.getInventory().clear();
                final ItemStack espada = new ItemStack(Material.WOOD_SWORD);
                final ItemMeta espadameta = espada.getItemMeta();
                espadameta.setDisplayName("�cSword");
                espada.addEnchantment(Enchantment.DURABILITY, 3);
                p.getInventory().addItem(new ItemStack[] { espada });
                final ItemStack bow = new ItemStack(Material.POTION, 1, (short)8201);
                final ItemMeta bowmeta = bow.getItemMeta();
                bowmeta.setDisplayName("�6Urgal Potion");
                bow.setAmount(2);
                bow.setItemMeta(bowmeta);
                p.getInventory().addItem(new ItemStack[] { bow });
                Main.giveSoup(p, 34);
            }
            return true;
        }
        return false;
    }
}
