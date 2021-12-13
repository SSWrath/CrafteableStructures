package me.sswrath.craftstructures.listeners;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import me.sswrath.craftstructures.Core;

/**
 * A class designed to manage all custom recipes for the plugin.
 * 
 * @author jcedeno
 */
public class CraftingManager {

    // TemploMike GoldCarrot = new TemploMike(new NamespacedKey(instance, "Templo
    // Mike"));
    private Core instance;

    public CraftingManager(Core instance) {
        this.instance = instance;

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
