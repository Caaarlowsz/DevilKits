package me.devilkits.Kits;

import org.bukkit.event.*;
import me.devilkits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.meta.*;

public class Paladino implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Paladino(final Main main) {
        Paladino.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("paladino")) {
            if (!Main.usandokit.contains(p.getName()) && p.hasPermission("kit.paladino")) {
                p.sendMessage("�7Voce pegou o Kit : �6Paladino");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                Main.usandokit.add(p.getName());
                Main.paladino.add(sender.getName());
                p.getInventory().clear();
                final ItemStack espada = new ItemStack(Material.STONE_SWORD);
                final ItemMeta espadameta = espada.getItemMeta();
                final ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                final ItemMeta chestplatemeta = chestplate.getItemMeta();
                chestplatemeta.setDisplayName("�7Paladino");
                espadameta.setDisplayName("�cSword");
                espada.addEnchantment(Enchantment.DURABILITY, 3);
                chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                p.getInventory().addItem(new ItemStack[] { espada });
                p.getInventory().setChestplate(chestplate);
                Main.giveSoup(p, 35);
            }
            return true;
        }
        return false;
    }
}
