package nl.revangemt.revangecore.modules.medicmodule.tasks;

import com.google.common.base.Strings;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import nl.revangemt.revangecore.RevangeCore;
import nl.revangemt.revangecore.modules.medicmodule.MedicModule;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class ProgressBar extends BukkitRunnable {
    private int time;
    private int seconds;
    private int secondsC;
    private int max;
    private RevangeCore plugin;
    private Player player;
    private String type;

    public ProgressBar(RevangeCore plugin, Player player, String type) {
        this.type = type;

        this.plugin = plugin;
        this.time = 9;
        this.secondsC = 0;
        this.player = player;

        if(Objects.equals(type, "bandage")) {
            this.seconds = 2 - 1;
            this.max = 20;
            (new CooldownTask(player)).runTaskLaterAsynchronously(this.plugin, 5*20);
        }else if(Objects.equals(type, "medkit")) {
            this.seconds = 5 - 1;
            this.max = 50;
            (new CooldownTask(player)).runTaskLaterAsynchronously(this.plugin, 10*20);
        }

    }


    public void run() {
        this.time--;
        this.secondsC++;
        if (this.time == -1) {
            this.time = 9;
            this.seconds--;
        }

        if (this.seconds != -1) {
            this.player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§8[§r" + getProgressBar(this.secondsC, max, 10, '|', "§a", "§c") + "§8]"));
        }

        if (this.seconds == 0 && this.time == 0 ) {
            this.player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§8[§r" + getProgressBar(1, 1, 10, '|', "§a", "§c") + "§8]"));

            if(Objects.equals(type, "bandage")) {
                if (this.player.getHealth() > 15) {
                    this.player.setHealth(player.getMaxHealth());
                } else {
                    this.player.setHealth(player.getHealth() + 5);
                }
            }else if(Objects.equals(type, "medkit")) {
                this.player.setHealth(player.getMaxHealth());
            }

            this.player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 10);
            player.spawnParticle(Particle.REDSTONE, player.getLocation(), 20, 0.001, 2, -2, 1);
            cancel();
        }


    }

    public String getProgressBar(int current, int max, int totalBars, char symbol, String completedColor, String notCompletedColor) {
        float percent = (float) current / max;
        int progressBars = (int) (totalBars * percent);

        return Strings.repeat("" + completedColor + symbol, progressBars) + Strings.repeat(notCompletedColor + symbol, totalBars - progressBars);
    }
}