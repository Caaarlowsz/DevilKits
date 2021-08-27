package me.devilkits.Kits;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.devilkits.Main;

public class Copycat implements Listener, CommandExecutor {
	public static Main plugin;

	public Copycat(final Main main) {
		Copycat.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("copycat")) {
			if (!Main.usandokit.contains(p.getName()) && p.hasPermission("kit.copycat")) {
				p.sendMessage("§7Voce pegou o Kit : §6Copycat");
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
				Main.usandokit.add(p.getName());
				Main.copycat.add(sender.getName());
				p.getInventory().clear();
				final ItemStack espada = new ItemStack(Material.WOOD_SWORD);
				final ItemMeta espadameta = espada.getItemMeta();
				espadameta.setDisplayName("§cSword");
				espada.addEnchantment(Enchantment.DURABILITY, 3);
				p.getInventory().addItem(new ItemStack[] { espada });
				Main.giveSoup(p, 35);
			}
			return true;
		}
		return false;
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerDeath(final PlayerDeathEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		final Player vitima = e.getEntity();
		if (e.getEntity().getKiller() instanceof Player) {
			final Player matador = e.getEntity().getKiller();
			if (matador != vitima && !Main.copycat.contains(matador.getName())) {
				return;
			}
			if (!Main.endermage.contains(vitima.getName())) {
				return;
			}
			matador.playSound(matador.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			matador.sendMessage("§b§oAgora voce \u00e9 um: §7§o§lEndermage");
			Main.removeAbility(matador);
			Main.endermage.add(matador.getName());
			Main.copycat.add(matador.getName());
			Main.usandokit.add(matador.getName());
			removeKitAbilityForCopycat(matador);
			final ItemStack kitse = new ItemStack(Material.PORTAL);
			final ItemMeta kitsme = kitse.getItemMeta();
			kitsme.setDisplayName("§5Endermage Portal");
			kitse.setItemMeta(kitsme);
			matador.getInventory().setItem(1, kitse);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerDeath1(final PlayerDeathEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		final Player vitima = e.getEntity();
		if (e.getEntity().getKiller() instanceof Player) {
			final Player matador = e.getEntity().getKiller();
			if (matador != vitima && !Main.copycat.contains(matador.getName())) {
				return;
			}
			if (!Main.gladiator.contains(vitima.getName())) {
				return;
			}
			matador.playSound(matador.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			matador.sendMessage("§b§oAgora voce \u00e9 um: §7§o§lGladiator");
			Main.removeAbility(matador);
			Main.gladiator.add(matador.getName());
			Main.copycat.add(matador.getName());
			Main.usandokit.add(matador.getName());
			removeKitAbilityForCopycat(matador);
			final ItemStack kitse = new ItemStack(Material.IRON_FENCE);
			final ItemMeta kitsme = kitse.getItemMeta();
			kitsme.setDisplayName("§6Shadow Game");
			kitse.setItemMeta(kitsme);
			matador.getInventory().setItem(1, kitse);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerDeath11(final PlayerDeathEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		final Player vitima = e.getEntity();
		if (e.getEntity().getKiller() instanceof Player) {
			final Player matador = e.getEntity().getKiller();
			if (matador != vitima && !Main.copycat.contains(matador.getName())) {
				return;
			}
			if (!Main.archer.contains(vitima.getName())) {
				return;
			}
			matador.playSound(matador.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			matador.sendMessage("§b§oAgora voce \u00e9 um: §7§o§lArcher");
			Main.removeAbility(matador);
			Main.archer.add(matador.getName());
			Main.copycat.add(matador.getName());
			Main.usandokit.add(matador.getName());
			removeKitAbilityForCopycat(matador);
			final ItemStack bow = new ItemStack(Material.BOW);
			final ItemMeta bowmeta = bow.getItemMeta();
			bowmeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
			bowmeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			bowmeta.setDisplayName("§cBow Archer");
			bow.setItemMeta(bowmeta);
			final ItemStack bow2 = new ItemStack(Material.ARROW);
			final ItemMeta bowmeta2 = bow2.getItemMeta();
			bow2.setItemMeta(bowmeta2);
			matador.getInventory().setItem(1, bow);
			matador.getInventory().setItem(2, bow2);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerDeath111(final PlayerDeathEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		final Player vitima = e.getEntity();
		if (e.getEntity().getKiller() instanceof Player) {
			final Player matador = e.getEntity().getKiller();
			if (matador != vitima && !Main.copycat.contains(matador.getName())) {
				return;
			}
			if (!Main.jellyfish.contains(vitima.getName())) {
				return;
			}
			matador.playSound(matador.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			matador.sendMessage("§b§oAgora voce \u00e9 um: §7§o§lJellyfish");
			Main.removeAbility(matador);
			Main.jellyfish.add(matador.getName());
			Main.copycat.add(matador.getName());
			Main.usandokit.add(matador.getName());
			removeKitAbilityForCopycat(matador);
			final ItemStack bow = new ItemStack(Material.SLIME_BALL);
			final ItemMeta bowmeta = bow.getItemMeta();
			bowmeta.setDisplayName("§bJellyfish Kit");
			bow.setItemMeta(bowmeta);
			matador.getInventory().setItem(1, bow);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerDeath1111(final PlayerDeathEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		final Player vitima = e.getEntity();
		if (e.getEntity().getKiller() instanceof Player) {
			final Player matador = e.getEntity().getKiller();
			if (matador != vitima && !Main.copycat.contains(matador.getName())) {
				return;
			}
			if (!Main.fisherman.contains(vitima.getName())) {
				return;
			}
			matador.playSound(matador.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			matador.sendMessage("§b§oAgora voce \u00e9 um: §7§o§lFisherman");
			Main.removeAbility(matador);
			Main.fisherman.add(matador.getName());
			Main.copycat.add(matador.getName());
			Main.usandokit.add(matador.getName());
			removeKitAbilityForCopycat(matador);
			final ItemStack bow = new ItemStack(Material.FISHING_ROD);
			final ItemMeta bowmeta = bow.getItemMeta();
			bowmeta.setDisplayName("§cFishing Rod");
			bow.setItemMeta(bowmeta);
			matador.getInventory().setItem(1, bow);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerDeath11111(final PlayerDeathEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		final Player vitima = e.getEntity();
		if (e.getEntity().getKiller() instanceof Player) {
			final Player matador = e.getEntity().getKiller();
			if (matador != vitima && !Main.copycat.contains(matador.getName())) {
				return;
			}
			if (!Main.kangaroo.contains(vitima.getName())) {
				return;
			}
			matador.playSound(matador.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			matador.sendMessage("§b§oAgora voce \u00e9 um: §7§o§lKangaroo");
			Main.removeAbility(matador);
			Main.kangaroo.add(matador.getName());
			Main.copycat.add(matador.getName());
			Main.usandokit.add(matador.getName());
			removeKitAbilityForCopycat(matador);
			final ItemStack bow = new ItemStack(Material.FIREWORK);
			final ItemMeta bowmeta = bow.getItemMeta();
			bowmeta.setDisplayName("§cKangaroo Rocket");
			bow.setItemMeta(bowmeta);
			matador.getInventory().setItem(1, bow);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerDeath111111(final PlayerDeathEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		final Player vitima = e.getEntity();
		if (e.getEntity().getKiller() instanceof Player) {
			final Player matador = e.getEntity().getKiller();
			if (matador != vitima && !Main.copycat.contains(matador.getName())) {
				return;
			}
			if (!Main.monk.contains(vitima.getName())) {
				return;
			}
			matador.playSound(matador.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			matador.sendMessage("§b§oAgora voce \u00e9 um: §7§o§lMonk");
			Main.removeAbility(matador);
			removeKitAbilityForCopycat(matador);
			Main.monk.add(matador.getName());
			Main.copycat.add(matador.getName());
			Main.usandokit.add(matador.getName());
			final ItemStack bow = new ItemStack(Material.BLAZE_ROD);
			final ItemMeta bowmeta = bow.getItemMeta();
			bowmeta.setDisplayName("§6Monk Kit");
			bow.setItemMeta(bowmeta);
			matador.getInventory().setItem(1, bow);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerDeath1111111(final PlayerDeathEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		final Player vitima = e.getEntity();
		if (e.getEntity().getKiller() instanceof Player) {
			final Player matador = e.getEntity().getKiller();
			if (matador != vitima && !Main.copycat.contains(matador.getName())) {
				return;
			}
			if (!Main.switcher.contains(vitima.getName())) {
				return;
			}
			matador.playSound(matador.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			matador.sendMessage("§b§oAgora voce \u00e9 um: §7§o§lSwitcher");
			Main.removeAbility(matador);
			removeKitAbilityForCopycat(matador);
			Main.switcher.add(matador.getName());
			Main.copycat.add(matador.getName());
			Main.usandokit.add(matador.getName());
			final ItemStack bow = new ItemStack(Material.SNOW_BALL);
			final ItemMeta bowmeta = bow.getItemMeta();
			bowmeta.setDisplayName("§cSwitcher Ball");
			bow.setItemMeta(bowmeta);
			bow.setAmount(16);
			matador.getInventory().setItem(1, bow);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerDeath11111111(final PlayerDeathEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		final Player vitima = e.getEntity();
		if (e.getEntity().getKiller() instanceof Player) {
			final Player matador = e.getEntity().getKiller();
			if (matador != vitima && !Main.copycat.contains(matador.getName())) {
				return;
			}
			if (!Main.urgal.contains(vitima.getName())) {
				return;
			}
			matador.playSound(matador.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			matador.sendMessage("§b§oAgora voce \u00e9 um: §7§o§lUrgal");
			Main.removeAbility(matador);
			removeKitAbilityForCopycat(matador);
			Main.urgal.add(matador.getName());
			Main.copycat.add(matador.getName());
			Main.usandokit.add(matador.getName());
			final ItemStack bow = new ItemStack(Material.POTION, 1, (short) 8201);
			final ItemMeta bowmeta = bow.getItemMeta();
			bowmeta.setDisplayName("§6Urgal Potion");
			bow.setAmount(2);
			bow.setItemMeta(bowmeta);
			matador.getInventory().setItem(1, bow);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerDeath111111111(final PlayerDeathEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		final Player vitima = e.getEntity();
		if (e.getEntity().getKiller() instanceof Player) {
			final Player matador = e.getEntity().getKiller();
			if (matador != vitima && !Main.copycat.contains(matador.getName())) {
				return;
			}
			if (!Main.anchor.contains(vitima.getName())) {
				return;
			}
			matador.playSound(matador.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			matador.sendMessage("§b§oAgora voce \u00e9 um: §7§o§lAnchor");
			Main.removeAbility(matador);
			Main.anchor.add(matador.getName());
			Main.copycat.add(matador.getName());
			Main.usandokit.add(matador.getName());
			removeKitAbilityForCopycat(matador);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerDeath1111111111(final PlayerDeathEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		final Player vitima = e.getEntity();
		if (e.getEntity().getKiller() instanceof Player) {
			final Player matador = e.getEntity().getKiller();
			if (matador != vitima && !Main.copycat.contains(matador.getName())) {
				return;
			}
			if (!Main.camel.contains(vitima.getName())) {
				return;
			}
			matador.playSound(matador.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			matador.sendMessage("§b§oAgora voce \u00e9 um: §7§o§lCamel");
			Main.removeAbility(matador);
			Main.camel.add(matador.getName());
			Main.copycat.add(matador.getName());
			Main.usandokit.add(matador.getName());
			removeKitAbilityForCopycat(matador);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerDeath11111111111(final PlayerDeathEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		final Player vitima = e.getEntity();
		if (e.getEntity().getKiller() instanceof Player) {
			final Player matador = e.getEntity().getKiller();
			if (matador != vitima && !Main.copycat.contains(matador.getName())) {
				return;
			}
			if (!Main.ninja.contains(vitima.getName())) {
				return;
			}
			matador.playSound(matador.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			matador.sendMessage("§b§oAgora voce \u00e9 um: §7§o§lNinja");
			Main.removeAbility(matador);
			Main.ninja.add(matador.getName());
			Main.copycat.add(matador.getName());
			Main.usandokit.add(matador.getName());
			removeKitAbilityForCopycat(matador);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerDeath111111111111(final PlayerDeathEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		final Player vitima = e.getEntity();
		if (e.getEntity().getKiller() instanceof Player) {
			final Player matador = e.getEntity().getKiller();
			if (matador != vitima && !Main.copycat.contains(matador.getName())) {
				return;
			}
			if (!Main.poseidon.contains(vitima.getName())) {
				return;
			}
			matador.playSound(matador.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			matador.sendMessage("§b§oAgora voce \u00e9 um: §7§o§lPoseidon");
			Main.removeAbility(matador);
			Main.poseidon.add(matador.getName());
			Main.copycat.add(matador.getName());
			Main.usandokit.add(matador.getName());
			removeKitAbilityForCopycat(matador);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerDeath1111111111111(final PlayerDeathEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		final Player vitima = e.getEntity();
		if (e.getEntity().getKiller() instanceof Player) {
			final Player matador = e.getEntity().getKiller();
			if (matador != vitima && !Main.copycat.contains(matador.getName())) {
				return;
			}
			if (!Main.snail.contains(vitima.getName())) {
				return;
			}
			matador.playSound(matador.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			matador.sendMessage("§b§oAgora voce \u00e9 um: §7§o§lSnail");
			Main.removeAbility(matador);
			Main.snail.add(matador.getName());
			Main.copycat.add(matador.getName());
			Main.usandokit.add(matador.getName());
			removeKitAbilityForCopycat(matador);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerDeath11111111111111(final PlayerDeathEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		final Player vitima = e.getEntity();
		if (e.getEntity().getKiller() instanceof Player) {
			final Player matador = e.getEntity().getKiller();
			if (matador != vitima && !Main.copycat.contains(matador.getName())) {
				return;
			}
			if (!Main.stomper.contains(vitima.getName())) {
				return;
			}
			matador.playSound(matador.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			matador.sendMessage("§b§oAgora voce \u00e9 um: §7§o§lStomper");
			Main.removeAbility(matador);
			removeKitAbilityForCopycat(matador);
			Main.stomper.add(matador.getName());
			Main.copycat.add(matador.getName());
			Main.usandokit.add(matador.getName());
			final ItemStack bow = new ItemStack(Material.GOLDEN_APPLE);
			final ItemMeta bowmeta = bow.getItemMeta();
			bowmeta.setDisplayName("§9Stomper Apple");
			bow.setItemMeta(bowmeta);
			matador.getInventory().setItem(1, bow);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerDeath111111111111111(final PlayerDeathEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		final Player vitima = e.getEntity();
		if (e.getEntity().getKiller() instanceof Player) {
			final Player matador = e.getEntity().getKiller();
			if (matador != vitima && !Main.copycat.contains(matador.getName())) {
				return;
			}
			if (!Main.viper.contains(vitima.getName())) {
				return;
			}
			matador.playSound(matador.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			matador.sendMessage("§b§oAgora voce \u00e9 um: §7§o§lViper");
			Main.removeAbility(matador);
			Main.viper.add(matador.getName());
			Main.copycat.add(matador.getName());
			Main.usandokit.add(matador.getName());
			removeKitAbilityForCopycat(matador);
		}
	}

	public static void removeKitAbilityForCopycat(final Player p) {
		p.getInventory().remove(Material.BOW);
		p.getInventory().remove(Material.ARROW);
		p.getInventory().remove(Material.PORTAL);
		p.getInventory().remove(Material.FISHING_ROD);
		p.getInventory().remove(Material.IRON_FENCE);
		p.getInventory().remove(Material.SLIME_BALL);
		p.getInventory().remove(Material.FIREWORK);
		p.getInventory().remove(Material.BLAZE_ROD);
		p.getInventory().remove(Material.SNOW_BALL);
		p.getInventory().remove(Material.GOLDEN_APPLE);
		p.getInventory().remove(Material.POTION);
	}
}
