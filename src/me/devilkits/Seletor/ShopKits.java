package me.devilkits.Seletor;

import org.bukkit.event.inventory.*;
import org.bukkit.entity.*;
import me.devilkits.*;
import org.bukkit.event.*;
import org.bukkit.*;
import java.util.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.command.*;

public class ShopKits implements CommandExecutor, Listener
{
    @EventHandler
    public void InventoryClickEvent(final InventoryClickEvent e) {
        final Player gui = (Player)e.getWhoClicked();
        if (e.getInventory().getTitle().equals("§6Shop de Kits") && e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null && e.getCurrentItem().getItemMeta().hasDisplayName()) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Ryu")) {
                if (!Main.perm.has(gui, "kit.ryu")) {
                    if (Main.econ.has(gui.getName(), 25000.0)) {
                        Main.econ.withdrawPlayer(gui.getName(), 25000.0);
                        Main.perm.playerAdd(gui, "kit.ryu");
                        gui.sendMessage("§7Voc\u00ea comprou o kit: §6Ryu");
                        gui.closeInventory();
                    }
                    else {
                        gui.closeInventory();
                        gui.sendMessage("§7Voce nao comprou! Sem dinheiro suficiente!");
                    }
                }
                else {
                    gui.closeInventory();
                    gui.sendMessage("§7Voce ja possui o kit! ");
                }
            }
            else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bAnchor")) {
                if (!Main.perm.has(gui, "kit.anchor")) {
                    if (Main.econ.has(gui.getName(), 23000.0)) {
                        Main.econ.withdrawPlayer(gui.getName(), 23000.0);
                        Main.perm.playerAdd(gui, "kit.anchor");
                        gui.sendMessage("§7Voc\u00ea comprou o kit: §6Anchor");
                        gui.closeInventory();
                    }
                    else {
                        gui.closeInventory();
                        gui.sendMessage("§7Voce nao comprou! Sem dinheiro suficiente!");
                    }
                }
                else {
                    gui.closeInventory();
                    gui.sendMessage("§7Voce ja possui o kit! ");
                }
            }
            else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Flash")) {
                if (!Main.perm.has(gui, "kit.flash")) {
                    if (Main.econ.has(gui.getName(), 25000.0)) {
                        Main.econ.withdrawPlayer(gui.getName(), 25000.0);
                        Main.perm.playerAdd(gui, "kit.flash");
                        gui.sendMessage("§7Voc\u00ea comprou o kit: §6Flash");
                        gui.closeInventory();
                    }
                    else {
                        gui.closeInventory();
                        gui.sendMessage("§7Voce nao comprou! Sem dinheiro suficiente!");
                    }
                }
                else {
                    gui.closeInventory();
                    gui.sendMessage("§7Voce ja possui o kit! ");
                }
            }
            else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Naruto")) {
                if (!Main.perm.has(gui, "kit.naruto")) {
                    if (Main.econ.has(gui.getName(), 25000.0)) {
                        Main.econ.withdrawPlayer(gui.getName(), 25000.0);
                        Main.perm.playerAdd(gui, "kit.naruto");
                        gui.sendMessage("§7Voc\u00ea comprou o kit: §6Naruto");
                        gui.closeInventory();
                    }
                    else {
                        gui.closeInventory();
                        gui.sendMessage("§7Voce nao comprou! Sem dinheiro suficiente!");
                    }
                }
                else {
                    gui.closeInventory();
                    gui.sendMessage("§7Voce ja possui o kit! ");
                }
            }
            else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Hulk")) {
                if (!Main.perm.has(gui, "kit.hulk")) {
                    if (Main.econ.has(gui.getName(), 25000.0)) {
                        Main.econ.withdrawPlayer(gui.getName(), 25000.0);
                        Main.perm.playerAdd(gui, "kit.hulk");
                        gui.sendMessage("§7Voc\u00ea comprou o kit: §6Hulk");
                        gui.closeInventory();
                    }
                    else {
                        gui.closeInventory();
                        gui.sendMessage("§7Voce nao comprou! Sem dinheiro suficiente!");
                    }
                }
                else {
                    gui.closeInventory();
                    gui.sendMessage("§7Voce ja possui o kit! ");
                }
            }
            else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Thor")) {
                if (!Main.perm.has(gui, "kit.thor")) {
                    if (Main.econ.has(gui.getName(), 80000.0)) {
                        Main.econ.withdrawPlayer(gui.getName(), 80000.0);
                        Main.perm.playerAdd(gui, "kit.thor");
                        gui.sendMessage("§7Voc\u00ea comprou o kit: §6Thor");
                        gui.closeInventory();
                    }
                    else {
                        gui.closeInventory();
                        gui.sendMessage("§7Voce nao comprou! Sem dinheiro suficiente!");
                    }
                }
                else {
                    gui.closeInventory();
                    gui.sendMessage("§7Voce ja possui o kit! ");
                }
            }
            else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Ryu")) {
                if (!Main.perm.has(gui, "kit.Ryu")) {
                    if (Main.econ.has(gui.getName(), 25000.0)) {
                        Main.econ.withdrawPlayer(gui.getName(), 25000.0);
                        Main.perm.playerAdd(gui, "kit.Ryu");
                        gui.sendMessage("§7Voc\u00ea comprou o kit: §6Ryu");
                        gui.closeInventory();
                    }
                    else {
                        gui.closeInventory();
                        gui.sendMessage("§7Voce nao comprou! Sem dinheiro suficiente!");
                    }
                }
                else {
                    gui.closeInventory();
                    gui.sendMessage("§7Voce ja possui o kit! ");
                }
            }
            else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Sniper")) {
                if (!Main.perm.has(gui, "kit.sniper")) {
                    if (Main.econ.has(gui.getName(), 25000.0)) {
                        Main.econ.withdrawPlayer(gui.getName(), 25000.0);
                        Main.perm.playerAdd(gui, "kit.sniper");
                        gui.sendMessage("§7Voc\u00ea comprou o kit: §6Sniper");
                        gui.closeInventory();
                    }
                    else {
                        gui.closeInventory();
                        gui.sendMessage("§7Voce nao comprou! Sem dinheiro suficiente!");
                    }
                }
                else {
                    gui.closeInventory();
                    gui.sendMessage("§7Voce ja possui o kit! ");
                }
            }
            else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Fujao")) {
                if (!Main.perm.has(gui, "kit.fujao")) {
                    if (Main.econ.has(gui.getName(), 25000.0)) {
                        Main.econ.withdrawPlayer(gui.getName(), 25000.0);
                        Main.perm.playerAdd(gui, "kit.fujao");
                        gui.sendMessage("§7Voc\u00ea comprou o kit: §5Fujao");
                        gui.closeInventory();
                    }
                    else {
                        gui.closeInventory();
                        gui.sendMessage("§7Voce nao comprou! Sem dinheiro suficiente!");
                    }
                }
                else {
                    gui.closeInventory();
                    gui.sendMessage("§7Voce ja possui o kit! ");
                }
            }
        }
        else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Hunter")) {
            if (!Main.perm.has(gui, "kit.hunter")) {
                if (Main.econ.has(gui.getName(), 25000.0)) {
                    Main.econ.withdrawPlayer(gui.getName(), 25000.0);
                    Main.perm.playerAdd(gui, "kit.hunter");
                    gui.sendMessage("§7Voc\u00ea comprou o kit: §5Hunter");
                    gui.closeInventory();
                }
                else {
                    gui.closeInventory();
                    gui.sendMessage("§7Voce nao comprou! Sem dinheiro suficiente!");
                }
            }
            else {
                gui.closeInventory();
                gui.sendMessage("§7Voce ja possui o kit! ");
            }
        }
        else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Grappler")) {
            if (!Main.perm.has(gui, "kit.grappler")) {
                if (Main.econ.has(gui.getName(), 25000.0)) {
                    Main.econ.withdrawPlayer(gui.getName(), 25000.0);
                    Main.perm.playerAdd(gui, "kit.grappler");
                    gui.sendMessage("§7Voc\u00ea comprou o kit: §5Grappler");
                    gui.closeInventory();
                }
                else {
                    gui.closeInventory();
                    gui.sendMessage("§7Voce nao comprou! Sem dinheiro suficiente!");
                }
            }
            else {
                gui.closeInventory();
                gui.sendMessage("§7Voce ja possui o kit! ");
            }
        }
        else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stone-Man")) {
            if (!Main.perm.has(gui, "kit.stoneman")) {
                if (Main.econ.has(gui.getName(), 25000.0)) {
                    Main.econ.withdrawPlayer(gui.getName(), 25000.0);
                    Main.perm.playerAdd(gui, "kit.stoneman");
                    gui.sendMessage("§7Voc\u00ea comprou o kit: §5StoneMan");
                    gui.closeInventory();
                }
                else {
                    gui.closeInventory();
                    gui.sendMessage("§7Voce nao comprou! Sem dinheiro suficiente!");
                }
            }
            else {
                gui.closeInventory();
                gui.sendMessage("§7Voce ja possui o kit! ");
            }
        }
    }
    
    public static void guiShop(final Player p) {
        final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder)p, 27, "§6Shop de Kits");
        final ItemStack Ryu = new ItemStack(Material.BEACON);
        final ItemMeta Ryumeta = Ryu.getItemMeta();
        Ryumeta.setDisplayName("§7Ryu");
        final List<String> loreRyu = new ArrayList<String>();
        loreRyu.add("§625.000 §7Creditos");
        Ryumeta.setLore((List)loreRyu);
        Ryu.setItemMeta(Ryumeta);
        final ItemStack anchor = new ItemStack(Material.ANVIL);
        final ItemMeta anchormeta = anchor.getItemMeta();
        anchormeta.setDisplayName("§7Anchor");
        final List<String> loreanchor = new ArrayList<String>();
        loreanchor.add("§625.000 §7Creditos");
        anchormeta.setLore((List)loreanchor);
        anchor.setItemMeta(anchormeta);
        final ItemStack Flash = new ItemStack(Material.REDSTONE_TORCH_ON);
        final ItemMeta Flashmeta = Flash.getItemMeta();
        Flashmeta.setDisplayName("§7Flash");
        final List<String> Flashlore = new ArrayList<String>();
        Flashlore.add("§625.000 §7Creditos");
        Flashmeta.setLore((List)Flashlore);
        Flash.setItemMeta(Flashmeta);
        final ItemStack Naruto = new ItemStack(Material.GOLD_INGOT);
        final ItemMeta Narutom = Naruto.getItemMeta();
        Narutom.setDisplayName("§7Naruto");
        final List<String> Narutol = new ArrayList<String>();
        Narutol.add("§625.000 §7Creditos");
        Narutom.setLore((List)Narutol);
        Naruto.setItemMeta(Narutom);
        final ItemStack Hulk = new ItemStack(Material.DIAMOND);
        final ItemMeta Hulkm = Hulk.getItemMeta();
        Hulkm.setDisplayName("§7Hulk");
        final List<String> Hulkl = new ArrayList<String>();
        Hulkl.add("§625.000 §7Creditos");
        Hulkm.setLore((List)Hulkl);
        Hulk.setItemMeta(Hulkm);
        final ItemStack Thor = new ItemStack(Material.WOOD_AXE);
        final ItemMeta Thormeta = Thor.getItemMeta();
        Thormeta.setDisplayName("§7Thor");
        final List<String> Thorlore = new ArrayList<String>();
        Thorlore.add("§625.000 §7Creditos");
        Thormeta.setLore((List)Thorlore);
        Thor.setItemMeta(Thormeta);
        final ItemStack Sniper = new ItemStack(Material.IRON_BARDING);
        final ItemMeta Sniperm = Sniper.getItemMeta();
        Sniperm.setDisplayName("§7Sniper");
        final List<String> Sniperl = new ArrayList<String>();
        Sniperl.add("§625.000 §7Creditos");
        Sniperm.setLore((List)Sniperl);
        Sniper.setItemMeta(Sniperm);
        final ItemStack fujao = new ItemStack(Material.GHAST_TEAR);
        final ItemMeta fujaom = fujao.getItemMeta();
        fujaom.setDisplayName("§7Fujao");
        final List<String> fujaol = new ArrayList<String>();
        fujaol.add("§625.000 §7Creditos");
        fujaom.setLore((List)fujaol);
        fujao.setItemMeta(fujaom);
        final ItemStack Hunter = new ItemStack(Material.STICK);
        final ItemMeta Hunterm = Hunter.getItemMeta();
        Hunterm.setDisplayName("§7Hunter");
        final List<String> Hunterl = new ArrayList<String>();
        Hunterl.add("§625.000 §7Creditos");
        Hunterm.setLore((List)Hunterl);
        Hunter.setItemMeta(Hunterm);
        final ItemStack Grappler = new ItemStack(Material.LEASH);
        final ItemMeta Grapplerm = Grappler.getItemMeta();
        Grapplerm.setDisplayName("§7Grappler");
        final List<String> Grapplerl = new ArrayList<String>();
        Grapplerl.add("§625.000 §7Creditos");
        Grapplerm.setLore((List)Grapplerl);
        Grappler.setItemMeta(Grapplerm);
        final ItemStack StoneMan = new ItemStack(Material.STONE);
        final ItemMeta StoneManm = StoneMan.getItemMeta();
        StoneManm.setDisplayName("§7Stone-Man");
        final List<String> StoneManl = new ArrayList<String>();
        StoneManl.add("§625.000 §7Creditos");
        StoneManm.setLore((List)StoneManl);
        StoneMan.setItemMeta(StoneManm);
        final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
        final ItemMeta vidrom = vidro.getItemMeta();
        vidrom.setDisplayName(" ");
        vidro.setItemMeta(vidrom);
        final ItemStack Saldo = new ItemStack(Material.EMERALD);
        final ItemMeta Saldoi = Saldo.getItemMeta();
        Saldoi.setDisplayName("§7Saldo: §6" + Main.econ.getBalance(p.getName()) + " §7Creditos");
        Saldo.setItemMeta(Saldoi);
        inv.setItem(0, Saldo);
        inv.setItem(1, vidro);
        inv.setItem(2, vidro);
        inv.setItem(3, Ryu);
        inv.setItem(4, vidro);
        inv.setItem(5, anchor);
        inv.setItem(6, vidro);
        inv.setItem(7, vidro);
        inv.setItem(8, vidro);
        inv.setItem(9, vidro);
        inv.setItem(10, Flash);
        inv.setItem(11, Naruto);
        inv.setItem(12, Hulk);
        inv.setItem(13, Thor);
        inv.setItem(14, Sniper);
        inv.setItem(15, fujao);
        inv.setItem(16, Hunter);
        inv.setItem(17, vidro);
        inv.setItem(18, vidro);
        inv.setItem(19, vidro);
        inv.setItem(20, vidro);
        inv.setItem(21, Grappler);
        inv.setItem(22, vidro);
        inv.setItem(23, StoneMan);
        inv.setItem(24, vidro);
        inv.setItem(25, vidro);
        inv.setItem(26, Saldo);
        p.openInventory(inv);
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (label.equalsIgnoreCase("loja")) {
            final Player p = (Player)sender;
            guiShop(p);
        }
        return false;
    }
}
