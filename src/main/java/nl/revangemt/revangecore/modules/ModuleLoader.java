package nl.revangemt.revangecore.modules;

import lombok.Getter;
import nl.revangemt.revangecore.RevangeCore;
import nl.revangemt.revangecore.modules.playermodule.PlayerModule;
import nl.revangemt.revangecore.modules.restartmodule.RestartModule;
import nl.revangemt.revangecore.modules.taakstrafmodule.TaakstrafModule;
import org.bukkit.Bukkit;

public class ModuleLoader {

    private static @Getter PlayerModule playerModule;
    private static @Getter RestartModule restartModule;
    private static @Getter TaakstrafModule taakstrafModule;

    public static void load(RevangeCore plugin) {
        Bukkit.getLogger().info("Loading modules..");

        playerModule = new PlayerModule(plugin);
        restartModule = new RestartModule(plugin);
        taakstrafModule = new TaakstrafModule(plugin);
    }

    public static void disable() {
        restartModule.unload();
    }
}
