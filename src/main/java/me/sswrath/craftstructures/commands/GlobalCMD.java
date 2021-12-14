package me.sswrath.craftstructures.commands;

import org.bukkit.entity.Player;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Subcommand;
import lombok.NonNull;
import me.sswrath.craftstructures.Core;

/**
 * <p>
 * An example class of how to build commands using Aikar's Annotation Command
 * (ACF).
 * Framework.
 * </p>
 * 
 * <p>
 * This class extends {@link BaseCommand} and is annotated with
 * {@link CommandAlias} and {@link CommandPermission}. In ACF, in order to
 * create a command, you must create class that extends the BaseCommand object.
 * </p>
 * 
 * <p>
 * In order to set the actual in-game command, the annotation
 * {@link CommandAlias} must be set. Don't put the slash, it will be added for
 * you.
 * </p>
 * 
 * <p>
 * If you want the permission to be used only by a certain permission, use the
 * {@link CommandPermission} annotation.
 * </p>
 * 
 * @author <b>jcedeno</b> - Original author.
 * @author <b>aleiv</b> - Mantainer.
 * @author <b>sswrath</b> - Mantainer.
 */
@CommandAlias("global")
@CommandPermission("admin.perm")
public class GlobalCMD extends BaseCommand {
    /** Variables */
    private @NonNull Core instance;

    /**
     * Default constructor.
     * 
     * @param instance A reference to the main class.
     */
    public GlobalCMD(Core instance) {
        this.instance = instance;
    }

    /**
     * <p>
     * We use a command framework built by aikar, the creator of paper. It's called
     * ACF (Annotation Command Framework).<br>
     * <br>
     * Using the annotation Subcommand it create a subcommand og the
     * original CommandAlias in this class. That is, it creates a subcommand of
     * /global.
     * <br>
     * <br>
     * In this case, the subcommand is /global demo-cmd <string>, it is only
     * executable by a player and takes Text as arguments.
     * </p>
     * 
     * @param sender
     * @param arguments
     */
    @Subcommand("demo-cmd")
    public void demoCommand(Player sender, String arguments) {
        /*
         * Echo back the string arugments to the user. Look at how I used \n to break
         * line and \" to add quotes inside of a string.
         */
        sender.sendMessage(
                Core.getMiniMessage()
                        .parse("<green>This is a demo command. \nYour input was: <white>\"" + arguments
                                + "\" <green>."));

    }
}
