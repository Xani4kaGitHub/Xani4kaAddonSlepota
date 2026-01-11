package org.xani4kaaddonslepota;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.xani4kaaddonslepota.config.ConfigManager;
import org.xani4kaaddonslepota.effects.EffectHandler;
import org.xani4kaaddonslepota.regions.RegionChecker;

import java.util.HashSet;
import java.util.Set;

public class BlindnessManager {
    
    private final Xani4kaAddonSlepota plugin;
    private final Set<Player> blindedPlayers;
    private final ConfigManager configManager;
    private final EffectHandler effectHandler;
    private final RegionChecker regionChecker;
    private BukkitTask task;
    
    public BlindnessManager(Xani4kaAddonSlepota plugin, ConfigManager configManager) {
        this.plugin = plugin;
        this.configManager = configManager;
        this.blindedPlayers = new HashSet<>();
        this.effectHandler = new EffectHandler(configManager.getBlindnessLevel());
        this.regionChecker = new RegionChecker();
    }
    
    public void startTask() {
        task = new BukkitRunnable() {
            @Override
            public void run() {
                checkAllPlayers();
            }
        }.runTaskTimer(plugin, 0L, configManager.getCheckInterval());
    }
    
    public void stopTask() {
        if (task != null) {
            task.cancel();
        }
        for (Player player : blindedPlayers) {
            effectHandler.removeBlindness(player);
        }
        blindedPlayers.clear();
    }
    
    private void checkAllPlayers() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (regionChecker.shouldHaveBlindness(player)) {
                if (!blindedPlayers.contains(player) || !effectHandler.hasBlindnessEffect(player)) {
                    effectHandler.applyBlindness(player);
                    blindedPlayers.add(player);
                }
            } else {
                if (blindedPlayers.contains(player)) {
                    effectHandler.removeBlindness(player);
                    blindedPlayers.remove(player);
                }
            }
        }
    }
}