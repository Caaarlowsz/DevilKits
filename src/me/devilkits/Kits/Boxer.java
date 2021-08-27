package me.devilkits.Kits;

import me.devilkits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.*;

public class Boxer implements Listener, CommandExecutor
{
    public static Main plugin;
    public int DanoBoxer;
    
    public Boxer(final Main main) {
        this.DanoBoxer = 5;
        Boxer.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("boxer")) {
            if (!Main.usandokit.contains(p.getName()) && p.hasPermission("kit.boxer")) {
                p.sendMessage("§7Voce pegou o Kit : §6Boxer");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                Main.usandokit.add(p.getName());
                Main.bomber.add(sender.getName());
                p.getInventory().clear();
                final ItemStack espada = new ItemStack(Material.QUARTZ);
                final ItemMeta espadameta = espada.getItemMeta();
                espadameta.setDisplayName("§cSword");
                p.getInventory().addItem(new ItemStack[] { espada });
                Main.giveSoup(p, 35);
            }
            return true;
        }
        return false;
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            final Player boxer = (Player)e.getDamager();
            if (Main.bomber.contains(boxer.getName()) && boxer.getItemInHand().getType() == Material.QUARTZ) {
                e.setDamage((double)this.DanoBoxer);
            }
        }
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            final Player boxer = (Player)e.getEntity();
            final Player player = (Player)e.getDamager();
            if (Main.bomber.contains(boxer.getName()) && player.getItemInHand() == null) {
                e.setDamage(e.getDamage() - 1.0);
            }
        }
    }
}
