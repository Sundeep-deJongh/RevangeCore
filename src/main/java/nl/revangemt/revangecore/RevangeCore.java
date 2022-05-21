package nl.revangemt.revangecore;

import lombok.Getter;
import nl.revangemt.revangecore.modules.ModuleLoader;
import nl.revangemt.revangecore.utils.ConfigurationFile;
import nl.revangemt.revangecore.utils.GUIHolder;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.LinkedHashMap;

public final class RevangeCore extends JavaPlugin {

    private static @Getter RevangeCore instance;
    private static @Getter ConfigurationFile taxiConfig;

    @Override
    public void onEnable() {
        instance = this;
        ModuleLoader.load(this);
        GUIHolder.init(this);

        taxiConfig = new ConfigurationFile(this, "taxi.yml", true);
        taxiConfig.saveConfig();


    }

    @Override
    public void onDisable() {
        ModuleLoader.disable();
    }
}