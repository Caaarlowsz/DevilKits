package me.devilkits.Kits;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import me.devilkits.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import java.util.*;
import java.util.concurrent.*;
import org.bukkit.*;
import org.bukkit.block.*;
import org.bukkit.event.*;

public class Flash implements Listener, CommandExecutor
{
    public static HashMap<String, Long> cooldown;
    
    static {
        Flash.cooldown = new HashMap<String, Long>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("flash")) {
            if (!Main.usandokit.contains(p.getName()) && p.hasPermission("kit.flash")) {
                p.sendMessage("§7Voce pegou o Kit : §6Flash");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                Main.usandokit.add(p.getName());
                Main.flash.add(sender.getName());
                final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
                p.getInventory().clear();
                dima.addEnchantment(Enchantment.DURABILITY, 3);
                p.getInventory().addItem(new ItemStack[] { dima });
                p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.REDSTONE_TORCH_ON) });
                Main.giveSoup(p, 34);
            }
            return true;
        }
        return false;
    }
    
    @EventHandler
    public void flash(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && Main.flash.contains(p.getName()) && p.getItemInHand().getType() == Material.REDSTONE_TORCH_ON) {
            if (!Flash.cooldown.containsKey(p.getName()) || Flash.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
                e.setCancelled(true);
                p.updateInventory();
                final Block b = p.getTargetBlock((HashSet)null, 100).getRelative(BlockFace.UP);
                p.teleport(b.getLocation());
                p.playSound(p.getLocation(), Sound.AMBIENCE_CAVE, 10.0f, 10.0f);
                Flash.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(20L));
                return;
            }
            p.sendMessage(ChatColor.GRAY + "Faltam " + TimeUnit.MILLISECONDS.toSeconds(Flash.cooldown.get(p.getName()) - System.currentTimeMillis()) + " segundos para poder usar novamente.");
        }
    }
}
