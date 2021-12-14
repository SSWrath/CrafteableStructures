package me.sswrath.craftstructures.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.sswrath.craftstructures.Core;
import me.sswrath.craftstructures.events.GameTickEvent;

/**
 * A sample of a Bukkit Listener. Loook at the {@link EventHandler} annotations
 * on top of method in order to register them with bukkit.
 * 
 * @author <b>jcedeno</b> - Original author.
 * @author <b>aleiv</b> - Mantainer.
 */
public class GlobalListener implements Listener {
    /** Variables */
    Core instance;

    /**
     * Default constructor.
     * 
     * @param instance The instance of the plugin.
     */
    public GlobalListener(Core instance) {
        this.instance = instance;
    }

    @EventHandler
    public void onGameTick(GameTickEvent e) {

    }
}
