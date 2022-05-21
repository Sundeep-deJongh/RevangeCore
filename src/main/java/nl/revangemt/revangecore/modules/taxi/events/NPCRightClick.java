package nl.revangemt.revangecore.modules.taxi.events;

import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import nl.revangemt.revangecore.RevangeCore;
import nl.revangemt.revangecore.modules.taxi.inventories.TeleportGUI;
import nl.revangemt.revangecore.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Objects;

public class NPCRightClick implements Listener {

    @EventHandler
    public void rightClickEvent(NPCRightClickEvent e) {
        Player p = e.getClicker();
        NPC npc = e.getNPC();
        if (npc == null) return;
        if (!Objects.equals(npc.getName(), Utils.color(RevangeCore.getTaxiConfig().getConfig().getString("NPC-Name")))) return;

        new TeleportGUI(p).openGUi();
    }
}
