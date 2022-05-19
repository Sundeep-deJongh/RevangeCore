package nl.revangemt.revangecore;

import lombok.Getter;
import nl.revangemt.revangecore.modules.ModuleLoader;
import nl.revangemt.revangecore.utils.ConfigurationFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.LinkedHashMap;

public final class RevangeCore extends JavaPlugin {

    private static @Getter RevangeCore instance;

    @Override
    public void onEnable() {
        instance = this;
        ModuleLoader.load(this);

    }

    @Override
    public void onDisable() {
        ModuleLoader.disable();
    }
}
