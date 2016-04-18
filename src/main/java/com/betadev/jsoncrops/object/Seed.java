package com.betadev.jsoncrops.object;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class Seed {
	public String name = "Null";
	public int lightLevelMin = 9;
	public int lightLevelMax = Integer.MAX_VALUE;
	public int damage = 0; // TODO
	public double extraSeedChance = 0;
	public double extraEssenceDropChance = 0;
	public Block blockTexture;
	public Item itemTexture;

	public Seed() {}

	public Seed(String name, Block blockTexture) {
		this.name = name;
		this.blockTexture = blockTexture;
	}

	public Seed(String name, Item itemTexture) {
		this.name = name;
		this.itemTexture = itemTexture;
	}

	public Seed(String name, int lightLevelMin, int lightLevelMax, double extraSeedChance, double extraEssenceDropChance) {
		this.name = name;
		this.lightLevelMin = lightLevelMin;
		this.lightLevelMax = lightLevelMax;
		this.extraSeedChance = extraSeedChance;
		this.extraEssenceDropChance = extraEssenceDropChance;
	}
}