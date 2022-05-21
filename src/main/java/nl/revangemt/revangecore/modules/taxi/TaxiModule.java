package nl.revangemt.revangecore.modules.taxi;

import nl.revangemt.revangecore.RevangeCore;
import nl.revangemt.revangecore.modules.taxi.events.NPCRightClick;
import org.bukkit.Bukkit;

public class TaxiModule {

    private RevangeCore plugin;

    public TaxiModule(RevangeCore plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(new NPCRightClick(), plugin);
    }


}