package me.devilkits.Kits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.devilkits.Main;

public class Resouper implements Listener, CommandExecutor {
	public static Main plugin;

	public Resouper(final Main main) {
		Resouper.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("resouper")) {
			if (!Main.usandokit.contains(p.getName()) && p.hasPermission("kit.resouper")) {
				p.sendMessage("§7Voce pegou o Kit : §6Resouper");
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
				Main.usandokit.add(p.getName());
				Main.resouper.add(sender.getName());
				p.getInventory().clear();
				final ItemStack espada = new ItemStack(Material.WOOD_SWORD);
				final ItemMeta espadameta = espada.getItemMeta();
				espadameta.setDisplayName("§cSword");
				espada.addEnchantment(Enchantment.DURABILITY, 3);
				p.getInventory().addItem(new ItemStack[] { espada });
				Main.giveSoup(p, 35);
			}
			return true;
		}
		return false;
	}

	@EventHandler
	public void onKill(final PlayerDeathEvent e) {
		if (e.getEntity().getKiller() instanceof Player) {
			final Player k = e.getEntity().getKiller();
			if (Main.resouper.contains(k.getName())) {
				k.getInventory().remove(Material.BOWL);
				try {
					for (int i = 0; i < 34; ++i) {
						k.getInventory().setItem(k.getInventory().firstEmpty(), new ItemStack(Material.MUSHROOM_SOUP));
					}
				} catch (ArrayIndexOutOfBoundsException ex) {
				}
				k.sendMessage(ChatColor.GREEN + "Resoup Automatico Concluido!");
				k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			}
		}
	}
}
