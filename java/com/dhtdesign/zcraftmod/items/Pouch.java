package com.dhtdesign.zcraftmod.items;

import com.dhtdesign.zcraftmod.Main;
import com.dhtdesign.zcraftmod.init.ModItems;
import com.dhtdesign.zcraftmod.util.interfaces.IHasModel;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Pouch extends Item implements IHasModel {

	public Pouch(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.zCraftTab);
		
		ModItems.ITEMS.add(this);
	}



	@Override
	public void registerModels() {
		// TODO Auto-generated method stub
		
	}

}
