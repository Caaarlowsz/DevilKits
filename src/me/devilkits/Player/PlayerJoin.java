package me.devilkits.Player;

import me.devilkits.*;
import org.bukkit.inventory.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;

public class PlayerJoin implements Listener
{
    public Main plugin;
    
    public PlayerJoin(final Main main) {
        this.plugin = main;
    }
    
    @EventHandler
    public void Entrar(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        p.teleport(p.getWorld().getSpawnLocation());
        p.getInventory().setArmorContents((ItemStack[])null);
        final ItemStack chest = new ItemStack(Material.CHEST);
        final ItemMeta chestm = chest.getItemMeta();
        chestm.setDisplayName(ChatColor.GOLD + "Kits §7§o(§c§oClique Direito§7§o)");
        chest.setItemMeta(chestm);
        p.getPlayer().getInventory().setItem(0, chest);
        final ItemStack shop = new ItemStack(Material.COMPASS);
        final ItemMeta shopm = shop.getItemMeta();
        shopm.setDisplayName(ChatColor.GOLD + "Warps §7§o(§c§oClique Direito§7§o)");
        shop.setItemMeta(shopm);
        p.getPlayer().getInventory().setItem(3, shop);
        final ItemStack loja = new ItemStack(Material.DIAMOND);
        final ItemMeta lojam = loja.getItemMeta();
        lojam.setDisplayName(ChatColor.GOLD + "Shop §7§o(§c§oClique Direito§7§o)");
        loja.setItemMeta(lojam);
        p.getPlayer().getInventory().setItem(5, loja);
        final ItemStack vine = new ItemStack(Material.NETHER_STAR);
        final ItemMeta vinem = vine.getItemMeta();
        vinem.setDisplayName(ChatColor.GOLD + "Shop de Kit §7§o(§c§oClique Direito§7§o)");
        vine.setItemMeta(vinem);
        final ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE);
        final ItemMeta glassm = glass.getItemMeta();
        final String HotBar1 = this.plugin.getConfig().getString("HotBar");
        glassm.setDisplayName(HotBar1.replace("&", "§"));
        glass.setItemMeta(glassm);
        p.getInventory().setItem(1, glass);
        p.getInventory().setItem(2, glass);
        p.getInventory().setItem(6, glass);
        p.getInventory().setItem(7, glass);
        p.getInventory().setItem(4, vine);
    }
    
    @EventHandler
    public void NemPensarNosPlugins(final PlayerCommandPreprocessEvent e) {
        final Player p = e.getPlayer();
        if (e.getMessage().equalsIgnoreCase("/pl") || e.getMessage().equalsIgnoreCase("/plugins") || e.getMessage().equalsIgnoreCase("/plugin") || e.getMessage().equalsIgnoreCase("/bukkit:?") || e.getMessage().equalsIgnoreCase("/bukkit:plugin") || e.getMessage().equalsIgnoreCase("/bukkit:help") || e.getMessage().equalsIgnoreCase("/bukkit:pl") || e.getMessage().equalsIgnoreCase("/ver") || e.getMessage().equalsIgnoreCase("/bukkit:ver") || e.getMessage().equalsIgnoreCase("/logout") || e.getMessage().equalsIgnoreCase("/?")) {
            e.setCancelled(true);
            p.sendMessage("§2Plugin: (1)");
            p.sendMessage("§4ERROR 404");
        }
    }
    
    @EventHandler
    public void onClickItem4(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && e.getPlayer().getItemInHand().getType() == Material.DIAMOND) {
            e.setCancelled(true);
            p.chat("/buy");
        }
    }
}
