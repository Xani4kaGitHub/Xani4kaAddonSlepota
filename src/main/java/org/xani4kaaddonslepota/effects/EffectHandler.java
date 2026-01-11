package org.xani4kaaddonslepota.effects;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EffectHandler {
    
    private final int blindnessLevel;
    
    public EffectHandler(int blindnessLevel) {
        this.blindnessLevel = blindnessLevel;
    }
    
    public boolean hasBlindnessEffect(Player player) {
        PotionEffect effect = player.getPotionEffect(PotionEffectType.BLINDNESS);
        return effect != null && effect.getAmplifier() >= (blindnessLevel - 1);
    }
    
    public void applyBlindness(Player player) {
        player.removePotionEffect(PotionEffectType.BLINDNESS);
        PotionEffect blindness = new PotionEffect(
            PotionEffectType.BLINDNESS, 
            Integer.MAX_VALUE, 
            blindnessLevel - 1, 
            false, 
            false
        );
        player.addPotionEffect(blindness);
    }
    
    public void removeBlindness(Player player) {
        player.removePotionEffect(PotionEffectType.BLINDNESS);
    }
}