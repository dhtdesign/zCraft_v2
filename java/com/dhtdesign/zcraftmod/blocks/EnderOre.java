package com.dhtdesign.zcraftmod.blocks;

import java.util.Random;

import com.dhtdesign.zcraftmod.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class EnderOre extends BlockBase {

	public EnderOre(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.METAL);
		setHardness(6.0F);
		setResistance(15.0F);
		setHarvestLevel("pickaxe", 3);
		//setLightLevel(1.0F);
		//setLightOpacity(1);
		//setBlockUnbreakable();
		
		
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) 
	{
		return ModItems.ENDER_INGOT;
		
	}
	
	@Override
	public int quantityDropped(Random rand)
	{
		int max = 4;
		int min = 1;
		return rand.nextInt(max) + min;
		
	}
	
}
