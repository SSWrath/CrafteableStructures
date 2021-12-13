package me.sswrath.craftstructures.listeners;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class TemploMike extends CraftingTemplate {

    public TemploMike(NamespacedKey namespacedKey) {
        super(namespacedKey);

        final ItemStack item = new ItemStack(Material.COMMAND_BLOCK);

        final ShapedRecipe recipe = new ShapedRecipe(namespacedKey, item);
        recipe.shape("AAA", "ABA", "AAA");
        recipe.setIngredient('A', Material.GOLD_INGOT);
        recipe.setIngredient('B', Material.CARROT);

        setRecipe(recipe);
    }

    private void setRecipe(ShapedRecipe recipe) {
    }

}
