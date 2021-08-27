package me.devilkits.Kits;

import org.bukkit.plugin.java.*;
import me.devilkits.*;
import java.util.*;
import org.bukkit.command.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.potion.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.craftbukkit.v1_7_R2.entity.*;
import net.minecraft.server.v1_7_R2.*;
import org.bukkit.util.*;
import org.bukkit.entity.*;
import org.bukkit.metadata.*;
import java.util.concurrent.*;
import org.bukkit.*;
import org.bukkit.event.entity.*;

public class Batman implements Listener, CommandExecutor
{
    private static final JavaPlugin BatMan;
    public static Main plugin;
    public static HashMap<String, Long> cooldown;
    Map<Player, Cordinha> hooks;
    
    static {
        BatMan = null;
        Batman.cooldown = new HashMap<String, Long>();
    }
    
    public Batman(final Main main) {
        this.hooks = new HashMap<Player, Cordinha>();
        Batman.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("batman")) {
            if (!Main.usandokit.contains(p.getName()) && p.hasPermission("kit.batman")) {
                p.sendMessage("§7Voce pegou o Kit : §6Batman");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                Main.usandokit.add(p.getName());
                Main.batman.add(sender.getName());
                p.getInventory().clear();
                final ItemStack peitoral = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                final ItemStack espada = new ItemStack(Material.WOOD_SWORD);
                final ItemMeta espadameta = espada.getItemMeta();
                espadameta.setDisplayName("§cSword");
                final ItemStack arma = new ItemStack(Material.SHEARS);
                final ItemMeta armameta = espada.getItemMeta();
                armameta.setDisplayName("§6Bat§7Arma");
                espada.addEnchantment(Enchantment.DURABILITY, 3);
                p.getInventory().setChestplate(peitoral);
                p.getInventory().addItem(new ItemStack[] { espada });
                p.getInventory().addItem(new ItemStack[] { arma });
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999999, 0));
                p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999999, 0));
                Main.giveSoup(p, 34);
            }
            return true;
        }
        return false;
    }
    
    @EventHandler
    public void onSlot(final PlayerItemHeldEvent e) {
        if (this.hooks.containsKey(e.getPlayer())) {
            this.hooks.get(e.getPlayer()).remove();
            this.hooks.remove(e.getPlayer());
        }
    }
    
    @EventHandler
    public void grapplerDamageNoLeash(final EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        final Player player = (Player)event.getEntity();
        if (event.getCause() != EntityDamageEvent.DamageCause.FALL) {
            return;
        }
        if (this.hooks.containsKey(player) && this.hooks.get(player).isHooked() && event.getDamage() > 3.0) {
            event.setDamage(3.0);
        }
    }
    
    @EventHandler
    public void onMove(final PlayerMoveEvent e) {
        if (this.hooks.containsKey(e.getPlayer()) && !e.getPlayer().getItemInHand().getType().equals((Object)Material.SHEARS)) {
            this.hooks.get(e.getPlayer()).remove();
            this.hooks.remove(e.getPlayer());
        }
    }
    
    @EventHandler
    public void onLeash(final PlayerLeashEntityEvent e) {
        final Player p = e.getPlayer();
        if (e.getPlayer().getItemInHand().getType().equals((Object)Material.SHEARS)) {
            e.setCancelled(true);
            e.getPlayer().updateInventory();
            e.setCancelled(true);
            if (!this.hooks.containsKey(p)) {
                return;
            }
            if (!this.hooks.get(p).isHooked()) {
                return;
            }
            final double t;
            final double d = t = this.hooks.get(p).getBukkitEntity().getLocation().distance(p.getLocation());
            final double v_x = (1.0 + 0.07 * t) * (this.hooks.get(p).getBukkitEntity().getLocation().getX() - p.getLocation().getX()) / t;
            final double v_y = (1.0 + 0.03 * t) * (this.hooks.get(p).getBukkitEntity().getLocation().getY() - p.getLocation().getY()) / t;
            final double v_z = (1.0 + 0.07 * t) * (this.hooks.get(p).getBukkitEntity().getLocation().getZ() - p.getLocation().getZ()) / t;
            final Vector v = p.getVelocity();
            v.setX(v_x);
            v.setY(v_y);
            v.setZ(v_z);
            p.setVelocity(v);
        }
    }
    
    @EventHandler
    public void onClick(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (e.getPlayer().getItemInHand().getType().equals((Object)Material.SHEARS)) {
            e.setCancelled(true);
            if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
                if (this.hooks.containsKey(p)) {
                    this.hooks.get(p).remove();
                }
                final Cordinha nmsHook = new Cordinha(p.getWorld(), (EntityHuman)((CraftPlayer)p).getHandle());
                nmsHook.spawn(p.getEyeLocation().add(p.getLocation().getDirection().getX(), p.getLocation().getDirection().getY(), p.getLocation().getDirection().getZ()));
                nmsHook.move(p.getLocation().getDirection().getX() * 5.0, p.getLocation().getDirection().getY() * 5.0, p.getLocation().getDirection().getZ() * 5.0);
                this.hooks.put(p, nmsHook);
            }
            else {
                if (!this.hooks.containsKey(p)) {
                    return;
                }
                if (!this.hooks.get(p).isHooked()) {
                    return;
                }
                final double t;
                final double d = t = this.hooks.get(p).getBukkitEntity().getLocation().distance(p.getLocation());
                final double v_x = (1.0 + 0.2 * t) * (this.hooks.get(p).getBukkitEntity().getLocation().getX() - p.getLocation().getX()) / t;
                final double v_y = (1.0 + 0.03 * t) * (this.hooks.get(p).getBukkitEntity().getLocation().getY() - p.getLocation().getY()) / t;
                final double v_z = (1.0 + 0.2 * t) * (this.hooks.get(p).getBukkitEntity().getLocation().getZ() - p.getLocation().getZ()) / t;
                final Vector v = p.getVelocity();
                v.setX(v_x);
                v.setY(v_y);
                v.setZ(v_z);
                p.setVelocity(v);
            }
        }
    }
    
    @EventHandler
    public void batarma(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && Main.ryu.contains(p.getName()) && p.getItemInHand().getType() == Material.SHEARS) {
            if (!Batman.cooldown.containsKey(p.getName()) || Batman.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
                e.setCancelled(true);
                p.updateInventory();
                final Location location = p.getEyeLocation();
                final BlockIterator blocksToAdd = new BlockIterator(location, 0.0, 40);
                while (blocksToAdd.hasNext()) {
                    final Location blockToAdd = blocksToAdd.next().getLocation();
                    p.getWorld().playEffect(blockToAdd, Effect.STEP_SOUND, (Object)Material.COAL_BLOCK, 20);
                    p.playSound(blockToAdd, Sound.IRONGOLEM_THROW, 3.0f, 3.0f);
                }
                final Snowball h = (Snowball)p.launchProjectile((Class)Snowball.class);
                final Vector velo1 = p.getLocation().getDirection().normalize().multiply(10);
                h.setVelocity(velo1);
                h.setMetadata("batarma", (MetadataValue)new FixedMetadataValue(Main.plugin, (Object)true));
                Batman.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(40L));
                return;
            }
            p.sendMessage(ChatColor.RED + "Faltam " + TimeUnit.MILLISECONDS.toSeconds(Batman.cooldown.get(p.getName()) - System.currentTimeMillis()) + " segundos para poder usar novamente.");
        }
    }
    
    @EventHandler
    public void dano(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Snowball) {
            final Snowball s = (Snowball)e.getDamager();
            if (s.hasMetadata("batarma")) {
                e.setDamage(e.getDamage() + 10.0);
            }
        }
    }
}
