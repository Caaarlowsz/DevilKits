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

public class C4 implements Listener, CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		final ItemStack dima = new ItemStack(Material.STONE_SWORD);
		dima.addEnchantment(Enchantment.DURABILITY, 3);
		final ItemMeta souperaa = dima.getItemMeta();
		souperaa.setDisplayName("§cSword");
		dima.setItemMeta(souperaa);
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta sopas = sopa.getItemMeta();
		sopas.setDisplayName("§6Sopa");
		sopa.setItemMeta(sopas);
		final ItemStack especial = new ItemStack(Material.STONE_BUTTON);
		final ItemMeta especial2 = especial.getItemMeta();
		especial2.setDisplayName("§7C4");
		especial.setItemMeta(especial2);
		if (cmd.equalsIgnoreCase("c4")) {
			if (Main.usandokit.contains(p.getName())) {
				p.sendMessage("§cVoce ja esta usando um kit");
				return true;
			}
			if (!p.hasPermission("kit.c4")) {
				p.sendMessage("§cVoce nao tem permissao para usar este kit!");
				return true;
			}
			Main.usandokit.add(p.getName());
			p.sendMessage("§7Voce pegou o Kit : §6C4");
			p.setGameMode(GameMode.ADVENTURE);
			p.getInventory().clear();
			Main.c4.add(p.getName());
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { especial });
			for (int i = 0; i <= 34; ++i) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
