package me.devilkits.Utils;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import me.devilkits.*;
import org.bukkit.*;
import org.bukkit.event.*;

public class GanharMoney implements Listener
{
    @EventHandler
    public void Morrer(final PlayerDeathEvent e) {
        final Player p = e.getEntity();
        e.setDeathMessage((String)null);
        if (p.getKiller() instanceof Player) {
            final Player killer = p.getKiller();
            Main.econ.depositPlayer(killer.getName(), 100.0);
            killer.sendMessage(ChatColor.GOLD + "Foi depositado 100 creditos em sua conta");
        }
        e.getDrops().clear();
    }
    
    @EventHandler
    public void Morrer2(final PlayerDeathEvent e) {
        final Player p = e.getEntity();
        e.setDeathMessage((String)null);
        Main.econ.withdrawPlayer(p.getName(), 30.0);
        p.sendMessage("§7Foi descontado 30 creditos por ter morrido");
    }
}
