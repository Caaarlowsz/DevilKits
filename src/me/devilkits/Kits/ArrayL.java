package me.devilkits.Kits;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class ArrayL implements Listener {
	public static ArrayList<String> used;
	public static ArrayList<String> fujao;
	public static ArrayList<String> puurga;

	static {
		ArrayL.used = new ArrayList<String>();
		ArrayL.fujao = new ArrayList<String>();
		ArrayL.puurga = new ArrayList<String>();
	}

	@EventHandler
	public void remove(final PlayerDeathEvent e) {
		final Player p = e.getEntity();
		ArrayL.used.remove(p.getName());
		ArrayL.puurga.remove(p.getName());
		ArrayL.fujao.remove(p.getName());
	}
}
