package com.betadev.jsoncrops.proxy;

import com.betadev.jsoncrops.registry.ItemRegistry;
import com.betadev.jsoncrops.render.EssenceItemRenderer;
import com.betadev.jsoncrops.render.SeedItemRenderer;

import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
	@Override
	public void init() {
		MinecraftForgeClient.registerItemRenderer(ItemRegistry.seed, new SeedItemRenderer());
		MinecraftForgeClient.registerItemRenderer(ItemRegistry.essence, new EssenceItemRenderer());
	}
}