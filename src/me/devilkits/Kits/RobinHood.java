package me.devilkits.Kits;

import me.devilkits.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.potion.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.meta.*;

public class RobinHood implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public RobinHood(final Main main) {
        RobinHood.plugin = main;
    }
    
    @EventHandler
    public void onEntityDamageByEntity(final EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Arrow && ((Arrow)event.getDamager()).getShooter() instanceof Player) {
            final Arrow arrow = (Arrow)event.getDamager();
            final Player p = (Player)arrow.getShooter();
            p.getLocation().distance(event.getEntity().getLocation());
            if (event.getEntity() instanceof Player && Main.robinhood.contains(p.getName())) {
                p.playSound(p.getLocation(), Sound.WITHER_SHOOT, 1.0f, 1.0f);
                event.setDamage(20.0);
            }
        }
    }
    
    @EventHandler
    public void robinHoodKill(final PlayerDeathEvent event) {
        if (!(event.getEntity().getKiller() instanceof Player)) {
            return;
        }
        if (event.getEntity().getKiller() == null) {
            return;
        }
        if (Main.robinhood.contains(event.getEntity().getKiller().getName())) {
            event.getEntity().getKiller().getInventory().addItem(new ItemStack[] { new ItemStack(Material.ARROW) });
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
        final ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§cSword");
        dima.setItemMeta(souperaa);
        final ItemStack arco = new ItemStack(Material.BOW);
        final ItemMeta arcoa = arco.getItemMeta();
        arcoa.setDisplayName("§6Robin's Bow");
        arco.setItemMeta(arcoa);
        final ItemStack flecha = new ItemStack(Material.ARROW, 1);
        final ItemMeta flecas = flecha.getItemMeta();
        flecas.setDisplayName("7Arrow");
        flecha.setItemMeta(flecas);
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("6oSopa");
        sopa.setItemMeta(sopas);
        if (cmd.equalsIgnoreCase("robinhood")) {
            if (Main.usandokit.contains(p.getName())) {
                p.sendMessage("§cVoce ja esta usando um kit");
                return true;
            }
            if (!p.hasPermission("kit.robinhood")) {
                p.sendMessage("§cVoce ja esta usando um kit!");
                return true;
            }
            Main.usandokit.add(p.getName());
            p.sendMessage("§7Voce pegou o Kit : §6RobinHood");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 999999, 0));
            Main.robinhood.add(p.getName());
            dima.addEnchantment(Enchantment.DURABILITY, 3);
            arco.addEnchantment(Enchantment.ARROW_INFINITE, 1);
            p.getInventory().addItem(new ItemStack[] { dima });
            p.getInventory().addItem(new ItemStack[] { arco });
            p.getInventory().addItem(new ItemStack[] { flecha });
            for (int i = 0; i <= 34; ++i) {
                p.getInventory().addItem(new ItemStack[] { sopa });
            }
        }
        return false;
    }
}
