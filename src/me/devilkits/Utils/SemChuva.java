package me.devilkits.Utils;

import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class SemChuva implements Listener {
	public void chuva(final WeatherChangeEvent event) {
		event.setCancelled(true);
	}
}
