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

public class Kits implements Listener, CommandExecutor {
	public static void guiKits(final Player p) {
		final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder) p, 54, "§9Seus Kits:");
		final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
		final ItemMeta metav = vidro.getItemMeta();
		metav.setDisplayName(" ");
		vidro.setItemMeta(metav);
		final ItemStack vidro2 = new ItemStack(Material.ENDER_PORTAL);
		final ItemMeta metav2 = vidro.getItemMeta();
		metav2.setDisplayName(" ");
		vidro2.setItemMeta(metav2);
		final ItemStack vidro3 = new ItemStack(Material.WOOD_DOOR);
		final ItemMeta metav3 = vidro.getItemMeta();
		metav3.setDisplayName("§6Proximos Kits");
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
		if (p.hasPermission("kit.pvp")) {
			final ItemStack pyro = new ItemStack(Material.STONE_SWORD);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "PvP");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Kit sem habilidade");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Archer")) {
			final ItemStack pyro = new ItemStack(Material.BOW);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Archer");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Mate seus inimigos com seu arco e flecha");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Fireman")) {
			final ItemStack pyro = new ItemStack(Material.LAVA);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Fireman");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Nao Tome Dano Da Lava e");
			descpyro.add(ChatColor.GRAY + "Queime Seus Inimigos com sua espada");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Anchor")) {
			final ItemStack pyro = new ItemStack(Material.ANVIL);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Anchor");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Nao de knockback e nem leve knockback");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.c4")) {
			final ItemStack pyro = new ItemStack(Material.STONE_BUTTON);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "C4");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Exploda todo mundo ahaha");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Kangaroo")) {
			final ItemStack pyro = new ItemStack(Material.FIREWORK);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Kangaroo");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "De duplos pulos com sua firework");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.milkman")) {
			final ItemStack pyro = new ItemStack(Material.MILK_BUCKET);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Milkman");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Ganhe Regeneracao, Forca, Velocidade e Resistencia ao Fogo!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Lobisomem")) {
			final ItemStack pyro = new ItemStack(Material.MONSTER_EGG);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Lobisomem");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Ganhe velocidade e Super Pulo ao virar um lobisomem!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Ninja")) {
			final ItemStack pyro = new ItemStack(Material.NETHER_STAR);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Ninja");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Bata em um jogador aperte shift");
			descpyro.add(ChatColor.GRAY + "para se teleportar ate ele");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Frosty")) {
			final ItemStack pyro = new ItemStack(Material.SNOW_BLOCK);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Frosty");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Ganhe forca e Velocidade na Neve");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Ghoul")) {
			final ItemStack pyro = new ItemStack(Material.REDSTONE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Ghoul");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Se Torne um verdadeiro Ghoul!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Titan")) {
			final ItemStack pyro = new ItemStack(Material.BEDROCK);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Titan");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Ganhe Regeneracao IV");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Fisherman")) {
			final ItemStack pyro = new ItemStack(Material.FISHING_ROD);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Fisherman");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Use sua vara de pesca para puxar jogadores");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Viper")) {
			final ItemStack pyro = new ItemStack(Material.SPIDER_EYE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Viper");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Ao bater em jogadores voce tem 33% de chance");
			descpyro.add(ChatColor.GRAY + "de dar a eles o efeito de Veneno!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Viking")) {
			final ItemStack pyro = new ItemStack(Material.DIAMOND_AXE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Viking");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Cause o dano de uma espada de Iron com seu machado!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.infernor")) {
			final ItemStack pyro = new ItemStack(Material.NETHER_FENCE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Infernor");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Crie Uma Arena Infernal!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Snail")) {
			final ItemStack pyro = new ItemStack(Material.WEB);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Snail");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Ao bater em jogadores voce tem 33% de chance");
			descpyro.add(ChatColor.GRAY + "de dar a eles o efeito de Lentidao!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Barbarian")) {
			final ItemStack pyro = new ItemStack(Material.WOOD_SWORD);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Barbarian");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "A cada kill evolua sua Espada");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Naruto")) {
			final ItemStack pyro = new ItemStack(Material.GOLD_INGOT);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Naruto");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Tenha o poder de virar a Raposa de 9 caldas!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Specialist")) {
			final ItemStack pyro = new ItemStack(Material.BOOK);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Specialist");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Tenha uma Mesa de Encantos Portatil");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Jellyfish")) {
			final ItemStack pyro = new ItemStack(Material.STATIONARY_WATER);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Jellyfish");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Ao clicar no chao coloque uma agua estatica");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Confuser")) {
			final ItemStack pyro = new ItemStack(Material.APPLE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Confuser");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Deixe seus inimigos com Confusao");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Stomper")) {
			final ItemStack pyro = new ItemStack(Material.DIAMOND_BOOTS);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Stomper");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Esmague seus inimigos");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Endermage")) {
			final ItemStack pyro = new ItemStack(Material.PORTAL);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Endermage");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Puxe quem estiver acima ou abaixo de voce!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Switcher")) {
			final ItemStack pyro = new ItemStack(Material.SNOW_BALL);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Switcher");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Ao jogar uma bola de neve em um player");
			descpyro.add(ChatColor.GRAY + "voce sera teleportado ate ele!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("LifeKit.Monk")) {
			final ItemStack pyro = new ItemStack(Material.BLAZE_ROD);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Monk");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Coloque items em um local");
			descpyro.add(ChatColor.GRAY + "aleatorio no inventario do inimigo!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Camel")) {
			final ItemStack pyro = new ItemStack(Material.SAND);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Camel");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Na areia ganhe velocidade e regenera\u00e7o!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Poseidon")) {
			final ItemStack pyro = new ItemStack(Material.WATER_BUCKET);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Poseidon");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Quando estiver na neve ganhe forca e speed!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.thor")) {
			final ItemStack pyro = new ItemStack(Material.WOOD_AXE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Thor");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Cause raios como o thor");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Urgal")) {
			final ItemStack pyro = new ItemStack(Material.POTION, 1, (short) 8265);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Urgal");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Ganhe uma po\u00e7ao de forca!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.sumo")) {
			final ItemStack pyro = new ItemStack(Material.EMERALD_BLOCK);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Sumo");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Lance seus inimigos para o alto");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Copycat")) {
			final ItemStack pyro = new ItemStack(Material.DOUBLE_PLANT);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Copycat");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Quando matar um player roube o kit dele!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Gladiator")) {
			final ItemStack pyro = new ItemStack(Material.IRON_FENCE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Gladiator");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Puxe players para uma arena 1v1!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.WeakSword")) {
			final ItemStack pyro = new ItemStack(Material.FERMENTED_SPIDER_EYE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "WeakSword");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Cause efeito de Whiter nos seus inimigos");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Critical")) {
			final ItemStack pyro = new ItemStack(Material.GOLDEN_APPLE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Critical");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Tenha chance de dar golpes criticos nos inimigos");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Berserker")) {
			final ItemStack pyro = new ItemStack(Material.OBSIDIAN);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Berserker");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Tenha um monstro de si mesmo!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Hunter")) {
			final ItemStack pyro = new ItemStack(Material.STICK);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Hunter");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Atire Dardos nos seus inimigos! E os Cause:");
			descpyro.add(ChatColor.GRAY + "Veneno, Confusao, Cegueira e Lentidao");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Grappler")) {
			final ItemStack pyro = new ItemStack(Material.LEASH);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Grappler");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Se Pendure Onde Quiser!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Boxer")) {
			final ItemStack pyro = new ItemStack(Material.QUARTZ);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Boxer");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Tome Dano Reduzido e Cause um Dano imenso com suas luvas!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Hulk")) {
			final ItemStack pyro = new ItemStack(Material.DIAMOND);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Hulk");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Levante seus inimigos e os arremesse");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Reaper")) {
			final ItemStack pyro = new ItemStack(Material.WOOD_HOE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Reaper");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Com sua enchada deixe seus inmigos com efeito de whiter");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Launcher")) {
			final ItemStack pyro = new ItemStack(Material.SPONGE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Launcher");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Arremesse seus inimigos para o ar");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.HomemPedra")) {
			final ItemStack pyro = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Homem-Pedra");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Ganhe Velocidade e Regeneracao na Pedra");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Resouper")) {
			final ItemStack pyro = new ItemStack(Material.MUSHROOM_SOUP);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Resouper");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Ao matar um jogador ganhe sopas no inventario!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Turtle")) {
			final ItemStack pyro = new ItemStack(Material.DIAMOND_CHESTPLATE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName(ChatColor.GOLD + "Turtle");
			final ArrayList<String> descpyro = new ArrayList<>();
			descpyro.add(ChatColor.GRAY + "Ao pressionar SHIFT tome dano reduzido");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		ItemStack[] arrayOfItemStack;
		for (int descpyro2 = (arrayOfItemStack = inv.getContents()).length,
				metapyro2 = 0; metapyro2 < descpyro2; ++metapyro2) {
			final ItemStack item = arrayOfItemStack[metapyro2];
			if (item == null) {
				inv.setItem(inv.firstEmpty(), vidro);
			}
		}
		p.openInventory(inv);
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (commandLabel.equalsIgnoreCase("kits") || commandLabel.equalsIgnoreCase("kit")) {
			final Player p = (Player) sender;
			guiKits(p);
		}
		return false;
	}

	@EventHandler
	public void onPlayerCLickInventry(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§9Seus Kits:") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.STONE_SWORD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/pvp");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WOOD_DOOR) {
				e.setCancelled(true);
				p.chat("/kits2");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BOW) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/archer");
				return;
			}
			if (e.getCurrentItem().getType() == Material.ANVIL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/anchor");
				return;
			}
			if (e.getCurrentItem().getType() == Material.REDSTONE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/ghoul");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BEDROCK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/titan");
				return;
			}
			if (e.getCurrentItem().getType() == Material.MONSTER_EGG) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/lobisomem");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FIREWORK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kangaroo");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WOOD_SWORD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/barbarian");
				return;
			}
			if (e.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/turtle");
				return;
			}
			if (e.getCurrentItem().getType() == Material.DIAMOND_AXE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/viking");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FERMENTED_SPIDER_EYE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/weaksword");
				return;
			}
			if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/ninja");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FISHING_ROD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/fisherman");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SPIDER_EYE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/viper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.CHAINMAIL_CHESTPLATE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/homempedra");
				return;
			}
			if (e.getCurrentItem().getType() == Material.DIAMOND) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/hulk");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WEB) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/snail");
				return;
			}
			if (e.getCurrentItem().getType() == Material.GOLDEN_APPLE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/critical");
				return;
			}
			if (e.getCurrentItem().getType() == Material.STICK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/hunter");
				return;
			}
			if (e.getCurrentItem().getType() == Material.LEASH) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/grappler");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WOOD_HOE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/reaper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.QUARTZ) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/boxer");
				return;
			}
			if (e.getCurrentItem().getType() == Material.STATIONARY_WATER) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/jellyfish");
				return;
			}
			if (e.getCurrentItem().getType() == Material.MUSHROOM_SOUP) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/resouper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.GOLD_PLATE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/resouper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SPONGE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/launcher");
				return;
			}
			if (e.getCurrentItem().getType() == Material.DIAMOND_BOOTS) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/stomper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.NETHER_FENCE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/infernor");
				return;
			}
			if (e.getCurrentItem().getType() == Material.PORTAL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/endermage");
				return;
			}
			if (e.getCurrentItem().getType() == Material.MILK_BUCKET) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/milkman");
				return;
			}
			if (e.getCurrentItem().getType() == Material.GOLD_INGOT) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/naruto");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BOOK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/specialist");
				return;
			}
			if (e.getCurrentItem().getType() == Material.OBSIDIAN) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/berserker");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SNOW_BALL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/switcher");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BLAZE_ROD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/monk");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SAND) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/camel");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WATER_BUCKET) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/poseidon");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SNOW_BLOCK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/frosty");
				return;
			}
			if (e.getCurrentItem().getType() == Material.POTION) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/urgal");
				return;
			}
			if (e.getCurrentItem().getType() == Material.EMERALD_BLOCK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/sumo");
				return;
			}
			if (e.getCurrentItem().getType() == Material.APPLE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/confuser");
				return;
			}
			if (e.getCurrentItem().getType() == Material.DOUBLE_PLANT) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/copycat");
				return;
			}
			if (e.getCurrentItem().getType() == Material.LAVA) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/fireman");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WOOD_AXE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/thor");
				return;
			}
			if (e.getCurrentItem().getType() == Material.IRON_FENCE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/gladiator");
				return;
			}
			if (e.getCurrentItem().getType() == Material.STONE_BUTTON) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/c4");
			}
		}
	}
}
