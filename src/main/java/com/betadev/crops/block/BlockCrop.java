package com.betadev.crops.block;

import com.betadev.crops.tile.TileCrop;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCrop extends BlockCrops implements ITileEntityProvider {
	public BlockCrop() {
		super();
		setBlockName("jsoncrops.crop");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileCrop();
	}
}