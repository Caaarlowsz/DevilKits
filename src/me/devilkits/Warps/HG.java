package me.devilkits.Warps;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.devilkits.Main;

public class HG implements Listener, CommandExecutor {
	public static Main plugin;

	public HG(final Main main) {
		HG.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("hg")) {
			final Player p = (Player) sender;
			final World w = Bukkit.getServer().getWorld(HG.plugin.getConfig().getString("hg.world"));
			final double x = HG.plugin.getConfig().getDouble("hg.x");
			final double y = HG.plugin.getConfig().getDouble("hg.y");
			final double z = HG.plugin.getConfig().getDouble("hg.z");
			final Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) HG.plugin.getConfig().getDouble("hg.pitch"));
			lobby.setYaw((float) HG.plugin.getConfig().getDouble("hg.yaw"));
			p.getInventory().clear();
			p.setHealthScale(1.0);
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
			p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
			p.sendMessage(ChatColor.GRAY + "Teleportando em 5 segundos!");
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) HG.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.teleport(lobby);
					p.getInventory().clear();
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("§7Teleportado!");
					p.setHealthScale(20.0);
					for (final PotionEffect effect : p.getActivePotionEffects()) {
						p.getInventory().setBoots((ItemStack) null);
						p.getInventory().setChestplate((ItemStack) null);
						p.getInventory().setLeggings((ItemStack) null);
						p.getInventory().setHelmet((ItemStack) null);
						p.setHealthScale(20.0);
						final ItemStack espada = new ItemStack(Material.STONE_SWORD);
						p.getInventory().setItem(0, espada);
						p.setFireTicks(0);
						final ItemStack re = new ItemStack(Material.BROWN_MUSHROOM, 64);
						final ItemMeta remeta = re.getItemMeta();
						remeta.setDisplayName("Recraft");
						re.setItemMeta(remeta);
						p.getInventory().setItem(1, re);
						final ItemStack rec = new ItemStack(Material.RED_MUSHROOM, 64);
						final ItemMeta recmeta = rec.getItemMeta();
						recmeta.setDisplayName("Recraft");
						rec.setItemMeta(recmeta);
						p.getInventory().setItem(2, rec);
						final ItemStack recc = new ItemStack(Material.BOWL, 64);
						final ItemMeta reccmeta = recc.getItemMeta();
						reccmeta.setDisplayName("Recraft");
						recc.setItemMeta(reccmeta);
						p.getInventory().setItem(3, recc);
						Main.giveSoup(p, 36);
						p.removePotionEffect(effect.getType());
					}
				}
			}, 90L);
			return false;
		}
		return false;
	}
}
