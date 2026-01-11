package org.xani4kaaddonslepota.utils;

import org.bukkit.plugin.java.JavaPlugin;

public class MessageUtils {
    
    private final JavaPlugin plugin;
    
    public MessageUtils(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    
    public void printStartupMessage() {
        plugin.getLogger().info("                      .__   _____  __            ");
        plugin.getLogger().info("___  ________    ____ |__| /  |  ||  | _______   ");
        plugin.getLogger().info("\\  \\/  /\\__  \\  /    \\|  |/   |  ||  |/ /\\__  \\  ");
        plugin.getLogger().info(" >    <  / __ \\|   |  \\  /    ^   /    <  / __ \\_");
        plugin.getLogger().info("/__/\\_ \\(____  /___|  /__\\____   ||__|_ \\(____  /");
        plugin.getLogger().info("      \\/     \\/     \\/        |__|     \\/     \\/ ");
        plugin.getLogger().info("Xani4kaAddonSlepota активирован!");
        plugin.getLogger().info("Telegram: https://t.me/HomeXani");
    }
    
    public void printShutdownMessage() {
        plugin.getLogger().info("                      .__   _____  __            ");
        plugin.getLogger().info("___  ________    ____ |__| /  |  ||  | _______   ");
        plugin.getLogger().info("\\  \\/  /\\__  \\  /    \\|  |/   |  ||  |/ /\\__  \\  ");
        plugin.getLogger().info(" >    <  / __ \\|   |  \\  /    ^   /    <  / __ \\_");
        plugin.getLogger().info("/__/\\_ \\(____  /___|  /__\\____   ||__|_ \\(____  /");
        plugin.getLogger().info("      \\/     \\/     \\/        |__|     \\/     \\/ ");
        plugin.getLogger().info("Xani4kaAddonSlepota деактивирован!");
        plugin.getLogger().info("Telegram: https://t.me/HomeXani");
    }
}