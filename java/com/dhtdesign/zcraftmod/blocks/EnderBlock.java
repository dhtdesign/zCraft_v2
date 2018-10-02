package com.dhtdesign.zcraftmod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class EnderBlock extends BlockBase 
{

	public EnderBlock(String name, Material material) 
	{
		super(name, material);
		
		setSoundType(SoundType.METAL);
		setHardness(6.0F);
		setResistance(45.0F);
		setHarvestLevel("pickaxe", 3);
		setLightLevel(1.0F);
		//setLightOpacity(1);
		//setBlockUnbreakable();
	}

}
