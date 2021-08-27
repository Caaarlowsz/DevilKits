package me.devilkits.Kits;

import me.devilkits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.entity.*;
import org.bukkit.*;
import org.bukkit.event.*;

public class Resouper implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Resouper(final Main main) {
        Resouper.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("resouper")) {
            if (!Main.usandokit.contains(p.getName()) && p.hasPermission("kit.resouper")) {
                p.sendMessage("§7Voce pegou o Kit : §6Resouper");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                Main.usandokit.add(p.getName());
                Main.resouper.add(sender.getName());
                p.getInventory().clear();
                final ItemStack espada = new ItemStack(Material.WOOD_SWORD);
                final ItemMeta espadameta = espada.getItemMeta();
                espadameta.setDisplayName("§cSword");
                espada.addEnchantment(Enchantment.DURABILITY, 3);
                p.getInventory().addItem(new ItemStack[] { espada });
                Main.giveSoup(p, 35);
            }
            return true;
        }
        return false;
    }
    
    @EventHandler
    public void onKill(final PlayerDeathEvent e) {
        if (e.getEntity().getKiller() instanceof Player) {
            final Player k = e.getEntity().getKiller();
            if (Main.resouper.contains(k.getName())) {
                k.getInventory().remove(Material.BOWL);
                try {
                    for (int i = 0; i < 34; ++i) {
                        k.getInventory().setItem(k.getInventory().firstEmpty(), new ItemStack(Material.MUSHROOM_SOUP));
                    }
                }
                catch (ArrayIndexOutOfBoundsException ex) {}
                k.sendMessage(ChatColor.GREEN + "Resoup Automatico Concluido!");
                k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            }
        }
    }
}
