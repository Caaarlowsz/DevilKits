package me.devilkits.Utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class Book implements Listener {
	@EventHandler
	public void onPlayerJoin(final PlayerJoinEvent e) {
		final ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
		final Player p = e.getPlayer();
		final BookMeta meta = (BookMeta) book.getItemMeta();
		meta.setTitle(ChatColor.GOLD + "Regras");
		meta.setAuthor(ChatColor.AQUA + "Equipe do Servidor");
		meta.addPage(new String[] { ChatColor.GRAY + "----==[§4REGRAS§7]==----" + ChatColor.RED + "1.Nao usar hack\n"
				+ ChatColor.RED + "\n" + ChatColor.RED + "2.Nao xingar players " + ChatColor.RED + "e a staff!\n"
				+ ChatColor.RED + "\n" + ChatColor.RED + "3.Nao abusar de bugs\n" + ChatColor.RED + "\n" + ChatColor.RED
				+ "4.Nao divulgar\n" + ChatColor.RED + "qualquer tipo de\n" + ChatColor.RED + "servidor ou site\n"
				+ ChatColor.RED + "\n" + ChatColor.RED + "\n" + ChatColor.BLUE + "Bom Jogo!" });
		book.setItemMeta((ItemMeta) meta);
		p.getInventory().setItem(8, book);
	}
}
