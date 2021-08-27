package me.devilkits.Utils;

import me.devilkits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class Ban implements CommandExecutor
{
    private Main plugin;
    
    public Ban(final Main plugin) {
        this.plugin = plugin;
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.equalsIgnoreCase("ban") && p.hasPermission("DevilKits.ban")) {
            if (args.length >= 2) {
                final Player target = p.getServer().getPlayer(args[0]);
                if (target != null) {
                    if (!target.isOp()) {
                        target.setBanned(true);
                        target.kickPlayer(args[1]);
                        p.sendMessage(ChatColor.RED + "Voce baniu " + target.getName());
                    }
                    else {
                        p.sendMessage(ChatColor.GRAY + "Erro: " + ChatColor.RED + "Esse jogador nao pode ser banido.");
                    }
                }
                else {
                    p.sendMessage(ChatColor.GRAY + "Erro: " + ChatColor.RED + "Jogador inexistente.");
                }
            }
            else {
                p.sendMessage(ChatColor.GRAY + "Use /" + cmd + " <jogador> <motivo>");
            }
        }
        return true;
    }
}
