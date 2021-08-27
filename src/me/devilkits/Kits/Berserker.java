package me.devilkits.Kits;

import me.devilkits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.entity.*;
import org.bukkit.potion.*;
import org.bukkit.*;
import org.bukkit.event.*;

public class Berserker implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Berserker(final Main main) {
        Berserker.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("berserker")) {
            if (!Main.usandokit.contains(p.getName()) && p.hasPermission("kitpvp.berserker")) {
                p.sendMessage("§7Voce pegou o Kit : §6Berserker");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                Main.usandokit.add(p.getName());
                Main.berserker.add(sender.getName());
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
    public void forca(final PlayerDeathEvent e) {
        if (e.getEntity().getKiller() instanceof Player) {
            final Player p = e.getEntity().getKiller();
            if (Main.berserker.contains(p.getName())) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 400, 0));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 400, 0));
                p.sendMessage(ChatColor.AQUA + "Um Monstro encarnou em voce!");
                p.playSound(p.getLocation(), Sound.AMBIENCE_THUNDER, 1.0f, 1.0f);
            }
        }
    }
}
