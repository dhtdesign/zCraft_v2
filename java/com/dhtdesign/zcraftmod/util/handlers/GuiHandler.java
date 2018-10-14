package com.dhtdesign.zcraftmod.util.handlers;

import com.dhtdesign.zcraftmod.blocks.container.ContainerEnderChest;
import com.dhtdesign.zcraftmod.blocks.gui.GuiEnderChest;
import com.dhtdesign.zcraftmod.blocks.tileentity.TileEntityEnderChest;
import com.dhtdesign.zcraftmod.items.container.ContainerPouch;
import com.dhtdesign.zcraftmod.items.gui.GuiPouch;
import com.dhtdesign.zcraftmod.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	public static final int GUI_ENDER_CHEST = 1;
	public static final int GUI_POUCH = 2;

	static ItemStack equipped = ItemStack.EMPTY;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		int handId = 0;
		EnumHand hand = handId == 1 ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND;

		switch (ID) {
		case GUI_ENDER_CHEST: {
			return new ContainerEnderChest(player.inventory,
					(TileEntityEnderChest) world.getTileEntity(new BlockPos(x, y, z)), player);
		}
		case GUI_POUCH: {

			return new ContainerPouch(player.inventory, null, player, hand);
		}

		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		int handId = 0;
		EnumHand hand = handId == 1 ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND;

		switch (ID) {
		case GUI_ENDER_CHEST: {
			return new GuiEnderChest(player.inventory, (TileEntityEnderChest) world.getTileEntity(new BlockPos(x, y, z)), player);

		}
		case GUI_POUCH: {

			return new GuiPouch(player.inventory, null, player);
		}

		}

		return null;
	}

	private void registergui() {
	}

}
