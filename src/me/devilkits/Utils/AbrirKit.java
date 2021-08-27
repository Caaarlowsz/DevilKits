package me.devilkits.Utils;

import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.*;
import org.bukkit.event.*;

public class AbrirKit implements Listener
{
    @EventHandler
    public void onClickItem(final PlayerInteractEvent e) {
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && e.getPlayer().getItemInHand().getType() == Material.CHEST) {
            e.setCancelled(true);
            e.getPlayer().chat("/kits");
        }
    }
    
    @EventHandler
    public void onClickItem1(final PlayerInteractEvent e) {
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && e.getPlayer().getItemInHand().getType() == Material.COMPASS) {
            e.setCancelled(true);
            e.getPlayer().chat("/warps");
        }
    }
    
    @EventHandler
    public void onClickItem2(final PlayerInteractEvent e) {
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && e.getPlayer().getItemInHand().getType() == Material.NETHER_STAR) {
            e.setCancelled(true);
            e.getPlayer().chat("/loja");
        }
    }
}
