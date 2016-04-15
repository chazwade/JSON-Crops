package com.betadev.crops;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.betadev.crops.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mod(modid = "jsoncrops", name = "JSON Crops", version = "@VERSION@")
public class JSONCrops {
	private Logger log = LogManager.getLogger("JSON Crops");
	private File configDir;

	@Instance
	public static JSONCrops instance;

	@SidedProxy(clientSide = "com.betadev.crops.proxy.ClientProxy", serverSide = "com.betadev.crops.proxy.CommonProxy")
	public static CommonProxy proxy;

	public static CreativeTabs tabModpackTweaks = new CreativeTabs("jsoncrops.creativeTab") {
		@Override
		public ItemStack getIconItemStack() {
			return new ItemStack(Items.map, 1, 0);
		}

		@Override
		public Item getTabIconItem() {
			return Items.map;
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		log.info("Loading JSON Crops");
		configDir = new File(event.getModConfigurationDirectory(), "JSONCrops");
		configDir.mkdirs();
		proxy.preInit();
	}
}