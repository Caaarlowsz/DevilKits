package me.devilkits.Kits;

import me.devilkits.*;
import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.entity.*;

public class Fireman implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Fireman(final Main main) {
        Fireman.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("fireman")) {
            if (!Main.usandokit.contains(p.getName()) && p.hasPermission("kit.fireman")) {
                p.sendMessage("§7Voce pegou o Kit : §6Fireman");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                Main.usandokit.add(p.getName());
                Main.fireman.add(sender.getName());
                p.getInventory().clear();
                final ItemStack espada = new ItemStack(Material.WOOD_SWORD);
                final ItemMeta espadameta = espada.getItemMeta();
                espadameta.setDisplayName("§cSword");
                espada.addEnchantment(Enchantment.DURABILITY, 3);
                p.getInventory().addItem(new ItemStack[] { espada });
                Main.giveSoup(p, 35);
            }
            return true;
        }
        return false;
    }
    
    @EventHandler
    public void damage(final EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            final Player p = (Player)e.getEntity();
            if (Main.fireman.contains(p.getName()) && (e.getCause() == EntityDamageEvent.DamageCause.LAVA || e.getCause() == EntityDamageEvent.DamageCause.FIRE || e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK)) {
                e.setCancelled(true);
            }
        }
    }
    
    @EventHandler
    public void Fogo(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            final Player p = (Player)e.getDamager();
            if (Main.fireman.contains(p.getName()) && p.getInventory().getItemInHand() != null && p.getInventory().getItemInHand().getType() == Material.WOOD_SWORD && e.getEntity() instanceof LivingEntity) {
                final LivingEntity en = (LivingEntity)e.getEntity();
                if (en.isDead()) {
                    return;
                }
                en.setFireTicks(100);
            }
        }
    }
}
