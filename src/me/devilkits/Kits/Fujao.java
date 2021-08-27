package me.devilkits.Kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.devilkits.Main;

public class Fujao implements Listener, CommandExecutor {
	public static Main plugin;
	static List<Player> cooldownm;

	static {
		Fujao.cooldownm = new ArrayList<Player>();
	}

	public Fujao(final Main main) {
		Fujao.plugin = main;
	}

	@EventHandler
	public void stomperApple(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (event.getPlayer().getItemInHand().getType() == Material.GHAST_TEAR
				&& ArrayL.fujao.contains(event.getPlayer().getName())) {
			if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK
					|| event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
				event.setCancelled(true);
			}
			if (Fujao.cooldownm.contains(p)) {
				p.sendMessage("§cSo pode usar uma vez!");
				return;
			}
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 35, 10));
			p.getWorld().playSound(p.getLocation(), Sound.ARROW_HIT, 5.0f, -5.0f);
			Fujao.cooldownm.add(p);
			Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask((Plugin) Fujao.plugin,
					Fujao1.FujaoFuncao(this, p), 500L);
		}
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		final ItemStack dima = new ItemStack(Material.STONE_SWORD);
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemStack archer = new ItemStack(Material.GHAST_TEAR);
		final ItemMeta karcher = archer.getItemMeta();
		karcher.setDisplayName(ChatColor.GOLD + "Fuja!");
		archer.setItemMeta(karcher);
		dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		if (cmd.equalsIgnoreCase("fujao")) {
			if (ArrayL.used.contains(p.getName())) {
				p.sendMessage("§cVoce ja esta usando um kit!");
				return true;
			}
			if (!p.hasPermission("kit.fujao")) {
				p.sendMessage("§c§oVoce nao tem permissao para este kit!");
				return true;
			}
			ArrayL.used.add(p.getName());
			p.setGameMode(GameMode.SURVIVAL);
			p.sendMessage(ChatColor.GREEN + "§7Voce pegou o Kit : §6Fujao");
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			ArrayL.fujao.add(p.getName());
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { archer });
			for (int i = 0; i <= 34; ++i) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
