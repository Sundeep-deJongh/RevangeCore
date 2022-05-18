package nl.revangemt.revangecore.modules;

import lombok.Getter;
import nl.revangemt.revangecore.RevangeCore;
import nl.revangemt.revangecore.modules.playermodule.PlayerModule;
import nl.revangemt.revangecore.modules.restartmodule.RestartModule;
import org.bukkit.Bukkit;

public class ModuleLoader {

    private static @Getter PlayerModule playerModule;
    private static @Getter RestartModule restartModule;

    public static void load(RevangeCore plugin) {
        Bukkit.getLogger().info("Loading modules..");

        playerModule = new PlayerModule(plugin);
        restartModule = new RestartModule(plugin);
    }
}
