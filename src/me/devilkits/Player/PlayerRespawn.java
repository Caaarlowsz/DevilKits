package me.devilkits.Player;

import me.devilkits.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.inventory.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.potion.*;
import org.bukkit.entity.*;
import java.util.*;

public class PlayerRespawn implements Listener
{
    public Main plugin;
    
    public PlayerRespawn(final Main main) {
        this.plugin = main;
    }
    
    @EventHandler
    public void Morrer(final PlayerDeathEvent e) {
        e.setDeathMessage((String)null);
        e.getDrops().clear();
    }
    
    @EventHandler
    public void onDeathPlayer(final PlayerRespawnEvent e) {
        final Player p = e.getPlayer();
        p.getInventory().clear();
        p.setExp(0.0f);
        p.getInventory().setHelmet((ItemStack)null);
        p.getInventory().setChestplate((ItemStack)null);
        p.getInventory().setLeggings((ItemStack)null);
        p.getInventory().setBoots((ItemStack)null);
        p.setLevel(0);
        p.setExhaustion(20.0f);
        p.setFoodLevel(20000);
        p.setHealth(20.0);
        Main.removeAbility(p);
        final ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
        final BookMeta meta = (BookMeta)book.getItemMeta();
        meta.setTitle(ChatColor.GREEN + "Regras §7§o(§c§oClique Direito§7§o)");
        meta.setAuthor(ChatColor.AQUA + "Equipe do Servidor");
        meta.addPage(new String[] { ChatColor.GRAY + "----==[§4REGRAS§7]==----" + ChatColor.RED + "1.Nao usar hack\n" + ChatColor.RED + "\n" + ChatColor.RED + "2.Nao xingar players " + ChatColor.RED + "e a staff!\n" + ChatColor.RED + "\n" + ChatColor.RED + "3.Nao abusar de bugs\n" + ChatColor.RED + "\n" + ChatColor.RED + "4.Nao divulgar\n" + ChatColor.RED + "qualquer tipo de\n" + ChatColor.RED + "servidor ou site\n" + ChatColor.RED + "\n" + ChatColor.RED + "\n" + ChatColor.BLUE + "Bom Jogo!" });
        book.setItemMeta((ItemMeta)meta);
        p.getInventory().setItem(8, book);
        final ItemStack chest = new ItemStack(Material.CHEST);
        final ItemMeta chestm = chest.getItemMeta();
        chestm.setDisplayName(ChatColor.GOLD + "Kits §7§o(§c§oClique Direito§7§o)");
        chest.setItemMeta(chestm);
        p.getPlayer().getInventory().setItem(0, chest);
        final ItemStack shop = new ItemStack(Material.COMPASS);
        final ItemMeta shopm = shop.getItemMeta();
        shopm.setDisplayName(ChatColor.GOLD + "Warps §7§o(§c§oClique Direito§7§o)");
        shop.setItemMeta(shopm);
        p.getPlayer().getInventory().setItem(3, shop);
        final ItemStack loja = new ItemStack(Material.DIAMOND);
        final ItemMeta lojam = loja.getItemMeta();
        lojam.setDisplayName(ChatColor.GOLD + "Shop §7§o(§c§oClique Direito§7§o)");
        loja.setItemMeta(lojam);
        p.getPlayer().getInventory().setItem(5, loja);
        final ItemStack vine = new ItemStack(Material.NETHER_STAR);
        final ItemMeta vinem = vine.getItemMeta();
        vinem.setDisplayName(ChatColor.GOLD + "Shop de Kit §7§o(§c§oClique Direito§7§o)");
        vine.setItemMeta(vinem);
        final ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE);
        final ItemMeta glassm = glass.getItemMeta();
        final String HotBar1 = this.plugin.getConfig().getString("HotBar");
        glassm.setDisplayName(HotBar1.replace("&", "§"));
        glass.setItemMeta(glassm);
        p.getInventory().setItem(1, glass);
        p.getInventory().setItem(2, glass);
        p.getInventory().setItem(6, glass);
        p.getInventory().setItem(7, glass);
        p.getInventory().setItem(4, vine);
        for (final PotionEffect effect : p.getActivePotionEffects()) {
            p.removePotionEffect(effect.getType());
        }
    }
}
