package online.kingdomkeys.kingdomkeys.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;
import online.kingdomkeys.kingdomkeys.network.PacketHandler;
import online.kingdomkeys.kingdomkeys.network.packet.PacketOrgPortalTP;

public class OrgPortalEntity extends Entity implements IEntityAdditionalSpawnData{

	int maxTicks = 100;
	
	BlockPos destinationPos;
    int destinationDim;
    boolean shouldTeleport;

	public OrgPortalEntity(EntityType<? extends Entity> type, World world) {
		super(type, world);
		this.preventEntitySpawning = true;
	}

	public OrgPortalEntity(FMLPlayMessages.SpawnEntity spawnEntity, World world) {
		super(ModEntities.TYPE_ORG_PORTAL.get(), world);
	}

	public OrgPortalEntity(World world) {
		super(ModEntities.TYPE_ORG_PORTAL.get(), world);
		this.preventEntitySpawning = true;
	}

	public OrgPortalEntity(World world, PlayerEntity player, BlockPos spawnPos, BlockPos destinationPos, int destinationDim, boolean shouldTP) {
		super(ModEntities.TYPE_ORG_PORTAL.get(), world);
		this.setPosition(spawnPos.getX()+0.5,spawnPos.getY(), spawnPos.getZ()+0.5);
        this.destinationPos = destinationPos;
        this.destinationDim = destinationDim;
        this.shouldTeleport = shouldTP;
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	public void tick() {
		if (this.ticksExisted > maxTicks) {
			this.remove();
		}
		
		world.addParticle(ParticleTypes.CLOUD, getPosX(), getPosY(), getPosZ(), 0, 0, 0);

		super.tick();
	}
	
	 @Override
	    public void onCollideWithPlayer(PlayerEntity player) {
	        if(shouldTeleport) {
		        if(!this.isAlive())
		            return;
		        if(player != null){
		            if (destinationPos != null) {
		                if(destinationPos.getX()!=0 && destinationPos.getY()!=0 && destinationPos.getZ()!=0){
		                	player.setPosition(destinationPos.getX(), destinationPos.getY(), destinationPos.getZ());
		                	if(player.world.isRemote)
		                		PacketHandler.sendToServer(new PacketOrgPortalTP(this.destinationDim,destinationPos.getX()+0.5, destinationPos.getY()+1, destinationPos.getZ()+0.5));
		                }
		            }
		        }
	        }

	        super.onCollideWithPlayer(player);
	    }

	public int getMaxTicks() {
		return maxTicks;
	}

	public void setMaxTicks(int maxTicks) {
		this.maxTicks = maxTicks;
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		// compound.putInt("lvl", this.getLvl());
		/*if(destinationPos == null)
            return;
    	
        compound.putInt("x",destinationPos.getX());
        compound.putInt("y",destinationPos.getY());
        compound.putInt("z",destinationPos.getZ());
        compound.putInt("dim",destinationDim);
        compound.putBoolean("tp",shouldTeleport);*/
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		// this.setLvl(compound.getInt("lvl"));
	/*	destinationPos = new BlockPos(compound.getInt("x"),compound.getInt("y"),compound.getInt("z"));
    	destinationDim = compound.getInt("dim");
    	shouldTeleport = compound.getBoolean("tp");*/
	}

	@Override
	protected void registerData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void writeSpawnData(PacketBuffer buffer) {
		if(destinationPos == null)
            return;
    	
        buffer.writeInt(destinationPos.getX());
        buffer.writeInt(destinationPos.getY());
        buffer.writeInt(destinationPos.getZ());
        buffer.writeInt(destinationDim);
        buffer.writeBoolean(shouldTeleport);	}

	@Override
	public void readSpawnData(PacketBuffer additionalData) {
		destinationPos = new BlockPos(additionalData.readInt(),additionalData.readInt(),additionalData.readInt());
    	destinationDim = additionalData.readInt();
    	shouldTeleport = additionalData.readBoolean();
    }
}