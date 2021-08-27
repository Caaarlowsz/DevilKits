package me.devilkits.Seletor;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Kits2 implements Listener, CommandExecutor {
	public static void guiKits(final Player p) {
		final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder) p, 54, "§9Seus Kits: (2)");
		final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
		final ItemMeta metav = vidro.getItemMeta();
		metav.setDisplayName(" ");
		vidro.setItemMeta(metav);
		final ItemStack vidro2 = new ItemStack(Material.ENDER_PORTAL);
		final ItemMeta metav2 = vidro.getItemMeta();
		metav2.setDisplayName(" ");
		vidro2.setItemMeta(metav2);
		final ItemStack vidro3 = new ItemStack(Material.IRON_DOOR);
		final ItemMeta metav3 = vidro.getItemMeta();
		metav3.setDisplayName("§6Kits Anteriores");
		vidro3.setItemMeta(metav3);
		final ItemStack vidro4 = new ItemStack(Material.THIN_GLASS);
		final ItemMeta metav4 = vidro.getItemMeta();
		metav4.setDisplayName(" ");
		vidro4.setItemMeta(metav4);
		inv.setItem(0, vidro3);
		inv.setItem(1, vidro4);
		inv.setItem(2, vidro4);
		inv.setItem(3, vidro4);
		inv.setItem(4, vidro2);
		inv.setItem(5, vidro4);
		inv.setItem(6, vidro4);
		inv.setItem(7, vidro4);
		inv.setItem(8, vidro3);
		if (p.hasPermission("kit.DarkGod")) {
			final ItemStack pyro = new ItemStack(Material.HOPPER);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "DarkGod");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Deixe seus inimigos cegos!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.paladino")) {
			final ItemStack pyro = new ItemStack(Material.LEATHER_CHESTPLATE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Paladino");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Voce tera mais protecao!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.stoneman")) {
			final ItemStack pyro = new ItemStack(Material.STONE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "StoneMan");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Ao ficar sobre as pedras ganhara habilidades");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.batman")) {
			final ItemStack pyro = new ItemStack(Material.SHEARS);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "BatMan");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Receba um batgancho e fuja rapido");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.timelord")) {
			final ItemStack pyro = new ItemStack(Material.WATCH);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "TimeLord");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Pare o tempo de um inimigo!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.wolverine")) {
			final ItemStack pyro = new ItemStack(Material.IRON_INGOT);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Wolverine");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Seja imortal!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.pulapula")) {
			final ItemStack pyro = new ItemStack(Material.COCOA);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Pula-Pula");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Pule que nem uma purga para cima dos inimigos");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.fujao")) {
			final ItemStack pyro = new ItemStack(Material.GHAST_TEAR);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Fujao");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Quando nao tiver mais jeito corra!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.morf")) {
			final ItemStack pyro = new ItemStack(Material.BLAZE_POWDER);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Morf");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Morfe e mate seus inimigos");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.sniper")) {
			final ItemStack pyro = new ItemStack(Material.IRON_BARDING);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Sniper");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Tenha uma boa mira e mate todos!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.skeleton")) {
			final ItemStack pyro = new ItemStack(Material.BONE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Skeleton");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Mate seus inimigos com um hit!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.grandpa")) {
			final ItemStack pyro = new ItemStack(Material.STICK);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Grandpa");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Jogue seus inimigos pra longe!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.salamander")) {
			final ItemStack pyro = new ItemStack(Material.FIRE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Salamander");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Ganhe poderes no bioma nether!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.robinhood")) {
			final ItemStack pyro = new ItemStack(Material.ARROW);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "RobinHood");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Mate com apenas uma flexada");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.flash")) {
			final ItemStack pyro = new ItemStack(Material.REDSTONE_TORCH_ON);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Flash");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Seja rapido como o flash!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.ryu")) {
			final ItemStack pyro = new ItemStack(Material.BEACON);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Ryu");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "De um HADOKKEN no inimigo!!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		p.openInventory(inv);
		ItemStack[] arrayOfItemStack;
		for (int descpyro2 = (arrayOfItemStack = inv.getContents()).length,
				metapyro2 = 0; metapyro2 < descpyro2; ++metapyro2) {
			final ItemStack item = arrayOfItemStack[metapyro2];
			if (item == null) {
				inv.setItem(inv.firstEmpty(), vidro);
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (commandLabel.equalsIgnoreCase("kits2") || commandLabel.equalsIgnoreCase("kit2")) {
			final Player p = (Player) sender;
			guiKits(p);
		}
		return false;
	}

	@EventHandler
	public void onPlayerCLickInventry(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§9Seus Kits: (2)") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.HOPPER) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/darkgod");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WATCH) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/timelord");
				return;
			}
			if (e.getCurrentItem().getType() == Material.LEATHER_CHESTPLATE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/paladino");
				return;
			}
			if (e.getCurrentItem().getType() == Material.IRON_INGOT) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/wolverine");
				return;
			}
			if (e.getCurrentItem().getType() == Material.COCOA) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/pulapula");
				return;
			}
			if (e.getCurrentItem().getType() == Material.GHAST_TEAR) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/fujao");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SHEARS) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/batman");
				return;
			}
			if (e.getCurrentItem().getType() == Material.STONE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/stoneman");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BLAZE_POWDER) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/morf");
				return;
			}
			if (e.getCurrentItem().getType() == Material.IRON_BARDING) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/sniper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BONE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/skeleton");
				return;
			}
			if (e.getCurrentItem().getType() == Material.STICK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/grandpa");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FIRE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/salamander");
				return;
			}
			if (e.getCurrentItem().getType() == Material.ARROW) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/robinhood");
				return;
			}
			if (e.getCurrentItem().getType() == Material.REDSTONE_TORCH_ON) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/flash");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BEACON) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/ryu");
				return;
			}
			if (e.getCurrentItem().getType() == Material.IRON_DOOR) {
				e.setCancelled(true);
				p.chat("/kits");
			}
		}
	}
}
