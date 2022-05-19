package nl.revangemt.revangecore;

import lombok.Getter;
import net.milkbowl.vault.economy.Economy;
import nl.revangemt.revangecore.modules.ModuleLoader;
import nl.revangemt.revangecore.utils.ConfigurationFile;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.LinkedHashMap;

public final class RevangeCore extends JavaPlugin {

    private static @Getter RevangeCore instance;
    private static @Getter Economy econ;

    @Override
    public void onEnable() {
        instance = this;
        ModuleLoader.load(this);
        setupEconomy();

    }

    @Override
    public void onDisable() {
        ModuleLoader.disable();
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
}
