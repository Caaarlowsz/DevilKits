package me.devilkits.Warps;

import org.bukkit.event.*;
import me.devilkits.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.potion.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import java.util.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.plugin.*;
import org.bukkit.*;

public class Knock implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Knock(final Main main) {
        Knock.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("knock")) {
            final Player p = (Player)sender;
            final World w = Bukkit.getServer().getWorld(Knock.plugin.getConfig().getString("knock.world"));
            final double x = Knock.plugin.getConfig().getDouble("knock.x");
            final double y = Knock.plugin.getConfig().getDouble("knock.y");
            final double z = Knock.plugin.getConfig().getDouble("knock.z");
            final Location lobby = new Location(w, x, y, z);
            lobby.setPitch((float)Knock.plugin.getConfig().getDouble("knock.pitch"));
            lobby.setYaw((float)Knock.plugin.getConfig().getDouble("knock.yaw"));
            p.getInventory().clear();
            p.setHealthScale(1.0);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 130, 10));
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 130, 10));
            p.sendMessage(ChatColor.GRAY + "Teleportando em 5 segundos!");
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Knock.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.teleport(lobby);
                    p.getInventory().clear();
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("§7Teleportado!");
                    p.setHealthScale(20.0);
                    for (final PotionEffect effect : p.getActivePotionEffects()) {
                        final ItemStack espada = new ItemStack(Material.STICK);
                        final ItemMeta espadameta = espada.getItemMeta();
                        espadameta.setDisplayName("§6KNOCK!");
                        espada.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
                        p.getInventory().setItem(0, espada);
                        p.setFireTicks(0);
                        p.getInventory().setBoots((ItemStack)null);
                        p.getInventory().setChestplate((ItemStack)null);
                        p.getInventory().setLeggings((ItemStack)null);
                        p.getInventory().setHelmet((ItemStack)null);
                        p.setHealthScale(20.0);
                        Main.giveSoup(p, 36);
                        p.removePotionEffect(effect.getType());
                    }
                }
            }, 90L);
            return false;
        }
        return false;
    }
}
