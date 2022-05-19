package nl.revangemt.revangecore.modules.funmodule;

import nl.revangemt.revangecore.RevangeCore;
import nl.revangemt.revangecore.modules.funmodule.commands.ForceSitCMD;
import nl.revangemt.revangecore.modules.funmodule.commands.SitCMD;

public class FunModule {
    private RevangeCore plugin;

    public FunModule(RevangeCore plugin) {
        this.plugin = plugin;
        new SitCMD(plugin);
        new ForceSitCMD(plugin);
    }
}
