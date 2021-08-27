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

public class HomemInvisivel implements Listener, CommandExecutor {
	public static Main plugin;

	public HomemInvisivel(final Main main) {
		HomemInvisivel.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("homeminvisivel")) {
			if (!Main.usandokit.contains(p.getName()) && p.hasPermission("kit.homeminvisivel")) {
				p.sendMessage("§7Voce pegou o Kit : §6Homem-Invisivel");
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
				Main.usandokit.add(p.getName());
				Main.homeminvisivel.add(sender.getName());
				p.getInventory().clear();
				final ItemStack porcao = new ItemStack(Material.POTION, 3, (short) 8206);
				final ItemMeta porcaometa = porcao.getItemMeta();
				final ItemStack espada = new ItemStack(Material.STONE_SWORD);
				final ItemMeta espadameta = espada.getItemMeta();
				espadameta.setDisplayName("§cSword");
				porcaometa.setDisplayName("§cInvisibilidade");
				espada.addEnchantment(Enchantment.DURABILITY, 3);
				p.getInventory().addItem(new ItemStack[] { porcao });
				p.getInventory().addItem(new ItemStack[] { espada });
				Main.giveSoup(p, 35);
			}
			return true;
		}
		return false;
	}
}
