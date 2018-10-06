package com.dhtdesign.zcraftmod.world.gen;

import java.util.Random;

import com.dhtdesign.zcraftmod.blocks.BlockOres;
import com.dhtdesign.zcraftmod.init.ModBlocks;
import com.dhtdesign.zcraftmod.util.handlers.EnumHandler;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenCustomOres implements IWorldGenerator
{
	private WorldGenerator ore_nether_azoproit, ore_overworld_azoproit, ore_end_azoproit;
	
	public WorldGenCustomOres() 
	{
		ore_nether_azoproit = new WorldGenMinable(ModBlocks.ORE_NETHER.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.AZOPROIT), 3, BlockMatcher.forBlock(Blocks.NETHERRACK));	
		ore_overworld_azoproit = new WorldGenMinable(ModBlocks.ORE_OVERWORLD.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.AZOPROIT), 3, BlockMatcher.forBlock(Blocks.STONE));
		ore_end_azoproit = new WorldGenMinable(ModBlocks.ORE_END.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.AZOPROIT), 3, BlockMatcher.forBlock(Blocks.END_STONE));
		
	}
	
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch(world.provider.getDimension())
		{
		case -1:
			
			runGenerator(ore_nether_azoproit, world, random, chunkX, chunkZ, 3, 0, 100);
	
			
			break;
			
		case 0:
			
			runGenerator(ore_overworld_azoproit, world, random, chunkX, chunkZ, 15, 5, 15);

			
			break;
			
		case 1:
			
			runGenerator(ore_end_azoproit, world, random, chunkX, chunkZ, 3, 0, 256);

		}
		
	}
	

	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight)
	{
		if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore generated out of bounds");
		
		int heightDiff = maxHeight - minHeight + 1;
		for(int i = 0; i < chance; i++)
		{
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			gen.generate(world, rand, new BlockPos(x,y,z));
		}
}

}
