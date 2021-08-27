package me.devilkits.Warps;

import org.bukkit.event.*;
import me.devilkits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class SetKnock implements CommandExecutor, Listener
{
    public static Main plugin;
    
    public SetKnock(final Main main) {
        SetKnock.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("setknock") && sender instanceof Player) {
            if (!sender.hasPermission("DevilKits.setwarp")) {
                final Player p1 = (Player)sender;
                p1.sendMessage("§cVoce nao tem permissao!");
            }
            if (sender.hasPermission("DevilKits.setwarp")) {
                final Player p1 = (Player)sender;
                SetKnock.plugin.getConfig().set("knock.x", (Object)p1.getLocation().getX());
                SetKnock.plugin.getConfig().set("knock.y", (Object)p1.getLocation().getY());
                SetKnock.plugin.getConfig().set("knock.z", (Object)p1.getLocation().getZ());
                SetKnock.plugin.getConfig().set("knock.pitch", (Object)p1.getLocation().getPitch());
                SetKnock.plugin.getConfig().set("knock.yaw", (Object)p1.getLocation().getYaw());
                SetKnock.plugin.getConfig().set("knock.world", (Object)p1.getLocation().getWorld().getName());
                SetKnock.plugin.saveConfig();
                p1.sendMessage("§7Warp Knock setada com sucesso");
            }
        }
        return false;
    }
}
