package me.devilkits.Utils;

import me.devilkits.*;
import org.bukkit.event.entity.*;
import org.bukkit.*;
import org.bukkit.plugin.*;
import org.bukkit.event.*;

public class DropEvent implements Listener
{
    public static Main plugin;
    
    public DropEvent(final Main main) {
        DropEvent.plugin = main;
    }
    
    @EventHandler
    public void onItemDrop(final ItemSpawnEvent e) {
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)DropEvent.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                e.getEntity().remove();
                e.getLocation().getWorld().playEffect(e.getEntity().getLocation(), Effect.ENDER_SIGNAL, 7);
            }
        }, 5L);
    }
}
