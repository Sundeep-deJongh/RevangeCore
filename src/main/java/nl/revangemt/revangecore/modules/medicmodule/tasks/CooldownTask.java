package nl.revangemt.revangecore.modules.medicmodule.tasks;

import nl.revangemt.revangecore.modules.medicmodule.MedicModule;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;

public class CooldownTask extends BukkitRunnable {

    private Player player;

    public CooldownTask( Player player) {
        this.player = player;
    }

    @Override
    public void run() {
        MedicModule.getCooldown().remove(player.getUniqueId());
        cancel();
    }
}
