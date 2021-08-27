package me.devilkits.Utils;

import me.devilkits.*;
import org.bukkit.event.server.*;
import org.bukkit.event.*;

public class Motd implements Listener
{
    public Main plugin;
    
    public Motd(final Main instance) {
        this.plugin = instance;
    }
    
    @EventHandler
    public void Motd(final ServerListPingEvent e) {
        final String MSG_Motd = this.plugin.getConfig().getString("Motd");
        e.setMotd(MSG_Motd.replace("&", "§"));
    }
}
