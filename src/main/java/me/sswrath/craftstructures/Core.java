package me.sswrath.craftstructures;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import co.aikar.commands.PaperCommandManager;
import kr.entree.spigradle.annotations.SpigotPlugin;
import lombok.Getter;
import me.sswrath.craftstructures.commands.GlobalCMD;
import me.sswrath.craftstructures.listeners.CraftingManager;
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
    private @Getter CraftingManager craftingManager;
    private @Getter static MiniMessage miniMessage = MiniMessage.get();

    @Override
    public void onEnable() {
        /** Set the instance */
        instance = this;
        /** Register with dependencies */
        RapidInvManager.register(this);
        BukkitTCT.registerPlugin(this);
        /** Register the acf command manager */
        this.commandManager = new PaperCommandManager(this);
        /** Instantiate the game object. */
        this.game = new Game(this);
        /** Start the game loop */
        game.runTaskTimerAsynchronously(this, 0L, 20L);
        /** Register the crafting manager */
        this.craftingManager = new CraftingManager(this);
        /** Register the Global Listener */
        Bukkit.getPluginManager().registerEvents(new GlobalListener(this), this);
        /** Register the Global Commands after everything else is registered. */
        commandManager.registerCommand(new GlobalCMD(this));

    }

    @Override
    public void onDisable() {

    }

}