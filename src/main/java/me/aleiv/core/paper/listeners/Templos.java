package me.aleiv.core.paper.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import net.kyori.adventure.text.minimessage.MiniMessage;

public class Templos {
   public void onEnable() {
      ItemStack item = new ItemStack(Material.COMMAND_BLOCK);
      ItemMeta meta = item.getItemMeta();
      meta.displayName(MiniMessage.get().parse("<yellow>Mike's Temple"));
      item.addEnchantment(Enchantment.MENDING, 1);
      NamespacedKey key = new NamespacedKey((@NotNull Plugin) this, "<yellow>Mike's Temple");
      ShapedRecipe recipe = new ShapedRecipe(key, item);
      recipe.shape("***", "***", "*S*");
      recipe.setIngredient('*', Material.AIR);
      recipe.setIngredient('S', Material.BEACON);
      Bukkit.addRecipe(recipe);
   }

}
