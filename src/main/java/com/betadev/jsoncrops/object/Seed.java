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

	public Seed(String name, Block blockTexture) {
		this(name, 9, Integer.MAX_VALUE, 1, 0, 0, blockTexture, null);
	}

	public Seed(String name, Item itemTexture) {
		this(name, 9, Integer.MAX_VALUE, 1, 0, 0, null, itemTexture);
	}

	public Seed(String name, int tier, Block blockTexture) {
		this(name, 9, Integer.MAX_VALUE, tier, 0, 0, blockTexture, null);
	}

	public Seed(String name, int tier, Item itemTexture) {
		this(name, 9, Integer.MAX_VALUE, tier, 0, 0, null, itemTexture);
	}

	public Seed(String name, int lightLevelMin, int lightLevelMax, int tier, double extraSeedChance, double extraEssenceChance, Block blockTexture) {
		this(name, lightLevelMin, lightLevelMax, tier, extraSeedChance, extraEssenceChance, blockTexture, null);
	}

	public Seed(String name, int lightLevelMin, int lightLevelMax, int tier, double extraSeedChance, double extraEssenceChance, Item itemTexture) {
		this(name, lightLevelMin, lightLevelMax, tier, extraSeedChance, extraEssenceChance, null, itemTexture);
	}

	public Seed(String name, int lightLevelMin, int lightLevelMax, int tier, double extraSeedChance, double extraEssenceChance, Block blockTexture, Item itemTexture) {
		this.name = name;
		this.lightLevelMin = lightLevelMin;
		this.lightLevelMax = lightLevelMax;
		this.tier = tier;
		this.extraSeedChance = extraSeedChance;
		this.extraEssenceChance = extraEssenceChance;
		this.blockTexture = blockTexture;
		this.itemTexture = itemTexture;
	}
}