package me.devilkits.Utils;

import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.help.*;
import org.bukkit.event.*;

public class ComandoErrado implements Listener
{
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerCommandPreprocess(final PlayerCommandPreprocessEvent event) {
        if (!event.isCancelled()) {
            final Player player = event.getPlayer();
            final String cmd = event.getMessage().split(" ")[0];
            final HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(cmd);
            if (topic == null) {
                player.sendMessage("§7Ops... comando errado!");
                player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 1.0f, 1.0f);
                event.setCancelled(true);
            }
        }
    }
}
