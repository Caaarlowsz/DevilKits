package me.devilkits.Kits;

import me.devilkits.*;
import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.potion.*;
import org.bukkit.event.*;

public class Snail implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Snail(final Main main) {
        Snail.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("Snail")) {
            if (!Main.usandokit.contains(p.getName()) && p.hasPermission("kit.Snail")) {
                p.sendMessage("�7Voce pegou o Kit : �6Snail");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                Main.usandokit.add(p.getName());
                Main.snail.add(sender.getName());
                p.getInventory().clear();
                final ItemStack espada = new ItemStack(Material.WOOD_SWORD);
                final ItemMeta espadameta = espada.getItemMeta();
                espadameta.setDisplayName("�cSword");
                espada.addEnchantment(Enchantment.DURABILITY, 3);
                p.getInventory().addItem(new ItemStack[] { espada });
                Main.giveSoup(p, 34);
            }
            return true;
        }
        return false;
    }
    
    @EventHandler(ignoreCancelled = true)
    public void Snail(final EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof LivingEntity && event.getDamager() instanceof Player) {
            final Player damager = (Player)event.getDamager();
            if (Main.snail.contains(damager.getName()) && Math.random() < 0.5) {
                ((LivingEntity)event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 0));
            }
        }
    }
}