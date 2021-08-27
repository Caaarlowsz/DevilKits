package me.devilkits.Warps;

import org.bukkit.event.*;
import me.devilkits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class SetHG implements CommandExecutor, Listener
{
    public static Main plugin;
    
    public SetHG(final Main main) {
        SetHG.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("sethg") && sender instanceof Player) {
            if (!sender.hasPermission("DevilKits.setwarp")) {
                final Player p1 = (Player)sender;
                p1.sendMessage("§cVoce nao tem permissao!");
            }
            if (sender.hasPermission("DevilKits.setwarp")) {
                final Player p1 = (Player)sender;
                SetHG.plugin.getConfig().set("hg.x", (Object)p1.getLocation().getX());
                SetHG.plugin.getConfig().set("hg.y", (Object)p1.getLocation().getY());
                SetHG.plugin.getConfig().set("hg.z", (Object)p1.getLocation().getZ());
                SetHG.plugin.getConfig().set("hg.pitch", (Object)p1.getLocation().getPitch());
                SetHG.plugin.getConfig().set("hg.yaw", (Object)p1.getLocation().getYaw());
                SetHG.plugin.getConfig().set("hg.world", (Object)p1.getLocation().getWorld().getName());
                SetHG.plugin.saveConfig();
                p1.sendMessage("§7Warp HG setada com sucesso");
            }
        }
        return false;
    }
}
