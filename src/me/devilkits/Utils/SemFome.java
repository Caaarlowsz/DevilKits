package me.devilkits.Utils;

import org.bukkit.event.entity.*;
import org.bukkit.event.*;

public class SemFome implements Listener
{
    @EventHandler
    public void Fome(final FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }
}
