package org.xani4kaaddonslepota;

import org.bukkit.plugin.java.JavaPlugin;
import org.xani4kaaddonslepota.config.ConfigManager;
import org.xani4kaaddonslepota.flags.FlagManager;
import org.xani4kaaddonslepota.utils.MessageUtils;

public final class Xani4kaAddonSlepota extends JavaPlugin {

    private FlagManager flagManager;
    private ConfigManager configManager;
    private BlindnessManager blindnessManager;
    private MessageUtils messageUtils;

    @Override
    public void onLoad() {
        flagManager = new FlagManager(this);
        
        if (!flagManager.registerFlags()) {
            getLogger().severe("Не удалось зарегистрировать флаги! Плагин будет отключен.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
    }

    @Override
    public void onEnable() {
        messageUtils = new MessageUtils(this);
        configManager = new ConfigManager(this);
        blindnessManager = new BlindnessManager(this, configManager);
        
        blindnessManager.startTask();
        
        messageUtils.printStartupMessage();
    }

    @Override
    public void onDisable() {
        if (blindnessManager != null) {
            blindnessManager.stopTask();
        }
        
        if (messageUtils != null) {
            messageUtils.printShutdownMessage();
        }
    }
    
    public ConfigManager getConfigManager() {
        return configManager;
    }
    
    public FlagManager getFlagManager() {
        return flagManager;
    }
}
