package me.devilkits.Kits;

import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.command.*;
import me.devilkits.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.event.entity.*;
import java.util.*;

public class Vulture implements Listener, CommandExecutor
{
    public static ArrayList<Player> vulture;
    
    static {
        Vulture.vulture = new ArrayList<Player>();
    }
    
    @EventHandler
    public void deathe(final PlayerDeathEvent e) {
        final Player p = e.getEntity();
        Vulture.vulture.remove(p);
    }
    
    @EventHandler
    public void ent(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        Vulture.vulture.remove(p);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player jogador = (Player)sender;
        if (label.equalsIgnoreCase("vulture")) {
            if (jogador.hasPermission("kit.vulture")) {
                if (Main.usandokit.contains(jogador.getName())) {
                    jogador.sendMessage("§cVoce ja esta usando um kit!");
                }
                else {
                    giveKit(jogador);
                }
            }
            else {
                jogador.sendMessage(ChatColor.RED + "Voce nao possue este kit !");
            }
        }
        return false;
    }
    
    public static void giveKit(final Player p) {
        p.getInventory().clear();
        p.sendMessage(ChatColor.GREEN + "§7Voce pegou o Kit : §6Vulture");
        final ItemStack espada = new ItemStack(Material.STONE_SWORD);
        espada.addEnchantment(Enchantment.DURABILITY, 3);
        p.getInventory().addItem(new ItemStack[] { espada });
        for (int i = 0; i < 37; ++i) {
            p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
        }
        Main.usandokit.add(p.getName());
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            final Player p = (Player)e.getEntity();
            final Player d = (Player)e.getDamager();
            if (!Vulture.vulture.contains(d)) {
                return;
            }
            final Random r = new Random();
            final int rand = r.nextInt(100);
            if (rand <= 15) {
                boolean lostsoup = false;
                final ItemStack[] item = p.getInventory().getContents();
                for (int slot = 0; slot < 36; ++slot) {
                    final ItemStack soup = item[slot];
                    if (!lostsoup && soup != null && soup.isSimilar(new ItemStack(Material.MUSHROOM_SOUP))) {
                        lostsoup = true;
                        p.getInventory().setItem(slot, new ItemStack(Material.AIR));
                    }
                }
                d.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
                p.sendMessage(ChatColor.RED + "Cade minhas sopas?");
                d.sendMessage(ChatColor.GREEN + "Eu catei =P");
            }
        }
    }
}
