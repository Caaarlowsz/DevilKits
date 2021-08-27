package me.devilkits.Warps;

import org.bukkit.event.*;
import me.devilkits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class SetMDR implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public SetMDR(final Main main) {
        SetMDR.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("setmdr") && sender instanceof Player) {
            if (!sender.hasPermission("DevilKits.setwarp")) {
                final Player p = (Player)sender;
                p.sendMessage("§cVoce nao tem permissao!");
            }
            if (sender.hasPermission("DevilKits.setwarp")) {
                final Player p = (Player)sender;
                SetMDR.plugin.getConfig().set("mdr.x", (Object)p.getLocation().getX());
                SetMDR.plugin.getConfig().set("mdr.y", (Object)p.getLocation().getY());
                SetMDR.plugin.getConfig().set("mdr.z", (Object)p.getLocation().getZ());
                SetMDR.plugin.getConfig().set("mdr.pitch", (Object)p.getLocation().getPitch());
                SetMDR.plugin.getConfig().set("mdr.yaw", (Object)p.getLocation().getYaw());
                SetMDR.plugin.getConfig().set("mdr.world", (Object)p.getLocation().getWorld().getName());
                SetMDR.plugin.saveConfig();
                p.sendMessage("§7Warp MDR setada com sucesso");
            }
            return true;
        }
        return false;
    }
}
