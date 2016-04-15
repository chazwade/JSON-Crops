package com.betadev.jsoncrops.block;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.betadev.jsoncrops.ModInfo;
import com.betadev.jsoncrops.registry.ItemRegistry;
import com.betadev.jsoncrops.tile.TileCrop;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class BlockCrop extends BlockCrops implements ITileEntityProvider {
	@SideOnly(Side.CLIENT)
	private IIcon[] icon = new IIcon[8];

	public BlockCrop() {
		super();
		setBlockName(ModInfo.MOD_ID + ".crop");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir) {
		for(int i = 0; i < 8; i++) {
			icon[i] = ir.registerIcon(ModInfo.MOD_ID + ":crop_base_" + i);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return icon[meta];
	}

	@Override
	public Item getItemDropped(int meta, Random random, int p_149650_3) {
		return null;
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune) {
		return new ArrayList<ItemStack>();
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