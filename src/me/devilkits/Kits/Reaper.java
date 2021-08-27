package me.devilkits.Kits;

import me.devilkits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.entity.*;
import org.bukkit.potion.*;
import org.bukkit.event.*;

public class Reaper implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Reaper(final Main main) {
        Reaper.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("reaper")) {
            if (!Main.usandokit.contains(p.getName()) && p.hasPermission("kit.reaper")) {
                p.sendMessage("§7Voce pegou o Kit : §6Reaper");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                Main.usandokit.add(p.getName());
                Main.reaper.add(sender.getName());
                p.getInventory().clear();
                final ItemStack espada = new ItemStack(Material.WOOD_SWORD);
                final ItemMeta espadameta = espada.getItemMeta();
                espadameta.setDisplayName("§cSword");
                espada.addEnchantment(Enchantment.DURABILITY, 3);
                p.getInventory().addItem(new ItemStack[] { espada });
                p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.WOOD_HOE) });
                Main.giveSoup(p, 34);
            }
            return true;
        }
        return false;
    }
    
    @EventHandler
    public void OnClick(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            final Player damager = (Player)e.getDamager();
            final Player victim = (Player)e.getEntity();
            if (Main.reaper.contains(damager.getName())) {
                Main.reaper.add(damager.getName());
                if (damager.getInventory().getItemInHand().getType() == Material.WOOD_HOE) {
                    victim.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 3));
                }
            }
        }
    }
}
