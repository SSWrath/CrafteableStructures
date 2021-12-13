package me.sswrath.craftstructures.crafting.type;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

/**
 * Class that creates the recipe for the Temple of Mike.
 * 
 * @author <b>sswrath</b> - Original author.
 */
public class TemploMike extends CraftingTemplate {

    public TemploMike(NamespacedKey namespacedKey) {
        super(namespacedKey);
        // Create the itemstack and shaped recipe.
        final var item = new ItemStack(Material.COMMAND_BLOCK);
        final var recipe = new ShapedRecipe(namespacedKey, item);
        // Give shape to recipe and add ingredients.
        recipe.shape("AAA", "ABA", "AAA");
        recipe.setIngredient('A', Material.GOLD_INGOT);
        recipe.setIngredient('B', Material.CARROT);
        // Call the super and the the recipe on the template object.
        super.recipe(recipe);
        // Note, this recipe now needs to be register by the crafting manager.
    }

}
