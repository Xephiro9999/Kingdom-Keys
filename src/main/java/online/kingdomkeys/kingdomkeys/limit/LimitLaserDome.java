package online.kingdomkeys.kingdomkeys.limit;

import java.util.List;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.common.Mod;
import online.kingdomkeys.kingdomkeys.KingdomKeys;
import online.kingdomkeys.kingdomkeys.capability.IPlayerCapabilities;
import online.kingdomkeys.kingdomkeys.capability.ModCapabilities;
import online.kingdomkeys.kingdomkeys.client.sound.ModSounds;
import online.kingdomkeys.kingdomkeys.entity.organization.LaserDomeCoreEntity;
import online.kingdomkeys.kingdomkeys.item.organization.IOrgWeapon;
import online.kingdomkeys.kingdomkeys.lib.DamageCalculation;
import online.kingdomkeys.kingdomkeys.util.Utils.OrgMember;

@Mod.EventBusSubscriber(modid = KingdomKeys.MODID)
public class LimitLaserDome extends Limit {

	public LimitLaserDome(String registryName, int order, int[] limitLaserDomeCosts, OrgMember owner) {
		super(registryName, order, limitLaserDomeCosts, owner);
	}

	@Override
	public void onUse(PlayerEntity player, LivingEntity target, int size) {
		ItemStack stack = player.getHeldItemMainhand();
		player.world.playSound(player, player.getPosition(), ModSounds.antidrive.get(), SoundCategory.PLAYERS, 1F, 1F);
		IPlayerCapabilities playerData = ModCapabilities.getPlayer(player);
		float damage;
		if(stack != null && stack.getItem() instanceof IOrgWeapon) {
			damage = (DamageCalculation.getOrgStrengthDamage(player, stack) + DamageCalculation.getOrgMagicDamage(player, 1, (IOrgWeapon) stack.getItem())) / 2 * 0.15F;
		} else {
			damage = (playerData.getStrength() + playerData.getMagic()) / 2 * 0.15F;
		}

		LaserDomeCoreEntity dome = new LaserDomeCoreEntity(player.world, player, target, damage, size);
		dome.setPosition(target.getPosition().getX(), target.getPosition().getY(), target.getPosition().getZ());
		player.world.addEntity(dome);
	}
}