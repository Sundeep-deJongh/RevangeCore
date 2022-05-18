package nl.revangemt.revangecore;

import lombok.Getter;
import nl.revangemt.revangecore.modules.ModuleLoader;
import org.bukkit.plugin.java.JavaPlugin;

public final class RevangeCore extends JavaPlugin {

    private static @Getter RevangeCore instance;

    @Override
    public void onEnable() {
        instance = this;
        ModuleLoader.load(this);

    }

    @Override
    public void onDisable() {
    }
}
