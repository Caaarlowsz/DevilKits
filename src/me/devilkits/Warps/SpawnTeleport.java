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
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.devilkits.Main;

public class SpawnTeleport implements Listener, CommandExecutor {
	public static Main plugin;

	public SpawnTeleport(final Main main) {
		SpawnTeleport.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("spawn")) {
			final Player p = (Player) sender;
			p.getInventory().clear();
			p.getInventory().setBoots((ItemStack) null);
			p.getInventory().setChestplate((ItemStack) null);
			p.getInventory().setLeggings((ItemStack) null);
			p.getInventory().setHelmet((ItemStack) null);
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
			p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
			p.sendMessage("§7Teleportando em 5 segundos! ");
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) SpawnTeleport.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					final World w = Bukkit.getServer()
							.getWorld(SpawnTeleport.plugin.getConfig().getString("spawn.world"));
					final double x = SpawnTeleport.plugin.getConfig().getDouble("spawn.x");
					final double y = SpawnTeleport.plugin.getConfig().getDouble("spawn.y");
					final double z = SpawnTeleport.plugin.getConfig().getDouble("spawn.z");
					final Location lobby = new Location(w, x, y, z);
					lobby.setPitch((float) SpawnTeleport.plugin.getConfig().getDouble("spawn.pitch"));
					lobby.setYaw((float) SpawnTeleport.plugin.getConfig().getDouble("spawn.yaw"));
					Main.removeAbility(p);
					p.getInventory().setBoots((ItemStack) null);
					p.getInventory().setChestplate((ItemStack) null);
					p.getInventory().setLeggings((ItemStack) null);
					p.getInventory().setHelmet((ItemStack) null);
					p.getInventory().clear();
					p.teleport(lobby);
					p.setExp(0.0f);
					p.setExhaustion(20.0f);
					p.setFireTicks(0);
					Main.removeAbility(p);
					p.setFoodLevel(20000);
					p.setHealth(20.0);
					final ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
					final BookMeta meta = (BookMeta) book.getItemMeta();
					meta.setTitle(ChatColor.GREEN + "Regras §7§o(§c§oClique Direito§7§o)");
					meta.setAuthor(ChatColor.AQUA + "Equipe do Servidor");
					meta.addPage(new String[] { ChatColor.GRAY + "----==[§4REGRAS§7]==----" + ChatColor.RED
							+ "1.Nao usar hack\n" + ChatColor.RED + "\n" + ChatColor.RED + "2.Nao xingar players "
							+ ChatColor.RED + "e a staff!\n" + ChatColor.RED + "\n" + ChatColor.RED
							+ "3.Nao abusar de bugs\n" + ChatColor.RED + "\n" + ChatColor.RED + "4.Nao divulgar\n"
							+ ChatColor.RED + "qualquer tipo de\n" + ChatColor.RED + "servidor ou site\n"
							+ ChatColor.RED + "\n" + ChatColor.RED + "\n" + ChatColor.BLUE + "Bom Jogo!" });
					book.setItemMeta((ItemMeta) meta);
					p.getInventory().setItem(8, book);
					final ItemStack chest = new ItemStack(Material.CHEST);
					final ItemMeta chestm = chest.getItemMeta();
					chestm.setDisplayName(ChatColor.GOLD + "Kits §7§o(§c§oClique Direito§7§o)");
					chest.setItemMeta(chestm);
					p.getPlayer().getInventory().setItem(0, chest);
					final ItemStack shop = new ItemStack(Material.COMPASS);
					final ItemMeta shopm = shop.getItemMeta();
					shopm.setDisplayName(ChatColor.GOLD + "Warps §7§o(§c§oClique Direito§7§o)");
					shop.setItemMeta(shopm);
					p.getPlayer().getInventory().setItem(3, shop);
					final ItemStack loja = new ItemStack(Material.DIAMOND);
					final ItemMeta lojam = loja.getItemMeta();
					lojam.setDisplayName(ChatColor.GOLD + "Shop §7§o(§c§oClique Direito§7§o)");
					loja.setItemMeta(lojam);
					p.getPlayer().getInventory().setItem(5, loja);
					final ItemStack vine = new ItemStack(Material.NETHER_STAR);
					final ItemMeta vinem = vine.getItemMeta();
					vinem.setDisplayName(ChatColor.GOLD + "Shop de Kit §7§o(§c§oClique Direito§7§o)");
					vine.setItemMeta(vinem);
					final ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE);
					final ItemMeta glassm = glass.getItemMeta();
					glassm.setDisplayName(ChatColor.GOLD + " ");
					glass.setItemMeta(glassm);
					p.getInventory().setItem(1, glass);
					p.getInventory().setItem(2, glass);
					p.getInventory().setItem(6, glass);
					p.getInventory().setItem(7, glass);
					p.getInventory().setItem(4, vine);
					for (final PotionEffect effect : p.getActivePotionEffects()) {
						p.removePotionEffect(effect.getType());
					}
				}
			}, 90L);
		}
		return false;
	}
}
