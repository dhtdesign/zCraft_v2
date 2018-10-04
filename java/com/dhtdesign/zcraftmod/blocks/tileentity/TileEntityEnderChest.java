package com.dhtdesign.zcraftmod.blocks.tileentity;

import com.dhtdesign.zcraftmod.blocks.container.ContainerEnderChest;
import com.dhtdesign.zcraftmod.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;

public class TileEntityEnderChest extends TileEntityLockableLoot implements ITickable
{
	private NonNullList<ItemStack> chestContent = NonNullList.<ItemStack>withSize(72, ItemStack.EMPTY);
	public int numPlayerUsing, ticksSinceSync;
	public float lidAngle, prevLidAngle;
	
	
	
	@Override
	public int getSizeInventory()
	{
		return 72;
	}

	@Override
	public boolean isEmpty()
	{
		for(ItemStack stack : this.chestContent)
		{
			if(!stack.isEmpty()) return false;
		}
		
		return true;
	}
	
	@Override
	public String getName() 
	{
		return this.hasCustomName() ? this.customName : "container.ender_chest";
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		this.chestContent = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
		
		if(!this.checkLootAndRead(compound)) ItemStackHelper.loadAllItems(compound, chestContent);
		if(compound.hasKey("CustomName", 8)) this.customName = compound.getString("CustomName");
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		
		if(!this.checkLootAndWrite(compound)) ItemStackHelper.saveAllItems(compound, chestContent);
		if(compound.hasKey("CustomName", 8)) compound.setString("CustomName", this.customName);
		
		return compound;
	}
	
	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) 
	{
		return new ContainerEnderChest(playerInventory, this, playerIn);
	}
	
	@Override
	public String getGuiID() 
	{
		return Reference.MOD_ID + ":ender_chest";
	}
	
	@Override
	protected NonNullList<ItemStack> getItems() 
	{
		return this.chestContent;
	}
	
	@Override
	public void update()
	{
		if (!this.world.isRemote && this.numPlayerUsing != 0 && (this.ticksSinceSync + pos.getX() + pos.getY() + pos.getZ()) % 200 == 0)
        {
            this.numPlayerUsing = 0;
            float f = 5.0F;

            for (EntityPlayer entityplayer : this.world.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB((double)((float)pos.getX() - 5.0F), (double)((float)pos.getY() - 5.0F), (double)((float)pos.getZ() - 5.0F), (double)((float)(pos.getX() + 1) + 5.0F), (double)((float)(pos.getY() + 1) + 5.0F), (double)((float)(pos.getZ() + 1) + 5.0F))))
            {
                if (entityplayer.openContainer instanceof ContainerEnderChest)
                {
                    if (((ContainerEnderChest)entityplayer.openContainer).getChestInventory() == this)
                    {
                        ++this.numPlayerUsing;
                    }
                }
            }
        }
		
        this.prevLidAngle = this.lidAngle;
        float f1 = 0.1F;

        if (this.numPlayerUsing > 0 && this.lidAngle == 0.0F)
        {
            double d1 = (double)pos.getX() + 0.5D;
            double d2 = (double)pos.getZ() + 0.5D;
            this.world.playSound((EntityPlayer)null, d1, (double)pos.getY() + 0.5D, d2, SoundEvents.BLOCK_IRON_TRAPDOOR_OPEN, SoundCategory.BLOCKS, 0.5F, this.world.rand.nextFloat() * 0.1F + 0.9F);
        }

        if (this.numPlayerUsing == 0 && this.lidAngle > 0.0F || this.numPlayerUsing > 0 && this.lidAngle < 1.0F)
        {
            float f2 = this.lidAngle;

            if (this.numPlayerUsing > 0)
            {
                this.lidAngle += 0.1F;
            }
            else
            {
                this.lidAngle -= 0.1F;
            }

            if (this.lidAngle > 1.0F)
            {
                this.lidAngle = 1.0F;
            }

            float f3 = 0.5F;

            if (this.lidAngle < 0.5F && f2 >= 0.5F)
            {
                double d3 = (double)pos.getX() + 0.5D;
                double d0 = (double)pos.getZ() + 0.5D;
                this.world.playSound((EntityPlayer)null, d3, (double)pos.getY() + 0.5D, d0, SoundEvents.BLOCK_IRON_TRAPDOOR_CLOSE, SoundCategory.BLOCKS, 0.5F, this.world.rand.nextFloat() * 0.1F + 0.9F);
            }

            if (this.lidAngle < 0.0F)
            {
                this.lidAngle = 0.0F;
            }
        }		
	}
	
	@Override
	public void openInventory(EntityPlayer player)
	{
		++this.numPlayerUsing;
		this.world.addBlockEvent(pos, this.getBlockType(), 1, this.numPlayerUsing);
		this.world.notifyNeighborsOfStateChange(pos, this.getBlockType(), false);
	}
	
	@Override
	public void closeInventory(EntityPlayer player) 
	{
		--this.numPlayerUsing;
		this.world.addBlockEvent(pos, this.getBlockType(), 1, this.numPlayerUsing);
		this.world.notifyNeighborsOfStateChange(pos, this.getBlockType(), false);
}

	@Override
	public int getInventoryStackLimit() {
		
		return 64;
	} 
	
}
