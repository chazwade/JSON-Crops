package com.betadev.jsoncrops.proxy;

import com.betadev.jsoncrops.JSONCrops;
import com.betadev.jsoncrops.registry.ItemRegistry;
import com.betadev.jsoncrops.render.SeedItemRenderer;

import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
	@Override
	public void init() {
		JSONCrops.log.info("We're rendering items.");
		MinecraftForgeClient.registerItemRenderer(ItemRegistry.seed, new SeedItemRenderer());
	}
}