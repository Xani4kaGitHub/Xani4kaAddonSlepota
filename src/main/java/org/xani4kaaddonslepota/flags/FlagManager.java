package org.xani4kaaddonslepota.flags;

import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.flags.registry.FlagConflictException;
import com.sk89q.worldguard.protection.flags.registry.FlagRegistry;
import org.bukkit.plugin.java.JavaPlugin;

public class FlagManager {
    
    public static StateFlag SLEPOTA_FLAG;
    private final JavaPlugin plugin;
    
    public FlagManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    
    public boolean registerFlags() {
        FlagRegistry registry = WorldGuard.getInstance().getFlagRegistry();
        try {
            StateFlag flag = new StateFlag("slepota", false);
            registry.register(flag);
            SLEPOTA_FLAG = flag;
            plugin.getLogger().info("Флаг 'slepota' успешно зарегистрирован!");
            return true;
        } catch (FlagConflictException e) {
            plugin.getLogger().severe("Не удалось зарегистрировать флаг 'slepota': " + e.getMessage());
            return false;
        }
    }
}