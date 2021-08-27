package me.devilkits.Kits;

import me.devilkits.*;
import org.bukkit.event.block.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.*;
import java.util.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.command.*;
import org.bukkit.inventory.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;

public class TimeLord implements Listener, CommandExecutor
{
    public static Main plugin;
    public ArrayList<String> frozenPlayers;
    public static ArrayList<String> cooldownt;
    
    static {
        TimeLord.cooldownt = new ArrayList<String>();
    }
    
    public TimeLord(final Main main) {
        this.frozenPlayers = new ArrayList<String>();
        TimeLord.plugin = main;
    }
    
    @EventHandler
    public void timelordkit(final PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && player.getItemInHand().getType() == Material.WATCH && Main.timelord.contains(player.getName())) {
            if (TimeLord.cooldownt.contains(player.getName())) {
                player.sendMessage(ChatColor.RED + "§7Espere para usar novamente!");
            }
            else {
                for (final Entity frozen : player.getNearbyEntities(4.0, 4.0, 4.0)) {
                    if (frozen != null && frozen instanceof Player) {
                        Main.freeze.add(((Player)frozen).getName());
                        if (Main.freezing.contains(player.getName())) {
                            continue;
                        }
                        player.getWorld().playEffect(player.getLocation(), Effect.POTION_BREAK, 10);
                        player.getWorld().playSound(player.getLocation(), Sound.WITHER_SHOOT, 10.0f, 1.0f);
                        Main.freezing.add(player.getName());
                        TimeLord.cooldownt.add(player.getName());
                        TimeLord.plugin.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)TimeLord.plugin, (Runnable)new Runnable() {
                            @Override
                            public void run() {
                                Main.freezing.remove(player.getName());
                                TimeLord.cooldownt.remove(player.getName());
                                player.sendMessage("§7TimeLord recarregado!");
                            }
                        }, 2400L);
                    }
                }
            }
        }
    }
    
    @EventHandler
    public void onPlayerMove(final PlayerMoveEvent event) {
        final Player player = event.getPlayer();
        if (Main.freeze.contains(player.getName()) && !Main.freezing.contains(player.getName())) {
            event.setTo(player.getLocation());
            player.sendMessage("§7Voce foi congelado por um TimeLord!!");
            TimeLord.plugin.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)TimeLord.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    Main.freeze.remove(player.getName());
                }
            }, 100L);
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
        final ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§cSword");
        dima.setItemMeta(souperaa);
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§6§oSopa");
        sopa.setItemMeta(sopas);
        final ItemStack timelord = new ItemStack(Material.WATCH);
        final ItemMeta timelorda = timelord.getItemMeta();
        timelorda.setDisplayName("§5TimeLord");
        timelord.setItemMeta(timelorda);
        if (cmd.equalsIgnoreCase("timelord")) {
            if (Main.usandokit.contains(p.getName())) {
                p.sendMessage("§cVoce ja esta usado um kit");
                return true;
            }
            if (!p.hasPermission("kit.timelord")) {
                Main.usandokit.add(p.getName());
            }
            p.sendMessage("§7Voce pegou o Kit : §6Timelord");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            Main.timelord.add(p.getName());
            p.getInventory().addItem(new ItemStack[] { dima });
            p.getInventory().addItem(new ItemStack[] { timelord });
            for (int i = 0; i <= 34; ++i) {
                p.getInventory().addItem(new ItemStack[] { sopa });
            }
        }
        return false;
    }
}
