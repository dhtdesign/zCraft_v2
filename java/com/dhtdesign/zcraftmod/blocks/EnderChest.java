package com.dhtdesign.zcraftmod.blocks;

import javax.annotation.Nullable;

import com.dhtdesign.zcraftmod.Main;
import com.dhtdesign.zcraftmod.blocks.tileentity.TileEntityEnderChest;
import com.dhtdesign.zcraftmod.init.ModBlocks;
import com.dhtdesign.zcraftmod.init.ModItems;
import com.dhtdesign.zcraftmod.util.Reference;
import com.dhtdesign.zcraftmod.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.World;

public class EnderChest extends BlockContainer implements IHasModel
{
	
	protected static final AxisAlignedBB ENDER_CHEST_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.875D, 0.9375D);
	
	//public static EnderChest enderChestBlock;

	public static Block enderChestBlock;

	public EnderChest(String name) 
	{
		super(Material.IRON);
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setHardness(3.0F);
		setCreativeTab(Main.zCraftTab);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		
	}
	
	 @Override
	    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	    {
	        return ENDER_CHEST_AABB;
	}
	
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		if(!worldIn.isRemote)
		{
			playerIn.openGui(Main.instance, Reference.GUI_ENDER_CHEST, worldIn, pos.getX(), pos.getY(), pos.getZ());
			playerIn.sendMessage(new TextComponentString(TextFormatting.DARK_RED + "test"));
		}
		
		
		return true;
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) 
	{
		TileEntityEnderChest tileentity = (TileEntityEnderChest)worldIn.getTileEntity(pos);
		InventoryHelper.dropInventoryItems(worldIn, pos, tileentity);
		super.breakBlock(worldIn, pos, state);
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) 
	{
		if(stack.hasDisplayName())
		{
			TileEntity tileentity = worldIn.getTileEntity(pos);
			
			if(tileentity instanceof TileEntityEnderChest)
			{
				((TileEntityEnderChest)tileentity).setCustomName(stack.getDisplayName());
			}
			
		}
		
		
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileEntityEnderChest();
	}
	
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
	{
		return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
	}
	
	
	@Override
	public boolean isFullBlock(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) 
	{
		return false;
	}
	
	
	@Override
	public boolean isOpaqueCube(IBlockState state) 
	{
		return false;
	}

    @Nullable
    public ILockableContainer getLockableContainer(World worldIn, BlockPos pos)
    {
        return this.getContainer(worldIn, pos, false);
    }

    @Nullable
    public ILockableContainer getContainer(World worldIn, BlockPos pos, boolean allowBlocking)
    {
        return null;
    }
	
    
    private static final EnumFacing[] validRotationAxes = new EnumFacing[] { EnumFacing.UP, EnumFacing.DOWN };

    @Override
    public EnumFacing[] getValidRotations(World worldObj, BlockPos pos)
    {
        return validRotationAxes;
    }
    
    @Override
    public boolean rotateBlock(World worldObj, BlockPos pos, EnumFacing axis)
    {
        if (worldObj.isRemote)
        {
            return false;
        }

        if (axis == EnumFacing.UP || axis == EnumFacing.DOWN)
        {
            TileEntity tileEntity = worldObj.getTileEntity(pos);

            if (tileEntity instanceof TileEntityEnderChest)
            {
            	TileEntityEnderChest icte = (TileEntityEnderChest) tileEntity;

                icte.rotateAround();
            }

            return true;
        }
        return false;
    }

	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
