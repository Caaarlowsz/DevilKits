package me.devilkits.Kits;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.devilkits.Main;

public class Archer implements Listener, CommandExecutor {
	public static Main plugin;

	public Archer(final Main main) {
		Archer.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("archer")) {
			if (!Main.usandokit.contains(p.getName()) && p.hasPermission("kit.archer")) {
				p.sendMessage("§7Voce pegou o Kit : §6Archer");
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
				Main.usandokit.add(p.getName());
				Main.archer.add(sender.getName());
				p.getInventory().clear();
				final ItemStack espada = new ItemStack(Material.WOOD_SWORD);
				final ItemMeta espadameta = espada.getItemMeta();
				espadameta.setDisplayName("§cSword");
				espada.addEnchantment(Enchantment.DURABILITY, 3);
				p.getInventory().addItem(new ItemStack[] { espada });
				final ItemStack bow = new ItemStack(Material.BOW);
				final ItemMeta bowmeta = bow.getItemMeta();
				bowmeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
				bowmeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
				bowmeta.setDisplayName("§cBow Archer");
				bow.setItemMeta(bowmeta);
				final ItemStack bow2 = new ItemStack(Material.ARROW);
				p.getInventory().setItem(1, bow);
				p.getInventory().setItem(2, bow2);
				Main.giveSoup(p, 33);
			}
			return true;
		}
		return false;
	}
}
