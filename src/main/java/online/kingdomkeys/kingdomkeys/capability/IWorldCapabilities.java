package online.kingdomkeys.kingdomkeys.capability;

import java.util.List;
import java.util.UUID;

import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.CompoundNBT;
import online.kingdomkeys.kingdomkeys.lib.Party;

public interface IWorldCapabilities {
	boolean getHeartlessSpawn();
	void setHeartlessSpawn(boolean b);
	
	void setParties(List<Party> list);
	List<Party> getParties();
	Party getPartyFromMember(UUID memId);
	void addPartyMember(Party party, LivingEntity entity);
	void removeLeaderMember(Party party, LivingEntity entity);
	void addParty(Party party);
	void removeParty(Party party);
	Party getPartyFromName(String name);
	Party getPartyFromLeader(UUID leaderId);
	void read(CompoundNBT nbt);
	CompoundNBT write(CompoundNBT nbt);
}
