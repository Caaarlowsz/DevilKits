package me.devilkits.Kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.Plugin;

import me.devilkits.Main;

public class Phantom implements Listener, CommandExecutor {
	public static Main plugin;
	static List<String> cooldown;

	static {
		Phantom.cooldown = new ArrayList<String>();
	}

	public Phantom(final Main main) {
		Phantom.plugin = main;
	}

	@EventHandler
	public void onInteractPhantom(final PlayerInteractEvent event) {
		final ItemStack chest = new ItemStack(Material.LEATHER_HELMET, 1);
		final LeatherArmorMeta chestp = (LeatherArmorMeta) chest.getItemMeta();
		chestp.setColor(Color.WHITE);
		chest.setItemMeta((ItemMeta) chestp);
		final ItemStack chest2 = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		final LeatherArmorMeta chestp2 = (LeatherArmorMeta) chest2.getItemMeta();
		chestp2.setColor(Color.WHITE);
		chest2.setItemMeta((ItemMeta) chestp2);
		final ItemStack calca = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		final LeatherArmorMeta chestp3 = (LeatherArmorMeta) calca.getItemMeta();
		chestp3.setColor(Color.WHITE);
		calca.setItemMeta((ItemMeta) chestp3);
		final ItemStack chest3 = new ItemStack(Material.LEATHER_BOOTS, 1);
		final LeatherArmorMeta chestp4 = (LeatherArmorMeta) chest3.getItemMeta();
		chestp4.setColor(Color.WHITE);
		chest3.setItemMeta((ItemMeta) chestp4);
		if (event.getPlayer().hasPermission("kit.phantom") && event.getAction().name().contains("RIGHT")
				&& event.getPlayer().getItemInHand().getType() == Material.FEATHER
				&& Main.phantom.contains(event.getPlayer().getName())) {
			final Player p = event.getPlayer();
			if (Phantom.cooldown.contains(p.getName())) {
				return;
			}
			Phantom.cooldown.add(p.getName());
			p.setAllowFlight(true);
			p.setFlying(true);
			p.getInventory().setHelmet(new ItemStack(chest));
			p.getInventory().setChestplate(new ItemStack(chest2));
			p.getInventory().setLeggings(new ItemStack(calca));
			p.getInventory().setBoots(new ItemStack(chest3));
			p.updateInventory();
			p.sendMessage("§6Voce pode voar!");
			final int i = 5;
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Phantom.plugin,
					(Runnable) new Runnable() {
						@Override
						public void run() {
						}
					}, (long) i);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Phantom.plugin,
					(Runnable) new Runnable() {
						@Override
						public void run() {
						}
					}, (long) (i + 20));
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Phantom.plugin,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							p.sendMessage(ChatColor.GRAY + "Voce tem 3 segundos de voo!");
						}
					}, (long) (i + 40));
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Phantom.plugin,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							p.sendMessage(ChatColor.GRAY + "Voce tem 2 segundos de voo!");
						}
					}, (long) (i + 60));
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Phantom.plugin,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							p.sendMessage(ChatColor.GRAY + "Voce tem 1 segundos de voo!");
						}
					}, (long) (i + 80));
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Phantom.plugin,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							p.setAllowFlight(false);
							p.sendMessage("§6Voce nao pode voar mais!");
							p.getInventory().setHelmet((ItemStack) null);
							p.getInventory().setChestplate((ItemStack) null);
							p.getInventory().setLeggings((ItemStack) null);
							p.getInventory().setBoots((ItemStack) null);
							p.updateInventory();
						}
					}, 100L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Phantom.plugin,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							Phantom.cooldown.remove(p.getName());
							p.sendMessage("§7Voce pode usar agora!");
						}
					}, 800L);
		}
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
		final ItemMeta souperaa = dima.getItemMeta();
		souperaa.setDisplayName("§cSword");
		dima.setItemMeta(souperaa);
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta sopas = sopa.getItemMeta();
		sopas.setDisplayName("§6Sopa");
		sopa.setItemMeta(sopas);
		final ItemStack phantom = new ItemStack(Material.FEATHER);
		final ItemMeta specialistss = phantom.getItemMeta();
		specialistss.setDisplayName("§aPhantom's Feather");
		phantom.setItemMeta(specialistss);
		dima.addEnchantment(Enchantment.DURABILITY, 3);
		if (cmd.equalsIgnoreCase("phantom")) {
			if (Main.usandokit.contains(p.getName())) {
				p.sendMessage("§cVoce ja est usando um kit");
				return true;
			}
			if (!p.hasPermission("kit.phantom")) {
				p.sendMessage("§7Voce nao tem esse kit!");
				return true;
			}
			Main.usandokit.add(p.getName());
			Main.phantom.add(p.getName());
			p.sendMessage("§7Voce pegou o Kit : §6Phantom");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { phantom });
			for (int i = 0; i <= 34; ++i) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
