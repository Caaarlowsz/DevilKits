package me.devilkits.Kits;

import me.devilkits.*;
import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.potion.*;
import org.bukkit.event.*;

public class DarkGod implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public DarkGod(final Main main) {
        DarkGod.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("darkgod")) {
            if (!Main.usandokit.contains(p.getName()) && p.hasPermission("kit.darkgod")) {
                p.sendMessage("�7Voce pegou o Kit : �6DarkGod");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                Main.usandokit.add(p.getName());
                Main.darkgod.add(sender.getName());
                p.getInventory().clear();
                final ItemStack espada = new ItemStack(Material.WOOD_SWORD);
                final ItemMeta espadameta = espada.getItemMeta();
                espadameta.setDisplayName("�cSword");
                espada.addEnchantment(Enchantment.DURABILITY, 3);
                p.getInventory().addItem(new ItemStack[] { espada });
                Main.giveSoup(p, 35);
            }
            return true;
        }
        return false;
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player) || !(e.getEntity() instanceof LivingEntity)) {
            return;
        }
        final LivingEntity entity = (LivingEntity)e.getEntity();
        final Player p = (Player)e.getDamager();
        if (!Main.darkgod.contains(p.getName())) {
            return;
        }
        final Random rand = new Random();
        final int percent = rand.nextInt(100);
        if (percent <= 33) {
            entity.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 120, 0));
        }
    }
}