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

import java.util.concurrent.TimeUnit;

public class RestartTask extends BukkitRunnable {

    private int seconds;
    private BossBar bar;
    private long finishTime;

    public RestartTask(int seconds, BossBar bar) {
        this.seconds = seconds;
        this.bar = bar;
        this.finishTime = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(seconds);

        for(Player player : Bukkit.getOnlinePlayers()) {
            bar.addPlayer(player);

            player.sendTitle(Utils.color("&c&lRevange&f&lMT"), Utils.color("&fDe server restart over &c" + getTimestamp() + " &fminuten."), 10, 35, 20);
        }
    }

    @Override
    public void run() {
        seconds--;
        bar.setTitle(Utils.color(("&c&lRevange&f&lMT &8┃ &fDe server restart in &c" + getTimestamp() + " &fminuten.")));
        if(this.seconds <= 0) {
            cancel();
            bar.removeAll();
            RestartModule.setRestartTask(null);
            RestartModule.setRestartBar(null);

            for(Player player : Bukkit.getOnlinePlayers()) {
                player.kickPlayer(Utils.color("&cDe server is aan het restarten."));
            }
            Bukkit.getServer().spigot().restart();
        }
    }

    public String getTimestamp() {
        long millis = finishTime - System.currentTimeMillis();
        int minutes = (int)TimeUnit.MILLISECONDS.toMinutes(millis);
        int seconds = (int)(TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
        return minutes + ":" + ((String.valueOf(seconds).length() < 2) ? ("0" + seconds) : seconds);
    }

}
