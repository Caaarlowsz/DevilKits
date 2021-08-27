package me.devilkits.Jumps;

import me.devilkits.*;
import java.util.*;
import org.bukkit.event.player.*;
import org.bukkit.block.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.util.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;

public class Redstone implements Listener
{
    public static Main plugin;
    public static ArrayList<String> RedStone;
    
    static {
        Redstone.RedStone = new ArrayList<String>();
    }
    
    public Redstone(final Main main) {
        Redstone.plugin = main;
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJump1(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.REDSTONE_BLOCK) {
            Redstone.RedStone.remove(p.getName());
            final Location loc = e.getTo().getBlock().getLocation();
            final Vector sponge = p.getLocation().getDirection().multiply(3).setY(1);
            p.setVelocity(sponge);
            Redstone.RedStone.add(p.getName());
        }
    }
    
    @EventHandler
    public void onFall(final EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            final Player p = (Player)e.getEntity();
            if (e.getCause().equals((Object)EntityDamageEvent.DamageCause.FALL) && Redstone.RedStone.contains(p.getName())) {
                e.setCancelled(true);
                Redstone.RedStone.remove(p.getName());
            }
        }
    }
}
