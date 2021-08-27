package me.devilkits.Kits;

import me.devilkits.*;
import java.util.*;
import org.bukkit.command.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.entity.*;
import java.util.concurrent.*;
import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.util.*;

public class Hulk implements Listener, CommandExecutor
{
    public static Main plugin;
    public static HashMap<String, Long> cooldown;
    
    static {
        Hulk.cooldown = new HashMap<String, Long>();
    }
    
    public Hulk(final Main main) {
        Hulk.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("hulk")) {
            if (!Main.usandokit.contains(p.getName()) && p.hasPermission("kit.hulk")) {
                p.sendMessage("§7Voce pegou o Kit : §6Hulk");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                Main.usandokit.add(p.getName());
                Main.hulk.add(sender.getName());
                p.getInventory().clear();
                final ItemStack espada = new ItemStack(Material.WOOD_SWORD);
                final ItemMeta espadameta = espada.getItemMeta();
                espadameta.setDisplayName("§cSword");
                espada.addEnchantment(Enchantment.DURABILITY, 3);
                p.getInventory().addItem(new ItemStack[] { espada });
                p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.SADDLE) });
                Main.giveSoup(p, 34);
            }
            return true;
        }
        return false;
    }
    
    @EventHandler
    public void pegar(final PlayerInteractEntityEvent e) {
        final Player p = e.getPlayer();
        if (e.getRightClicked() instanceof Player) {
            final Player r = (Player)e.getRightClicked();
            if (Main.hulk.contains(p.getName())) {
                if (!Hulk.cooldown.containsKey(p.getName()) || Hulk.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
                    if (p.getItemInHand().getType() == Material.SADDLE) {
                        e.setCancelled(true);
                        p.updateInventory();
                        p.setPassenger((Entity)r);
                        Hulk.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(15L));
                        p.sendMessage(ChatColor.GOLD + "Voce pegou o player: " + ChatColor.WHITE + r.getName());
                        r.sendMessage(ChatColor.GOLD + "Voce foi pego pelo Hulk: " + ChatColor.WHITE + p.getName());
                    }
                }
                else {
                    p.sendMessage(ChatColor.RED + "Faltam " + TimeUnit.MILLISECONDS.toSeconds(Hulk.cooldown.get(p.getName()) - System.currentTimeMillis()) + " segundos para poder usar novamente.");
                }
            }
        }
    }
    
    @EventHandler
    public static void playerInteract(final PlayerInteractEvent event) {
        if (!event.getAction().equals((Object)Action.LEFT_CLICK_AIR)) {
            return;
        }
        final Player player = event.getPlayer();
        if (player.getPassenger() == null || !(player.getPassenger() instanceof Player)) {
            return;
        }
        final Player pass = (Player)player.getPassenger();
        player.eject();
        pass.damage(0.0, (Entity)player);
        pass.setVelocity(new Vector(pass.getVelocity().getX(), 1.0, pass.getVelocity().getZ()));
        pass.sendMessage(ChatColor.RED + "Voc\u00ea foi jogado por " + ChatColor.DARK_RED + player.getName());
    }
}
