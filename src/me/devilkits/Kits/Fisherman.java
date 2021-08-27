package me.devilkits.Kits;

import me.devilkits.*;
import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.player.*;
import org.bukkit.entity.*;
import org.bukkit.block.*;
import org.bukkit.event.*;

public class Fisherman implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Fisherman(final Main main) {
        Fisherman.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("fisherman")) {
            if (!Main.usandokit.contains(p.getName()) && p.hasPermission("kit.fisherman")) {
                p.sendMessage("§7Voce pegou o Kit : §6Fisherman");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                Main.usandokit.add(p.getName());
                Main.fisherman.add(sender.getName());
                p.getInventory().clear();
                final ItemStack espada = new ItemStack(Material.WOOD_SWORD);
                final ItemMeta espadameta = espada.getItemMeta();
                espadameta.setDisplayName("§cSword");
                espada.addEnchantment(Enchantment.DURABILITY, 3);
                p.getInventory().addItem(new ItemStack[] { espada });
                final ItemStack bow = new ItemStack(Material.FISHING_ROD);
                final ItemMeta bowmeta = bow.getItemMeta();
                bowmeta.setDisplayName("§5Fishing Rod");
                bow.setItemMeta(bowmeta);
                p.getInventory().addItem(new ItemStack[] { bow });
                Main.giveSoup(p, 34);
            }
            return true;
        }
        return false;
    }
    
    @EventHandler
    public void onPlayerFish(final PlayerFishEvent event) {
        final Entity caught = event.getCaught();
        final Block block = event.getHook().getLocation().getBlock();
        if (caught != null && caught != block && Main.fisherman.contains(event.getPlayer().getName())) {
            caught.teleport(event.getPlayer().getLocation());
        }
    }
}
