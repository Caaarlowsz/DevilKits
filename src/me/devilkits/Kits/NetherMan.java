package me.devilkits.Kits;

import me.devilkits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.player.*;
import org.bukkit.block.*;
import org.bukkit.potion.*;
import org.bukkit.event.*;

public class NetherMan implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public NetherMan(final Main main) {
        NetherMan.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("netherman")) {
            if (!Main.usandokit.contains(p.getName()) && p.hasPermission("kit.netherman")) {
                p.sendMessage("�7Voce pegou o Kit : �6NetherMan");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                Main.usandokit.add(p.getName());
                Main.netherman.add(sender.getName());
                p.getInventory().clear();
                final ItemStack espada = new ItemStack(Material.WOOD_SWORD);
                final ItemMeta espadameta = espada.getItemMeta();
                espadameta.setDisplayName("�cSword");
                espada.addEnchantment(Enchantment.DURABILITY, 3);
                p.getInventory().addItem(new ItemStack[] { espada });
                Main.giveSoup(p, 34);
            }
            return true;
        }
        return false;
    }
    
    @EventHandler
    public void onPlayernetherman(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if ((e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.NETHERRACK || e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.NETHER_BRICK) && Main.netherman.contains(p.getName())) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 80, 0));
            p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 80, 0));
        }
    }
}