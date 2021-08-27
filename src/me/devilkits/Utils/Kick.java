package me.devilkits.Utils;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class Kick implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("kick")) {
            if (sender instanceof ConsoleCommandSender) {
                System.out.println("Console nao pode usar esse comando");
                return true;
            }
            final Player p = (Player)sender;
            if (p.hasPermission("DevilKits.kick") || p.isOp()) {
                if (args.length == 0) {
                    p.sendMessage(ChatColor.GRAY + "Use /kick <player> <motivo>.");
                }
                else if (args.length == 1) {
                    final Player targetPlayer = p.getServer().getPlayer(args[0]);
                    if (targetPlayer == null) {
                        p.sendMessage("§4Este jogador esta offline!");
                    }
                    else {
                        Bukkit.broadcastMessage(ChatColor.RED + targetPlayer.getDisplayName() + "§7 foi kickado por §c" + p.getDisplayName() + ".");
                    }
                }
                else if (args.length > 1) {
                    final Player targetPlayer = p.getServer().getPlayer(args[0]);
                    if (targetPlayer == null) {
                        p.sendMessage("§4Este jogador esta offline!");
                    }
                    else {
                        String message = "";
                        for (int i = 1; i < args.length; ++i) {
                            message = String.valueOf(message) + args[i] + " ";
                        }
                        targetPlayer.kickPlayer("§7Voce foi kickado pelo jogador §c" + p.getDisplayName() + " §7por > " + message);
                        Bukkit.broadcastMessage(ChatColor.RED + targetPlayer.getDisplayName() + " §7Foi kickado por §c" + p.getDisplayName() + " §7por " + message);
                    }
                }
            }
            else {
                p.sendMessage("§4Sem permissao!");
            }
        }
        return false;
    }
}
