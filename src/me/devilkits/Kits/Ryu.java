package me.devilkits.Kits;

import me.devilkits.*;
import java.util.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.plugin.*;
import org.bukkit.metadata.*;
import java.util.concurrent.*;
import org.bukkit.entity.*;
import org.bukkit.util.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.command.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;

public class Ryu implements Listener, CommandExecutor
{
    public static Main plugin;
    public static HashMap<String, Long> cooldown;
    
    static {
        Ryu.cooldown = new HashMap<String, Long>();
    }
    
    public Ryu(final Main main) {
        Ryu.plugin = main;
    }
    
    @EventHandler
    public void hadouken(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && Main.ryu.contains(p.getName()) && p.getItemInHand().getType() == Material.BEACON) {
            if (!Ryu.cooldown.containsKey(p.getName()) || Ryu.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
                e.setCancelled(true);
                p.updateInventory();
                final Location location = p.getEyeLocation();
                final BlockIterator blocksToAdd = new BlockIterator(location, 0.0, 40);
                while (blocksToAdd.hasNext()) {
                    final Location blockToAdd = blocksToAdd.next().getLocation();
                    p.getWorld().playEffect(blockToAdd, Effect.STEP_SOUND, (Object)Material.BEACON, 20);
                    p.playSound(blockToAdd, Sound.IRONGOLEM_THROW, 3.0f, 3.0f);
                }
                final Snowball h = (Snowball)p.launchProjectile((Class)Snowball.class);
                final Vector velo1 = p.getLocation().getDirection().normalize().multiply(10);
                h.setVelocity(velo1);
                h.setMetadata("hadouken", (MetadataValue)new FixedMetadataValue((Plugin)Ryu.plugin, (Object)true));
                Ryu.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(20L));
                return;
            }
            p.sendMessage(ChatColor.GRAY + "Faltam " + TimeUnit.MILLISECONDS.toSeconds(Ryu.cooldown.get(p.getName()) - System.currentTimeMillis()) + " segundos para poder usar novamente.");
        }
    }
    
    @EventHandler
    public void dano(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Snowball) {
            final Snowball s = (Snowball)e.getDamager();
            if (s.hasMetadata("hadouken")) {
                e.setDamage(e.getDamage() + 9.0);
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        final ItemStack dima = new ItemStack(Material.STONE_SWORD);
        dima.addEnchantment(Enchantment.DURABILITY, 3);
        final ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§cSword");
        dima.setItemMeta(souperaa);
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§6Sopa");
        sopa.setItemMeta(sopas);
        final ItemStack especial = new ItemStack(Material.BEACON);
        final ItemMeta especial2 = especial.getItemMeta();
        especial2.setDisplayName("§bHadouken");
        especial.setItemMeta(especial2);
        if (cmd.equalsIgnoreCase("ryu")) {
            if (Main.usandokit.contains(p.getName())) {
                p.sendMessage("§cVoce ja esta usando um kit");
                return true;
            }
            if (!p.hasPermission("kit.ryu")) {
                p.sendMessage("§cVoce nao tem permissao para usar este kit!");
                return true;
            }
            Main.usandokit.add(p.getName());
            p.sendMessage("§7Voce pegou o Kit : §6Ryu");
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().clear();
            Main.ryu.add(p.getName());
            p.getInventory().addItem(new ItemStack[] { dima });
            p.getInventory().addItem(new ItemStack[] { especial });
            for (int i = 0; i <= 34; ++i) {
                p.getInventory().addItem(new ItemStack[] { sopa });
            }
        }
        return false;
    }
}
