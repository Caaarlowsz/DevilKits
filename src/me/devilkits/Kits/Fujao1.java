package me.devilkits.Kits;

import org.bukkit.event.*;
import org.bukkit.entity.*;

public class Fujao1 implements Runnable, Listener
{
    private Player p;
    
    public static Runnable FujaoFuncao(final Fujao paramFujao, final Player paramPlayer) {
        return (Runnable)paramPlayer;
    }
    
    @Override
    public void run() {
        Fujao.cooldownm.remove(this.p);
        this.p.sendMessage("§1Voce pode usar novamente!");
    }
}
