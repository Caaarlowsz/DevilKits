package me.devilkits.Kits;

import me.devilkits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.entity.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.event.*;

public class Critical implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Critical(final Main main) {
        Critical.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("critical")) {
            if (!Main.usandokit.contains(p.getName()) && p.hasPermission("kit.critical")) {
                p.sendMessage("§7Voce pegou o Kit : §6Critical");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                Main.usandokit.add(p.getName());
                Main.critical.add(sender.getName());
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
    public void dano(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            final Player p = (Player)e.getEntity();
            final Player d = (Player)e.getDamager();
            if (Main.critical.contains(d.getName())) {
                final Random r = new Random();
                final int c = r.nextInt(100);
                if (c <= 30) {
                    e.setDamage(e.getDamage() + 4.0);
                    p.getWorld().playEffect(p.getLocation(), Effect.STEP_SOUND, (Object)Material.REDSTONE_BLOCK, 10);
                    p.sendMessage(ChatColor.RED + "Voce recebeu um golpe critico de " + ChatColor.DARK_RED + d.getName());
                }
            }
        }
    }
}
