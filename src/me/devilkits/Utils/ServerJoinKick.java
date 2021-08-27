package me.devilkits.Utils;

import me.devilkits.*;
import org.bukkit.event.player.*;
import org.bukkit.event.*;
import org.bukkit.entity.*;

public class ServerJoinKick implements Listener
{
    public Main plugin;
    
    public ServerJoinKick(final Main main) {
        this.plugin = main;
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerLogin(final PlayerLoginEvent e) {
        if (e.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
            e.setKickMessage("§6Servidor lotado! \n §7Compre §6§lVIP §7para poder ter seu slot vago!");
        }
        if (e.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST) {
            e.setKickMessage("§7Servidor em modo §cMANUTENCAO§7! \n §7Aguarde! Ja voltamos...");
        }
        if (e.getResult() == PlayerLoginEvent.Result.KICK_BANNED) {
            e.setKickMessage("§7Voce foi §cBANIDO§7! \n §7Na loja do servidor voce podera comprar unban! \n §7Visite o site para obter informacoes!");
        }
    }
    
    @EventHandler
    public void fullJoin(final PlayerLoginEvent event) {
        final Player p = event.getPlayer();
        if (event.getResult() == PlayerLoginEvent.Result.KICK_FULL && p.hasPermission("DevilKits.joinfull")) {
            event.setResult(PlayerLoginEvent.Result.ALLOWED);
        }
    }
}
