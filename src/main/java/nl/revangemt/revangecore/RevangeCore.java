package nl.revangemt.revangecore;

import nl.revangemt.revangecore.modules.ModuleLoader;
import org.bukkit.plugin.java.JavaPlugin;

public final class RevangeCore extends JavaPlugin {

    @Override
    public void onEnable() {

        ModuleLoader.load();

    }

    @Override
    public void onDisable() {
    }
}
