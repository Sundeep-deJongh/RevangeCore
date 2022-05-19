package nl.revangemt.revangecore.modules.funmodule.commands;

import nl.revangemt.revangecore.RevangeCore;
import nl.revangemt.revangecore.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class SitCMD implements CommandExecutor {

    private RevangeCore plugin;


    public SitCMD(RevangeCore plugin) {
        plugin.getCommand("siton").setExecutor(this);
    }

    public void helpMessage(Player player) {
        player.sendMessage("");
        player.sendMessage(Utils.color("&7Fun module made by &cRazerStorm#4199"));
        player.sendMessage(Utils.color("&7Gemaakt voor &c&lRevange&f&lMT"));
        player.sendMessage("");
        player.sendMessage(Utils.color("&fCommands:"));
        player.sendMessage(Utils.color("&7/siton &c(speler)"));
        player.sendMessage(Utils.color("&7/forcesit &c(speler) (speler)"));
        player.sendMessage("");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if(!(player.hasPermission("revangecore.siton")))  {
            player.sendMessage(Utils.color("&cJe hebt geen toegang tot dit commando!"));
            return false;
        }
        if(args.length < 1) {
            player.sendMessage(Utils.color("&cJe moet een speler meegeven!"));
            return false;
        }

        if(Objects.equals(args[0], "help")) {
            helpMessage(player);
            return false;
        }

        if(Bukkit.getPlayer(args[0]) == null) {
            player.sendMessage(Utils.color("&cDeze speler is niet online!"));
            return false;
        }

        player.sendMessage(Utils.color("&aJe zit nu op " + args[0] + "!"));
        Player selected = Bukkit.getPlayer(args[0]);
        selected.setPassenger(player);

        return true;
    }
}