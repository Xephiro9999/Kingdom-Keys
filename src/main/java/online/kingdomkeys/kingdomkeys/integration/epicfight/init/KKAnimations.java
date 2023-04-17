package online.kingdomkeys.kingdomkeys.integration.epicfight.init;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import online.kingdomkeys.kingdomkeys.KingdomKeys;
import yesman.epicfight.api.animation.property.AnimationEvent;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.BasicAttackAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.forgeevent.AnimationRegistryEvent;
import yesman.epicfight.gameasset.Armatures;

public class KKAnimations {
    public static StaticAnimation TEST, CHAKRAM_AUTO_1, ROXAS_AUTO_1, ROXAS_IDLE, ROXAS_RUN,
            KK_SHIELD_AUTO_1, KK_SHIELD_AUTO_2, KK_SHIELD_AUTO_3, KH1_SORA_COMBO1, VALOR_IDLE, VALOR_AUTO_1, VALOR_AUTO_2,
            VALOR_AUTO_3, MASTER_IDLE, WISDOM_IDLE, WISDOM_RUN, WISDOM_COMBO1;


    private KKAnimations() {

    }

    public static void register(AnimationRegistryEvent event) {
        event.getRegistryMap().put(KingdomKeys.MODID, KKAnimations::build);

    }

    private static void build() {

        VALOR_IDLE = new StaticAnimation(true, "biped/living/valor_idle", Armatures.BIPED);
        WISDOM_IDLE = new StaticAnimation(true, "biped/living/wisdom_idle", Armatures.BIPED);
        WISDOM_RUN = new StaticAnimation(true, "biped/living/wisdom_run", Armatures.BIPED);
        WISDOM_COMBO1 = new BasicAttackAnimation(0.16F, 0.05F, 0.5F, 0.7F, KKColiders.KEYBLADE, Armatures.BIPED.toolR, "biped/combat/wisdom_combo1", Armatures.BIPED)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED, 1.1F).addEvents(
                        AnimationEvent.TimeStampedEvent.create(.2f, (ep, arr) -> {
                                    Player player = (Player) ep.getOriginal();
                                    Level world = player.getLevel();
                                    if (!world.isClientSide)
                                        WisdomProjectile.shoot(ep, Armatures.BIPED.toolR);
                                }, AnimationEvent.Side.BOTH),
                        AnimationEvent.TimeStampedEvent.create(.3f, (ep, arr) -> {
                            Player player = (Player) ep.getOriginal();
                            Level world = player.getLevel();
                            if (!world.isClientSide)
                                WisdomProjectile.shoot(ep, Armatures.BIPED.toolR);
                        }, AnimationEvent.Side.BOTH),
                        AnimationEvent.TimeStampedEvent.create(.6f, (ep, arr) -> {
                            Player player = (Player) ep.getOriginal();
                            Level world = player.getLevel();
                            if (!world.isClientSide)
                                WisdomProjectile.shoot(ep, Armatures.BIPED.toolR);
                        }, AnimationEvent.Side.BOTH));


        MASTER_IDLE = new StaticAnimation(true, "biped/living/master_idle", Armatures.BIPED);


        ROXAS_AUTO_1 = new BasicAttackAnimation(0.16F, 0.05F, 0.16F, 0.7F, null, Armatures.BIPED.toolR, "biped/combat/roxas_auto_1", Armatures.BIPED);
        ROXAS_IDLE = new StaticAnimation(true, "biped/living/roxas_idle", Armatures.BIPED);
        ROXAS_RUN = new StaticAnimation(true, "biped/living/roxas_run", Armatures.BIPED);

        KH1_SORA_COMBO1 = new BasicAttackAnimation(0.16F, 0.05F, 0.5F, 0.7F, KKColiders.KEYBLADE, Armatures.BIPED.toolR, "biped/combat/kh1_sora_auto_1", Armatures.BIPED);

        KK_SHIELD_AUTO_1 = new BasicAttackAnimation(0.16F, 0.05F, 0.16F, 0.7F, null, Armatures.BIPED.toolR, "biped/combat/kk_shield_auto_1", Armatures.BIPED);
        KK_SHIELD_AUTO_2 = new BasicAttackAnimation(0.16F, 0.05F, 0.16F, 0.7F, null, Armatures.BIPED.toolR, "biped/combat/kk_shield_auto_2", Armatures.BIPED);
        KK_SHIELD_AUTO_3 = new BasicAttackAnimation(0.16F, 0.05F, 0.16F, 0.7F, null, Armatures.BIPED.toolR, "biped/combat/kk_shield_auto_3", Armatures.BIPED);

        CHAKRAM_AUTO_1 = new BasicAttackAnimation(0.16F, 0.05F, 0.16F, 0.7F, null, Armatures.BIPED.toolR, "biped/combat/chakram_auto_1", Armatures.BIPED);

        TEST = new StaticAnimation(true, "biped/living/test", Armatures.BIPED);
    }
}