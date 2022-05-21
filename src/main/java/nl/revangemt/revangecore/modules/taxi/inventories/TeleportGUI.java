package nl.revangemt.revangecore.modules.taxi.inventories;

import io.github.bananapuncher714.nbteditor.NBTEditor;
import nl.revangemt.revangecore.RevangeCore;
import nl.revangemt.revangecore.utils.GUIHolder;
import nl.revangemt.revangecore.utils.ItemBuilder;
import nl.revangemt.revangecore.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Set;

public class TeleportGUI extends GUIHolder {

    private Player p;
    private FileConfiguration config;

    public TeleportGUI(Player p) {
        this.p = p;
    }

    public Inventory getInventory() {
        return  this.inventory;
    }

    public void openGUi() {
        this.config = RevangeCore.getTaxiConfig().getConfig();
        this.inventory = Bukkit.createInventory(this, config.getInt("GUI-rows") * 9, Utils.color("&6&lTaxi"));

        Set<String> locations = config.getConfigurationSection("locations").getKeys(false);


        int slot = 0;
        for(String currentLocation : locations) {
            ItemBuilder currentLocationItem = new ItemBuilder(Material.valueOf(config.getString("locations." + currentLocation + ".item.material")))
                    .setColoredName(config.getString("locations." + currentLocation + ".item.display-name"))
                    .setLore(Utils.color(config.getStringList("locations." + currentLocation + ".item.lores")))
                    .setNBT("taxi", currentLocation);

            if(config.getInt("locations." + currentLocation + ".item.durability") != 0) {
                currentLocationItem.setDurability((short) config.getInt("locations." + currentLocation + ".item.durability"));
            }

            if(config.getString("locations." + currentLocation + ".item.nbt-group") != null) {
                currentLocationItem.setNBT(config.getString("locations." + currentLocation + ".item.nbt-group"), config.getString("locations." + currentLocation + ".item.nbt-value"));
            }

            this.inventory.setItem(slot, currentLocationItem.toItemStack());
           slot++;
        }

        p.openInventory(this.inventory);
    }

    @Override
    public void onClick(InventoryClickEvent e) {
        e.setCancelled(true);
        if(e.getClickedInventory() == null) return;
        if(!(e.getClickedInventory() == e.getView().getTopInventory())) return;
        if(!(NBTEditor.contains(e.getCurrentItem(), "mtcustom"))) return;
        String nbt = NBTEditor.getString(e.getCurrentItem(), "taxi");

        String locString = config.getString("locations." + nbt + ".locatie");
        String[] locParts = locString.split(";");

        Location loc = new Location(
                Bukkit.getWorld(locParts[0]),
                Double.parseDouble(locParts[1]),
                Double.parseDouble(locParts[2]),
                Double.parseDouble(locParts[3]),
                Float.parseFloat(locParts[4]),
                Float.parseFloat(locParts[5])
        );

        p.teleport(loc);

    }

    @Override
    public void onInventoryClose(InventoryCloseEvent e) {

    }
}
