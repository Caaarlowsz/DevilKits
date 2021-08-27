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
import org.bukkit.*;
import org.bukkit.potion.*;
import java.util.concurrent.*;
import org.bukkit.event.*;

public class Ghoul implements Listener, CommandExecutor
{
    public static Main plugin;
    public static HashMap<String, Long> cooldown;
    
    static {
        Ghoul.cooldown = new HashMap<String, Long>();
    }
    
    public Ghoul(final Main main) {
        Ghoul.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("ghoul")) {
            if (!Main.usandokit.contains(p.getName()) && p.hasPermission("kit.ghoul")) {
                p.sendMessage("§7Voce pegou o Kit : §6Ghoul");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                Main.usandokit.add(p.getName());
                Main.ghoul.add(sender.getName());
                p.getInventory().clear();
                final ItemStack espada = new ItemStack(Material.WOOD_SWORD);
                final ItemMeta espadameta = espada.getItemMeta();
                espadameta.setDisplayName("§cSword");
                espada.addEnchantment(Enchantment.DURABILITY, 3);
                p.getInventory().addItem(new ItemStack[] { espada });
                p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.REDSTONE) });
                Main.giveSoup(p, 34);
            }
            return true;
        }
        return false;
    }
    
    @EventHandler
    public void interact(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && Main.ghoul.contains(p.getName()) && p.getItemInHand().getType() == Material.REDSTONE) {
            if (!Ghoul.cooldown.containsKey(p.getName()) || Ghoul.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
                e.setCancelled(true);
                p.updateInventory();
                p.sendMessage(ChatColor.RED + "§lMinha fome nao pode ser saciada!");
                p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 0));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 500, 0));
                p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 500, 3));
                p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 500, 0));
                p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 500, 2));
                p.playSound(p.getLocation(), Sound.WITHER_DEATH, 1.0f, 1.0f);
                Ghoul.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(40L));
                return;
            }
            p.sendMessage(ChatColor.RED + "Faltam " + TimeUnit.MILLISECONDS.toSeconds(Ghoul.cooldown.get(p.getName()) - System.currentTimeMillis()) + " segundos para poder usar novamente.");
        }
    }
}
