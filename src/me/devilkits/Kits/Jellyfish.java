package me.devilkits.Kits;

import org.bukkit.event.*;
import me.devilkits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.meta.*;

public class Jellyfish implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Jellyfish(final Main main) {
        Jellyfish.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("jellyfish")) {
            if (!Main.usandokit.contains(p.getName()) && p.hasPermission("icepvp.jellyfish")) {
                p.sendMessage("§7Voce pegou o Kit : §6Jellyfish");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                Main.usandokit.add(p.getName());
                Main.jellyfish.add(sender.getName());
                p.getInventory().clear();
                final ItemStack espada = new ItemStack(Material.WOOD_SWORD);
                final ItemMeta espadameta = espada.getItemMeta();
                espadameta.setDisplayName("§cSword");
                espada.addEnchantment(Enchantment.DURABILITY, 3);
                p.getInventory().addItem(new ItemStack[] { espada });
                final ItemStack bow = new ItemStack(Material.SLIME_BALL);
                final ItemMeta bowmeta = bow.getItemMeta();
                bowmeta.setDisplayName("§bJellyfish Kit");
                bow.setItemMeta(bowmeta);
                p.getInventory().addItem(new ItemStack[] { bow });
                Main.giveSoup(p, 34);
            }
            return true;
        }
        return false;
    }
}
