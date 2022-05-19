package nl.revangemt.revangecore.modules.medicmodule.commands;

import nl.revangemt.revangecore.RevangeCore;
import nl.revangemt.revangecore.utils.ItemBuilder;
import nl.revangemt.revangecore.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class MedicCMD implements CommandExecutor {

    private RevangeCore plugin;


    public MedicCMD(RevangeCore plugin) {
        plugin.getCommand("medic").setExecutor(this);
    }

    public void helpMessage(Player player) {
        player.sendMessage("");
        player.sendMessage(Utils.color("&7Medic Module made by &cRazerStorm#4199"));
        player.sendMessage(Utils.color("&7Gemaakt voor &c&lRevange&f&lMT"));
        player.sendMessage("");
        player.sendMessage(Utils.color("&fCommands:"));
        player.sendMessage(Utils.color("&7/medic &cget (bandage/medkit)"));
        player.sendMessage("");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if(!(player.hasPermission("revangecore.medic")))  {
            player.sendMessage(Utils.color("&cJe hebt geen toegang tot dit commando!"));
            return false;
        }
        if (args.length < 1) {
            helpMessage(player);
            return false;
        }
        if(Objects.equals(args[0], "get")) {
            if(args.length < 2) {
                player.sendMessage(Utils.color("&cError! Kies tussen bandage/medkit!"));
                return false;
            }
            if(args[1].equals("bandage")) {
                ItemStack bandage = new ItemBuilder(Material.BROWN_MUSHROOM)
                        .setNBT("mtcustom", "bandage_fullmodel")
                        .setColoredName("&f&lBandage")
                        .toItemStack();

                player.getInventory().addItem(bandage);
            }else if(args[1].equals("medkit")) {
                ItemStack medkit = new ItemBuilder(Material.BROWN_MUSHROOM)
                        .setNBT("mtcustom", "medkit_fullmodel")
                        .setColoredName("&f&lMedkit")
                        .toItemStack();

                player.getInventory().addItem(medkit);
            }

        }else{
            helpMessage(player);
        }
        return true;
    }
}