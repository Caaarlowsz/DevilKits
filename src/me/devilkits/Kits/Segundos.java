package me.devilkits.Kits;

import org.bukkit.event.*;

public class Segundos extends Event
{
    private static final HandlerList handlers;
    
    static {
        handlers = new HandlerList();
    }
    
    public static HandlerList getHandlerList() {
        return Segundos.handlers;
    }
    
    public HandlerList getHandlers() {
        return Segundos.handlers;
    }
}
