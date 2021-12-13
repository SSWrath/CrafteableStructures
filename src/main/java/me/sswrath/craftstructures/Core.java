package me.sswrath.craftstructures;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import co.aikar.commands.PaperCommandManager;
import kr.entree.spigradle.annotations.SpigotPlugin;
import lombok.Getter;
import me.aleiv.utils.NegativeSpaces;
import me.sswrath.craftstructures.commands.GlobalCMD;
import me.sswrath.craftstructures.listeners.GlobalListener;
import net.kyori.adventure.text.minimessage.MiniMessage;
import us.jcedeno.libs.rapidinv.RapidInvManager;
import us.jcedeno.utils.TCT.BukkitTCT;

/**
 * <p>
 * A core object that handles all the "Bukkit" stuff of the program. This class
 * <b>extends</b> {@link JavaPlugin} and is designed to operate as an standlone
 * plugin
 * using Purpur.
 * </p>
 * 
 * <p>
 * The project is built on uses Spigradle and thus the annotation
 * {@link SpigotPlugin} automatically creates the plugin.yml file with this as
 * the main class.
 * </p>
 * 
 * @author <b>jcedeno</b> - Original author.
 * @author <b>aleiv</b> - Mantainer.
 * @author <b>sswrath</b> - Mantainer.
 */
@SpigotPlugin
public class Core extends JavaPlugin {

    private static @Getter Core instance;
    private @Getter Game game;
    private @Getter PaperCommandManager commandManager;
    private @Getter static MiniMessage miniMessage = MiniMessage.get();

    @Override
    public void onEnable() {
        instance = this;

        RapidInvManager.register(this);
        BukkitTCT.registerPlugin(this);
        NegativeSpaces.registerCodes();

        game = new Game(this);
        game.runTaskTimerAsynchronously(this, 0L, 20L);

        // LISTENERS

        Bukkit.getPluginManager().registerEvents(new GlobalListener(this), this);

        // COMMANDS

        commandManager = new PaperCommandManager(this);

        commandManager.registerCommand(new GlobalCMD(this));

    }

    public void registerRecipe() {
        var item = new ItemStack(Material.COMMAND_BLOCK);
        var meta = item.getItemMeta();
        meta.displayName(MiniMessage.get().parse("<yellow>Mike's Temple"));
        item.addEnchantment(Enchantment.MENDING, 1);
        var key = new NamespacedKey(this, "<yellow>Mike's Temple");
        var recipe = new ShapedRecipe(key, item);
        recipe.shape("***", "***", "*S*");
        recipe.setIngredient('*', Material.AIR);
        recipe.setIngredient('S', Material.BEACON);
        Bukkit.addRecipe(recipe);
    }

    @Override
    public void onDisable() {

    }

}