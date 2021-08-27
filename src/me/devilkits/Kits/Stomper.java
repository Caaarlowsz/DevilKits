package me.devilkits.Kits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import me.devilkits.Main;

public class Stomper implements Listener, CommandExecutor {
	public static Main plugin;
	public static HashMap<String, Long> cooldown;
	public static List<Player> cooldownm;

	static {
		Stomper.cooldown = new HashMap<String, Long>();
		Stomper.cooldownm = new ArrayList<Player>();
	}

	public Stomper(final Main main) {
		Stomper.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("stomper")) {
			if (!Main.usandokit.contains(p.getName()) && p.hasPermission("kit.stomper")) {
				p.sendMessage("§7Voce pegou o Kit : §6Stomper");
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
				Main.usandokit.add(p.getName());
				Main.stomper.add(sender.getName());
				p.getInventory().clear();
				final ItemStack espada = new ItemStack(Material.WOOD_SWORD);
				final ItemMeta espadameta = espada.getItemMeta();
				espadameta.setDisplayName("§cSword");
				espada.addEnchantment(Enchantment.DURABILITY, 3);
				p.getInventory().addItem(new ItemStack[] { espada });
				final ItemStack bow = new ItemStack(Material.EMERALD_BLOCK);
				final ItemMeta bowmeta = bow.getItemMeta();
				bowmeta.setDisplayName("§cStomper Bost");
				bow.setItemMeta(bowmeta);
				p.getInventory().addItem(new ItemStack[] { bow });
				Main.giveSoup(p, 34);
			}
			return true;
		}
		return false;
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerStomp(final EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		final Player p = (Player) e.getEntity();
		if (e.getCause() != EntityDamageEvent.DamageCause.FALL) {
			return;
		}
		if (Main.stomper.contains(p.getName())) {
			for (final Entity ent : p.getNearbyEntities(1.0, 2.0, 1.0)) {
				if (ent instanceof Player) {
					final Player plr = (Player) ent;
					if (e.getDamage() <= 4.0) {
						e.setCancelled(true);
						return;
					}
					if (plr.isSneaking()) {
						plr.damage(6.0, (Entity) p);
						plr.sendMessage(ChatColor.RED + "Voce foi stompado por: " + ChatColor.RED + p.getName());
					} else {
						plr.damage(e.getDamage(), (Entity) p);
						plr.sendMessage(ChatColor.RED + "Voce foi stompado por: " + ChatColor.RED + p.getName());
					}
				}
			}
			e.setDamage(4.0);
		}
	}

	@EventHandler
	public void stomperApple(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (event.getPlayer().getItemInHand().getType() == Material.EMERALD_BLOCK
				&& Main.stomper.contains(event.getPlayer().getName())) {
			if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK
					|| event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
				event.setCancelled(true);
			}
			if (Stomper.cooldownm.contains(p)) {
				p.sendMessage("§cAguarde o cooldown acabar!");
				return;
			}
			final Vector vector = p.getEyeLocation().getDirection();
			vector.multiply(0.0f);
			vector.setY(6.0f);
			p.setVelocity(vector);
			final Location loc = p.getLocation();
			p.getWorld().playSound(loc, Sound.ENDERMAN_TELEPORT, 5.0f, -5.0f);
			Stomper.cooldownm.add(p);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Stomper.plugin,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							Stomper.cooldownm.remove(p);
							p.sendMessage("§aVoce pode usar novamente!");
							p.getWorld().playSound(p.getLocation(), Sound.EXPLODE, 5.0f, 5.0f);
						}
					}, 500L);
		}
	}
}
