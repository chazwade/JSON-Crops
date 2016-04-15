package com.betadev.jsoncrops.block;

import com.betadev.jsoncrops.ModInfo;
import com.betadev.jsoncrops.registry.ItemRegistry;
import com.betadev.jsoncrops.tile.TileCrop;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class BlockCrop extends BlockCrops implements ITileEntityProvider {
	public BlockCrop() {
		super();
		setBlockName(ModInfo.MOD_ID + ".crop");
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		dropItems(world, x, y, z, meta);
		super.breakBlock(world, x, y, z, block, meta);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileCrop();
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return EnumPlantType.Crop;
	}

	private void dropItems(World world, int x, int y, int z, int meta) {
		dropBlockAsItem(world, x, y, z, new ItemStack(ItemRegistry.seed, 1));
	}
}