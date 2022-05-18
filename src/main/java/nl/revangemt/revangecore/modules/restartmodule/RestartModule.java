package nl.revangemt.revangecore.modules.restartmodule;

import lombok.Getter;
import lombok.Setter;
import nl.revangemt.revangecore.RevangeCore;
import nl.revangemt.revangecore.modules.restartmodule.commands.RestartCommand;
import org.bukkit.boss.BossBar;
import org.bukkit.scheduler.BukkitTask;

public class RestartModule {

    private static @Getter @Setter BukkitTask restartTask;
    private static @Getter @Setter BossBar restartBar;

    private RevangeCore plugin;
    public RestartModule(RevangeCore plugin) {
        this.plugin = plugin;
        plugin.getCommand("serverrestart").setExecutor(new RestartCommand());
    }


}
