package nl.revangemt.revangecore.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.metadata.MetadataValue;
import sun.jvm.hotspot.oops.Metadata;

public class Utils {

    public static String color(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static boolean isVanished(Player player) {
        for(MetadataValue meta : player.getMetadata("vanished")) {
            if(meta.asBoolean()) return  true;
        }
        return false;
    }

}
