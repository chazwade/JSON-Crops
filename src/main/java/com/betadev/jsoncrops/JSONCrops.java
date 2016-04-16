package com.betadev.jsoncrops;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.betadev.jsoncrops.proxy.CommonProxy;
import com.betadev.jsoncrops.registry.BlockRegistry;
import com.betadev.jsoncrops.registry.ItemRegistry;
import com.betadev.jsoncrops.registry.SeedRegistry;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, version = ModInfo.MOD_VERSION, dependencies = ModInfo.DEPENDENCIES)
public class JSONCrops {
	public static Logger log = LogManager.getLogger(ModInfo.MOD_NAME);
	private File configDir;

	@Mod.Instance(ModInfo.MOD_ID)
	public static JSONCrops instance;

	@SidedProxy(clientSide = ModInfo.CLIENT_PROXY_CLASS, serverSide = ModInfo.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	public static CreativeTabs creativeTab = new CreativeTabs(ModInfo.MOD_ID + ".creativeTab") {
		@Override
		public ItemStack getIconItemStack() {
			return new ItemStack(Items.map, 1, 0);
		}

		@Override
		public Item getTabIconItem() {
			return Items.map;
		}
	};

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		log.info("Loading " + ModInfo.MOD_NAME);
		configDir = new File(event.getModConfigurationDirectory(), ModInfo.MOD_NAME.replace(" ", ""));
		configDir.mkdirs();
		proxy.preInit();
		BlockRegistry.register();
		ItemRegistry.register();
		SeedRegistry.register();
	}
}