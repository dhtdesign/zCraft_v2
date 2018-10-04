package com.dhtdesign.zcraftmod.util.handlers;

import com.dhtdesign.zcraftmod.blocks.tileentity.TileEntityEnderChest;
import com.dhtdesign.zcraftmod.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler 
{
	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityEnderChest.class, new ResourceLocation(Reference.MOD_ID + ":ender_chest"));
	}

}
