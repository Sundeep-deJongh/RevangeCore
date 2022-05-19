package nl.revangemt.revangecore.modules.playermodule.listeners;

import nl.revangemt.revangecore.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if(!Utils.isVanished(event.getPlayer())) {
            event.setQuitMessage(Utils.color("&7[&c-&7] " + event.getPlayer().getName()));
        }
    }
}
