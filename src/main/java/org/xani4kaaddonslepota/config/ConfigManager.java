package org.xani4kaaddonslepota.config;

import org.bukkit.plugin.java.JavaPlugin;

public class ConfigManager {
    
    private final JavaPlugin plugin;
    private int blindnessLevel;
    private int checkInterval;
    
    public ConfigManager(JavaPlugin plugin) {
        this.plugin = plugin;
        loadConfig();
    }
    
    public void loadConfig() {
        plugin.saveDefaultConfig();
        plugin.reloadConfig();
        
        this.blindnessLevel = plugin.getConfig().getInt("blindness-level", 5);
        this.checkInterval = plugin.getConfig().getInt("check-interval", 10);
        
        if (blindnessLevel < 1 || blindnessLevel > 255) {
            plugin.getLogger().warning("Неверный уровень слепоты в конфиге! Используется значение по умолчанию: 5");
            this.blindnessLevel = 5;
        }
        
        if (checkInterval < 1) {
            plugin.getLogger().warning("Неверный интервал проверки в конфиге! Используется значение по умолчанию: 10");
            this.checkInterval = 10;
        }
        
        plugin.getLogger().info("Конфигурация загружена: уровень слепоты=" + blindnessLevel + ", интервал=" + checkInterval);
    }
    
    public int getBlindnessLevel() {
        return blindnessLevel;
    }
    
    public int getCheckInterval() {
        return checkInterval;
    }
    
    public void reloadConfig() {
        loadConfig();
    }
}