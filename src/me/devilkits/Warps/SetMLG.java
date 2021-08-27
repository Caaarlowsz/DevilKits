package me.devilkits.Warps;

import org.bukkit.event.*;
import me.devilkits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class SetMLG implements CommandExecutor, Listener
{
    public static Main plugin;
    
    public SetMLG(final Main main) {
        SetMLG.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("setmlg") && sender instanceof Player) {
            if (!sender.hasPermission("DevilKits.setwarp")) {
                final Player p1 = (Player)sender;
                p1.sendMessage("§cVoce nao tem permissao!");
            }
            if (sender.hasPermission("DevilKits.setwarp")) {
                final Player p1 = (Player)sender;
                SetMLG.plugin.getConfig().set("mlg.x", (Object)p1.getLocation().getX());
                SetMLG.plugin.getConfig().set("mlg.y", (Object)p1.getLocation().getY());
                SetMLG.plugin.getConfig().set("mlg.z", (Object)p1.getLocation().getZ());
                SetMLG.plugin.getConfig().set("mlg.pitch", (Object)p1.getLocation().getPitch());
                SetMLG.plugin.getConfig().set("mlg.yaw", (Object)p1.getLocation().getYaw());
                SetMLG.plugin.getConfig().set("mlg.world", (Object)p1.getLocation().getWorld().getName());
                SetMLG.plugin.saveConfig();
                p1.sendMessage("§7Warp MLG setada com sucesso");
            }
        }
        return false;
    }
}
