package me.aleiv.core.paper;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import co.aikar.commands.PaperCommandManager;
import kr.entree.spigradle.annotations.SpigotPlugin;
import lombok.Getter;
import me.aleiv.core.paper.commands.GlobalCMD;
import me.aleiv.core.paper.listeners.GlobalListener;
import me.aleiv.core.paper.utilities.NegativeSpaces;
import me.aleiv.core.paper.utilities.TCT.BukkitTCT;
import net.kyori.adventure.text.minimessage.MiniMessage;
import us.jcedeno.libs.rapidinv.RapidInvManager;

@SpigotPlugin
public class Core extends JavaPlugin {

    private static @Getter Core instance;
    private @Getter Game game;
    private @Getter PaperCommandManager commandManager;
    private @Getter static MiniMessage miniMessage = MiniMessage.get();

    @Override
    public void onEnable() {
        
            ItemStack item = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta meta = item.getItemMeta();
            meta.displayName(MiniMessage.get().parse("<yellow>Mike's Temple"));
            item.addEnchantment(Enchantment.MENDING, 1);
            NamespacedKey key = new NamespacedKey((@NotNull Plugin) this, "<yellow>Mike's Temple");
            ShapedRecipe recipe = new ShapedRecipe(key, item);
            recipe.shape("", "", "S");
            recipe.setIngredient('*', Material.AIR);
            recipe.setIngredient('S', Material.BEACON);
            Bukkit.addRecipe(recipe);
        instance = this;


        RapidInvManager.register(this);
        BukkitTCT.registerPlugin(this);
        NegativeSpaces.registerCodes();

        game = new Game(this);
        game.runTaskTimerAsynchronously(this, 0L, 20L);

        

        //LISTENERS

        Bukkit.getPluginManager().registerEvents(new GlobalListener(this), this);

        //COMMANDS
        
        commandManager = new PaperCommandManager(this);

        commandManager.registerCommand(new GlobalCMD(this));

    }

    @Override
    public void onDisable() {

    }

}