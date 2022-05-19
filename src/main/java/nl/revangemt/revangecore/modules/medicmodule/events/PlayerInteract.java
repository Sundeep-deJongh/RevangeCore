package nl.revangemt.revangecore.modules.medicmodule.events;

import io.github.bananapuncher714.nbteditor.NBTEditor;
import nl.revangemt.revangecore.RevangeCore;
import nl.revangemt.revangecore.modules.medicmodule.MedicModule;
import nl.revangemt.revangecore.modules.medicmodule.utils.ProgressBar;
import nl.revangemt.revangecore.utils.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class PlayerInteract implements Listener {

    private RevangeCore plugin = JavaPlugin.getPlugin(RevangeCore.class);

    @EventHandler
    public void playerInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if(e.getItem() == null) return;
        if(e.getItem().getItemMeta() == null) return;
        if(e.getItem().getItemMeta().getDisplayName() == null) return;
        if(e.getHand() != EquipmentSlot.HAND) return;
        if( !(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK) )) return;
        if (e.getItem().getType() == Material.AIR) return;
        if(!(e.getItem().getType().equals(Material.BROWN_MUSHROOM))) return;
        if(!(NBTEditor.contains(e.getItem(), "mtcustom"))) return;
        String nbt = NBTEditor.getString(e.getItem(), "mtcustom");
        if(!nbt.equals("bandage_fullmodel") && !nbt.equals("medkit_fullmodel")) return;

        if(MedicModule.getHealing().contains(p.getUniqueId())) {
            p.sendMessage(Utils.color("&cJe bent al bezig!"));
            return;
        }

        if(p.getHealth() == p.getMaxHealth()) {
            p.sendMessage(Utils.color("&cJe bent al max health!"));
            return;
        }

        MedicModule.getHealing().add(p.getUniqueId());

        ItemStack hand = p.getInventory().getItemInHand();
        if (hand.getAmount() != 1) {
            hand.setAmount(hand.getAmount() -1);
        } else {
            hand.setAmount(hand.getAmount() - 1);
            p.getInventory().setItemInHand(hand);
        }

        p.sendMessage(Utils.color("&aHealing.."));
        if(Objects.equals(nbt, "bandage_fullmodel")) {
            (new ProgressBar(this.plugin, p, "bandage")).runTaskTimer(this.plugin, 0L, 2L);
        }else if(Objects.equals(nbt, "medkit_fullmodel")) {
            (new ProgressBar(this.plugin, p, "medkit")).runTaskTimer(this.plugin, 0L, 2L);
        }else{
            return;
        }

    }

}
