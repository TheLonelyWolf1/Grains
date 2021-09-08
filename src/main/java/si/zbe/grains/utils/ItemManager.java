package si.zbe.grains.utils;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ItemManager {
    public static ItemStack workbench;
    public static ItemStack enderchest;

    public static void init() {
        createWorkbench();
        createEnderChest();
    }

    private static void createWorkbench() {
        ItemStack item = new ItemStack(Material.CRAFTING_TABLE, 1);
        ItemMeta itemmeta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GREEN + LanguageManager.get("workbench.lore"));
        itemmeta.setDisplayName(ChatColor.GOLD + LanguageManager.get("workbench.name"));
        itemmeta.setLore(lore);
        itemmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.addUnsafeEnchantment(Enchantment.LUCK, 1);
        item.setItemMeta(itemmeta);

        workbench = item;
    }
    private static void createEnderChest() {
        ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
        ItemMeta itemmeta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GREEN + LanguageManager.get("enderchest.lore"));
        itemmeta.setDisplayName(ChatColor.GOLD + LanguageManager.get("enderchest.name"));
        itemmeta.setLore(lore);
        itemmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.addUnsafeEnchantment(Enchantment.LUCK, 1);
        item.setItemMeta(itemmeta);
        enderchest = item;
    }
}
