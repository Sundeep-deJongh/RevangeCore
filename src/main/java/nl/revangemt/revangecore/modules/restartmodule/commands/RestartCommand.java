package nl.revangemt.revangecore.modules.restartmodule.commands;

import nl.revangemt.revangecore.RevangeCore;
import nl.revangemt.revangecore.modules.restartmodule.RestartModule;
import nl.revangemt.revangecore.modules.restartmodule.tasks.RestartTask;
import nl.revangemt.revangecore.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class RestartCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if(!player.hasPermission("revangecore.restart")) {
            player.sendMessage(Utils.color("&cJe hebt hier geen permissies voor."));
            return false;
        }

        if(args.length != 1) {
            sendHelp(player);
            return false;
        }

        if(args[0].equalsIgnoreCase("start")) {
            if(RestartModule.getRestartTask() != null) {
                player.sendMessage(Utils.color("&cEr is al een restart aan het runnen, gebruik /serverrestart stop om deze te stoppen."));
                return false;
            }
            BossBar bar = Bukkit.createBossBar(Utils.color("&c&lRevange&f&lMT &8┃ &fDe server restart in &c10 &fseconden."), BarColor.RED, BarStyle.SOLID);
            BukkitTask task = new RestartTask(60, bar).runTaskTimer(RevangeCore.getInstance(), 0L, 20L);
            player.sendMessage(Utils.color("&cJe hebt de serverrestart timer gestart."));
            RestartModule.setRestartBar(bar);
            RestartModule.setRestartTask(task);
            return false;
        }

        if(args[0].equalsIgnoreCase("stop")) {
            if(RestartModule.getRestartTask() == null) {
                player.sendMessage(Utils.color("&cEr is momenteel geen restart gaande."));
                return false;
            }
            BukkitTask task = RestartModule.getRestartTask();
            BossBar bar = RestartModule.getRestartBar();
            bar.removeAll();
            task.cancel();
            player.sendMessage(Utils.color("&cJe hebt de restart gecanceld."));
            RestartModule.setRestartTask(null);
            RestartModule.setRestartBar(null);
            return false;
        }
        sendHelp(player);
        return true;
    }

    public void sendHelp(Player player) {
        player.sendMessage(Utils.color("&c/serverrestart &fstart &7- &aStart de countdown."));
        player.sendMessage(Utils.color("&a/serverrestart &fstop &7- &aStop de countdown."));
        player.sendMessage(Utils.color("&7&oRestart Module made by TheBathDuck"));
    }
}
