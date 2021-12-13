package me.sswrath.craftstructures;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.sswrath.craftstructures.events.GameTickEvent;

/**
 * A simple object to handle all the state (data) of any game implementation.
 * 
 * @author <b>jcedeno</b> - Original author.
 * @author <b>aleiv</b> - Mantainer.
 * @author <b>sswrath</b> - Mantainer.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Game extends BukkitRunnable {
    Core instance;

    long gameTime = 0;
    long startTime = 0;

    /**
     * Basic constructor for the game class.
     * 
     * @param instance An instance object that extends the {@link JavaPlugin} class.
     */
    public Game(final Core instance) {
        this.instance = instance;
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public void run() {
        // Obtain new time variable
        final var nTime = obtainNewTime(this.startTime);
        // Set the new game time in seconds
        this.gameTime = nTime;
        // Call the event
        callGameTickEvent(nTime);
    }

    /**
     * Utility function to notify bukkit and other listeners of a custom game tick.
     * 
     * @param nTime The new game time in seconds for the tick.
     */
    private static void callGameTickEvent(final int nTime) {
        Bukkit.getPluginManager().callEvent(new GameTickEvent(nTime, true));
    }

    /**
     * Utility function to obtain the new game time in seconds.
     * 
     * @param startTime The start time of the game in milliseconds.
     * @return The new game time in seconds.
     */
    private static int obtainNewTime(final long startTime) {
        return (int) (Math.ceil((System.currentTimeMillis() - startTime) / 1000.0));
    }
}