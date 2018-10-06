package com.dhtdesign.zcraftmod.init;

import java.util.ArrayList;
import java.util.List;

import com.dhtdesign.zcraftmod.blocks.BlockBase;
import com.dhtdesign.zcraftmod.blocks.BlockOres;
import com.dhtdesign.zcraftmod.blocks.EnderBlock;
import com.dhtdesign.zcraftmod.blocks.EnderChest;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


public class ModBlocks 
{

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//Blocks
	public static final Block BLOCK_ENDER = new EnderBlock("block_ender",Material.IRON);
	
	//Ore
	//public static final Block ENDER_ORE = new EnderOre("ender_ore",Material.ROCK);
	
	public static final Block ORE_END = new BlockOres("ore_end", "end");
	public static final Block ORE_OVERWORLD = new BlockOres("ore_overworld", "overworld");
	public static final Block ORE_NETHER = new BlockOres("ore_nether", "nether");
	
	
	public static final Block ENDER_CHEST = new EnderChest("ender_chest");
}
