package online.kingdomkeys.kingdomkeys.item.organization;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import online.kingdomkeys.kingdomkeys.entity.organization.ChakramEntity;
import online.kingdomkeys.kingdomkeys.lib.Utils;

public class ChakramItem extends OrgWeaponItem implements IOrgWeapon {
   
    @Override
    public Utils.OrgMember getMember() {
        return Utils.OrgMember.AXEL;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity player, Hand handIn) {
    	ChakramEntity entity = new ChakramEntity(worldIn, player, this.getName().getFormattedText());
		player.world.addEntity(entity);
		entity.shoot(player, player.rotationPitch, player.rotationYaw, 0, 2F, 0);
		player.swingArm(Hand.MAIN_HAND);
    	return super.onItemRightClick(worldIn, player, handIn);
    }

}
