package me.devilkits.Kits;

import me.devilkits.*;
import java.util.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.util.*;
import java.util.concurrent.*;
import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.potion.*;

public class Hunter implements Listener, CommandExecutor
{
    public static Main plugin;
    public static HashMap<String, Long> cooldown;
    public static HashMap<String, Arrow> tiros;
    
    static {
        Hunter.cooldown = new HashMap<String, Long>();
        Hunter.tiros = new HashMap<String, Arrow>();
    }
    
    public Hunter(final Main main) {
        Hunter.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("hunter")) {
            if (!Main.usandokit.contains(p.getName()) && p.hasPermission("kit.hunter")) {
                p.sendMessage("§7Voce pegou o Kit : §6Hunter");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                Main.usandokit.add(p.getName());
                Main.hunter.add(sender.getName());
                p.getInventory().clear();
                final ItemStack espada = new ItemStack(Material.WOOD_SWORD);
                final ItemMeta espadameta = espada.getItemMeta();
                espadameta.setDisplayName("§cSword");
                espada.addEnchantment(Enchantment.DURABILITY, 3);
                p.getInventory().addItem(new ItemStack[] { espada });
                p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STICK) });
                Main.giveSoup(p, 34);
            }
            return true;
        }
        return false;
    }
    
    @EventHandler
    public void disparar(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.STICK && Main.hunter.contains(p.getName())) {
            if (!Hunter.cooldown.containsKey(p.getName()) || Hunter.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
                e.setCancelled(true);
                p.updateInventory();
                final Arrow tiro = (Arrow)p.launchProjectile((Class)Arrow.class);
                final Vector vec = p.getLocation().getDirection();
                tiro.setVelocity(new Vector(vec.getX() * 1.0 * 3.5, vec.getY() * 1.0 * 4.0, vec.getZ() * 1.0 * 3.5));
                Hunter.tiros.put(p.getName(), tiro);
                Hunter.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(20L));
                p.sendMessage(ChatColor.GOLD + "Dardo disparado!");
                p.playSound(p.getLocation(), Sound.GLASS, 1.0f, 1.0f);
                return;
            }
            p.sendMessage(ChatColor.RED + "Faltam " + TimeUnit.MILLISECONDS.toSeconds(Hunter.cooldown.get(p.getName()) - System.currentTimeMillis()) + " segundos para poder usar novamente.");
        }
    }
    
    @EventHandler
    public void aplicar(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Arrow) {
            final Player p = (Player)e.getEntity();
            final Arrow tiro = (Arrow)e.getDamager();
            if (tiro.getShooter() instanceof Player) {
                final Player shooter = (Player)tiro.getShooter();
                if (Hunter.tiros.containsKey(shooter.getName()) && tiro == Hunter.tiros.get(shooter.getName())) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 300, 0));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 300, 0));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 300, 0));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 300, 0));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 300, 0));
                    p.sendMessage(ChatColor.RED + "Voce foi atingido por um dardo de Hunter!");
                    p.playSound(p.getLocation(), Sound.BURP, 1.0f, 1.0f);
                    shooter.sendMessage(ChatColor.AQUA + "Seu dardo atingiu:" + ChatColor.GRAY + p.getName());
                    shooter.playSound(shooter.getLocation(), Sound.CAT_PURR, 1.0f, 1.0f);
                    Hunter.tiros.remove(shooter.getName());
                }
            }
        }
    }
}
