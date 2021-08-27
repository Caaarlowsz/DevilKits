package me.devilkits.Kits;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.devilkits.Main;

public class Lobisomem implements Listener, CommandExecutor {
	public static Main plugin;
	public static HashMap<String, Long> cooldown;

	static {
		Lobisomem.cooldown = new HashMap<String, Long>();
	}

	public Lobisomem(final Main main) {
		Lobisomem.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("lobisomem")) {
			if (!Main.usandokit.contains(p.getName()) && p.hasPermission("kit.lobisomem")) {
				p.sendMessage("§7Voce pegou o Kit : §6Lobisomem");
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
				Main.usandokit.add(p.getName());
				Main.lobisomem.add(sender.getName());
				p.getInventory().clear();
				final ItemStack espada = new ItemStack(Material.WOOD_SWORD);
				final ItemMeta espadameta = espada.getItemMeta();
				espadameta.setDisplayName("§cSword");
				espada.addEnchantment(Enchantment.DURABILITY, 3);
				p.getInventory().addItem(new ItemStack[] { espada });
				p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MONSTER_EGG) });
				Main.giveSoup(p, 34);
			}
			return true;
		}
		return false;
	}

	@EventHandler
	public void interact(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& Main.lobisomem.contains(p.getName()) && p.getItemInHand().getType() == Material.MONSTER_EGG) {
			if (!Lobisomem.cooldown.containsKey(p.getName())
					|| Lobisomem.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
				e.setCancelled(true);
				p.updateInventory();
				final Wolf w = (Wolf) p.getWorld().spawnEntity(new Location(p.getWorld(), p.getLocation().getX() + 2.0,
						p.getLocation().getY(), p.getLocation().getZ()), EntityType.WOLF);
				final Wolf w2 = (Wolf) p.getWorld().spawnEntity(new Location(p.getWorld(), p.getLocation().getX(),
						p.getLocation().getY(), p.getLocation().getZ() + 2.0), EntityType.WOLF);
				final Wolf w3 = (Wolf) p.getWorld().spawnEntity(new Location(p.getWorld(), p.getLocation().getX() + 2.0,
						p.getLocation().getY(), p.getLocation().getZ() + 2.0), EntityType.WOLF);
				w.setAngry(true);
				w.setOwner((AnimalTamer) p);
				w2.setAngry(true);
				w2.setOwner((AnimalTamer) p);
				w3.setAngry(true);
				w3.setOwner((AnimalTamer) p);
				final List<Entity> nearby = (List<Entity>) p.getNearbyEntities(5.0, 5.0, 5.0);
				for (final Entity en : nearby) {
					if (en instanceof Player) {
						final Player s = (Player) en;
						w.setTarget((LivingEntity) s);
						w2.setTarget((LivingEntity) s);
						w3.setTarget((LivingEntity) s);
					}
				}
				p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 0));
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 500, 0));
				p.playSound(p.getLocation(), Sound.WOLF_HOWL, 1.0f, 1.0f);
				Lobisomem.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(40L));
				return;
			}
			p.sendMessage(ChatColor.RED + "Faltam "
					+ TimeUnit.MILLISECONDS.toSeconds(Lobisomem.cooldown.get(p.getName()) - System.currentTimeMillis())
					+ " segundos para poder usar novamente.");
		}
	}
}
