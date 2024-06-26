package online.kingdomkeys.kingdomkeys.synthesis.shop;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.util.INBTSerializable;

public class ShopList implements INBTSerializable<CompoundTag>{
	List<ShopItem> list = new LinkedList<ShopItem>();

	@Nullable ResourceLocation names = null;
   
    ResourceLocation registryName;

    public ShopList() {

    }

    public ShopList(ResourceLocation rl, List<ShopItem> list, @Nullable List<String> names) {
    	this.registryName = rl;
		this.list = list;
	}
  /*  
    public String getType() {
    	return type;
    }

    public void setType(String type) {
    	this.type = type;
    }
    */

	public void setNames(@Nullable ResourceLocation names) {
		this.names = names;
	}

	public ResourceLocation getNames() {
		return this.names;
	}
   

	public List<ShopItem> getList() {
		return list;
	}

	public void setList(List<ShopItem> list) {
		this.list = list;
	}

	public void addToList(ShopItem shopItem) {
		this.list.add(shopItem);
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();

		nbt.putString("regname", getRegistryName().toString());
		nbt.putInt("len", list.size());
		for(int i=0;i<list.size();i++) {
			ShopItem shopItem = list.get(i);
			nbt.put("shop_item_"+i, shopItem.serializeNBT());
		}
		if (names != null) {
			nbt.putString("names", names.toString());
		}
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		this.list.clear();
		for(int i=0;i<nbt.getInt("len");i++) {
			ShopItem shopItem = new ShopItem();
			shopItem.deserializeNBT(nbt.getCompound("shop_item_"+i)); 
			this.list.add(shopItem);
		}
		this.setRegistryName(nbt.getString("regname"));
		if (nbt.contains("names")) {
			this.setNames(new ResourceLocation(nbt.getString("names")));
		}
	}

	public ResourceLocation getRegistryName() {
		return registryName;
	}
	public void setRegistryName(String registryName) {
		this.registryName = new ResourceLocation(registryName);
	}

	public void setRegistryName(String namespace, String path) {
		this.registryName = new ResourceLocation(namespace, path);
	}

	public void setRegistryName(ResourceLocation registryName) {
		this.registryName = registryName;
	}
}
