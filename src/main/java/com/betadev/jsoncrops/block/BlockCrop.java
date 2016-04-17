package com.betadev.jsoncrops.block;

import java.util.ArrayList;
import java.util.Random;

import com.betadev.jsoncrops.ModInfo;
import com.betadev.jsoncrops.object.Seed;
import com.betadev.jsoncrops.registry.ItemRegistry;
import com.betadev.jsoncrops.registry.SeedRegistry;
import com.betadev.jsoncrops.tile.TileCrop;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.util.ForgeDirection;

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
	public void updateTick(World world, int x, int y, int z, Random random) {
		Seed seed = getSeed(world, x, y, z);
		if(seed == null) {
			return;
		}
		int lightLevel = world.getBlockLightValue(x, y + 1, z);
		if(lightLevel >= seed.lightLevelMin && lightLevel <= seed.lightLevelMax) {
			int meta = world.getBlockMetadata(x, y, z);
			if(meta < 7 && random.nextInt((int) (25.0f / getGrowthChance(world, x, y, z)) + 1) == 0) {
				world.setBlockMetadataWithNotify(x, y, z, meta + 1, 2);
			}
		}
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		Seed seed = getSeed(world, x, y, z);
		if(seed == null) {
			return false;
		}
		if(!player.isSneaking() || player.getHeldItem() == null) {
			if(world.getBlockMetadata(x, y, z) >= 7) {
				if(!world.isRemote) {
					world.setBlockMetadataWithNotify(x, y, z, 0, 3);
					doHarvest(world, x, y, z, seed);
				}
				player.swingItem();
				return true;
			}
		}
		return false;
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
		TileEntity cropTile = world.getTileEntity(x, y, z);
		if(!(cropTile instanceof TileCrop)) {
			return;
		}
		dropBlockAsItem(world, x, y, z, new ItemStack(ItemRegistry.seed));
		if(meta >= 7) {
			doHarvest(world, x, y, z, SeedRegistry.seeds.get(((TileCrop) cropTile).seedName));
		}
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

	private Seed getSeed(World world, int x, int y, int z) {
		TileEntity crop = world.getTileEntity(x, y, z);
		if(crop != null && crop instanceof TileCrop) {
			return SeedRegistry.seeds.get(((TileCrop) crop).seedName);
		}
		return null;
	}

	private void doHarvest(World world, int x, int y, int z, Seed seed) {
		dropBlockAsItem(world, x, y, z, new ItemStack(ItemRegistry.essence, 1, seed.damage));
		Random random = new Random();
		if(random.nextDouble() <= seed.extraSeedChance) {
			dropBlockAsItem(world, x, y, z, new ItemStack(ItemRegistry.seed, 1, seed.damage));
		}
		if(random.nextDouble() <= seed.extraEssenceDropChance) {
			dropBlockAsItem(world, x, y, z, new ItemStack(ItemRegistry.essence, 1, seed.damage));
		}
	}

	// Thank you minecraft for this <3
	private float getGrowthChance(World world, int x, int y, int z) {
		float growthChance = 1;
		Block block = world.getBlock(x, y, z - 1);
		Block block1 = world.getBlock(x, y, z + 1);
		Block block2 = world.getBlock(x - 1, y, z);
		Block block3 = world.getBlock(x + 1, y, z);
		Block block4 = world.getBlock(x - 1, y, z - 1);
		Block block5 = world.getBlock(x + 1, y, z - 1);
		Block block6 = world.getBlock(x + 1, y, z + 1);
		Block block7 = world.getBlock(x - 1, y, z + 1);
		boolean flag = block2 == this || block3 == this;
		boolean flag1 = block == this || block1 == this;
		boolean flag2 = block4 == this || block5 == this || block6 == this || block7 == this;
		for(int loopX = x - 1; loopX <= x + 1; loopX++) {
			for(int loopZ = z - 1; loopZ <= z + 1; loopZ++) {
				float chance = 0;
				if(world.getBlock(loopX, y - 1, loopZ).canSustainPlant(world, loopX, y - 1, loopZ, ForgeDirection.UP, this)) {
					chance = 1;
					if(world.getBlock(loopX, y - 1, loopZ).isFertile(world, loopX, y - 1, loopZ)) {
						chance = 3;
					}
				}
				if(loopX != x || loopZ != z) {
					chance /= 4;
				}
				growthChance += chance;
			}
		}
		if(flag1 || flag && flag2) {
			growthChance /= 2;
		}
		return growthChance;
	}
}