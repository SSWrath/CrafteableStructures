package me.sswrath.craftstructures.listeners;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;

import lombok.Getter;
import lombok.Setter;

/**
 * A basic template holding the boiler plate to create a customr recipe using
 * spigot.
 * 
 * @author <b>jcedeno</b> - Original author.
 * @author <b>aleiv</b> - Mantainer.
 */
public class CraftingTemplate {
    /** Variables */
    private NamespacedKey namespacedKey;
    private Recipe recipe;
    private @Getter @Setter boolean enabled = false;

    /**
     * Default constrcutor
     * 
     * @param namespacedKey The key to use for the recipe.
     */
    public CraftingTemplate(final NamespacedKey namespacedKey) {
        this.namespacedKey = namespacedKey;
    }

    /**
     * @return The recipe.
     */
    public NamespacedKey namespacedKey() {
        return namespacedKey;
    }

    /**
     * Get the recipe.
     * 
     * @param namespacedKey The key to use for the recipe.
     */
    protected void namespacedKey(final NamespacedKey namespacedKey) {
        this.namespacedKey = namespacedKey;
    }

    /**
     * @return The recipe.
     */
    public Recipe recipe() {
        return recipe;
    }

    /**
     * Sets the recipe.
     * 
     * @param recipe The recipe.
     */
    protected void recipe(Recipe recipe) {
        this.recipe = recipe;
    }

}
