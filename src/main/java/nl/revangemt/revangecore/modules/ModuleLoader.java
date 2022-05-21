package nl.revangemt.revangecore.modules;

import lombok.Getter;
import nl.revangemt.revangecore.RevangeCore;
import nl.revangemt.revangecore.modules.funmodule.FunModule;
import nl.revangemt.revangecore.modules.medicmodule.MedicModule;
import nl.revangemt.revangecore.modules.playermodule.PlayerModule;
import nl.revangemt.revangecore.modules.restartmodule.RestartModule;
import nl.revangemt.revangecore.modules.taxi.TaxiModule;
import org.bukkit.Bukkit;

public class ModuleLoader {

    private static @Getter PlayerModule playerModule;
    private static @Getter RestartModule restartModule;
    private static @Getter FunModule funModule;
    private static @Getter MedicModule medicModule;
    private static @Getter TaxiModule taxiModule;

    public static void load(RevangeCore plugin) {
        Bukkit.getLogger().info("Loading modules..");

        playerModule = new PlayerModule(plugin);
        restartModule = new RestartModule(plugin);
        funModule = new FunModule(plugin);
        medicModule = new MedicModule(plugin);
        taxiModule = new TaxiModule(plugin);

    }

    public static void disable() {
        restartModule.unload();
    }
}
