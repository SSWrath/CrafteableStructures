package me.sswrath.craftstructures.listeners;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import me.sswrath.craftstructures.Core;

/**
 * A class designed to manage all custom recipes for the plugin.
 * 
 * @author <b>jcedeno</b> - Original author.
 */
public class CraftingManager {
    /** Variables */
    private Core instance;
    private static TemploMike temploMikeRecipe;

    /**
     * Default constructor.
     * 
     * @param instance The instance of the plugin.
     */
    public CraftingManager(Core instance) {
        // Set the instance.
        this.instance = instance;
        // Register the recipes.
        registerRecipes(false);
    }

    /**
     * A function that registers the recipes for the plugin.
     * 
     * @param force Whether or not to force the recipes to be registered. Otherwise,
     *              it will only register the recipes if they are not already
     *              registered.
     */
    protected void registerRecipes(boolean force) {
        if (force || temploMikeRecipe == null) {
            temploMikeRecipe = new TemploMike(getRecipeNamespace("Templo Mike"));
            // Register the recipe with bukkit.
            Bukkit.addRecipe(temploMikeRecipe.recipe());
        }
    }

    /**
     * Utility function to get a namespaced key for the plugin using the the
     * object's instance object.
     * 
     * @param name The name of the key.
     * @return The namespaced key.
     */
    public NamespacedKey getRecipeNamespace(String name) {
        return getRecipeNamespacedKey(name, instance);
    }

    /**
     * Utility function to quickly get a namespaced key for a custom recipe.
     * 
     * @param name   The name for the namespaced key.
     * @param plugin The plugin that the recipe belongs to.
     * @return The namespaced key.
     */
    public static NamespacedKey getRecipeNamespacedKey(String name, JavaPlugin plugin) {
        return new NamespacedKey(plugin, name);
    }

}
