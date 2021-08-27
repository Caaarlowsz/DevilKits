package me.devilkits.Utils;

import org.bukkit.event.*;
import org.bukkit.event.weather.*;

public class SemChuva implements Listener
{
    public void chuva(final WeatherChangeEvent event) {
        event.setCancelled(true);
    }
}
