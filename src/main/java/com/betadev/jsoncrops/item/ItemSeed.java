package com.betadev.jsoncrops.item;

import java.util.List;

import com.betadev.jsoncrops.JSONCrops;
import com.betadev.jsoncrops.ModInfo;
import com.betadev.jsoncrops.object.Seed;
import com.betadev.jsoncrops.registry.BlockRegistry;
import com.betadev.jsoncrops.registry.SeedRegistry;
import com.betadev.jsoncrops.tile.TileCrop;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemSeed extends Item implements IPlantable {
	private IIcon icon;

	public ItemSeed() {
		super();
		setUnlocalizedName(ModInfo.MOD_ID + ".seed");
		setCreativeTab(JSONCrops.creativeTab);
		setHasSubtypes(true);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item item, CreativeTabs tabs, List list) {
		for(Seed seed : SeedRegistry.seeds.values()) {
			list.add(new ItemStack(this, 1, seed.damage));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getItemStackDisplayName(ItemStack stack) {
		return String.format(StatCollector.translateToLocal(getUnlocalizedName()), StatCollector.translateToLocal(SeedRegistry.getSeed(stack.getItemDamage()).name));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconIndex(ItemStack stack) {
		return icon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int pass) {
		return icon;
	}

	@Override
	public void registerIcons(IIconRegister ir) {
		icon = ir.registerIcon(ModInfo.MOD_ID + ":seed_overlay");
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		Block block = world.getBlock(x, y, z);
		Seed seed = SeedRegistry.getSeed(stack.getItemDamage());
		if(isSoil(world, x, y, z, block) && ForgeDirection.getOrientation(side) == ForgeDirection.UP && world.isAirBlock(x, y + 1, z)) {
			world.setBlock(x, y + 1, z, BlockRegistry.crop);
			((TileCrop) world.getTileEntity(x, y + 1, z)).seedName = seed.name;
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