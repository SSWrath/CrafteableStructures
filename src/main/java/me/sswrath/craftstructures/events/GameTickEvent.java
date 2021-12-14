package me.sswrath.craftstructures.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import lombok.Getter;
import me.sswrath.craftstructures.Core;
import me.sswrath.craftstructures.Game;

/**
 * 
 * A simple Bukkit event that gets called on every custom loop game tick. See
 * {@link Core} and {@link Game} to understand the design pattern.
 * 
 * @author <b>jcedeno</b> - Original author.
 * @author <b>aleiv</b> - Mantainer.
 * @author <b>sswrath</b> - Mantainer.
 */
public class GameTickEvent extends Event {

    private static final @Getter HandlerList HandlerList = new HandlerList();
    @SuppressWarnings({ "java:S116", "java:S1170" })
    private final @Getter HandlerList Handlers = HandlerList;
    private final @Getter int second;

    public GameTickEvent(int second, boolean async) {
        super(async);
        this.second = second;
    }

    public GameTickEvent(int second) {
        this(second, false);
    }

}