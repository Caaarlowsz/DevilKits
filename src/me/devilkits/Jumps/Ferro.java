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

public class Ferro implements Listener
{
    public static Main plugin;
    public static ArrayList<String> Ferro;
    
    static {
        me.devilkits.Jumps.Ferro.Ferro = new ArrayList<String>();
    }
    
    public Ferro(final Main main) {
        me.devilkits.Jumps.Ferro.plugin = main;
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJump1(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.IRON_BLOCK) {
            me.devilkits.Jumps.Ferro.Ferro.remove(p.getName());
            final Location loc = e.getTo().getBlock().getLocation();
            final Vector sponge = p.getLocation().getDirection().multiply(0).setY(2);
            p.setVelocity(sponge);
            me.devilkits.Jumps.Ferro.Ferro.add(p.getName());
        }
    }
    
    @EventHandler
    public void onFall(final EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            final Player p = (Player)e.getEntity();
            if (e.getCause().equals((Object)EntityDamageEvent.DamageCause.FALL) && me.devilkits.Jumps.Ferro.Ferro.contains(p.getName())) {
                e.setCancelled(true);
                me.devilkits.Jumps.Ferro.Ferro.remove(p.getName());
            }
        }
    }
}
