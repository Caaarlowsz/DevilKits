package me.devilkits.Seletor;

import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.command.*;
import org.bukkit.event.inventory.*;
import org.bukkit.event.*;

public class Warps implements Listener, CommandExecutor
{
    public void gui(final Player p) {
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 27, ChatColor.GOLD + "Warps");
        final ItemStack Painel = new ItemStack(Material.THIN_GLASS);
        final ItemMeta PainelMeta = Painel.getItemMeta();
        PainelMeta.setDisplayName(ChatColor.GRAY + " ");
        Painel.setItemMeta(PainelMeta);
        inv.setItem(0, Painel);
        inv.setItem(1, Painel);
        inv.setItem(2, Painel);
        inv.setItem(3, Painel);
        inv.setItem(5, Painel);
        inv.setItem(6, Painel);
        inv.setItem(7, Painel);
        inv.setItem(8, Painel);
        inv.setItem(9, Painel);
        inv.setItem(17, Painel);
        inv.setItem(18, Painel);
        inv.setItem(19, Painel);
        inv.setItem(20, Painel);
        inv.setItem(21, Painel);
        inv.setItem(23, Painel);
        inv.setItem(24, Painel);
        inv.setItem(25, Painel);
        inv.setItem(26, Painel);
        final ItemStack fps = new ItemStack(Material.GLASS);
        final ItemMeta fpsmeta = fps.getItemMeta();
        fpsmeta.setDisplayName(ChatColor.GOLD + "FPS");
        fps.setItemMeta(fpsmeta);
        final ItemStack rdm = new ItemStack(Material.CAKE);
        final ItemMeta rdmmeta = rdm.getItemMeta();
        rdmmeta.setDisplayName(ChatColor.GOLD + "RDM");
        rdm.setItemMeta(rdmmeta);
        final ItemStack main = new ItemStack(Material.POTION, 1, (short)16421);
        final ItemMeta mainmeta = main.getItemMeta();
        mainmeta.setDisplayName(ChatColor.GOLD + "MAIN");
        main.setItemMeta(mainmeta);
        final ItemStack challenge = new ItemStack(Material.LAVA_BUCKET);
        final ItemMeta challengemeta = challenge.getItemMeta();
        challengemeta.setDisplayName(ChatColor.GOLD + "LAVA CHALLENGER");
        challenge.setItemMeta(challengemeta);
        final ItemStack mdr = new ItemStack(Material.DIAMOND_SWORD);
        final ItemMeta mdrmeta = mdr.getItemMeta();
        mdrmeta.setDisplayName(ChatColor.GOLD + "MDR");
        mdr.setItemMeta(mdrmeta);
        final ItemStack versos = new ItemStack(Material.BLAZE_ROD);
        final ItemMeta versosmeta = versos.getItemMeta();
        versosmeta.setDisplayName(ChatColor.GOLD + "1v1");
        versos.setItemMeta(versosmeta);
        final ItemStack mlg = new ItemStack(Material.WATER_BUCKET);
        final ItemMeta mlgmeta = mlg.getItemMeta();
        mlgmeta.setDisplayName(ChatColor.GOLD + "MLG");
        mlg.setItemMeta(mlgmeta);
        final ItemStack knock = new ItemStack(Material.STICK);
        final ItemMeta knockmeta = knock.getItemMeta();
        knockmeta.setDisplayName(ChatColor.GOLD + "Knock");
        knock.setItemMeta(knockmeta);
        final ItemStack hg = new ItemStack(Material.BOWL);
        final ItemMeta hgmeta = hg.getItemMeta();
        hgmeta.setDisplayName(ChatColor.GOLD + "HG");
        hg.setItemMeta(hgmeta);
        fpsmeta.setDisplayName(ChatColor.GOLD + "FPS");
        fps.setItemMeta(fpsmeta);
        inv.setItem(10, fps);
        mdrmeta.setDisplayName(ChatColor.GOLD + "MDR");
        mdr.setItemMeta(mdrmeta);
        inv.setItem(11, mdr);
        mainmeta.setDisplayName(ChatColor.GOLD + "MAIN");
        main.setItemMeta(mainmeta);
        inv.setItem(12, main);
        rdmmeta.setDisplayName(ChatColor.GOLD + "RDM");
        rdm.setItemMeta(rdmmeta);
        inv.setItem(13, rdm);
        challengemeta.setDisplayName(ChatColor.GOLD + "LAVA CHALLENGER");
        challenge.setItemMeta(challengemeta);
        inv.setItem(14, challenge);
        versosmeta.setDisplayName(ChatColor.GOLD + "1V1");
        versos.setItemMeta(versosmeta);
        inv.setItem(15, versos);
        hgmeta.setDisplayName(ChatColor.GOLD + "HG");
        hg.setItemMeta(hgmeta);
        inv.setItem(16, hg);
        mlg.setItemMeta(mlgmeta);
        inv.setItem(4, mlg);
        knock.setItemMeta(knockmeta);
        inv.setItem(22, knock);
        p.openInventory(inv);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("warps") || commandLabel.equalsIgnoreCase("warp")) {
            final Player p = (Player)sender;
            this.gui(p);
        }
        return false;
    }
    
    @EventHandler
    public void onInteract(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getName().equalsIgnoreCase(ChatColor.GOLD + "Warps")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getType() == Material.GLASS) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/fps");
            }
            if (e.getCurrentItem().getType() == Material.DIAMOND_SWORD) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/mdr");
            }
            if (e.getCurrentItem().getType() == Material.CAKE) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/rdm");
            }
            if (e.getCurrentItem().getType() == Material.BLAZE_ROD) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/1v1");
            }
            if (e.getCurrentItem().getType() == Material.BOWL) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/hg");
            }
            if (e.getCurrentItem().getType() == Material.LAVA_BUCKET) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/challenge");
            }
            if (e.getCurrentItem().getType() == Material.POTION) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/main");
            }
            if (e.getCurrentItem().getType() == Material.WATER_BUCKET) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/mlg");
            }
            if (e.getCurrentItem().getType() == Material.STICK) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/knock");
            }
        }
    }
}
