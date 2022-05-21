package nl.revangemt.revangecore.utils;

import com.sun.org.apache.xerces.internal.xs.StringList;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.metadata.MetadataValue;
import sun.jvm.hotspot.oops.Metadata;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static String color(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }


    public static List<String> color(List<String> s) {

        ArrayList<String> newLores = new ArrayList<>();

        for(String current : s) {
            newLores.add(color(current));
        }

        return newLores;
    }

}
