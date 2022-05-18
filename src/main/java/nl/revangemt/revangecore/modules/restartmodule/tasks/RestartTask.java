package nl.revangemt.revangecore.modules.restartmodule.tasks;

import nl.revangemt.revangecore.modules.playermodule.PlayerModule;
import nl.revangemt.revangecore.modules.restartmodule.RestartModule;
import nl.revangemt.revangecore.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class RestartTask extends BukkitRunnable {

    private int seconds;
    private BossBar bar;

    public RestartTask(int seconds, BossBar bar) {
        this.seconds = seconds;
        this.bar = bar;

        for(Player player : Bukkit.getOnlinePlayers()) {
            bar.addPlayer(player);
            player.sendTitle();
        }
    }

    @Override
    public void run() {
        seconds--;
        bar.setTitle(Utils.color(("&c&lRevange&f&lMT &8┃ &fDe server restart in &c" + seconds + " &fseconden.")));
        if(this.seconds <= 0) {
            cancel();
            bar.removeAll();
            RestartModule.setRestartTask(null);
            RestartModule.setRestartBar(null);
        }
    }


}
