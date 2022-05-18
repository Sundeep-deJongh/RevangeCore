package nl.revangemt.revangecore.modules.playermodule.listeners;

import nl.revangemt.revangecore.modules.restartmodule.RestartModule;
import nl.revangemt.revangecore.utils.Utils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage(Utils.color("&7[&a+&7] " + event.getPlayer().getName()));

        if(RestartModule.getRestartBar() != null) {
            RestartModule.getRestartBar().addPlayer(event.getPlayer());
        }

    }
}
