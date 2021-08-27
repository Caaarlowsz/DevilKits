package me.devilkits.Utils;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.event.*;

public class Hit implements Listener
{
    @EventHandler
    public void onHit(final EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Zombie && event.getDamager() instanceof Player) {
            final Player p = (Player)event.getDamager();
            final ItemStack[] armor = p.getInventory().getArmorContents();
            p.getItemInHand().setDurability((short)(-p.getItemInHand().getType().getMaxDurability()));
            if (armor.length > 0) {
                for (int i = 0; i < armor.length; ++i) {
                    armor[i].setDurability((short)(-armor[i].getType().getMaxDurability()));
                }
            }
        }
    }
}
