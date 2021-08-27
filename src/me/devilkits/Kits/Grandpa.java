package me.devilkits.Kits;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.devilkits.Main;

public class Grandpa implements Listener, CommandExecutor {
	public static Main plugin;

	public Grandpa(final Main main) {
		Grandpa.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
		final ItemMeta souperaa = dima.getItemMeta();
		souperaa.setDisplayName("§cSword");
		dima.setItemMeta(souperaa);
		dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta sopas = sopa.getItemMeta();
		sopas.setDisplayName("§6Sopa");
		sopa.setItemMeta(sopas);
		final ItemStack stick = new ItemStack(Material.STICK);
		final ItemMeta sticks = stick.getItemMeta();
		stick.setItemMeta(sticks);
		dima.addEnchantment(Enchantment.DURABILITY, 3);
		stick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
		if (cmd.equalsIgnoreCase("grandpa")) {
			if (Main.usandokit.contains(p.getName())) {
				p.sendMessage("§cVoce ja esta usando um kit");
				return true;
			}
			if (!p.hasPermission("kit.grandpa")) {
				p.sendMessage("§7Sem permissao");
				return true;
			}
			Main.usandokit.add(p.getName());
			Main.grandpa.add(p.getName());
			p.sendMessage("§7Voce pegou o Kit : §6Grandpa");
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { stick });
			for (int i = 0; i <= 34; ++i) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
