package com.dhtdesign.zcraftmod.items.tileentity;

import com.dhtdesign.zcraftmod.blocks.container.ContainerEnderChest;
import com.dhtdesign.zcraftmod.items.container.ContainerPouch;
import com.dhtdesign.zcraftmod.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;

public class TileEntityPouch extends TileEntityLockableLoot implements ITickable {

	// public NonNullList<ItemStack> pouchContents;
	private NonNullList<ItemStack> pouchContent = NonNullList.<ItemStack>withSize(72, ItemStack.EMPTY);

	@Override
	public int getSizeInventory() {
		return 72;
	}

	@Override
	public boolean isEmpty() {
		for (ItemStack stack : this.pouchContent) {
			if (!stack.isEmpty())
				return false;
		}

		return true;
	}

	@Override
	public int getInventoryStackLimit() {
		return 200;
	}

	@Override
	public String getName() {
		return this.hasCustomName() ? this.customName : "container.pouch";
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return new ContainerPouch(playerInventory, this, playerIn);
	}

	@Override
	public String getGuiID() {
		return Reference.MOD_ID + ":pouch";
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	protected NonNullList<ItemStack> getItems() {
		return this.pouchContent;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.pouchContent = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);

		if (!this.checkLootAndRead(compound))
			ItemStackHelper.loadAllItems(compound, pouchContent);
		if (compound.hasKey("CustomName", 8))
			this.customName = compound.getString("CustomName");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		if (!this.checkLootAndWrite(compound))
			ItemStackHelper.saveAllItems(compound, pouchContent);
		if (compound.hasKey("CustomName", 8))
			compound.setString("CustomName", this.customName);

		return compound;
	}
}
