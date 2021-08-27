package me.devilkits.Utils;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class Suicide implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        if (cmd.equalsIgnoreCase("morrer")) {
            final Player player = (Player)sender;
            Bukkit.broadcastMessage("§7" + player.getName() + " §cse suicidou");
            player.setHealth(0.0);
        }
        return false;
    }
}
