package me.devilkits.Kits;

import me.devilkits.*;
import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.event.player.*;
import org.bukkit.inventory.*;
import org.bukkit.*;
import org.bukkit.plugin.*;
import org.bukkit.event.*;

public class C4HAB implements Listener
{
    private ArrayList<Player> cooldown;
    private Main pl;
    private Map<Player, Item> inbomb;
    
    public C4HAB() {
        this.cooldown = new ArrayList<Player>();
        this.pl = Main.getMain();
        this.inbomb = new HashMap<Player, Item>();
    }
    
    @EventHandler
    public void a(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType() == Material.AIR) {
            return;
        }
        if (p.getInventory().getItemInHand().getType() != Material.STONE_BUTTON) {
            return;
        }
        if (e.getAction().name().contains("RIGHT")) {
            if (this.inbomb.containsKey(p)) {
                return;
            }
            if (this.cooldown.contains(p)) {
                p.sendMessage("§7Sua C4 ja foi explodida!");
                return;
            }
            final Item C4bomb = p.getWorld().dropItem(p.getEyeLocation(), new ItemStack(Material.TNT));
            C4bomb.setVelocity(e.getPlayer().getEyeLocation().getDirection().multiply(0.6));
            C4bomb.setPickupDelay(999999);
            C4bomb.getItemStack().getItemMeta().setDisplayName("§7C4");
            this.inbomb.put(p, C4bomb);
            this.cooldown.add(p);
        }
        else if (this.inbomb.containsKey(p)) {
            final Item C4bomb = this.inbomb.get(p);
            p.getWorld().createExplosion(C4bomb.getLocation(), 5.0f, true);
            this.inbomb.remove(p);
            C4bomb.remove();
            final Player p2 = e.getPlayer();
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)this.pl, (Runnable)new Runnable() {
                @Override
                public void run() {
                    C4HAB.this.cooldown.remove(p2.getName());
                }
            }, 20L);
        }
        else {
            p.sendMessage("§cA bomba ainda nao foi plantada!");
        }
    }
}
