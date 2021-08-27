package me.devilkits.Utils;

import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.*;

public class NoDropItens implements Listener
{
    @EventHandler
    public void onPickup(final PlayerPickupItemEvent e) {
        e.setCancelled(false);
    }
    
    @EventHandler
    public void onDropSwordsandHabilidades(final PlayerDropItemEvent e) {
        if (e.getItemDrop().getItemStack().getType() == Material.STONE_SWORD || e.getItemDrop().getItemStack().getType() == Material.STONE_SWORD || e.getItemDrop().getItemStack().getType() == Material.DIAMOND || e.getItemDrop().getItemStack().getType() == Material.DIAMOND || e.getItemDrop().getItemStack().getType() == Material.QUARTZ || e.getItemDrop().getItemStack().getType() == Material.WOOD_AXE || e.getItemDrop().getItemStack().getType() == Material.MILK_BUCKET || e.getItemDrop().getItemStack().getType() == Material.NETHER_STAR || e.getItemDrop().getItemStack().getType() == Material.APPLE || e.getItemDrop().getItemStack().getType() == Material.FISHING_ROD || e.getItemDrop().getItemStack().getType() == Material.STONE_SWORD || e.getItemDrop().getItemStack().getType() == Material.STICK || e.getItemDrop().getItemStack().getType() == Material.SADDLE || e.getItemDrop().getItemStack().getType() == Material.WOOD_HOE || e.getItemDrop().getItemStack().getType() == Material.MONSTER_EGG || e.getItemDrop().getItemStack().getType() == Material.BEDROCK || e.getItemDrop().getItemStack().getType() == Material.LEASH || e.getItemDrop().getItemStack().getType() == Material.REDSTONE || e.getItemDrop().getItemStack().getType() == Material.PAPER || e.getItemDrop().getItemStack().getType() == Material.STONE_AXE || e.getItemDrop().getItemStack().getType() == Material.SNOW_BALL || e.getItemDrop().getItemStack().getType() == Material.SLIME_BALL || e.getItemDrop().getItemStack().getType() == Material.PORTAL || e.getItemDrop().getItemStack().getType() == Material.BLAZE_POWDER || e.getItemDrop().getItemStack().getType() == Material.POTION || e.getItemDrop().getItemStack().getType() == Material.BOW || e.getItemDrop().getItemStack().getType() == Material.ARROW || e.getItemDrop().getItemStack().getType() == Material.GOLDEN_APPLE || e.getItemDrop().getItemStack().getType() == Material.FIREWORK || e.getItemDrop().getItemStack().getType() == Material.EMERALD || e.getItemDrop().getItemStack().getType() == Material.CHEST || (e.getItemDrop().getItemStack().getType() == Material.DIAMOND_SWORD | e.getItemDrop().getItemStack().getType() == Material.WATCH | e.getItemDrop().getItemStack().getType() == Material.SHEARS | e.getItemDrop().getItemStack().getType() == Material.GHAST_TEAR)) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onDropItensIniciais(final PlayerDropItemEvent e) {
        if ((e.getItemDrop().getItemStack().getType() == Material.CHEST | e.getItemDrop().getItemStack().getType() == Material.THIN_GLASS | e.getItemDrop().getItemStack().getType() == Material.VINE) || e.getItemDrop().getItemStack().getType() == Material.DIAMOND || e.getItemDrop().getItemStack().getType() == Material.COMPASS || e.getItemDrop().getItemStack().getType() == Material.BOOK || e.getItemDrop().getItemStack().getType() == Material.BOOKSHELF || e.getItemDrop().getItemStack().getType() == Material.BOOKSHELF) {
            e.setCancelled(true);
        }
    }
}
