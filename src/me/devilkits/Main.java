package me.devilkits;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;

import me.devilkits.Jumps.Diamante;
import me.devilkits.Jumps.Esmeralda;
import me.devilkits.Jumps.Ferro;
import me.devilkits.Jumps.Redstone;
import me.devilkits.Kits.Anchor;
import me.devilkits.Kits.Archer;
import me.devilkits.Kits.Barbarian;
import me.devilkits.Kits.Batman;
import me.devilkits.Kits.Berserker;
import me.devilkits.Kits.Boxer;
import me.devilkits.Kits.C4;
import me.devilkits.Kits.C4HAB;
import me.devilkits.Kits.Camel;
import me.devilkits.Kits.Confuser;
import me.devilkits.Kits.Copycat;
import me.devilkits.Kits.Critical;
import me.devilkits.Kits.DarkGod;
import me.devilkits.Kits.Endermage;
import me.devilkits.Kits.Fireman;
import me.devilkits.Kits.Fisherman;
import me.devilkits.Kits.Flash;
import me.devilkits.Kits.Frosty;
import me.devilkits.Kits.Fujao;
import me.devilkits.Kits.Ghoul;
import me.devilkits.Kits.Gladiator;
import me.devilkits.Kits.GladiatorHAB;
import me.devilkits.Kits.Granadier;
import me.devilkits.Kits.Grandpa;
import me.devilkits.Kits.Grappler;
import me.devilkits.Kits.HomemInvisivel;
import me.devilkits.Kits.HomemPedra;
import me.devilkits.Kits.Hulk;
import me.devilkits.Kits.Hunter;
import me.devilkits.Kits.Infernor;
import me.devilkits.Kits.InfernorHab;
import me.devilkits.Kits.Jellyfish;
import me.devilkits.Kits.JellyfishHab;
import me.devilkits.Kits.Kangaroo;
import me.devilkits.Kits.Launcher;
import me.devilkits.Kits.Lobisomem;
import me.devilkits.Kits.Milkman;
import me.devilkits.Kits.Monk;
import me.devilkits.Kits.MonkHAb;
import me.devilkits.Kits.Morf;
import me.devilkits.Kits.Naruto;
import me.devilkits.Kits.NetherMan;
import me.devilkits.Kits.Ninja;
import me.devilkits.Kits.PVP;
import me.devilkits.Kits.Paladino;
import me.devilkits.Kits.Phantom;
import me.devilkits.Kits.Poseidon;
import me.devilkits.Kits.PulaPula;
import me.devilkits.Kits.Reaper;
import me.devilkits.Kits.Resouper;
import me.devilkits.Kits.RobinHood;
import me.devilkits.Kits.Ryu;
import me.devilkits.Kits.Salamander;
import me.devilkits.Kits.Skeleton;
import me.devilkits.Kits.Snail;
import me.devilkits.Kits.Sniper;
import me.devilkits.Kits.Specialist;
import me.devilkits.Kits.Stomper;
import me.devilkits.Kits.StoneMan;
import me.devilkits.Kits.Sumo;
import me.devilkits.Kits.Switcher;
import me.devilkits.Kits.Thor;
import me.devilkits.Kits.TimeLord;
import me.devilkits.Kits.Titan;
import me.devilkits.Kits.Turtle;
import me.devilkits.Kits.Urgal;
import me.devilkits.Kits.Viking;
import me.devilkits.Kits.Viper;
import me.devilkits.Kits.WeakSword;
import me.devilkits.Kits.Wolverine;
import me.devilkits.Player.PlayerJoin;
import me.devilkits.Player.PlayerQuit;
import me.devilkits.Player.PlayerRespawn;
import me.devilkits.Seletor.Kits;
import me.devilkits.Seletor.Kits2;
import me.devilkits.Seletor.ShopKits;
import me.devilkits.Seletor.Warps;
import me.devilkits.Utils.AbrirKit;
import me.devilkits.Utils.Ban;
import me.devilkits.Utils.Book;
import me.devilkits.Utils.BroadcastBoss;
import me.devilkits.Utils.Build;
import me.devilkits.Utils.Chat;
import me.devilkits.Utils.ChatStaff;
import me.devilkits.Utils.ClearInv;
import me.devilkits.Utils.Coder;
import me.devilkits.Utils.CombatLog;
import me.devilkits.Utils.DiaNoite;
import me.devilkits.Utils.DropEvent;
import me.devilkits.Utils.Espada;
import me.devilkits.Utils.Fly;
import me.devilkits.Utils.Gamemode;
import me.devilkits.Utils.GanharMoney;
import me.devilkits.Utils.Head;
import me.devilkits.Utils.Hit;
import me.devilkits.Utils.IP;
import me.devilkits.Utils.Invsee;
import me.devilkits.Utils.Kick;
import me.devilkits.Utils.LimparChatV1;
import me.devilkits.Utils.Motd;
import me.devilkits.Utils.MsgJoinQuit;
import me.devilkits.Utils.NoDropItens;
import me.devilkits.Utils.Placas;
import me.devilkits.Utils.PoteSopa;
import me.devilkits.Utils.Report;
import me.devilkits.Utils.Say;
import me.devilkits.Utils.SemChuva;
import me.devilkits.Utils.SemFome;
import me.devilkits.Utils.ServerJoinKick;
import me.devilkits.Utils.SpawnMob;
import me.devilkits.Utils.Stats;
import me.devilkits.Utils.Suicide;
import me.devilkits.Utils.SwordNerf;
import me.devilkits.Utils.Tag;
import me.devilkits.Utils.TeleportarTodos;
import me.devilkits.Utils.Youtuber;
import me.devilkits.Warps.Challenge;
import me.devilkits.Warps.FPS;
import me.devilkits.Warps.HG;
import me.devilkits.Warps.IrMain;
import me.devilkits.Warps.Knock;
import me.devilkits.Warps.MDR;
import me.devilkits.Warps.MLG;
import me.devilkits.Warps.RDM;
import me.devilkits.Warps.SetChallenge;
import me.devilkits.Warps.SetFPS;
import me.devilkits.Warps.SetHG;
import me.devilkits.Warps.SetKnock;
import me.devilkits.Warps.SetMDR;
import me.devilkits.Warps.SetMLG;
import me.devilkits.Warps.SetMain;
import me.devilkits.Warps.SetRDM;
import me.devilkits.Warps.SetSpawn;
import me.devilkits.Warps.SpawnTeleport;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class Main extends JavaPlugin implements Listener {
	public static int QUE_COISA_FEIA_VENDO_OS_CODIGO_DOS_OUTROS;
	public static Permission perm;
	public static Main obterMain;
	public static Main instance;
	public static Main main;
	public static Main getMain;
	public static ItemStack FerramentaNormal;
	public static File n;
	public static FileConfiguration m;
	public static Economy econ;
	public static Permission perms;
	public static Plugin pl;
	public static ArrayList<String> usandokit;
	public static ArrayList<String> grandpa;
	public static ArrayList<String> avatar;
	public static ArrayList<String> flash;
	public static ArrayList<String> robinhood;
	public static ArrayList<String> salamander;
	public static ArrayList<String> skeleton;
	public static ArrayList<String> sniper;
	public static ArrayList<String> reload;
	public static ArrayList<String> batman;
	public static ArrayList<String> c4;
	public static ArrayList<String> wolverine;
	public static ArrayList<String> morf;
	public static ArrayList<String> homeminvisivel;
	public static ArrayList<String> paladino;
	public static ArrayList<String> netherman;
	public static ArrayList<String> stoneman;
	public static ArrayList<String> anchor;
	public static ArrayList<String> stomper;
	public static ArrayList<String> thor;
	public static ArrayList<String> weaksword;
	public static ArrayList<String> spiderman;
	public static ArrayList<String> viking;
	public static ArrayList<String> specialist;
	public static ArrayList<String> confuser;
	public static ArrayList<String> madman;
	public static ArrayList<String> critical;
	public static ArrayList<Player> Players;
	public static ArrayList<String> lobisomem;
	public static ArrayList<String> grappler;
	public static ArrayList<String> titan;
	public static ArrayList<String> barbarian;
	public static ArrayList<String> reaper;
	public static ArrayList<String> launcher;
	public static ArrayList<String> endermage;
	public static ArrayList<String> ryu;
	public static ArrayList<String> switcher;
	public static ArrayList<String> gambler;
	public static ArrayList<String> resouper;
	public static ArrayList<String> berserker;
	public static ArrayList<String> darkgod;
	public static ArrayList<String> hulk;
	public static ArrayList<String> homempedra;
	public static ArrayList<String> sumo;
	public static ArrayList<String> camel;
	public static ArrayList<String> naruto;
	public static ArrayList<String> poseidon;
	public static ArrayList<String> timelord;
	public static ArrayList<String> congelado;
	public static Map<String, Integer> g;
	public static Plugin plugin;
	public static ArrayList<String> urgal;
	public static ArrayList<String> InfernoHab;
	public List<String> hadouken;
	public static ArrayList<String> kangaroo;
	public static ArrayList<String> infernor;
	public static ArrayList<String> freezing;
	public static ArrayList<String> freeze;
	public static ArrayList<String> hunter;
	public static ArrayList<String> frosty;
	public static ArrayList<String> bomber;
	public static ArrayList<String> ghoul;
	public static ArrayList<String> phantom;
	public static ArrayList<String> fireman;
	public static ArrayList<String> homemaranha;
	public static ArrayList<String> milkman;
	public static ArrayList<String> viper;
	public static ArrayList<String> snail;
	public static ArrayList<String> cooldown;
	public static ArrayList<String> copycat;
	public static ArrayList<String> gladiator;
	public static ArrayList<String> turtle;
	public static ArrayList<String> ninja;
	public static ArrayList<String> jellyfish;
	public static ArrayList<String> admin;
	public static ArrayList<String> hg;
	public static ArrayList<String> monk;
	public static ArrayList<String> fisherman;
	public static ArrayList<String> granadier;
	public static ArrayList<String> archer;
	public static ArrayList<String> fujao;
	public static ArrayList<String> pulapula;
	public static Plugin config;

	static {
		Main.perm = null;
		Main.econ = null;
		Main.perms = null;
		Main.usandokit = new ArrayList<String>();
		Main.grandpa = new ArrayList<String>();
		Main.avatar = new ArrayList<String>();
		Main.flash = new ArrayList<String>();
		Main.robinhood = new ArrayList<String>();
		Main.salamander = new ArrayList<String>();
		Main.skeleton = new ArrayList<String>();
		Main.sniper = new ArrayList<String>();
		Main.reload = new ArrayList<String>();
		Main.batman = new ArrayList<String>();
		Main.c4 = new ArrayList<String>();
		Main.wolverine = new ArrayList<String>();
		Main.morf = new ArrayList<String>();
		Main.homeminvisivel = new ArrayList<String>();
		Main.paladino = new ArrayList<String>();
		Main.netherman = new ArrayList<String>();
		Main.stoneman = new ArrayList<String>();
		Main.anchor = new ArrayList<String>();
		Main.stomper = new ArrayList<String>();
		Main.thor = new ArrayList<String>();
		Main.weaksword = new ArrayList<String>();
		Main.spiderman = new ArrayList<String>();
		Main.viking = new ArrayList<String>();
		Main.specialist = new ArrayList<String>();
		Main.confuser = new ArrayList<String>();
		Main.madman = new ArrayList<String>();
		Main.critical = new ArrayList<String>();
		Main.Players = new ArrayList<Player>();
		Main.lobisomem = new ArrayList<String>();
		Main.grappler = new ArrayList<String>();
		Main.titan = new ArrayList<String>();
		Main.barbarian = new ArrayList<String>();
		Main.reaper = new ArrayList<String>();
		Main.launcher = new ArrayList<String>();
		Main.endermage = new ArrayList<String>();
		Main.ryu = new ArrayList<String>();
		Main.switcher = new ArrayList<String>();
		Main.gambler = new ArrayList<String>();
		Main.resouper = new ArrayList<String>();
		Main.berserker = new ArrayList<String>();
		Main.darkgod = new ArrayList<String>();
		Main.hulk = new ArrayList<String>();
		Main.homempedra = new ArrayList<String>();
		Main.sumo = new ArrayList<String>();
		Main.camel = new ArrayList<String>();
		Main.naruto = new ArrayList<String>();
		Main.poseidon = new ArrayList<String>();
		Main.timelord = new ArrayList<String>();
		Main.congelado = new ArrayList<String>();
		Main.g = new HashMap<String, Integer>();
		Main.urgal = new ArrayList<String>();
		Main.InfernoHab = new ArrayList<String>();
		Main.kangaroo = new ArrayList<String>();
		Main.infernor = new ArrayList<String>();
		Main.freezing = new ArrayList<String>();
		Main.freeze = new ArrayList<String>();
		Main.hunter = new ArrayList<String>();
		Main.frosty = new ArrayList<String>();
		Main.bomber = new ArrayList<String>();
		Main.ghoul = new ArrayList<String>();
		Main.phantom = new ArrayList<String>();
		Main.fireman = new ArrayList<String>();
		Main.homemaranha = new ArrayList<String>();
		Main.milkman = new ArrayList<String>();
		Main.viper = new ArrayList<String>();
		Main.snail = new ArrayList<String>();
		Main.cooldown = new ArrayList<String>();
		Main.copycat = new ArrayList<String>();
		Main.gladiator = new ArrayList<String>();
		Main.turtle = new ArrayList<String>();
		Main.ninja = new ArrayList<String>();
		Main.jellyfish = new ArrayList<String>();
		Main.admin = new ArrayList<String>();
		Main.hg = new ArrayList<String>();
		Main.monk = new ArrayList<String>();
		Main.fisherman = new ArrayList<String>();
		Main.granadier = new ArrayList<String>();
		Main.archer = new ArrayList<String>();
		Main.fujao = new ArrayList<String>();
		Main.pulapula = new ArrayList<String>();
	}

	public Main() {
		this.hadouken = new ArrayList<String>();
	}

	public static Main getObterMain() {
		return Main.obterMain;
	}

	public static Main getMain() {
		return Main.main;
	}

	public void onEnable() {
		Main.obterMain = this;
		this.getConfig().options().copyDefaults(true);
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		this.saveDefaultConfig();
		this.carregarEventos();
		this.carregarComandos();
		this.saveConfig();
		final ConsoleCommandSender s = this.getServer().getConsoleSender();
		s.sendMessage("§6======================");
		s.sendMessage("§6§l      DevilKits");
		s.sendMessage("§7   By DevilSecktor");
		s.sendMessage("§6======================");
		final RegisteredServiceProvider<Economy> economyProvider = (RegisteredServiceProvider<Economy>) this.getServer()
				.getServicesManager().getRegistration(Economy.class);
		if (economyProvider != null) {
			Main.econ = (Economy) economyProvider.getProvider();
			final RegisteredServiceProvider<Permission> permissionprovider = (RegisteredServiceProvider<Permission>) this
					.getServer().getServicesManager().getRegistration(Permission.class);
			if (permissionprovider != null) {
				Main.perm = (Permission) permissionprovider.getProvider();
			}
			this.carregarEventos();
			this.carregarComandos();
			this.getServer().getPluginManager().registerEvents((Listener) new HG(this), (Plugin) this);
			this.getServer().getPluginManager().registerEvents((Listener) new Stats(this), (Plugin) this);
			this.saveConfig();
			if (this.getServer().getPluginManager().getPlugin("BarAPI") == null) {
				Bukkit.getServer().getConsoleSender()
						.sendMessage("§2BarAPI nao esta na pasta!\n          §7Opcao de BossBar anulada!");
			}
		}
	}

	public void carregarComandos() {
		this.getCommand("batman").setExecutor((CommandExecutor) new Batman(this));
		this.getCommand("wolverine").setExecutor((CommandExecutor) new Wolverine(this));
		this.getCommand("c4").setExecutor((CommandExecutor) new C4());
		this.getCommand("morf").setExecutor((CommandExecutor) new Morf(this));
		this.getCommand("kick").setExecutor((CommandExecutor) new Kick());
		this.getCommand("clear").setExecutor((CommandExecutor) new ClearInv());
		this.getCommand("anchor").setExecutor((CommandExecutor) new Anchor(this));
		this.getCommand("fly").setExecutor((CommandExecutor) new Fly());
		this.getCommand("espada").setExecutor((CommandExecutor) new Espada());
		this.getCommand("archer").setExecutor((CommandExecutor) new Archer(this));
		this.getCommand("hulk").setExecutor((CommandExecutor) new Hulk(this));
		this.getCommand("camel").setExecutor((CommandExecutor) new Camel(this));
		this.getCommand("gm").setExecutor((CommandExecutor) new Gamemode());
		this.getCommand("head").setExecutor((CommandExecutor) new Head(this));
		this.getCommand("specialist").setExecutor((CommandExecutor) new Specialist(this));
		this.getCommand("morrer").setExecutor((CommandExecutor) new Suicide());
		this.getCommand("tpall").setExecutor((CommandExecutor) new TeleportarTodos());
		this.getCommand("frosty").setExecutor((CommandExecutor) new Frosty(this));
		this.getCommand("confuser").setExecutor((CommandExecutor) new Confuser(this));
		this.getCommand("endermage").setExecutor((CommandExecutor) new Endermage(this));
		this.getCommand("naruto").setExecutor((CommandExecutor) new Naruto(this));
		this.getCommand("titan").setExecutor((CommandExecutor) new Titan(this));
		this.getCommand("reaper").setExecutor((CommandExecutor) new Reaper(this));
		this.getCommand("invsee").setExecutor((CommandExecutor) new Invsee());
		this.getCommand("viking").setExecutor((CommandExecutor) new Viking(this));
		this.getCommand("fisherman").setExecutor((CommandExecutor) new Fisherman(this));
		this.getCommand("berserker").setExecutor((CommandExecutor) new Berserker(this));
		this.getCommand("resouper").setExecutor((CommandExecutor) new Resouper(this));
		this.getCommand("barbarian").setExecutor((CommandExecutor) new Barbarian(this));
		this.getCommand("infernor").setExecutor((CommandExecutor) new Infernor(this));
		this.getCommand("fireman").setExecutor((CommandExecutor) new Fireman(this));
		this.getCommand("gladiator").setExecutor((CommandExecutor) new Gladiator(this));
		this.getCommand("pvp").setExecutor((CommandExecutor) new PVP(this));
		this.getCommand("jellyfish").setExecutor((CommandExecutor) new Jellyfish(this));
		this.getCommand(".").setExecutor((CommandExecutor) new ChatStaff(this));
		this.getCommand("cc").setExecutor((CommandExecutor) new LimparChatV1());
		this.getCommand("thor").setExecutor((CommandExecutor) new Thor(this));
		this.getCommand("kangaroo").setExecutor((CommandExecutor) new Kangaroo(this));
		this.getCommand("monk").setExecutor((CommandExecutor) new Monk(this));
		this.getCommand("report").setExecutor((CommandExecutor) new Report(this));
		this.getCommand("ninja").setExecutor((CommandExecutor) new Ninja(this));
		this.getCommand("poseidon").setExecutor((CommandExecutor) new Poseidon(this));
		this.getCommand("ghoul").setExecutor((CommandExecutor) new Ghoul(this));
		this.getCommand("snail").setExecutor((CommandExecutor) new Snail(this));
		this.getCommand("switcher").setExecutor((CommandExecutor) new Switcher(this));
		this.getCommand("launcher").setExecutor((CommandExecutor) new Launcher(this));
		this.getCommand("weaksword").setExecutor((CommandExecutor) new WeakSword(this));
		this.getCommand("darkgod").setExecutor((CommandExecutor) new DarkGod(this));
		this.getCommand("milkman").setExecutor((CommandExecutor) new Milkman(this));
		this.getCommand("sumo").setExecutor((CommandExecutor) new Sumo(this));
		this.getCommand("critical").setExecutor((CommandExecutor) new Critical(this));
		this.getCommand("homempedra").setExecutor((CommandExecutor) new HomemPedra(this));
		this.getCommand("boxer").setExecutor((CommandExecutor) new Boxer(this));
		this.getCommand("turtle").setExecutor((CommandExecutor) new Turtle(this));
		this.getCommand("hunter").setExecutor((CommandExecutor) new Hunter(this));
		this.getCommand("urgal").setExecutor((CommandExecutor) new Urgal(this));
		this.getCommand("lobisomem").setExecutor((CommandExecutor) new Lobisomem(this));
		this.getCommand("granadier").setExecutor((CommandExecutor) new Granadier(this));
		this.getCommand("viper").setExecutor((CommandExecutor) new Viper(this));
		this.getCommand("tag").setExecutor((CommandExecutor) new Tag());
		this.getCommand("copycat").setExecutor((CommandExecutor) new Copycat(this));
		this.getCommand("fps").setExecutor((CommandExecutor) new FPS(this));
		this.getCommand("mdr").setExecutor((CommandExecutor) new MDR(this));
		this.getCommand("rdm").setExecutor((CommandExecutor) new RDM(this));
		this.getCommand("main").setExecutor((CommandExecutor) new IrMain(this));
		this.getCommand("challenge").setExecutor((CommandExecutor) new Challenge(this));
		this.getCommand("setmain").setExecutor((CommandExecutor) new SetMain(this));
		this.getCommand("setfps").setExecutor((CommandExecutor) new SetFPS(this));
		this.getCommand("setmdr").setExecutor((CommandExecutor) new SetMDR(this));
		this.getCommand("stomper").setExecutor((CommandExecutor) new Stomper(this));
		this.getCommand("setrdm").setExecutor((CommandExecutor) new SetRDM(this));
		this.getCommand("setchallenge").setExecutor((CommandExecutor) new SetChallenge(this));
		this.getCommand("setspawn").setExecutor((CommandExecutor) new SetSpawn(this));
		this.getCommand("spawn").setExecutor((CommandExecutor) new SpawnTeleport(this));
		this.getCommand("pulapula").setExecutor((CommandExecutor) new PulaPula());
		this.getCommand("fujao").setExecutor((CommandExecutor) new Fujao(this));
		this.getCommand("stoneman").setExecutor((CommandExecutor) new StoneMan(this));
		this.getCommand("sethg").setExecutor((CommandExecutor) new SetHG(this));
		this.getCommand("hg").setExecutor((CommandExecutor) new HG(this));
		this.getCommand("netherman").setExecutor((CommandExecutor) new NetherMan(this));
		this.getCommand("bcb").setExecutor((CommandExecutor) new BroadcastBoss());
		this.getCommand("broadboss").setExecutor((CommandExecutor) new BroadcastBoss());
		this.getCommand("grappler").setExecutor((CommandExecutor) new Grappler(this));
		this.getCommand("ban").setExecutor((CommandExecutor) new Ban(this));
		this.getCommand("paladino").setExecutor((CommandExecutor) new Paladino(this));
		this.getCommand("homeminvisivel").setExecutor((CommandExecutor) new HomemInvisivel(this));
		this.getCommand("ip").setExecutor((CommandExecutor) new IP());
		this.getCommand("say").setExecutor((CommandExecutor) new Say());
		this.getCommand("timelord").setExecutor((CommandExecutor) new TimeLord(this));
		this.getCommand("setknock").setExecutor((CommandExecutor) new SetKnock(this));
		this.getCommand("knock").setExecutor((CommandExecutor) new Knock(this));
		this.getCommand("setmlg").setExecutor((CommandExecutor) new SetMLG(this));
		this.getCommand("mlg").setExecutor((CommandExecutor) new MLG(this));
		this.getCommand("kits").setExecutor((CommandExecutor) new Kits());
		this.getCommand("kits2").setExecutor((CommandExecutor) new Kits2());
		this.getCommand("sniper").setExecutor((CommandExecutor) new Sniper(this));
		this.getCommand("skeleton").setExecutor((CommandExecutor) new Skeleton(this));
		this.getCommand("grandpa").setExecutor((CommandExecutor) new Grandpa(this));
		this.getCommand("salamander").setExecutor((CommandExecutor) new Salamander(this));
		this.getCommand("ryu").setExecutor((CommandExecutor) new Ryu(this));
		this.getCommand("flash").setExecutor((CommandExecutor) new Flash());
		this.getCommand("robinhood").setExecutor((CommandExecutor) new RobinHood(this));
		this.getCommand("warps").setExecutor((CommandExecutor) new Warps());
		this.getCommand("phantom").setExecutor((CommandExecutor) new Phantom(this));
		this.getCommand("dia").setExecutor((CommandExecutor) new DiaNoite());
		this.getCommand("noite").setExecutor((CommandExecutor) new DiaNoite());
		this.getCommand("youtuber").setExecutor((CommandExecutor) new Youtuber(this));
		this.getCommand("loja").setExecutor((CommandExecutor) new ShopKits());
		this.getCommand("coder").setExecutor((CommandExecutor) new Coder());
		this.getCommand("resetkit").setExecutor((CommandExecutor) this);
	}

	public static void giveSoup(final Player p, final int quantas) {
		for (int i = 0; i < quantas; ++i) {
			p.getInventory().setItem(p.getInventory().firstEmpty(), new ItemStack(Material.MUSHROOM_SOUP));
		}
	}

	public static void giveSword(final Player p, final int slot, final Material type, final String nome) {
		final ItemStack item = new ItemStack(type);
		final ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		p.getInventory().setItem(slot, item);
	}

	public static void abilitySpecialItem(final Player p, final Material m, final int slot, final String nome) {
	}

	public void carregarEventos() {
		final PluginManager pm = Bukkit.getServer().getPluginManager();
		this.getServer().getPluginManager().registerEvents((Listener) new Batman(this), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new Grappler(this), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new Ryu(this), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new C4HAB(), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) this, (Plugin) this);
		Bukkit.getServer().getPluginManager().registerEvents((Listener) new InfernorHab(this), (Plugin) this);
		Bukkit.getServer().getPluginManager().registerEvents((Listener) new Ferro(this), (Plugin) this);
		pm.registerEvents((Listener) new ServerJoinKick(this), (Plugin) this);
		pm.registerEvents((Listener) new SemFome(), (Plugin) this);
		pm.registerEvents((Listener) new C4(), (Plugin) this);
		pm.registerEvents((Listener) new C4HAB(), (Plugin) this);
		pm.registerEvents((Listener) new TimeLord(this), (Plugin) this);
		pm.registerEvents((Listener) new Morf(this), (Plugin) this);
		pm.registerEvents((Listener) new Book(), (Plugin) this);
		pm.registerEvents((Listener) new SemChuva(), (Plugin) this);
		pm.registerEvents((Listener) new PoteSopa(), (Plugin) this);
		pm.registerEvents((Listener) new NoDropItens(), (Plugin) this);
		pm.registerEvents((Listener) new Hit(), (Plugin) this);
		pm.registerEvents((Listener) new SpawnMob(), (Plugin) this);
		pm.registerEvents((Listener) new Chat(), (Plugin) this);
		pm.registerEvents((Listener) new DropEvent(this), (Plugin) this);
		pm.registerEvents((Listener) new Build(), (Plugin) this);
		pm.registerEvents((Listener) new PVP(this), (Plugin) this);
		pm.registerEvents((Listener) new SetHG(this), (Plugin) this);
		pm.registerEvents((Listener) new HG(this), (Plugin) this);
		pm.registerEvents((Listener) new Anchor(this), (Plugin) this);
		pm.registerEvents((Listener) new Archer(this), (Plugin) this);
		pm.registerEvents((Listener) new Barbarian(this), (Plugin) this);
		pm.registerEvents((Listener) new Camel(this), (Plugin) this);
		pm.registerEvents((Listener) new Endermage(this), (Plugin) this);
		pm.registerEvents((Listener) new DarkGod(this), (Plugin) this);
		pm.registerEvents((Listener) new Fisherman(this), (Plugin) this);
		pm.registerEvents((Listener) new Milkman(this), (Plugin) this);
		pm.registerEvents((Listener) new Sumo(this), (Plugin) this);
		pm.registerEvents((Listener) new Confuser(this), (Plugin) this);
		pm.registerEvents((Listener) new Fireman(this), (Plugin) this);
		pm.registerEvents((Listener) new Fly(), (Plugin) this);
		pm.registerEvents((Listener) new ChatStaff(this), (Plugin) this);
		pm.registerEvents((Listener) new LimparChatV1(), (Plugin) this);
		pm.registerEvents((Listener) new Report(this), (Plugin) this);
		pm.registerEvents((Listener) new TeleportarTodos(), (Plugin) this);
		pm.registerEvents((Listener) new Suicide(), (Plugin) this);
		pm.registerEvents((Listener) new Espada(), (Plugin) this);
		pm.registerEvents((Listener) new GladiatorHAB(this), (Plugin) this);
		pm.registerEvents((Listener) new Jellyfish(this), (Plugin) this);
		pm.registerEvents((Listener) new Titan(this), (Plugin) this);
		pm.registerEvents((Listener) new Thor(this), (Plugin) this);
		pm.registerEvents((Listener) new Specialist(this), (Plugin) this);
		pm.registerEvents((Listener) new WeakSword(this), (Plugin) this);
		pm.registerEvents((Listener) new Hulk(this), (Plugin) this);
		pm.registerEvents((Listener) new Viking(this), (Plugin) this);
		pm.registerEvents((Listener) new Critical(this), (Plugin) this);
		pm.registerEvents((Listener) new Reaper(this), (Plugin) this);
		pm.registerEvents((Listener) new Infernor(this), (Plugin) this);
		pm.registerEvents((Listener) new Boxer(this), (Plugin) this);
		pm.registerEvents((Listener) new Kangaroo(this), (Plugin) this);
		pm.registerEvents((Listener) new Ryu(this), (Plugin) this);
		pm.registerEvents((Listener) new MonkHAb(this), (Plugin) this);
		pm.registerEvents((Listener) new Ninja(this), (Plugin) this);
		pm.registerEvents((Listener) new Naruto(this), (Plugin) this);
		pm.registerEvents((Listener) new Launcher(this), (Plugin) this);
		pm.registerEvents((Listener) new Resouper(this), (Plugin) this);
		pm.registerEvents((Listener) new Poseidon(this), (Plugin) this);
		pm.registerEvents((Listener) new Berserker(this), (Plugin) this);
		pm.registerEvents((Listener) new HomemPedra(this), (Plugin) this);
		pm.registerEvents((Listener) new Hunter(this), (Plugin) this);
		pm.registerEvents((Listener) new Stomper(this), (Plugin) this);
		pm.registerEvents((Listener) new Snail(this), (Plugin) this);
		pm.registerEvents((Listener) new Granadier(this), (Plugin) this);
		pm.registerEvents((Listener) new Frosty(this), (Plugin) this);
		pm.registerEvents((Listener) new Lobisomem(this), (Plugin) this);
		pm.registerEvents((Listener) new Ghoul(this), (Plugin) this);
		pm.registerEvents((Listener) new Switcher(this), (Plugin) this);
		pm.registerEvents((Listener) new Viper(this), (Plugin) this);
		pm.registerEvents((Listener) new Turtle(this), (Plugin) this);
		pm.registerEvents((Listener) new JellyfishHab(this), (Plugin) this);
		pm.registerEvents((Listener) new Copycat(this), (Plugin) this);
		pm.registerEvents((Listener) new SwordNerf(this), (Plugin) this);
		pm.registerEvents((Listener) new Kits(), (Plugin) this);
		pm.registerEvents((Listener) new Warps(), (Plugin) this);
		pm.registerEvents((Listener) new Ferro(this), (Plugin) this);
		pm.registerEvents((Listener) new Esmeralda(this), (Plugin) this);
		pm.registerEvents((Listener) new Diamante(this), (Plugin) this);
		pm.registerEvents((Listener) new Redstone(this), (Plugin) this);
		pm.registerEvents((Listener) new Kits(), (Plugin) this);
		pm.registerEvents((Listener) new CombatLog(this), (Plugin) this);
		pm.registerEvents((Listener) new PlayerQuit(), (Plugin) this);
		pm.registerEvents((Listener) new Placas(this), (Plugin) this);
		pm.registerEvents((Listener) new PulaPula(), (Plugin) this);
		pm.registerEvents((Listener) new Fujao(this), (Plugin) this);
		pm.registerEvents((Listener) new PlayerJoin(this), (Plugin) this);
		pm.registerEvents((Listener) new PlayerQuit(), (Plugin) this);
		pm.registerEvents((Listener) new PlayerRespawn(this), (Plugin) this);
		pm.registerEvents((Listener) new StoneMan(this), (Plugin) this);
		pm.registerEvents((Listener) new NetherMan(this), (Plugin) this);
		pm.registerEvents((Listener) new SetKnock(this), (Plugin) this);
		pm.registerEvents((Listener) new Knock(this), (Plugin) this);
		pm.registerEvents((Listener) new SetMLG(this), (Plugin) this);
		pm.registerEvents((Listener) new MLG(this), (Plugin) this);
		pm.registerEvents((Listener) new Kits2(), (Plugin) this);
		pm.registerEvents((Listener) new AbrirKit(), (Plugin) this);
		pm.registerEvents((Listener) new Sniper(this), (Plugin) this);
		pm.registerEvents((Listener) new Skeleton(this), (Plugin) this);
		pm.registerEvents((Listener) new Grandpa(this), (Plugin) this);
		pm.registerEvents((Listener) new RobinHood(this), (Plugin) this);
		pm.registerEvents((Listener) new Salamander(this), (Plugin) this);
		pm.registerEvents((Listener) new Ryu(this), (Plugin) this);
		pm.registerEvents((Listener) new Flash(), (Plugin) this);
		pm.registerEvents((Listener) new Phantom(this), (Plugin) this);
		pm.registerEvents((Listener) new Youtuber(this), (Plugin) this);
		pm.registerEvents((Listener) new Motd(this), (Plugin) this);
		pm.registerEvents((Listener) new MsgJoinQuit(this), (Plugin) this);
		pm.registerEvents((Listener) new ShopKits(), (Plugin) this);
		pm.registerEvents((Listener) new GanharMoney(), (Plugin) this);
	}

	public static WorldGuardPlugin getWorldGuard() {
		final Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
		if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
			return null;
		}
		return (WorldGuardPlugin) plugin;
	}

	public static boolean SemPvP(final Player p) {
		final ApplicableRegionSet region = getWorldGuard().getRegionManager(p.getWorld())
				.getApplicableRegions(p.getLocation());
		return region.allows(DefaultFlag.PVP);
	}

	public static WorldGuardPlugin getWorldGuard1() {
		final Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
		if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
			return null;
		}
		return (WorldGuardPlugin) plugin;
	}

	public static void removeAbility(final Player p) {
		Main.usandokit.remove(p.getName());
		Main.avatar.remove(p.getName());
		Main.flash.remove(p.getName());
		Main.salamander.remove(p.getName());
		Main.reload.remove(p.getName());
		Main.sniper.remove(p.getName());
		Main.homeminvisivel.remove(p.getName());
		Main.wolverine.remove(p.getName());
		Main.batman.remove(p.getName());
		Main.anchor.remove(p.getName());
		Main.morf.remove(p.getName());
		Main.c4.remove(p.getName());
		Main.archer.remove(p.getName());
		Main.stomper.remove(p.getName());
		Main.endermage.remove(p.getName());
		Main.homemaranha.remove(p.getName());
		Main.switcher.remove(p.getName());
		Main.paladino.remove(p.getName());
		Main.camel.remove(p.getName());
		Main.urgal.remove(p.getName());
		Main.archer.remove(p.getName());
		Main.copycat.remove(p.getName());
		Main.berserker.remove(p.getName());
		Main.viking.remove(p.getName());
		Main.naruto.remove(p.getName());
		Main.hunter.remove(p.getName());
		Main.fisherman.remove(p.getName());
		Main.darkgod.remove(p.getName());
		Main.frosty.remove(p.getName());
		Main.infernor.remove(p.getName());
		Main.hulk.remove(p.getName());
		Main.homempedra.remove(p.getName());
		Main.specialist.remove(p.getName());
		Main.ryu.remove(p.getName());
		Main.timelord.remove(p.getName());
		Main.bomber.remove(p.getName());
		Main.gladiator.remove(p.getName());
		Main.thor.remove(p.getName());
		Main.critical.remove(p.getName());
		Main.fireman.remove(p.getName());
		Main.titan.remove(p.getName());
		Main.barbarian.remove(p.getName());
		Main.phantom.remove(p.getName());
		Main.hg.remove(p.getName());
		Main.poseidon.remove(p.getName());
		Main.resouper.remove(p.getName());
		Main.milkman.remove(p.getName());
		Main.grappler.remove(p.getName());
		Main.launcher.remove(p.getName());
		Main.madman.remove(p.getName());
		Main.confuser.remove(p.getName());
		Main.jellyfish.remove(p.getName());
		Main.sumo.remove(p.getName());
		Main.kangaroo.remove(p.getName());
		Main.reaper.remove(p.getName());
		Main.weaksword.remove(p.getName());
		Main.granadier.remove(p.getName());
		Main.monk.remove(p.getName());
		Main.ninja.remove(p.getName());
		Main.snail.remove(p.getName());
		Main.viper.remove(p.getName());
		Main.turtle.remove(p.getName());
		Main.stoneman.remove(p.getName());
		Main.netherman.remove(p.getName());
		Main.pulapula.remove(p.getName());
		Main.fujao.remove(p.getName());
		Main.skeleton.remove(p.getName());
		Main.robinhood.remove(p.getName());
		Main.grandpa.remove(p.getName());
		GladiatorHAB.fighting.remove(p.getName());
		GladiatorHAB.gladgladiator.remove(p.getName());
		GladiatorHAB.localizacao.remove(p);
		GladiatorHAB.oldl.remove(p.getName());
		GladiatorHAB.tasks.remove(p.getName());
		TimeLord.cooldownt.remove(p.getName());
		Kangaroo.kangaroo.remove(p);
		Ninja.a.remove(p);
		Ninja.b.remove(p);
		Ninja.cooldownbk.remove(p);
	}

	public boolean onCommand1(final CommandSender sender, final Command command, final String label,
			final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("resetkit")) {
			if (p.hasPermission("DeviKits.resetkit")) {
				removeAbility(p);
				p.sendMessage("§7Seu kit foi resetado com sucesso");
				p.playSound(p.getLocation(), Sound.BLAZE_DEATH, 4.0f, 4.0f);
				p.getInventory().clear();
				final ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
				final BookMeta meta = (BookMeta) book.getItemMeta();
				meta.setTitle(ChatColor.GREEN + "Regras §7§o(§c§oClique Direito§7§o)");
				meta.setAuthor(ChatColor.AQUA + "Equipe do Servidor");
				meta.addPage(new String[] { ChatColor.GRAY + "----==[§4REGRAS§7]==----" + ChatColor.RED
						+ "1.Nao usar hack\n" + ChatColor.RED + "\n" + ChatColor.RED + "2.Nao xingar players "
						+ ChatColor.RED + "e a staff!\n" + ChatColor.RED + "\n" + ChatColor.RED
						+ "3.Nao abusar de bugs\n" + ChatColor.RED + "\n" + ChatColor.RED + "4.Nao divulgar\n"
						+ ChatColor.RED + "qualquer tipo de\n" + ChatColor.RED + "servidor ou site\n" + ChatColor.RED
						+ "\n" + ChatColor.RED + "\n" + ChatColor.BLUE + "Bom Jogo!" });
				book.setItemMeta((ItemMeta) meta);
				p.getInventory().setItem(8, book);
				final ItemStack chest = new ItemStack(Material.CHEST);
				final ItemMeta chestm = chest.getItemMeta();
				chestm.setDisplayName(ChatColor.GOLD + "Kits §7§o(§c§oClique Direito§7§o)");
				chest.setItemMeta(chestm);
				p.getPlayer().getInventory().setItem(0, chest);
				final ItemStack shop = new ItemStack(Material.COMPASS);
				final ItemMeta shopm = shop.getItemMeta();
				shopm.setDisplayName(ChatColor.GOLD + "Warps §7§o(§c§oClique Direito§7§o)");
				shop.setItemMeta(shopm);
				p.getPlayer().getInventory().setItem(3, shop);
				final ItemStack loja = new ItemStack(Material.DIAMOND);
				final ItemMeta lojam = loja.getItemMeta();
				lojam.setDisplayName(ChatColor.GOLD + "Shop §7§o(§c§oClique Direito§7§o)");
				loja.setItemMeta(lojam);
				p.getPlayer().getInventory().setItem(5, loja);
				final ItemStack vine = new ItemStack(Material.NETHER_STAR);
				final ItemMeta vinem = vine.getItemMeta();
				vinem.setDisplayName(ChatColor.GOLD + "Shop de Kit §7§o(§c§oClique Direito§7§o)");
				vine.setItemMeta(vinem);
				final ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE);
				final ItemMeta glassm = glass.getItemMeta();
				final String HotBar1 = Main.plugin.getConfig().getString("HotBar");
				glassm.setDisplayName(HotBar1.replace("&", "§"));
				glass.setItemMeta(glassm);
				p.getInventory().setItem(1, glass);
				p.getInventory().setItem(2, glass);
				p.getInventory().setItem(6, glass);
				p.getInventory().setItem(7, glass);
				p.getInventory().setItem(4, vine);
				for (final PotionEffect effect : p.getActivePotionEffects()) {
					p.removePotionEffect(effect.getType());
				}
			} else {
				p.sendMessage("§cVoce nao tem permissao!");
			}
		}
		return false;
	}
}
