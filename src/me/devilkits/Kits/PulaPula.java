package me.devilkits.Kits;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import me.devilkits.*;
import java.util.*;
import org.bukkit.potion.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.*;

public class PulaPula implements Listener, CommandExecutor
{
    @EventHandler
    public void onEntityDamage(final EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player) || !(e.getEntity() instanceof LivingEntity)) {
            return;
        }
        final LivingEntity entity = (LivingEntity)e.getEntity();
        final Player p = (Player)e.getDamager();
        if (!Main.pulapula.contains(p.getName())) {
            return;
        }
        final Random rand = new Random();
        final int percent = rand.nextInt(100);
        if (percent <= 33) {
            entity.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 220, 0));
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        final ItemStack dima = new ItemStack(Material.STONE_SWORD);
        dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
        if (label.equalsIgnoreCase("pulapula")) {
            if (Main.usandokit.contains(p.getName())) {
                p.sendMessage("§cVoce ja esta usando um kit!");
            }
            if (!p.hasPermission("kit.pulapula")) {
                p.sendMessage("§c§oVoce nao tem permissao para este kit!");
                return true;
            }
            p.getInventory().clear();
            Main.usandokit.add(p.getName());
            Main.pulapula.add(p.getName());
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 120000000, 3));
            p.sendMessage(ChatColor.GREEN + "§7Voce pegou o Kit : §6Puurga");
            p.getInventory().addItem(new ItemStack[] { dima });
            for (int i = 0; i < 37; ++i) {
                p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
            }
        }
        return false;
    }
}
