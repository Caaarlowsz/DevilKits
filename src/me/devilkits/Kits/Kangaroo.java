package me.devilkits.Kits;

import java.util.*;
import me.devilkits.*;
import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.block.*;
import org.bukkit.util.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.block.*;
import org.bukkit.event.entity.*;
import org.bukkit.entity.*;

public class Kangaroo implements Listener, CommandExecutor
{
    public static ArrayList<Player> kangaroo;
    public static Main plugin;
    
    static {
        Kangaroo.kangaroo = new ArrayList<Player>();
    }
    
    public Kangaroo(final Main main) {
        Kangaroo.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("kangaroo")) {
            if (!Main.usandokit.contains(p.getName()) && p.hasPermission("kit.kangaroo")) {
                p.sendMessage("�7Voce pegou o Kit : �6Kangaroo");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                Main.usandokit.add(p.getName());
                Main.kangaroo.add(sender.getName());
                p.getInventory().clear();
                final ItemStack espada = new ItemStack(Material.WOOD_SWORD);
                final ItemMeta espadameta = espada.getItemMeta();
                espadameta.setDisplayName("�cSword");
                espada.addEnchantment(Enchantment.DURABILITY, 3);
                p.getInventory().addItem(new ItemStack[] { espada });
                final ItemStack bow = new ItemStack(Material.FIREWORK);
                final ItemMeta bowmeta = bow.getItemMeta();
                bowmeta.setDisplayName("�cKangaroo Rocket");
                bow.setItemMeta(bowmeta);
                p.getInventory().addItem(new ItemStack[] { bow });
                Main.giveSoup(p, 34);
            }
            return true;
        }
        return false;
    }
    
    @EventHandler
    public void onInteract(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (p.getItemInHand().getType() == Material.FIREWORK) {
            if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
                event.setCancelled(true);
            }
            if (Main.kangaroo.contains(p.getName()) && !Kangaroo.kangaroo.contains(p)) {
                if (!p.isSneaking()) {
                    p.setFallDistance(-5.0f);
                    final Vector vector = p.getEyeLocation().getDirection();
                    vector.multiply(0.6f);
                    vector.setY(1.2f);
                    p.setVelocity(vector);
                }
                else {
                    p.setFallDistance(-5.0f);
                    final Vector vector = p.getEyeLocation().getDirection();
                    vector.multiply(1.2f);
                    vector.setY(0.8);
                    p.setVelocity(vector);
                }
                Kangaroo.kangaroo.add(p);
            }
        }
    }
    
    @EventHandler
    public void onMove(final PlayerMoveEvent event) {
        final Player p = event.getPlayer();
        if (Kangaroo.kangaroo.contains(p)) {
            final Block b = p.getLocation().getBlock();
            if (b.getType() != Material.AIR || b.getRelative(BlockFace.DOWN).getType() != Material.AIR) {
                Kangaroo.kangaroo.remove(p);
            }
        }
    }
    
    @EventHandler
    public void onDamage(final EntityDamageEvent event) {
        final Entity e = event.getEntity();
        if (e instanceof Player) {
            final Player player = (Player)e;
            if (event.getEntity() instanceof Player && event.getCause() == EntityDamageEvent.DamageCause.FALL && player.getInventory().contains(Material.FIREWORK) && event.getDamage() >= 7.0) {
                event.setDamage(7.0);
            }
        }
    }
}