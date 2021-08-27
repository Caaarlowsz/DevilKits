package me.devilkits.Utils;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class StatsManager implements Listener {
	private static StatsManager classe;
	private Plugin p;
	private FileConfiguration config;
	private File cfile;

	static {
		StatsManager.classe = new StatsManager();
	}

	public static StatsManager classe() {
		return StatsManager.classe;
	}

	public void setupkits(final Plugin p) {
		this.p = p;
		if (!p.getDataFolder().exists()) {
			p.getDataFolder().mkdir();
		}
		this.cfile = new File(p.getDataFolder(), "StatsDatabase.yml");
		if (!this.cfile.exists()) {
			try {
				this.cfile.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.config = (FileConfiguration) YamlConfiguration.loadConfiguration(this.cfile);
	}

	public int getKills(final Player p) {
		return this.config.getInt(String.valueOf(p.getName().toLowerCase()) + ".kills");
	}

	public int getDeaths(final Player p) {
		return this.config.getInt(String.valueOf(p.getName().toLowerCase()) + ".deaths");
	}

	public int getWins1v1(final Player p) {
		return this.config.getInt(String.valueOf(p.getName().toLowerCase()) + ".wins1v1");
	}

	public int getLosers1v1(final Player p) {
		return this.config.getInt(String.valueOf(p.getName().toLowerCase()) + ".losers1v1");
	}

	public void addKills(final Player p) {
		this.config.set(String.valueOf(p.getName().toLowerCase()) + ".kills", (Object) (this.getKills(p) + 1));
		this.save();
	}

	public void addDeaths(final Player p) {
		this.config.set(String.valueOf(p.getName().toLowerCase()) + ".deaths", (Object) (this.getDeaths(p) + 1));
		this.save();
	}

	public void addWins1v1(final Player p) {
		this.config.set(String.valueOf(p.getName().toLowerCase()) + ".wins1v1", (Object) (this.getWins1v1(p) + 1));
		this.save();
	}

	public void addLosers1v1(final Player p) {
		this.config.set(String.valueOf(p.getName().toLowerCase()) + ".losers1v1", (Object) (this.getLosers1v1(p) + 1));
	}

	private void save() {
		try {
			this.config.save(this.cfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Plugin getPlugin() {
		return this.p;
	}
}
