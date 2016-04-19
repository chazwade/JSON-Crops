package com.betadev.jsoncrops.object;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class Seed {
	// Internal stuff
	public int damage = 0;
	// Generated stuff
	public String name;
	public int lightLevelMin;
	public int lightLevelMax;
	public int tier;
	public double extraSeedChance;
	public double extraEssenceChance;
	public Block blockTexture;
	public Item itemTexture;
	public String inputItem;
	public String outputItem;

	public Seed(String name, Block blockTexture, String inputItem, String outputItem) {
		this(name, 9, Integer.MAX_VALUE, 1, 0, 0, blockTexture, null, inputItem, outputItem);
	}

	public Seed(String name, Item itemTexture, String inputItem, String outputItem) {
		this(name, 9, Integer.MAX_VALUE, 1, 0, 0, null, itemTexture, inputItem, outputItem);
	}

	public Seed(String name, int lightLevelMin, int lightLevelMax, int tier, double extraSeedChance, double extraEssenceChance, Block blockTexture, Item itemTexture, String inputItem, String outputItem) {
		this.name = name;
		this.lightLevelMin = lightLevelMin;
		this.lightLevelMax = lightLevelMax;
		this.tier = tier;
		this.extraSeedChance = extraSeedChance;
		this.extraEssenceChance = extraEssenceChance;
		this.blockTexture = blockTexture;
		this.itemTexture = itemTexture;
		this.inputItem = inputItem;
		this.outputItem = outputItem;
	}
}