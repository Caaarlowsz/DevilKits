package me.devilkits.Utils;

import org.bukkit.plugin.*;
import java.io.*;
import org.bukkit.configuration.file.*;
import java.util.*;

public class MoneyManager
{
    private static MoneyManager instance;
    private Plugin p;
    private static FileConfiguration config;
    private static File cfile;
    
    static {
        MoneyManager.instance = new MoneyManager();
    }
    
    public static MoneyManager pl() {
        return MoneyManager.instance;
    }
    
    public void setup(final Plugin p) {
        this.p = p;
        if (!p.getDataFolder().exists()) {
            p.getDataFolder().mkdir();
        }
        MoneyManager.cfile = new File(p.getDataFolder(), "money.yml");
        if (!MoneyManager.cfile.exists()) {
            try {
                MoneyManager.cfile.createNewFile();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        MoneyManager.config = (FileConfiguration)YamlConfiguration.loadConfiguration(MoneyManager.cfile);
    }
    
    public int getBalance(final String p) {
        return MoneyManager.config.getInt("money." + p.toLowerCase());
    }
    
    public void adicionarDinheiro(final String p, final int amnt) {
        this.setarBalance(p, this.getBalance(p) + amnt);
    }
    
    public boolean removerDinheiro(final String p, final int amnt) {
        if (this.getBalance(p) - amnt < 0) {
            return false;
        }
        this.setarBalance(p, this.getBalance(p) - amnt);
        return true;
    }
    
    public boolean clearDinheiro(final String p, final int amnt) {
        this.setarBalance(p, 0);
        return true;
    }
    
    public void setarBalance(final String p, final int amnt) {
        MoneyManager.config.set("money." + p.toLowerCase(), (Object)amnt);
        save();
    }
    
    public ArrayList<String> getValues() {
        final Map<String, Object> map = (Map<String, Object>)MoneyManager.config.getValues(true);
        final ArrayList<String> lines = new ArrayList<String>();
        for (final Map.Entry<String, Object> e : map.entrySet()) {
            lines.add(e.getValue() + " " + e.getKey());
        }
        return lines;
    }
    
    private static void save() {
        try {
            MoneyManager.config.save(MoneyManager.cfile);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Plugin getPlugin() {
        return this.p;
    }
}
