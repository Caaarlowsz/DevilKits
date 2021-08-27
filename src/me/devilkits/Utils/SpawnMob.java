package me.devilkits.Utils;

import org.bukkit.entity.Blaze;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Horse;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Pig;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class SpawnMob implements Listener {
	@EventHandler
	public void onMagmaCubeSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof MagmaCube) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onPigSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Pig) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onHorse1Spawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Horse) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onWitchSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Witch) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onSheepSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Sheep) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onCowSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Cow) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onChickenSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Chicken) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onSquidSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Squid) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onWolfSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Wolf) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onMooshroomSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof MushroomCow) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onOcelotSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Ocelot) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onVillagerSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Villager) {
			e.setCancelled(false);
		}
	}

	@EventHandler
	public void onHorseSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Horse) {
			e.setCancelled(false);
		}
	}

	@EventHandler
	public void onEnderDragonSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof EnderDragon) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onCreeperSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Creeper) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onSkeletonSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Skeleton) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onSpiderSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Spider) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onWitherSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Wither) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onZombieSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Zombie) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onSlimeSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Slime) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onGhastSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Ghast) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onPigZombieSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof PigZombie) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onEndermanSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Enderman) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onCaveSpiderSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof CaveSpider) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onSilverfishSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Silverfish) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onBlazeSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Blaze) {
			e.setCancelled(true);
		}
	}
}
