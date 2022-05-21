package nl.revangemt.revangecore.modules.medicmodule;

import lombok.Getter;
import lombok.Setter;
import nl.revangemt.revangecore.RevangeCore;
import nl.revangemt.revangecore.modules.medicmodule.commands.MedicCMD;
import nl.revangemt.revangecore.modules.medicmodule.events.PlayerInteract;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.UUID;

public class MedicModule {

    private RevangeCore plugin;

    private static @Getter ArrayList<UUID> cooldown = new ArrayList<>();

    public MedicModule(RevangeCore plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(new PlayerInteract(), plugin);
        new MedicCMD(plugin);
    }

}