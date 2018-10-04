package com.dhtdesign.zcraftmod.util.handlers;

import com.dhtdesign.zcraftmod.blocks.container.ContainerEnderChest;
import com.dhtdesign.zcraftmod.blocks.gui.GuiEnderChest;
import com.dhtdesign.zcraftmod.blocks.tileentity.TileEntityEnderChest;
import com.dhtdesign.zcraftmod.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUI_ENDER_CHEST) return new ContainerEnderChest(player.inventory, (TileEntityEnderChest)world.getTileEntity(new BlockPos(x,y,z)), player);
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUI_ENDER_CHEST) return new GuiEnderChest(player.inventory, (TileEntityEnderChest)world.getTileEntity(new BlockPos(x,y,z)), player);
		return null;
	}
	
	private void registergui() 
	{
	}

}
