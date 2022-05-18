package nl.revangemt.revangecore.modules.playermodule;

import nl.revangemt.revangecore.RevangeCore;
import nl.revangemt.revangecore.modules.playermodule.listeners.JoinListener;
import nl.revangemt.revangecore.modules.playermodule.listeners.QuitListener;
import org.bukkit.Bukkit;

public class PlayerModule {

    private RevangeCore plugin;

    public PlayerModule(RevangeCore plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(new JoinListener(), plugin);
        Bukkit.getPluginManager().registerEvents(new QuitListener(), plugin);
    }


}
