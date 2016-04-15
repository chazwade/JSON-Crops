package com.betadev.jsoncrops.registry;

import com.betadev.jsoncrops.ModInfo;
import com.betadev.jsoncrops.block.BlockCrop;
import com.betadev.jsoncrops.tile.TileCrop;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class BlockRegistry {
	public static Block crop;

	public static void register() {
		crop = new BlockCrop();
		GameRegistry.registerBlock(crop, "BlockCrop");
		GameRegistry.registerTileEntity(TileCrop.class, ModInfo.MOD_ID);
	}
}