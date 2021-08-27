package me.devilkits.Kits;

import me.devilkits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;

public class Specialist implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Specialist(final Main main) {
        Specialist.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("specialist")) {
            if (!Main.usandokit.contains(p.getName()) && p.hasPermission("kit.specialist")) {
                p.sendMessage("�7Voce pegou o Kit : �6Specialist");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                Main.usandokit.add(p.getName());
                Main.specialist.add(sender.getName());
                p.getInventory().clear();
                final ItemStack espada = new ItemStack(Material.WOOD_SWORD);
                final ItemMeta espadameta = espada.getItemMeta();
                espadameta.setDisplayName("�cSword");
                p.getInventory().addItem(new ItemStack[] { espada });
                p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.ENCHANTED_BOOK) });
                Main.giveSoup(p, 34);
            }
            return true;
        }
        return false;
    }
    
    @EventHandler
    public void onIasnteract(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (Main.specialist.contains(p.getName()) && (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.ENCHANTED_BOOK) {
            p.openEnchanting((Location)null, true);
        }
    }
    
    @EventHandler
    public void onVampire(final EntityDeathEvent event) {
        if (event.getEntity() instanceof Player) {
            final Player killed = (Player)event.getEntity();
            if (killed.getKiller() instanceof Player) {
                final Player player = event.getEntity().getKiller();
                if (Main.specialist.contains(player.getName())) {
                    player.setLevel(1);
                }
            }
        }
    }
}
