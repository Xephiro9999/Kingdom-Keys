package online.kingdomkeys.kingdomkeys.item;

import java.util.List;
import java.util.UUID;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import online.kingdomkeys.kingdomkeys.util.Utils;
import online.kingdomkeys.kingdomkeys.world.utils.BaseTeleporter;

public class WayfinderItem extends Item {
	public WayfinderItem(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public void inventoryTick(ItemStack stack, Level worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (entityIn instanceof Player player) {
			if (stack.getTag() != null) {
				if (!stack.getTag().hasUUID("ownerUUID"))
					stack.setTag(setID(stack.getTag(), player));
			} else {
				stack.setTag(setID(new CompoundTag(), player));
			}
			super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
		}
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		if (!world.isClientSide) {
			ServerLevel serverLevel = (ServerLevel) world;
			ItemStack stack = player.getItemInHand(hand);

			Player owner = getOwner(serverLevel, stack.getTag());
			if (owner == null) {
				player.sendSystemMessage(Component.translatable("Player " + stack.getTag().getString("ownerName").toString() + " not found"));
				return super.use(world, player, hand);
			}

			teleport(player, owner);
			player.getCooldowns().addCooldown(this, 300 * 20);

		}
		return super.use(world, player, hand);
	}

	public void teleport(Player player, Entity owner) {
		if (player.level().dimension() != owner.level().dimension()) {
			ServerLevel destiinationWorld = owner.getServer().getLevel(owner.level().dimension());
			player.changeDimension(destiinationWorld, new BaseTeleporter(owner.getX() + 0.5, owner.getY(), owner.getZ() + 0.5));
		}

		player.teleportTo(owner.getX() + 0.5, owner.getY(), owner.getZ() + 0.5);
		player.setDeltaMovement(0, 0, 0);
	}

	public CompoundTag setID(CompoundTag nbt, Player player) {
		nbt.putUUID("ownerUUID", player.getUUID());
		nbt.putString("ownerName", player.getDisplayName().getString());
		return nbt;
	}

	public Player getOwner(ServerLevel level, CompoundTag nbt) {
		if (nbt == null)
			return null;

		UUID playerUUID = nbt.getUUID("ownerUUID");

		for (Player p : Utils.getAllPlayers(level.getServer())) {
			if (p.getUUID().equals(playerUUID)) {
				return p;
			}
		}
		return null;
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		if (stack.getTag() != null) {
			tooltip.add(Component.translatable(ChatFormatting.GRAY + "Owner: " + stack.getTag().getString("ownerName").toString()));
			tooltip.add(Component.translatable(ChatFormatting.GRAY + "Cooldown: " + (int) (Minecraft.getInstance().player.getCooldowns().getCooldownPercent(this, 0) * 100) + "%"));
		}
	}

	@Override
	public boolean isEnchantable(ItemStack pStack) {
		return false;
	}

}
