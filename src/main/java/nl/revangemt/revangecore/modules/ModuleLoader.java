package nl.revangemt.revangecore.modules;

import lombok.Getter;
import nl.revangemt.revangecore.RevangeCore;
import nl.revangemt.revangecore.modules.playermodule.PlayerModule;
import org.bukkit.Bukkit;

public class ModuleLoader {

    private static @Getter PlayerModule playerModule;

    public static void load(RevangeCore plugin) {
        Bukkit.getLogger().info("Loading modules..");

        playerModule = new PlayerModule(plugin);
    }
}
