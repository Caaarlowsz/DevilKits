package me.devilkits.Utils;

import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class Chat implements Listener
{
    @EventHandler
    public void onPlayerChatRank(final AsyncPlayerChatEvent e) {
        final Player p = e.getPlayer();
        e.setFormat(String.valueOf(p.getDisplayName()) + ChatColor.GOLD + " » " + ChatColor.RESET + e.getMessage().replace("&", "§"));
    }
}
