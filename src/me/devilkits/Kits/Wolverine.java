package me.devilkits.Kits;

import org.bukkit.event.*;
import me.devilkits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.potion.*;
import org.bukkit.inventory.meta.*;

public class Wolverine implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Wolverine(final Main main) {
        Wolverine.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("wolverine")) {
            if (!Main.usandokit.contains(p.getName()) && p.hasPermission("kit.wolverine")) {
                p.sendMessage("§7Voce pegou o Kit : §6Wolverine");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                Main.usandokit.add(p.getName());
                Main.wolverine.add(sender.getName());
                p.getInventory().clear();
                final ItemStack espada = new ItemStack(Material.WOOD_SWORD);
                final ItemMeta espadameta = espada.getItemMeta();
                espadameta.setDisplayName("§cSword");
                espada.addEnchantment(Enchantment.DURABILITY, 3);
                p.getInventory().addItem(new ItemStack[] { espada });
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999999, 0));
                p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 999999999, 0));
                p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999999, 0));
                p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999999, 0));
                p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 0));
                p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
                p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
                p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
                p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
                p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
                p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
                p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
                p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
            }
            return true;
        }
        return false;
    }
}
