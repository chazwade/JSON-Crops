package com.betadev.jsoncrops.item;

import com.betadev.jsoncrops.JSONCrops;
import com.betadev.jsoncrops.ModInfo;
import com.betadev.jsoncrops.registry.BlockRegistry;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemSeed extends Item implements IPlantable {
	public ItemSeed() {
		super();
		setUnlocalizedName(ModInfo.MOD_ID + ".seed");
		setCreativeTab(JSONCrops.creativeTab);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		Block block = world.getBlock(x, y, z);
		if(isSoil(world, x, y, z, block) && ForgeDirection.getOrientation(side) == ForgeDirection.UP && world.isAirBlock(x, y + 1, z)) {
			world.setBlock(x, y + 1, z, BlockRegistry.crop);
			if(!player.capabilities.isCreativeMode) {
				player.inventory.decrStackSize(player.inventory.currentItem, 1);
			}
			return true;
		}
		return false;
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return EnumPlantType.Crop;
	}

	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z) {
		return BlockRegistry.crop;
	}

	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
		return 0;
	}

	private boolean isSoil(World world, int x, int y, int z, Block block) {
		return block.canSustainPlant(world, x, y, z, ForgeDirection.UP, this);
	}
}