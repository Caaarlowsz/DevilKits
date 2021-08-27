package me.devilkits.Kits;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import me.devilkits.Main;

public class Thor implements Listener, CommandExecutor {
	public static Main plugin;

	public Thor(final Main main) {
		Thor.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("thor")) {
			if (!Main.usandokit.contains(p.getName()) && p.hasPermission("kit.Poseidon")) {
				p.sendMessage("§7Voce pegou o Kit : §6Thor");
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
				Main.usandokit.add(p.getName());
				Main.thor.add(sender.getName());
				p.getInventory().clear();
				final ItemStack espada = new ItemStack(Material.WOOD_SWORD);
				final ItemMeta espadameta = espada.getItemMeta();
				espadameta.setDisplayName("§cSword");
				espada.addEnchantment(Enchantment.DURABILITY, 3);
				p.getInventory().addItem(new ItemStack[] { espada });
				p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_AXE) });
				Main.giveSoup(p, 34);
			}
			return true;
		}
		return false;
	}

	@EventHandler
	public void onPlayerThor(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (e.getAction() != Action.RIGHT_CLICK_BLOCK) {
			return;
		}
		if (p.getItemInHand().getType() == Material.STONE_AXE && Main.thor.contains(p.getName())) {
			if (Main.cooldown.contains(p.getName())) {
				e.setCancelled(true);
				p.sendMessage(ChatColor.RED + "Seus poderes so poderao ser usados daqui 5 segundos!");
				return;
			}
			e.setCancelled(true);
			final Block b = e.getClickedBlock();
			final World w = p.getWorld();
			w.spawnEntity(w.getHighestBlockAt(b.getLocation()).getLocation(), EntityType.LIGHTNING);
			Main.cooldown.add(p.getName());
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Thor.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					Main.cooldown.remove(p.getName());
				}
			}, 100L);
		}
	}
}
