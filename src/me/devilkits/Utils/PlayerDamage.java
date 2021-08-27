package me.devilkits.Utils;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.potion.*;
import java.util.*;
import org.bukkit.event.*;

public class PlayerDamage implements Listener
{
    @EventHandler
    public void onPlayerDamage(final EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            final Player player = (Player)event.getDamager();
            if (player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
                for (final PotionEffect Effect : player.getActivePotionEffects()) {
                    if (Effect.getType().equals((Object)PotionEffectType.INCREASE_DAMAGE)) {
                        final double DamagePercentage = (Effect.getAmplifier() + 1) * 1.3 + 1.0;
                        int NewDamage;
                        if (event.getDamage() / DamagePercentage <= 1.0) {
                            NewDamage = (Effect.getAmplifier() + 1) * 3 + 1;
                        }
                        else {
                            NewDamage = (int)(event.getDamage() / DamagePercentage) + (Effect.getAmplifier() + 1) * 3;
                        }
                        event.setDamage((double)NewDamage);
                        break;
                    }
                }
            }
        }
    }
}
